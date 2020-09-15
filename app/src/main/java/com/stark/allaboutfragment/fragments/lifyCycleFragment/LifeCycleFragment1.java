package com.stark.allaboutfragment.fragments.lifyCycleFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.stark.allaboutfragment.LifeCycleActivity;
import com.stark.allaboutfragment.R;


public class LifeCycleFragment1 extends Fragment {
    private LifeCycleActivity mainContext;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public LifeCycleFragment1() {
        // Required empty public constructor
    }

    public static LifeCycleFragment1 newInstance(String param1, String param2) {
        LifeCycleFragment1 fragment = new LifeCycleFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /*
    The fragment instance is associated with an activity instance.The fragment and the activity is not fully initialized.
    Typically you get in this method a reference to the activity which uses the fragment for further initialization work.
    */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainContext = (LifeCycleActivity) context;
        showToast("onAttach");
    }

    /*
    Fragment is created. The onCreate() method is called after the onCreate() method of the activity but before the
    onCreateView() method of the fragment.
    */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToast("onCreate");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /*
    The fragment instance creates its view hierarchy. In the onCreateView() method the fragment creates its user interface.
    Here you can inflate a layout via the inflate() method call of the Inflator object passed as a parameter to this method.
    In this method you should not interactive with the activity, the activity is not yet fully initialized.
    There is no need to implement this method for headless fragments.The inflated views become part of the view hierarchy of
    its containing activity.
    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        showToast("onCreateView");
        return inflater.inflate(R.layout.fragment_life_cycle1, container, false);
    }

    /*
    The onActivityCreated() is called after the onCreateView() method when the host activity is created.
    Activity and fragment instance have been created as well as the view hierarchy of the activity. At this point,
    view can be accessed with the findViewById() method.
    i.e In this method you can instantiate objects which require a Context object.
    */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showToast("onActivityCreated");
    }

    /*
    The onStart() method is called once the fragment gets visible.
    */
    @Override
    public void onStart() {
        super.onStart();
        showToast("onStart");
    }

    /*
    Fragment becomes active.
    */
    @Override
    public void onResume() {
        super.onResume();
        showToast("onResume");
    }

    /*
    Fragment is visible but becomes not active anymore, e.g., if another activity is animating on top of the
    activity which contains the fragment.
    */
    @Override
    public void onPause() {
        super.onPause();
        showToast("onPause");
    }

    /*
    Fragment becomes not visible.
     */
    @Override
    public void onStop() {
        super.onStop();
        showToast("onStop");
    }

    /*
    Destroys the view of the fragment. If the fragment is recreated from the backstack this method is called and afterwards
    the onCreateView method.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        showToast("onDestroyView");
    }

    /*
    Not guaranteed to be called by the Android platform.
    */
    @Override
    public void onDestroy() {
        super.onDestroy();
        showToast("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        showToast("onDetach");
    }

    private void showToast(String msg){
        Toast.makeText(mainContext, msg + " called", Toast.LENGTH_SHORT).show();
    }
}