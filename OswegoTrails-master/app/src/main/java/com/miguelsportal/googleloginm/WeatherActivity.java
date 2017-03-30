package com.miguelsportal.googleloginm;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelsportal.googleloginm.data.Channel;
import com.miguelsportal.googleloginm.data.Item;
import com.miguelsportal.googleloginm.service.WeatherServiceCallback;
import com.miguelsportal.googleloginm.service.YahooWeatherService;

/**
 * Created by Miguel on 11/6/2016.
 * Description: This is the weather's class. A weather
        * interactive application implementation is in progress.....
        */

public class WeatherActivity extends Activity implements WeatherServiceCallback {

    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherIconImageView = (ImageView)findViewById(R.id.weatherIconImageView);
        temperatureTextView  = (TextView)findViewById(R.id.temperatureTextView);
        conditionTextView = (TextView)findViewById(R.id.conditionTextView);
        locationTextView = (TextView)findViewById(R.id.locationTextView);

        service = new YahooWeatherService(this);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();
        service.refreshWeather("Oswego, NY");

    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();
        int resourceId = getResources().getIdentifier("drawable/icon_"+ item.getCondition().getCode(),null,getPackageName());

        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resourceId);

        weatherIconImageView.setImageDrawable(weatherIconDrawable);

        temperatureTextView.setText(item.getCondition().getTemperature()+" "+channel.getUnits().getTemperature());
        conditionTextView.setText(item.getCondition().getDescription());
        locationTextView.setText(service.getLocation());



    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();

    }
}
