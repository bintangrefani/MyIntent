package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static String PERSON = "person";
    TextView tvObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        tvObject=findViewById(R.id.tv_object);

        Person bintang = getIntent().getParcelableExtra(PERSON);
        String nama = "Name " + bintang.getAge() + " Umur " + bintang.getName();
        tvObject.setText(nama);

    }
}
