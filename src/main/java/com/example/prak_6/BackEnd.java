package com.example.prak_6;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class BackEnd extends AppCompatActivity implements View.OnClickListener {
    public static BackPagerAdapter backAdap;
    ViewPager pager;
    Button Edit;
    Button GoStoreFront;
    Button Add;
    public static int EditId;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back_end);
        Edit = findViewById(R.id.editButton);
        Edit.setOnClickListener(this);
        GoStoreFront = findViewById(R.id.StoreFrontButton);
        GoStoreFront.setOnClickListener(this);
        Add = findViewById(R.id.addButton);
        Add.setOnClickListener(this);
        pager = findViewById(R.id.pagerList);
        backAdap = new BackPagerAdapter(this, StoreFront.arrDisp);
        pager.setAdapter(backAdap);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.StoreFrontButton:
                Intent intent = new Intent(this, StoreFront.class);
                startActivity(intent);
                finish();
                break;
            case R.id.editButton:
                EditId = pager.getCurrentItem();
                Intent intent2 = new Intent(this, EditFrame.class);
                startActivity(intent2);
                break;
            case R.id.addButton:
                EditId = 0;
                Intent intent3 = new Intent(this, EditFrame.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}
