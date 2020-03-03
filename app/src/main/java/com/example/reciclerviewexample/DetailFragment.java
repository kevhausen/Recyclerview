package com.example.reciclerviewexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String animalName;
    private String animalUrl;

    private ImageView imageView;
    private TextView textViewName;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
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
            animalName = getArguments().getString(ARG_PARAM1);
            animalUrl = getArguments().getString(ARG_PARAM2);


        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        initializeView(view);
        textViewName.setText(animalName);
        Glide.with(getContext()).load(animalUrl).centerCrop().into(imageView);


        return view;
    }

    private void initializeView (View view){
        textViewName =view.findViewById(R.id.textViewDetail);
        imageView =view.findViewById(R.id.imageViewDetail);
    }
}
