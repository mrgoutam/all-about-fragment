package com.stark.allaboutfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.stark.allaboutfragment.fragments.lifyCycleFragment.LifeCycleFragment1;
import com.stark.allaboutfragment.fragments.lifyCycleFragment.LifeCycleFragment2;
import com.stark.allaboutfragment.fragments.lifyCycleFragment.LifeCycleFragment3;

public class LifeCycleActivity extends AppCompatActivity {
    private FragmentManager lifeCycleFragmentManager;
    private FragmentTransaction lifeCycleFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        setTitle("Fragment Lifecycle");

        lifeCycleFragmentManager = getSupportFragmentManager();
        lifeCycleFragmentTransaction = lifeCycleFragmentManager.beginTransaction();
        switchFragment(Tag.LEFT.value);
    }

    public void leftClick(View view) {
        switchFragment(SimpleFragmentActivity.Tag.LEFT.value);
    }

    public void middleClick(View view) {
        switchFragment(SimpleFragmentActivity.Tag.MIDDLE.value);
    }

    public void rightClick(View view) {
        switchFragment(Tag.RIGHT.value);
    }

    private void switchFragment(int tag){
        try {
            lifeCycleFragmentTransaction = lifeCycleFragmentManager.beginTransaction();
            Fragment fragment;
            if (tag==Tag.MIDDLE.value){
                fragment = new LifeCycleFragment2();
            }else if (tag== Tag.RIGHT.value){
                fragment = new LifeCycleFragment3();
            }else {
                fragment = new LifeCycleFragment1();
            }

            lifeCycleFragmentTransaction.replace(R.id.frameLayout_holder, fragment);

            lifeCycleFragmentTransaction.addToBackStack(null);
            lifeCycleFragmentTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int backStackEntryCount = lifeCycleFragmentManager.getBackStackEntryCount();
        if (backStackEntryCount==0){
            Toast.makeText(this, "End of BackStack", Toast.LENGTH_SHORT).show();
        }
    }

    enum Tag{
        LEFT(0),
        MIDDLE(1),
        RIGHT(3);

        int value;
        Tag(int tag) {
            value = tag;
        }
    }
}