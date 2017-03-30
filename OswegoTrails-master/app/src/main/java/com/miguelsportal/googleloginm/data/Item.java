package com.miguelsportal.googleloginm.data;

import org.json.JSONObject;

/**
 * Created by Miguel on 11/30/2016.
 */

public class Item implements JSONPopulator {

    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));

    }
}
