package com.example.wenson.myfragmenttest;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ViewPageActivity extends AppCompatActivity  implements FragmentOne.OnFragmentInteractionListener,
        FragmentTwo.OnFragmentInteractionListener{

    private final static String TAG = "Wen.Activity";

    private @Nullable
    Fragment currFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        log("onCreate");

        initView();
    }

    private void initView(){
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(FragmentOne.newInstance("",""));
        fragments.add(FragmentTwo.newInstance("",""));

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), fragments);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(1); //avoid cache
        viewPager.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        log("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        log("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        log("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        log("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        log("onDestroy");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        currFragment = fragment;
        log("onAttachFragment");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        log("onConfigurationChanged");
    }


    private void log(String log){
        Log.i(TAG, log);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void gotoFragmentTwo() {

    }

    public static void Launch(Context context){
        Intent intent = new Intent(context, ViewPageActivity.class);
        ActivityCompat.startActivity(context, intent, null);
    }

}
