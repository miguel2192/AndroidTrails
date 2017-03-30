package com.miguelsportal.googleloginm;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.miguelsportal.googleloginm.db.TrailsDataSource;

import java.util.List;

public class TrailActivity extends AppCompatActivity
{

    public static final String PRODUCT_ID = "PRODUCT_ID";
    private List<Trail> trails;
    private TrailsDataSource datasource;
    private ArrayAdapter<Trail> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        datasource = new TrailsDataSource(this);
        datasource.open();

        trails = datasource.findAll();
        if (trails.size() == 0) {
            createData();
            trails = datasource.findAll();
        }

        refreshDisplay();



        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(TrailActivity.this,JourneyActivity.class );

                Trail trail = trails.get(position);
                intent.putExtra("com.miguelsportal.googleloginm.Trail",trail);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {// Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.menu_trail,menu);
        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView search = (SearchView) menu.findItem(R.id.action_Search).getActionView();
        search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                trails = datasource.searchName(query);
                refreshDisplay();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //custom adapter doesn't support the required methods?
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        switch (id)
        {
            case R.id.action_Alphanumeric:
                trails = datasource.findAll();
                refreshDisplay();
                return true;
//            case R.id.action_Rating:
//                trails = datasource.findFiltered("rating = 1", "rating DESC");
//                refreshDisplay();
//                return true;
            case R.id.action_Type:
                trails = datasource.findFiltered("bike = 1", "bike DESC");
                refreshDisplay();
                return true;
            case R.id.action_Search:
               // Controlled by the Override in onCreateOptionsMenu()
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        datasource.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        datasource.close();
    }

    private void createData()
    {
        TrailsPullParser parser = new TrailsPullParser();
        List<Trail> trails = parser.parseXML(this);

        for (Trail trail : trails)
        {
            datasource.create(trail);
        }

    }

    public void refreshDisplay()
    {
        //TrailListAdapter adapter = new TrailListAdapter(this, R.layout.list_item, trails);
        adapter = new TrailListAdapter(this, android.R.layout.simple_list_item_1,trails);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

    }

}
