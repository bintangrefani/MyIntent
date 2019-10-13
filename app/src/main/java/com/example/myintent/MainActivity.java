package com.example.myintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMove, btnMoveData, btnMoveObject, btnDialNumber, btnMoveResult;
    TextView tvResult;
    private int REQUEST_CODE = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMove=findViewById(R.id.btn_move);
        btnMoveData=findViewById(R.id.btn_move_data);
        btnMoveObject=findViewById(R.id.btn_move_object);
        btnDialNumber=findViewById(R.id.btn_dial_number);
        btnMoveResult=findViewById(R.id.btn_move_result);
        tvResult=findViewById(R.id.tv_result);

        btnMove.setOnClickListener(this);
        btnMoveData.setOnClickListener(this);
        btnMoveObject.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);
        btnMoveResult.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE)
        {
            if (resultCode == MoveForResultActivity.RESULT_CODE)
            {
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.valueOf(selectedValue));
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_move:
                Intent intent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_move_data:
                Intent intent2 = new Intent(MainActivity.this, MoveWithDataActivity.class);
                intent2.putExtra(MoveWithDataActivity.NAME, "Bintang");
                intent2.putExtra(MoveWithDataActivity.UMUR, 21);
                startActivity(intent2);
                break;
            case R.id.btn_move_object:
                Intent intent3 = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                Person bintang = new Person();
                bintang.setName("Bintang Refani Mauludi");
                bintang.setAge(21);
                intent3.putExtra(MoveWithObjectActivity.PERSON, bintang);
                startActivity(intent3);
                break;
            case R.id.btn_dial_number:
                String phoneNumber = "087786563041";
                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+phoneNumber));
                startActivity(intent4);
                break;
            case R.id.btn_move_result:
                Intent moveForResult = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResult, REQUEST_CODE);
                break;
        }
    }
}
