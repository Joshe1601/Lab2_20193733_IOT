package com.mptechprojects.lab2_20193733;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CalculatorActivity extends AppCompatActivity {

    private double firstNumber;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_divide);
        Button buttonEquals = findViewById(R.id.button_equals);
        Button buttonClear = findViewById(R.id.button_clear);

        TextView textViewA = findViewById(R.id.textA);
        TextView textViewB = findViewById(R.id.textB);

        ArrayList<Button> numbers = new ArrayList<>();

        numbers.add(button0);
        numbers.add(button1);
        numbers.add(button2);
        numbers.add(button3);
        numbers.add(button4);
        numbers.add(button5);
        numbers.add(button6);
        numbers.add(button7);
        numbers.add(button8);
        numbers.add(button9);

        for (Button b : numbers) {
            b.setOnClickListener(v -> {
                if (textViewB.getText().toString().equals("0")) {
                    textViewB.setText(b.getText());
                } else {
                    textViewB.setText(textViewB.getText().toString() + b.getText().toString());
                }
            });
        }

        ArrayList<Button> operators = new ArrayList<>();

        operators.add(buttonPlus);
        operators.add(buttonMinus);
        operators.add(buttonMultiply);
        operators.add(buttonDivide);

        for (Button b : operators) {
            b.setOnClickListener(v -> {
                firstNumber = Double.parseDouble(textViewB.getText().toString());
                operator = b.getText().toString();
                textViewA.setText(textViewB.getText().toString()+operator);
                textViewB.setText("0");
            });
        }

        buttonClear.setOnClickListener(v -> {
            //textViewA.setText("");
            textViewB.setText("0");
        });

        buttonEquals.setOnClickListener(v -> {
            double secondNumber = Double.parseDouble(textViewB.getText().toString());
            double result = 0;
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
            }
            textViewA.setText("");
            textViewB.setText(String.valueOf(result));
        });


    }
}
