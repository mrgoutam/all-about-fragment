package com.stark.allaboutfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.stark.allaboutfragment.fragments.simpleFragments.LeftFragmentScreen;
import com.stark.allaboutfragment.fragments.simpleFragments.MiddleFragmentScreen;
import com.stark.allaboutfragment.fragments.simpleFragments.RightFragmentScreen;


public class SimpleFragmentActivity extends AppCompatActivity {
    private FragmentManager simpleFragmentManager;
    private FragmentTransaction simpleFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);
        setTitle("Simple Fragments");

        /*
        The FragmentManager class allows you to add, remove and replace fragments in the layout of your activity.
        It can accessed in an activity via the getSupportFragmentManager() method.
         */
        simpleFragmentManager = getSupportFragmentManager();

        /*
        The modifications must be performed in a transaction via the FragmentTransaction class.
         */
        simpleFragmentTransaction = simpleFragmentManager.beginTransaction();

        /*
        Calling the first fragment
         */
        switchFragment(Tag.LEFT.value);
    }

    public void leftClick(View view) {
        switchFragment(Tag.LEFT.value);
    }

    public void middleClick(View view) {
        switchFragment(Tag.MIDDLE.value);
    }

    public void rightClick(View view) {
        switchFragment(Tag.RIGHT.value);
    }

    private void switchFragment(int tag){
        try {
            simpleFragmentTransaction = simpleFragmentManager.beginTransaction();
            Fragment fragment;
            if (tag==Tag.MIDDLE.value){
                fragment = new MiddleFragmentScreen();
            }else if (tag==Tag.RIGHT.value){
                fragment = new RightFragmentScreen();
            }else {
                fragment = new LeftFragmentScreen();
            }

            simpleFragmentTransaction.replace(R.id.frameLayout_holder, fragment);

            /*
            If you want to add the transaction to the back-stack of Android, you use the addToBackStack() method.
            This adds the action to the history stack of the activity and allows the user to revert this change via
            the back button.
             */
            simpleFragmentTransaction.addToBackStack(null);
            simpleFragmentTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int backStackEntryCount = simpleFragmentManager.getBackStackEntryCount();
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