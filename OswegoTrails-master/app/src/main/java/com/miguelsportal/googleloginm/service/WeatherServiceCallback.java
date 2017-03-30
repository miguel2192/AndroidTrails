package com.miguelsportal.googleloginm.service;

import com.miguelsportal.googleloginm.data.Channel;

/**
 * Created by Miguel on 11/30/2016.
 */

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
