package com.example.asus.turkcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Profile extends Fragment implements View.OnClickListener{

    private Button add ;

    private  static  final String TAG="Profile";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile,container,false);

        add = (Button) view.findViewById(R.id.add);
        add.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Storage.class);
        startActivity(intent);
    }
}
