package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Fragment fragment,fragment_lower;
    LowerOperationViewModel lowerOperationViewModel;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lowerOperationViewModel=new ViewModelProvider(MainActivity.this).get(LowerOperationViewModel.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#d7dadb"));
        }
        if(savedInstanceState==null)
        {
            fragment=new upper_ans();
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.fragment_container,upper_ans.class,null).commit();
            fragment_lower=new lower_operation();
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.fragment_container_work,lower_operation.class,null).commit();

        }
    }
}