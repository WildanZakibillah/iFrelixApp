package com.example.ifrelix;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JobsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobsFragment extends Fragment {

    // Parameter fragment (jika diperlukan)
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public JobsFragment() {
        // Required empty public constructor
    }

    /**
     * Factory method to create a new instance of this fragment.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobsFragment.
     */
    public static JobsFragment newInstance(String param1, String param2) {
        JobsFragment fragment = new JobsFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jobs, container, false);

        // Mendapatkan referensi LinearLayout dari setiap job item
        LinearLayout jobItem1 = view.findViewById(R.id.jobItem1);
        LinearLayout jobItem2 = view.findViewById(R.id.jobItem2);
        LinearLayout jobItem3 = view.findViewById(R.id.jobItem3);
        LinearLayout jobItem4 = view.findViewById(R.id.jobItem4);
        LinearLayout jobItem5 = view.findViewById(R.id.jobItem5);
        LinearLayout jobItem6 = view.findViewById(R.id.jobItem6);

        // Set OnClickListener untuk Job Item 1
        jobItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk menuju Item1Activity
                Intent intent = new Intent(getActivity(), Item1Activity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener untuk Job Item 2
        jobItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk menuju Item2Activity
                Intent intent = new Intent(getActivity(), Item2Activity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener untuk Job Item 3
        jobItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk menuju Item3Activity
                Intent intent = new Intent(getActivity(), Item3Activity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener untuk Job Item 4
        jobItem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk menuju Item4Activity
                Intent intent = new Intent(getActivity(), Item4Activity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener untuk Job Item 5
        jobItem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk menuju Item5Activity
                Intent intent = new Intent(getActivity(), Item5Activity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener untuk Job Item 6
        jobItem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk menuju Item6Activity
                Intent intent = new Intent(getActivity(), Item6Activity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
