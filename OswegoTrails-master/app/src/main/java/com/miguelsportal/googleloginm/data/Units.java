package com.miguelsportal.googleloginm.data;

import org.json.JSONObject;

/**
 * Created by Miguel on 11/30/2016.
 */

public class Units implements JSONPopulator {

    private String temperature;

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");

    }

    public String getTemperature() {
        return temperature;
    }
}
