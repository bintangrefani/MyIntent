package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MoveForResultActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rgChoose;
    RadioButton rb10, rb20, rb30, rb40;
    Button btnChoose;
    public static String EXTRA_SELECTED_VALUE = "pilih";
    public static int RESULT_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);
        rgChoose=findViewById(R.id.rg_choose);
        rb10=findViewById(R.id.rb_10);
        rb20=findViewById(R.id.rb_20);
        rb30=findViewById(R.id.rb_30);
        rb40=findViewById(R.id.rb_40);
        btnChoose=findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_choose)
        {
            if (rgChoose.getCheckedRadioButtonId()!=0)
            {
                int value = 0;
                switch (rgChoose.getCheckedRadioButtonId())
                {
                    case R.id.rb_10:
                        value=10;
                        break;
                    case R.id.rb_20:
                        value=20;
                        break;
                    case R.id.rb_30:
                        value=30;
                        break;
                    case R.id.rb_40:
                        value=40;
                        break;
                }
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE, resultIntent);
                finish();
            }
        }
    }
}
