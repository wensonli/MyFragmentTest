package com.example.wenson.myfragmenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        Button btnOneButton = findViewById(R.id.btnOneButton);
        btnOneButton.setOnClickListener(this);

        Button btnTwoButton = findViewById(R.id.btnTwoButton);
        btnTwoButton.setOnClickListener(this);

        Button btnViewPagerButton = findViewById(R.id.btnViewPagerButton);
        btnViewPagerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){

            case R.id.btnOneButton:
                OneFragmentActivity.Launch(this);
                break;

            case R.id.btnTwoButton:
                TwoFragmentActivity.Launch(this);
                break;

            case R.id.btnViewPagerButton:
                ViewPageActivity.Launch(this);
                break;
            default:

                break;
        }
    }


}
