package com.example.wenson.myfragmenttest;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class OneFragmentActivity extends AppCompatActivity implements FragmentOne.OnFragmentInteractionListener,
                        FragmentTwo.OnFragmentInteractionListener{

    private final static String TAG = "Wen.Activity";

    private @Nullable Fragment currFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composit_fragment);

        log("onCreate");

        if(savedInstanceState == null){
            Fragment fragmentOne = FragmentOne.newInstance("","");
            getSupportFragmentManager()
                    .beginTransaction()
                    .add( R.id.content, fragmentOne,  FragmentOne.TAG)
                    .commit();
        }
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
    public void gotoFragmentTwo() {

        Fragment fragmentTwo = FragmentTwo.newInstance("","");
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(FragmentTwo.TAG)
                .add( R.id.content, fragmentTwo,  FragmentTwo.TAG)
                .hide(currFragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    public static void Launch(Context context){
        Intent intent = new Intent(context, OneFragmentActivity.class);
        ActivityCompat.startActivity(context, intent, null);
    }

}
