package org.openstreetmap.sotmlatam;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.graphics.Color;

import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.annotations.MarkerViewOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.constants.MyLocationTracking;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.location.LocationListener;
import com.mapbox.mapboxsdk.location.LocationServices;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.services.Constants;
import com.mapbox.services.commons.ServicesException;
import com.mapbox.services.commons.geojson.LineString;
import com.mapbox.services.commons.models.Position;
import com.mapbox.services.directions.v5.DirectionsCriteria;
import com.mapbox.services.directions.v5.MapboxDirections;
import com.mapbox.services.directions.v5.models.DirectionsResponse;
import com.mapbox.services.directions.v5.models.DirectionsRoute;

import com.mapbox.mapboxsdk.annotations.PolylineOptions;


import org.openstreetmap.sotmlatam.utils.SpinnerImgAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenueActivity extends AppCompatActivity {
    private MapView mapView;
    private MapboxMap map;
    private FloatingActionButton floatingActionButton;
    private LocationServices locationServices;
    private static final int PERMISSIONS_LOCATION = 0;
    private DirectionsRoute currentRoute;
    private String routeType[] = {DirectionsCriteria.PROFILE_WALKING, DirectionsCriteria.PROFILE_CYCLING, DirectionsCriteria.PROFILE_DRIVING,};

    private Spinner sp;
    private Position origin = null;
    private Position destination;
    private int indexFlagMarkerIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapboxAccountManager.start(this, getString(R.string.access_token));
        setContentView(R.layout.activity_venue2);
        locationServices = LocationServices.getLocationServices(VenueActivity.this);
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mapView.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(MapboxMap mapboxMap) {
                        map = mapboxMap;
                        createMarkers();
                        map.getTrackingSettings().setMyLocationTrackingMode(MyLocationTracking.TRACKING_FOLLOW);

                        int padding[] = {0, 0, 0, 0};
                        map.getMyLocationViewSettings().setForegroundDrawable(getResources().getDrawable(R.drawable.ic_face_black_24dp), getResources().getDrawable(R.drawable.ic_face_black_24dp));
                        setupScreenLocationFocus();
                        map.setOnMyLocationTrackingModeChangeListener(new MapboxMap.OnMyLocationTrackingModeChangeListener() {
                            @Override
                            public void onMyLocationTrackingModeChange(int myLocationTrackingMode) {
                                if(myLocationTrackingMode==0){
                                    userFocus = false;

                                }else
                                {
                                    userFocus = true;
                                }
                                setupFocus();
                            }
                        });
                    }
                });

                mapView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userFocus = false;
                        setupFocus();
                    }
                });

            }
        });

        setupFABLocation();
        setupFABRoute();
        setupRouteType();
    }

    private void setupScreenLocationFocus() {
        focus = (ImageView) findViewById(R.id.focus);
        focus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map.getMyLocation() != null && !userFocus) {
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(map.getMyLocation()), 16));
                }
                userFocus = !userFocus;
                setupFocus();
            }
        });
        setupFocus();
    }

    private void setupRouteType() {
        sp = (Spinner) findViewById(R.id.route_type);
        Integer[] image = {R.drawable.a_pie,
                R.drawable.bicicleta, R.drawable.carro};
        SpinnerImgAdapter spinnerAdapter = new SpinnerImgAdapter(this,
                R.layout.spinner_op, image);
        sp.setAdapter(spinnerAdapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (origin != null) {
                    try {
                        Toast.makeText(VenueActivity.this, getString(R.string.route_wait), Toast.LENGTH_LONG).show();

                        getRoute(origin, destination);

                    } catch (ServicesException e) {
                        Toast.makeText(VenueActivity.this, getString(R.string.ups_error), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    boolean userFocus = true;
    ImageView focus;


    private void setupFocus() {
        if (userFocus) {
            focus.setImageResource(R.drawable.gpsencendido);
          //  map.getTrackingSettings().setDismissAllTrackingOnGesture(true);
        } else {
            focus.setImageResource(R.drawable.gpsapagado);
        //    map.getTrackingSettings().setDismissAllTrackingOnGesture(false);
        }
    }

    private void setupFABRoute() {
        FloatingActionButton routeFloatingActionButton = (FloatingActionButton) findViewById(R.id.route);
        routeFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(VenueActivity.this);
                builder.setTitle(R.string.map_dialog_title)
                        .setItems(R.array.map_options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                if (which == 1) {
                                    //
                                    destination = Position.fromCoordinates(-46.63326, -23.54558);
                                } else {
                                    //
                                    destination = Position.fromCoordinates(-46.64156, -23.54757);
                                }


                                if (locationServices != null && locationServices.getLastLocation() != null) {
                                    origin = Position.fromCoordinates(locationServices.getLastLocation().getLongitude(), locationServices.getLastLocation().getLatitude());
                                    // Create an Icon object for the marker to use
                                    IconFactory iconFactory = IconFactory.getInstance(VenueActivity.this);
                                    Drawable iconDrawable = ContextCompat.getDrawable(VenueActivity.this, R.drawable.flag_green);
                                    Icon icon = iconFactory.fromDrawable(iconDrawable);
                                    // Add the custom icon marker to the map
                                    map.addMarker(new MarkerOptions()
                                            .position(new LatLng(origin.getLatitude(), origin.getLongitude()))
                                            .icon(icon));

                                    try {
                                        Toast.makeText(VenueActivity.this, getString(R.string.route_wait), Toast.LENGTH_LONG).show();
                                        CameraPosition camaraPosition = new CameraPosition.Builder()
                                                .target(new LatLng(origin.getLatitude(), origin.getLongitude())) // Sets the new camera position
                                                // .zoom(17) // Sets the zoom
                                                // .bearing(180) // Rotate the camera
                                                .tilt(30) // Set the camera tilt
                                                .build(); // Creates a CameraPosition from the builder
                                        map.animateCamera(CameraUpdateFactory
                                                .newCameraPosition(camaraPosition), 7000);
                                        getRoute(origin, destination);
                                    } catch (ServicesException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    createRouteDialog(destination);
                                }
                            }
                        });
                builder.create().show();
            }
        });
    }

    private void setupFABLocation() {
        floatingActionButton = (FloatingActionButton) findViewById(R.id.location_toggle_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null) {
                    toggleGps(!map.isMyLocationEnabled());
                }
            }
        });
        floatingActionButton.setImageResource(R.drawable.ic_my_location_24dp);
    }

    private void createRouteDialog(final Position destination) {
        android.app.AlertDialog.Builder builder2 = new android.app.AlertDialog.Builder(VenueActivity.this);
        builder2.setTitle(R.string.information).setMessage(R.string.information2).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                map.setOnMapLongClickListener(new MapboxMap.OnMapLongClickListener() {
                    @Override
                    public void onMapLongClick(@NonNull LatLng point) {
                        Toast.makeText(VenueActivity.this, getString(R.string.route_wait), Toast.LENGTH_LONG).show();
                        IconFactory iconFactory = IconFactory.getInstance(VenueActivity.this);
                        Drawable iconDrawable = ContextCompat.getDrawable(VenueActivity.this, R.drawable.flag_green);
                        Icon icon = iconFactory.fromDrawable(iconDrawable);
                        final Marker marker = map.addMarker(new MarkerViewOptions()
                                .position(point));
                        marker.setIcon(icon);
                        ValueAnimator markerAnimator = ObjectAnimator.ofObject(marker, "position",
                                new LatLngEvaluator(), marker.getPosition(), point);
                        markerAnimator.setDuration(1000);
                        markerAnimator.start();
                        Position origin2 = Position.fromCoordinates(point.getLongitude(), point.getLatitude());
                        try {
                            getRoute(origin2, destination);
                        } catch (ServicesException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }).show();
    }

    private void createMarkers() {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(-46.63326, -23.54558))
                .title(getString(R.string.library))
                .snippet(getString(R.string.library_desc)));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(-46.64156, -23.54757))
                .title(getString(R.string.mobilab))
                .snippet(getString(R.string.mobilab_desc)));
    }


    private void getRoute(Position origin, Position destination) throws ServicesException {
        MapboxDirections client = new MapboxDirections.Builder()
                .setOrigin(origin)
                .setDestination(destination)
                .setProfile(routeType[sp.getSelectedItemPosition()])
                .setAccessToken(getString(R.string.access_token))
                .build();
        client.enqueueCall(new Callback<DirectionsResponse>() {
            @Override
            public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                // You can get the generic HTTP info about the response
                Log.d("", "Response code: " + response.code());
                if (response.body() == null) {
                    Log.e("", "No routes found, make sure you set the right user and access token.");
                    return;
                }

                try {
                    // Print some info about the route
                    currentRoute = response.body().getRoutes().get(0);
                    Log.d("", "Distance: " + currentRoute.getDistance());
                    Toast.makeText(VenueActivity.this, "Route is " + currentRoute.getDistance() +
                            " meters long.", Toast.LENGTH_LONG).show();
                    if (map.getPolylines().size() == 1) {
                        map.removePolyline(map.getPolylines().get(0));
                        map.removeMarker(map.getMarkers().get(2));
                    }

                    // Draw the route on the map
                    drawRoute(currentRoute);
                } catch (Exception e) {
                    Toast.makeText(VenueActivity.this, getString(R.string.ups_error),
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DirectionsResponse> call, Throwable t) {
                Log.e("", "Error: " + t.getMessage());
                Toast.makeText(VenueActivity.this, getString(R.string.ups_error),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void drawRoute(DirectionsRoute route) {
        // Convert LineString coordinates into LatLng[]
        LineString lineString = LineString.fromPolyline(route.getGeometry(),
                Constants.OSRM_PRECISION_V5);
        List<Position> coordinates = lineString.getCoordinates();
        LatLng[] points = new LatLng[coordinates.size()];

        for (int i = 0; i < coordinates.size(); i++) {
            points[i] = new LatLng(
                    coordinates.get(i).getLatitude(),
                    coordinates.get(i).getLongitude());
        }

        // Draw Points on MapView
        map.addPolyline(new PolylineOptions()
                .add(points)
                .color(Color.parseColor("#009688"))
                .width(5));
    }

    // Add the mapView lifecycle to the activity's lifecycle methods
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();


    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    private void toggleGps(boolean enableGps) {
        if (enableGps) {
            // Check if user has granted location permission
            if (!locationServices.areLocationPermissionsGranted()) {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_LOCATION);
            } else {
                enableLocation(true);
            }
        } else {
            enableLocation(false);
        }
    }

    private void enableLocation(boolean enabled) {
        if (enabled) {

            // If we have the last location of the user, we can move the camera to that position.
            Location lastLocation = locationServices.getLastLocation();
            if (lastLocation != null) {
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lastLocation), 16));
            }

            locationServices.addLocationListener(new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    if (location != null) {
                        // Move the map camera to where the user location is and then remove the
                        // listener so the camera isn't constantly updating when the user location
                        // changes. When the user disables and then enables the location again, this
                        // listener is registered again and will adjust the camera once again.
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location), 16));
                        locationServices.removeLocationListener(this);
                    }
                }
            });
            floatingActionButton.setImageResource(R.drawable.ic_location_disabled_24dp);
        } else {
            floatingActionButton.setImageResource(R.drawable.ic_my_location_24dp);

        }
        // Enable or disable the location layer on the map
        map.setMyLocationEnabled(enabled);
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableLocation(true);
            }
        }
    }

    private static class LatLngEvaluator implements TypeEvaluator<LatLng> {
        // Method is used to interpolate the marker animation.

        private LatLng latLng = new LatLng();

        @Override
        public LatLng evaluate(float fraction, LatLng startValue, LatLng endValue) {
            latLng.setLatitude(startValue.getLatitude() +
                    ((endValue.getLatitude() - startValue.getLatitude()) * fraction));
            latLng.setLongitude(startValue.getLongitude() +
                    ((endValue.getLongitude() - startValue.getLongitude()) * fraction));
            return latLng;
        }
    }
}
