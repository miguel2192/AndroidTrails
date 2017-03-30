package com.miguelsportal.googleloginm;

/**
 * Created by James on 11/27/2016.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.util.Log;


public class TrailsPullParser {


    private static final String TRAIL_ID = "TrailId";
    private static final String TRAIL_NAME = "trailName";
    private static final String TRAIL_DESC = "description";
    private static final String TRAIL_BIKE = "bike";
    private static final String TRAIL_IMAGE = "image";
    private static final String TRAIL_RATING = "rating";

    private Trail currentTrail  = null;
    private String currentTag = null;
    List<Trail> trails = new ArrayList<Trail>();

    public List<Trail> parseXML(Context context)
    {

        try
        {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            InputStream stream = context.getResources().openRawResource(R.raw.trails);
            xpp.setInput(stream, null);

            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT)
            {
                if (eventType == XmlPullParser.START_TAG)
                {
                    handleStartTag(xpp.getName());
                }
                else if (eventType == XmlPullParser.END_TAG)
                {
                    currentTag = null;
                }
                else if (eventType == XmlPullParser.TEXT)
                {
                    handleText(xpp.getText());
                }
                eventType = xpp.next();
            }

        }
        catch (NotFoundException e)
        {
           //
        }
        catch (XmlPullParserException e)
        {
            //
        }
        catch (IOException e)
        {
            //
        }

        return trails;
    }

    private void handleText(String text) {
        String xmlText = text;
        if (currentTrail != null && currentTag != null) {
            if (currentTag.equals(TRAIL_ID)) {
                Integer id = Integer.parseInt(xmlText);
                currentTrail.setTrailID(id);
            }
            else if (currentTag.equals(TRAIL_NAME)) {
                currentTrail.setName(xmlText);
            }
            else if (currentTag.equals(TRAIL_DESC)) {
                currentTrail.setDescription(xmlText);
            }
            else if (currentTag.equals(TRAIL_BIKE)) {
                Integer bike = Integer.parseInt(xmlText);
                currentTrail.setBike(bike);
            }
            else if (currentTag.equals(TRAIL_IMAGE)) {
                currentTrail.setImage(xmlText);
            }
            else if (currentTag.equals(TRAIL_RATING)){
                Integer rating = Integer.parseInt(xmlText);
                currentTrail.setRating(rating);
            }
        }
    }

    private void handleStartTag(String name) {
        if (name.equals("trail")) {
            currentTrail = new Trail();
            trails.add(currentTrail);
        }
        else {
            currentTag = name;
        }
    }
}
