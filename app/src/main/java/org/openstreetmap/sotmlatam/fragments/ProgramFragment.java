package org.openstreetmap.sotmlatam.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import org.openstreetmap.sotmlatam.R;
import org.openstreetmap.sotmlatam.controller.EventController;
import org.openstreetmap.sotmlatam.db.MyPlacesHelper;
import org.openstreetmap.sotmlatam.db.ProgramEvent;
import org.openstreetmap.sotmlatam.utils.BaseOSMCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

;import jp.wasabeef.recyclerview.animators.LandingAnimator;


public class ProgramFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mPlaceParam;
    private String mDateParam;


    public ProgramFragment() {
        // Required empty public constructor
    }


    public static ProgramFragment newInstance(String param1, String param2) {
        ProgramFragment fragment = new ProgramFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPlaceParam = getArguments().getString(ARG_PARAM1);
            mDateParam = getArguments().getString(ARG_PARAM2);
        }

    }

    RecyclerView recyclerView;
    ProgramRecyclerViewAdapter adapter;
LinearLayoutManager linearLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //   view = inflater.inflate(R.layout.fragment_program, container, false);
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_program, container, false);
        LandingAnimator animator = new LandingAnimator();
        animator.setAddDuration(1000);
        recyclerView.setItemAnimator(animator   );
        linearLayoutManager  = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ProgramRecyclerViewAdapter(new ArrayList<ProgramEvent>(), getActivity());
        recyclerView.setAdapter(adapter);
        String values[] = {mPlaceParam, mDateParam};
        new CreateCalendar().execute(values);
        return recyclerView;
    }

    public void changeDate(String place, String date) {
        mDateParam = date;
        mPlaceParam = place;
        String values[] = {mPlaceParam, mDateParam};
        recyclerView.getLayoutManager().scrollToPosition(0);
        new CreateCalendar().execute(values);
    }

    private class CreateCalendar extends AsyncTask<String, Void, List<ProgramEvent>> {


        MyPlacesHelper helper;
        ProgramEvent currentEvent;
        int index;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            helper = new MyPlacesHelper(getActivity());
        }

        @Override
        protected List<ProgramEvent> doInBackground(String... params) {
            currentEvent = helper.getCurrentEvent(params[0],params[1]);
            List<ProgramEvent> events =helper.getProgramEvent(params[0],params[1]);


            index = events.indexOf(currentEvent);
            return events;
        }

        @Override
        protected void onPostExecute(final List<ProgramEvent> list) {
            adapter.setmValues(list);

            linearLayoutManager.scrollToPositionWithOffset(index, 20);
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void doCalendar() {
        new CreateCalendar().execute("");
    }
}
