package org.openstreetmap.sotmlatam.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.tibolte.agendacalendarview.AgendaCalendarView;
import com.github.tibolte.agendacalendarview.models.CalendarEvent;

import org.openstreetmap.sotmlatam.R;
import org.openstreetmap.sotmlatam.utils.DrawableEventRenderer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class AboutFragment extends Fragment {




    public AboutFragment() {

    }


    public static AboutFragment newInstance() {
        AboutFragment fragment = new AboutFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_about, container, false);
    }





}
