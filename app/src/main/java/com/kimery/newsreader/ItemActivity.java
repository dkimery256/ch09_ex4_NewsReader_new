package com.kimery.newsreader;


import android.os.Bundle;
import android.app.Activity;

public class ItemActivity extends Activity implements ItemFragment.FragListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
    }

}