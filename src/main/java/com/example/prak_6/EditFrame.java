package com.example.prak_6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditFrame extends AppCompatActivity implements View.OnClickListener {
    Button apply;
    EditText text;
    EditText name;
    EditText count;
    EditText cost;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_frame);
        apply = findViewById(R.id.applyButton);
        apply.setOnClickListener(this);
        text = findViewById(R.id.text);
        name = findViewById(R.id.name);
        count = findViewById(R.id.count);
        cost = findViewById(R.id.cost);
        if (BackEnd.EditId != 0) {
            name.setText(StoreFront.arrDisp.get(BackEnd.EditId).Name);
            text.setText(StoreFront.arrDisp.get(BackEnd.EditId).Text);
            count.setText(String.valueOf(StoreFront.arrDisp.get(BackEnd.EditId).Count));
            cost.setText(String.valueOf(StoreFront.arrDisp.get(BackEnd.EditId).Price));
        }
    }
    @Override
    public void onClick(View v) {
        if (BackEnd.EditId != 0) {
            StoreFront.Product pr = new StoreFront.Product(BackEnd.EditId, name.getText().toString(), text.getText().toString(), Integer.parseInt(count.getText().toString()), Integer.parseInt(cost.getText().toString()));
            StoreFront.arrDisp.set(BackEnd.EditId, pr);
        }
        else {
            StoreFront.arrDisp.add(new StoreFront.Product(StoreFront.id, name.getText().toString(), text.getText().toString(), Integer.parseInt(count.getText().toString()), Integer.parseInt(cost.getText().toString())));
            StoreFront.id++;
        }
        BackEnd.backAdap.notifyDataSetChanged();
        finish();
    }
}
