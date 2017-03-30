package com.miguelsportal.googleloginm;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by James on 11/12/2016.
 */

public class TrailListAdapter extends ArrayAdapter<Trail> {
    private Context context;
    private List<Trail> trails;

    public TrailListAdapter(Context context, int resource, List<Trail> objects) {
        super(context, resource, objects);
        trails = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Trail trail = trails.get(position);
        TextView nameText = (TextView) convertView.findViewById(R.id.nameText);
        nameText.setText(trail.getName());


        return convertView;
    }


}