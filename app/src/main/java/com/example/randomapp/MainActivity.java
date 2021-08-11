package com.example.randomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnRandom;
    EditText edtMin, edtMax;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnRandom = findViewById(R.id.btnRandom);
        edtMin = findViewById(R.id.edtMin);
        edtMax = findViewById(R.id.edtMax);
        txtResult = findViewById(R.id.tvResult);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtMin.getText().toString().length() == 0 || edtMax.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "Điền hết Max Min chưa thằng ngu???", Toast.LENGTH_SHORT).show();
                }
                else {
                    int max, min;
                    min = Integer.parseInt(edtMin.getText().toString());
                    max = Integer.parseInt(edtMax.getText().toString());
                    if (max < min) {
                        Toast.makeText(MainActivity.this, "Đmm mày bị ngu à Max > Min chứ thằng ngu", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Random random = new Random();
                        int result = random.nextInt(max - min + 1) + min;
                        txtResult.setText(result + "");
                    }
                }
            }
        });
    }
}