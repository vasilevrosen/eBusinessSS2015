package com.soco.ebusiness.soco;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;


public class MeineFavoritenListActivity extends ListActivity {

    ListView lv;
    List<ParseObject> objectlist;

    List<String> alleUserEventIdStr;
    List<String> alleUserEventsTitel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meine_favoriten_list);

        ParseObject.registerSubclass(Event.class);
        alleUserEventIdStr = new ArrayList<String>();
        alleUserEventsTitel = new ArrayList<String>();

        objectlist = new ArrayList<ParseObject>();


        lv = getListView();



        JSONArray alleUserEventId = ParseUser.getCurrentUser().getJSONArray("userFavoriten");

        for (int i = 1; i < alleUserEventId.length(); i++){

            alleUserEventIdStr.add(alleUserEventId.optString(i));

        }


        for(String s: alleUserEventIdStr){

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Event");

            query.whereEqualTo("objectId", s);

            ParseObject po = null;

            try {
                po = query.getFirst();

            } catch (ParseException e) {
                Toast.makeText(MeineFavoritenListActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            objectlist.add(po);
            alleUserEventsTitel.add(po.getString("Titel"));






        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MeineFavoritenListActivity.this, android.R.layout.simple_list_item_1, alleUserEventsTitel);

        lv.setAdapter(arrayAdapter);
    }


    @Override
    public void onResume(){
        super.onResume();

        ParseObject.registerSubclass(Event.class);
        alleUserEventIdStr = new ArrayList<String>();
        alleUserEventsTitel = new ArrayList<String>();

        objectlist = new ArrayList<ParseObject>();


        lv = getListView();



        JSONArray alleUserEventId = ParseUser.getCurrentUser().getJSONArray("userFavoriten");

        for (int i = 1; i < alleUserEventId.length(); i++){

            alleUserEventIdStr.add(alleUserEventId.optString(i));

        }


        for(String s: alleUserEventIdStr){

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Event");

            query.whereEqualTo("objectId", s);

            ParseObject po = null;

            try {
                po = query.getFirst();

            } catch (ParseException e) {
                Toast.makeText(MeineFavoritenListActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            objectlist.add(po);
            alleUserEventsTitel.add(po.getString("Titel"));






        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MeineFavoritenListActivity.this, android.R.layout.simple_list_item_1, alleUserEventsTitel);

        lv.setAdapter(arrayAdapter);

    }

    @Override
    public void onRestart(){

        super.onRestart();

        ParseObject.registerSubclass(Event.class);
        alleUserEventIdStr = new ArrayList<String>();
        alleUserEventsTitel = new ArrayList<String>();

        objectlist = new ArrayList<ParseObject>();


        lv = getListView();



        JSONArray alleUserEventId = ParseUser.getCurrentUser().getJSONArray("userFavoriten");

        for (int i = 1; i < alleUserEventId.length(); i++){

            alleUserEventIdStr.add(alleUserEventId.optString(i));

        }


        for(String s: alleUserEventIdStr){

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Event");

            query.whereEqualTo("objectId", s);

            ParseObject po = null;

            try {
                po = query.getFirst();

            } catch (ParseException e) {
                Toast.makeText(MeineFavoritenListActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            objectlist.add(po);
            alleUserEventsTitel.add(po.getString("Titel"));






        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MeineFavoritenListActivity.this, android.R.layout.simple_list_item_1, alleUserEventsTitel);

        lv.setAdapter(arrayAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_meine_favoriten_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String objectId = objectlist.get(position).getObjectId();

        Intent intent = new Intent(MeineFavoritenListActivity.this, EventActivity.class);
        intent.putExtra("objectId",objectId);
        startActivity(intent);



    }
}
