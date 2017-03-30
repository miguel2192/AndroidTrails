package com.miguelsportal.googleloginm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JourneyActivity extends AppCompatActivity {

    Trail trail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* String trail_Id = getIntent().getStringExtra(TrailActivity.TRAIL_ID);
        Trail trail = DataProvider.trailMap.get(trail_Id);*/

        Bundle bundle = getIntent().getExtras();
        trail = bundle.getParcelable("com.miguelsportal.googleloginm.Trail");

        refreshDisplay();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /**
                 * Created by Miguel on 12/2/2016.
                 * Description: This is for the journey button interaction!!!
                 */
//                double latitude = 47.6;
//                double longitude = -122.3;
//                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//               startActivity(intent);
               if(trail.getName().equals("Albion Cross Trail")) {
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1ugKU8dWVGNID3pZL4QfhCfJI128&ll=43.50697797782801%2C-76.00427630000001&z=18");
                   intent.setData(myUri);
                   startActivity(intent);
               }else if(trail.getName().equals("Altmar State Forest Trail")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1gt-BilAeDsu6MlJfz2hLCUkcqaM&ll=43.51233137782779%2C-76.06435779999998&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Amboy 4H Environmental Education Center")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1DSBH8mYAWxJEREM1mDv4eEDVtN8&ll=43.41365217783192%2C-75.90917589999998&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Breitbeck Park Trail ")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1YUcbsNvrGoKxk0ivhI8SkSp8RP8&ll=43.4614544778299%2C-76.52320860000003&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Chateaugay State Forest")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1-y9X6zEm7TEMJSITbTCi54eA43M&ll=43.577903677825226%2C-75.95106120000003&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Deer Creek Marsh")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1iXUlkN66depSMuuWfO3HtPFJHEQ&ll=43.603609277824255%2C-76.19705199999999&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Derby Hill Bird Observatory")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1WuOiPBJiaSkJ243UwJtE_NMWnfQ&ll=43.527511877827195%2C-76.23953010000002&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Fallbrook Recreation Center")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1Wx1lUclFv2r2AiswM5A0uX_wsmY&ll=43.424564077831434%2C-76.5397686&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Fort Ontario Historical Site")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=117RePZ2VIB4o4F1gD3BW92NeaXI&ll=43.46774637782963%2C-76.50511979999999&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Great Bear Springs Recreation Area")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=124l8JxDoDujzmWQrQDTGiuzM9GI&ll=43.265874277838535%2C-76.35196029999997&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Hall Island State Forest Trails")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1PPpHZ9GAzechs7zF1bH1VwccFaU&ll=43.517855577827575%2C-75.8586967&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Happy Valley Wildlife Management Area")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1CinHI9F1J6wNRotM3ImhehB6uoI&ll=43.453417377830206%2C-75.94488139999999&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Independence Park")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1bWdikgftoJRaY0N9KqUkiXbgsgc&ll=43.50171724479766%2C-76.44797800000003&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Kasoag State Forest Trail")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1Ll-8SKEllfSLXPtzlyJApEjb2RA&ll=43.464222777829775%2C-75.9062576&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Klondike State Forest")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1XfUtw369fGx7dbhlpA-mHCHsuac&ll=43.362504877834155%2C-75.9687424&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Littlejohn State Wildlife Management Area")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=10AFyTL8w376nakc_y9c8WH1iYHM&ll=43.67394987782164%2C-75.8752955&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Mexico Point Park")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1vc0tbUH047YfV9O86_c2yo-kdFs&ll=43.52068067782747%2C-76.25642070000004&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("O'Hara State Forest Trail")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=16y1ovGBnnHnShRaExr0lC8l7hMI&ll=43.49191107782863%2C-75.82008359999998&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Oswego County Forest Land")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1I3quhITPp5g9g7NrumuViGITHUI&ll=43.431751377831134%2C-75.90661239999997&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Oswego County Nature Park at Camp Zerbe")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1A7Vag-qFCLs8LdDSXtNBEDjpJQI&ll=43.45995927782994%2C-75.96599579999997&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Oswego County Recreation Trail")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=11n1sU1DHiDV_hNJPgWZKMg3HvKw&ll=43.31181417783641%2C-76.3809013&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Oswego East and West Riverwalks")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=181VVCHmrSVzeinZcSar2mnX_49Y&ll=43.45541117783014%2C-76.50702950000004&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Rice Creek Biological Field Station")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1H_Y0z51q2kNoD3314UauPjN85Ew&ll=43.43043317783121%2C-76.5425366&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Richard A. Noyes Bird Sanctuary")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1CXPUqWdEvRcnowcvDsMli7v7pJE&ll=43.5202361778275%2C-76.3705534&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Sage Creek Trail")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=10FXnnPPlOyK5IYjxfY-PTgWoeMI&ll=43.50072907782827%2C-76.20054959999999&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Salmon River Falls Unique Area")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1JYP5idohzm3Zu2eHNoiD0Jyr7_k&ll=43.54929457782634%2C-75.94419479999999&z=18");
                   intent.setData(myUri);
                   startActivity(intent);


               }else if(trail.getName().equals("Sandy Island Beach State Park")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=17dxWL7MnW4u3X54m3dUMS3jOjyQ&ll=43.63094237782323%2C-76.19475599999998&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Selkirk Shores State Park")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1FJaSAWKkcuQs9On-zdIpYHxNdaw&ll=43.544760977826535%2C-76.19273900000002&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Sunset Bay Park")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1WlI5z26wsPIVsjiz8pUekCq7Mp4&ll=43.521029777827465%2C-76.38379279999998&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Trout Brook State Forest")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1RDR2I9OplVVdGOlJrz9biz3kAL4&ll=43.61047667782397%2C-76.00101469999998&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else if(trail.getName().equals("Winona State Forest Recreation Area")){
                   Intent intent = new Intent("android.intent.action.VIEW");
                   intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                   intent.addCategory("android.intent.category.LAUNCHER");
                   Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=1uwSgBi4EB4WyvMri4YMtYAAz_zs&ll=43.69307317782096%2C-75.97526550000003&z=18");
                   intent.setData(myUri);
                   startActivity(intent);

               }else{
                   Context context = getApplicationContext();
                   CharSequence text = "Invalid Journey Event!";
                   int duration = Toast.LENGTH_SHORT;

                   Toast toast = Toast.makeText(context, text, duration);
                   toast.show();

               }//ends else
            }//ends onClick

        });//ends FloatingActionButton Journey

        //facebook button <-----actionListener----/>
        FloatingActionButton fab_facebook = (FloatingActionButton) findViewById(R.id.fab_facebook);
        fab_facebook.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {

                String message = "I am using the Oswego County Trails App! \n\"Please go to the android store to download it and start hiking!\"";
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(share, "Share App & Trail with Family & Friends"));



            }
        });//ends FloatingActionButton Facebook
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void refreshDisplay() {

        TextView tv = (TextView) findViewById(R.id.nameText);
        tv.setText(trail.getName());

        tv = (TextView) findViewById(R.id.descriptionText);
        tv.setText(trail.getDescription());

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        Bitmap bitmap = getBitmapFromAsset(trail.getImage());
        iv.setImageBitmap(bitmap);

    }

    private Bitmap getBitmapFromAsset(String trailId) {
        AssetManager assetManager = getAssets();
        InputStream stream = null;

        try {
            stream = assetManager.open(trailId + ".jpg");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void share(String nameApp, String imagePath, String message) {
        try {
            List<Intent> targetedShareIntents = new ArrayList<Intent>();
            Intent share = new Intent(android.content.Intent.ACTION_SEND);
            share.setType("image/jpeg");
            List<ResolveInfo> resInfo = getPackageManager()
                    .queryIntentActivities(share, 0);
            if (!resInfo.isEmpty()) {
                for (ResolveInfo info : resInfo) {
                    Intent targetedShare = new Intent(
                            android.content.Intent.ACTION_SEND);
                    targetedShare.setType("image/jpeg"); // put here your mime
                    // type
                    if (info.activityInfo.packageName.toLowerCase().contains(
                            nameApp)
                            || info.activityInfo.name.toLowerCase().contains(
                            nameApp)) {
                        targetedShare.putExtra(Intent.EXTRA_SUBJECT,
                                "Sample Photo");
                        targetedShare.putExtra(Intent.EXTRA_TEXT, message);
                        targetedShare.putExtra(Intent.EXTRA_STREAM,
                                Uri.fromFile(new File(imagePath)));
                        targetedShare.setPackage(info.activityInfo.packageName);
                        targetedShareIntents.add(targetedShare);
                    }
                }
                Intent chooserIntent = Intent.createChooser(
                        targetedShareIntents.remove(0), "Select app to share");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,
                        targetedShareIntents.toArray(new Parcelable[] {}));
                startActivity(chooserIntent);
            }
        } catch (Exception e) {
            Log.v("VM",
                    "Exception while sending image on" + nameApp + " "
                            + e.getMessage());
        }
    }

}
