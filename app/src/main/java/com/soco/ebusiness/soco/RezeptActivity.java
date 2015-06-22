package com.soco.ebusiness.soco;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;


public class RezeptActivity extends MainActivity {

    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezept);
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items); // load
        // titles
        // from
        // strings.xml

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);// load icons from
        // strings.xml

        set(navMenuTitles, navMenuIcons);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    public void rezeptSuchen(View view)
    {
        Intent intent = new Intent(RezeptActivity.this, RezeptSuchenActivity.class);
        startActivity(intent);
    }

    public void rezeptErstellen(View view)
    {
        if(App.get_loginstate()) {
            Intent intent = new Intent(this, RezeptErstellenActivity.class);
            startActivity(intent);
        } else sendToast(getString(R.string.msg_loginmissing));
    }
    public void onBackPressed()
    {
        //do whatever you want the 'Back' button to do
        //as an example the 'Back' button is set to start a new Activity named 'NewActivity'
        this.startActivity(new Intent(this, FirstActivity.class));

        return;
    }
    public void mapOpen(View view)
    {


        Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
            //sendToast(getString(R.string.msg_loginmissing));
    }
}
