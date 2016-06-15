package com.example.rohith.pollutionmonitor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Rohith on 6/15/16.
 */
public class CustomAdapter extends ArrayAdapter<String>{

    public CustomAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        View mySpinner = layoutInflater.inflate(R.layout.spinner_rows,parent, false);
        return mySpinner;
    }



}
