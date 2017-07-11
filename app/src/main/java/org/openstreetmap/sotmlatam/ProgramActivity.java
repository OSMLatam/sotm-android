package org.openstreetmap.sotmlatam;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.tibolte.agendacalendarview.AgendaCalendarView;
import com.github.tibolte.agendacalendarview.CalendarPickerController;
import com.github.tibolte.agendacalendarview.calendar.CalendarView;
import com.github.tibolte.agendacalendarview.models.BaseCalendarEvent;
import com.github.tibolte.agendacalendarview.models.CalendarEvent;
import com.github.tibolte.agendacalendarview.models.DayItem;

import org.openstreetmap.sotmlatam.fragments.ProgramFragment;
import org.openstreetmap.sotmlatam.utils.PageAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ProgramActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private Spinner spinner;
    boolean firsTime = true;
    String currentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // Set your date format
        currentData = sdf.format(d);

        initTab();
    }

    ViewPager viewPager;
    PageAdapter adapter;

    private void initTab() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new PageAdapter(getSupportFragmentManager());


        adapter.setDate(currentData);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                String date = spinner.getSelectedItem().toString();
                if (currentData.contains(spinner.getSelectedItem().toString()))
                    date = currentData;
                else if(date.contains("..."))
                    date = currentData;
                ((ProgramFragment) adapter.getMyMap().get(viewPager.getCurrentItem())).changeDate(
                       date, adapter.getTitles()[viewPager.getCurrentItem()]);
                spinner.setSelection(spinner.getSelectedItemPosition());
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).select();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_program, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        spinner = (Spinner) MenuItemCompat.getActionView(item);

        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.program_values, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(R.layout.checkedtextview);


        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (adapter != null && viewPager != null && adapter.getMyMap() != null &&
                        spinner != null && !firsTime && position!=0) {
                    String date = spinner.getSelectedItem().toString();
                    if (currentData.contains(spinner.getSelectedItem().toString()))
                        date = currentData;
                    ((ProgramFragment) adapter.getMyMap().get(viewPager.getCurrentItem())).changeDate(date
                            , adapter.getTitles()[viewPager.getCurrentItem()]);

                } else {
                    firsTime = false;

                }
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(android.R.color.white));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();    //Call the back button's method
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
