package com.miguelsportal.googleloginm;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Miguel on 11/6/2016.
 * Description: This is the Menu class, a menu is provided
 *  for the user to navegate.
 */

public class MenuActivity extends Activity {

//    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu); //ties this class to layout_menu

//        b = (Button) findViewById(R.id.button6);
//        b.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//             startActivity(new Intent(getApplicationContext(), AboutActivity.class));
//            }
//        });
    }

    public void showMenu(View view){

        //gets the button text from every button in menu
        String button_text;
        button_text = ((Button) view).getText().toString();
        System.out.println(button_text);

        /**
         * When user clicks on button, it gets the text and
         * compares it to the boolean conditionals listed below.
         * if any of the boolean conditionals matches the text
         * from button, then it opens the respective class.
         */

        if(button_text.equals("Maps")){

            //created by Luke Cavanaugh
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
            intent.addCategory("android.intent.category.LAUNCHER");
            Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=14yPhjw2mg8i4pm4GmLhDGnK2Aak&ll=43.380786449624686%2C-76.60614119252932&z=13");
            intent.setData(myUri);
            startActivity(intent);

        }else if(button_text.equals("Trails")){
            Intent intent = new Intent(this, TrailActivity.class);
            startActivity(intent);
        }else if(button_text.equals("Weather")){
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
        }else if(button_text.equals("Compass")){
            Intent intent = new Intent(this, CompassActivity.class);
            startActivity(intent);
        }else if(button_text.equals("About")){
//            Intent intent = new Intent(this, AboutActivity.class);
//            startActivity(intent);
            startActivity(new Intent(getApplicationContext(), AboutActivity.class));

        }else{
            System.out.println("Invalid Event!");
        }



    }
}
