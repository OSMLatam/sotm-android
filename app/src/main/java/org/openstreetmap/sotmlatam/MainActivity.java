package org.openstreetmap.sotmlatam;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import org.openstreetmap.sotmlatam.fragments.AboutFragment;
import org.openstreetmap.sotmlatam.fragments.HelpActivity;
import org.openstreetmap.sotmlatam.fragments.TwitterFragment;
import org.openstreetmap.sotmlatam.fragments.WelcomeFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setupFragment(WelcomeFragment.newInstance());
        //RelativeLayout rel = (RelativeLayout)findViewById(R.id.holder);
        //rel.getBackground().setAlpha(255);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_sotm) {
            Intent intent = new Intent(MainActivity.this,
                    SotMActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.twitter) {
            Intent intent = new Intent(MainActivity.this,
                    TwitterActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.action_help) {
            Intent intent = new Intent(MainActivity.this,
                    HelpActivity.class);
            startActivity(intent);
            return true;
        }else{
            Intent intent = new Intent(MainActivity.this,
                    AboutActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if(id==R.id.program){
            Intent intent = new Intent(MainActivity.this,
                    ProgramActivity.class);
            startActivity(intent);
        }else if(id==R.id.sponsor){
            Intent intent = new Intent(MainActivity.this,
                    SponsorActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(MainActivity.this,
                    VenueActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setupFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.holder, fragment)
                 .addToBackStack(null)
                .commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //
            if(getSupportFragmentManager().getBackStackEntryCount()==1)
                finish();
            else
                super.onBackPressed();
        }
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    /**
     * Checks if the app has permission to write to device storage
     *
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     * @param activity
     */
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    public  void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission

        int hasWriteContactsPermission = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_CONTACTS);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_CODE_ASK_PERMISSIONS);
        }
    }
}
