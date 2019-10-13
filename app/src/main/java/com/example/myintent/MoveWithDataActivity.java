package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithDataActivity extends AppCompatActivity {
    TextView tvName, tvUmur;
    public static String NAME = "name";
    public static String UMUR = "umur";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);
        tvName=findViewById(R.id.tv_name);
        tvUmur=findViewById(R.id.tv_umur);

        String name = getIntent().getStringExtra(NAME);
        int umur = getIntent().getIntExtra(UMUR, 0);
        tvUmur.setText(String.valueOf(umur));
        tvName.setText(name);
    }
}
