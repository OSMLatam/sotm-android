package org.openstreetmap.sotmlatam.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.openstreetmap.sotmlatam.ProgramActivity;
import org.openstreetmap.sotmlatam.R;


public class WelcomeFragment extends Fragment {

    public WelcomeFragment() {
        // Required empty public constructor
    }


    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
         ((Button)view.findViewById(R.id.btnProgram)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),
                        ProgramActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }






}
