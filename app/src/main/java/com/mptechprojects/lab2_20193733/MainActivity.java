package com.mptechprojects.lab2_20193733;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonIndications = findViewById(R.id.button_indications);
        Button buttonCalculate = findViewById(R.id.button_calculator);

        TextView textView_Telemath = findViewById(R.id.textView_Telemath);
        registerForContextMenu(textView_Telemath);

        buttonIndications.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, IndicationsActivity.class);
            startActivity(intent);
        });

        buttonCalculate.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NotNull MenuItem item) {
        TextView textView_Telemath = findViewById(R.id.textView_Telemath);

        if (item.getItemId() == R.id.context_blue) {
            textView_Telemath.setTextColor(getResources().getColor(R.color.blue));
            return true;
        } else if (item.getItemId() == R.id.context_red) {
            textView_Telemath.setTextColor(getResources().getColor(R.color.red));
            return true;
        } else if (item.getItemId() == R.id.context_green) {
            textView_Telemath.setTextColor(getResources().getColor(R.color.green));
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}