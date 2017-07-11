package org.openstreetmap.sotmlatam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import org.openstreetmap.sotmlatam.db.MyPlacesHelper;

/**
 * Created by laura on 9/6/2016.
 */
public class SplashActivity extends Activity implements
        MyPlacesHelper.LoadContentInterface {

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        db.close();
    }



    boolean active = true;
    int splashTime = 2000;
    int waited = 0;
    TextView initialText;
    private boolean dataInsertion = false;
    MyPlacesHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.splash);
        initialText = (TextView) findViewById(R.id.inf1o);
        db	 = new MyPlacesHelper(SplashActivity.this);


        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    active = false;
                    new MyPlacesHelper(SplashActivity.this);
                    while (waited < splashTime || dataInsertion) {
                        sleep(100);
                        waited += 100;

                    }
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    db.close();
                    finish();
                    Intent intent = new Intent(SplashActivity.this,
                            MainActivity.class);
                    startActivity(intent);

                }
            }
        };
        splashTread.start();
        db.getWritableDatabase();
    }

    @Override
    public void onFinishLoadContent() {
        dataInsertion = false;
    }



    @Override
    public void notificedProcessStarted() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                initialText
                        .setText("Cargando configuración inicial, por favor sea paciente. ");

            }
        });
        dataInsertion = true;

    }

}
