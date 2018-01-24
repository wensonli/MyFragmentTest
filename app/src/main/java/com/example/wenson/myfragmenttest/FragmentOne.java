package com.example.wenson.myfragmenttest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentOne.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOne extends Fragment {
    public static final String TAG = "Wen.FragmentOne";

    public static final String KEY_STATE = "STATE";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private boolean mState;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentOne() {
        // Required empty public constructor
    }

    private Handler mHandler = new Handler();


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentOne newInstance(String param1, String param2) {
        FragmentOne fragment = new FragmentOne();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null){
            mState = savedInstanceState.getBoolean(KEY_STATE);
        }

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        log("onCreate");
    }


    @Override
    public void onStart() {
        super.onStart();

        log("onStart");
    }


    @Override
    public void onResume() {
        super.onResume();

        log("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();

        log("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();

        log("onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        log("onDestroy");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null){
            mState = savedInstanceState.getBoolean(KEY_STATE);

        }

        asyncall();

        log("onActivityCreated");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        log("onCreateView");

        if (savedInstanceState != null) {
            mState = savedInstanceState.getBoolean(KEY_STATE);
        }

        View v =  inflater.inflate(R.layout.fragment_fragment_one, container, false);

        initView(v);

        return v;
    }

    private void changeState(){
        mState = !mState;
    }

    private void initView(View view){
        Button button = view.findViewById(R.id.btnGotoFragmentTwo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeState();

                if (mListener != null) {
                    mListener.gotoFragmentTwo();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        log("onDestroyView");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        log("onAttach");

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        log("onDetach");

        mListener = null;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        log("onHiddenChanged " + hidden);

        super.onHiddenChanged(hidden);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean(KEY_STATE, mState);

        log("onSaveInstanceState");
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void gotoFragmentTwo();
    }

    private void asyncall(){
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toastShow();
            }
        }, 3000);
    }


    //warning: getActivity() may null !
    private void toastShow(){
        if(!isVisible()){
            log("is not visiable so  no need show toast!");
            return;
        }


        Toast.makeText(getActivity(), "hello one, state is " + mState, Toast.LENGTH_LONG).show();
    }



    private void log(String log){
        Log.i(TAG, log);
    }
}
