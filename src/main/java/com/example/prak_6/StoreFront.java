package com.example.prak_6;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

public class StoreFront extends AppCompatActivity implements View.OnClickListener {
    public static class Product {
        int id;
        String Name;
        String Text;
        int Count;
        int Price;
        Product (int id, String name, String text, int count, int price) {
            this.id = id;
            this.Name = name;
            this.Text = text;
            this.Count = count;
            this.Price = price;
        }
    }
    public static ArrayList<Product> arrDisp = new ArrayList<>(10);
    CustomPagerAdapter adap;
    public static int id = 5;
    ViewPager pager;
    Button Bye;
    Button GoBackEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_front);
        Bye = findViewById(R.id.byeButton);
        Bye.setOnClickListener(this);
        GoBackEnd = findViewById(R.id.BackEndButton);
        GoBackEnd.setOnClickListener(this);
        pager = findViewById(R.id.pagerList);
        adap = new CustomPagerAdapter(this, arrDisp);
        pager.setAdapter(adap);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.BackEndButton:
                Intent intent = new Intent(this, BackEnd.class);
                startActivity(intent);
                finish();
                break;
            case R.id.byeButton:
                if (arrDisp.get(pager.getCurrentItem()).Count != 0) {
                    Product pr = new Product(pager.getCurrentItem(), arrDisp.get(pager.getCurrentItem()).Name, arrDisp.get(pager.getCurrentItem()).Text,
                            arrDisp.get(pager.getCurrentItem()).Count - 1, arrDisp.get(pager.getCurrentItem()).Price);
                    arrDisp.set(pr.id, pr);
                    adap.notifyDataSetChanged();
                }
                break;
            default:
                break;
        }
    }
}
