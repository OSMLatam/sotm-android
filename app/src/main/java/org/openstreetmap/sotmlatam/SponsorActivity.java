package org.openstreetmap.sotmlatam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import org.openstreetmap.sotmlatam.fragments.ItemFragment;
import org.openstreetmap.sotmlatam.fragments.dummy.DummyContent;

public class SponsorActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);
        setupFragment(ItemFragment.newInstance(2));
    }

    public void setupFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.holder, fragment)

                .commit();

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onBackPressed() {

            //
            if(getSupportFragmentManager().getBackStackEntryCount()==0)
                finish();
            else
                super.onBackPressed();
        }


}
