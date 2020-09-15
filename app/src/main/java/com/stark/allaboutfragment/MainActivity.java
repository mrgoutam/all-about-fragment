package com.stark.allaboutfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleFragment(View view) {
        startActivity(new Intent(MainActivity.this, SimpleFragmentActivity.class));
    }

    public void fragmentLifeCycle(View view) {
        startActivity(new Intent(MainActivity.this, LifeCycleActivity.class));
    }
}