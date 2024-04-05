package com.mptechprojects.lab2_20193733;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IndicationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indications);

        Button buttonCalculate = findViewById(R.id.button_calculator);

        buttonCalculate.setOnClickListener(v -> {
            Intent intent = new Intent(IndicationsActivity.this, CalculatorActivity.class);
            startActivity(intent);
        });

    }
}