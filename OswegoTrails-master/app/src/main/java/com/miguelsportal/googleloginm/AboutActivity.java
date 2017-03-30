package com.miguelsportal.googleloginm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by Miguel on 12/3/2016.
 */

public class AboutActivity extends AppCompatActivity {

    private TextView textView;
    private Animation animation;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.credits);
        textView = (TextView)findViewById(R.id.textView16);
        textView.setText("The intent of this\n" +
                " application is to encourage\n" +
                " the exploration and enjoyment\n" +
                " of Oswego County's many forests,\n" +
                " parks, and trails.\n\n"+
                "For additional information,\n" +
                " contact Oswego County Parks\n" +
                " and Recreation at 315-349-3451.\n\n"+
                "DEVELOPERS\n\n"+
                "This app was developed\n" +
                " for SUNY Oswego's CSC-380\n" +
                " Software Engineering course\n" +
                " under Dr. James Early.\n\n"+"Miguel Rodriguez\n"+
                "Luke Cavanaugh\n" +"James Olds\n" +"Nicholas Russo\n");

        textView.startAnimation(animation);
    }
}
