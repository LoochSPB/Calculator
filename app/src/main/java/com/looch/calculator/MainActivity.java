package com.looch.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calculator calculator;
    private String monitortxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView monitor = findViewById(R.id.monitor);
        if (savedInstanceState != null) {
            calculator = new Calculator(savedInstanceState.getString(monitortxt));
            monitor.setText(calculator.getMonitortxt());
        } else {
            calculator = new Calculator();
        }


        Button[] buttons = new Button[10];
        buttons[1] = findViewById(R.id.key_1);
        buttons[2] = findViewById(R.id.key_2);
        buttons[3] = findViewById(R.id.key_3);
        buttons[4] = findViewById(R.id.key_4);
        buttons[5] = findViewById(R.id.key_5);
        buttons[6] = findViewById(R.id.key_6);
        buttons[7] = findViewById(R.id.key_7);
        buttons[8] = findViewById(R.id.key_8);
        buttons[9] = findViewById(R.id.key_9);
        buttons[0] = findViewById(R.id.key_zero);


        View.OnClickListener buttonPressed = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.buttonPressed(v.getId());
                monitor.setText(calculator.getMonitortxt());
            }
        };

        for (Button button : buttons) {
            button.setOnClickListener(buttonPressed);
        }



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(monitortxt, calculator.getMonitortxt());
    }
}