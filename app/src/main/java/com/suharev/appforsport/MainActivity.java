package com.suharev.appforsport;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText massText, heightText;
    Button calculate;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        massText = findViewById(R.id.mass);
        heightText = findViewById(R.id.height);
        resultText = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);
        final float textSize = resultText.getTextSize() * 30;
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText.setTextSize(textSize);
                double mass = Double.parseDouble(massText.getText().toString());
                double height = Double.parseDouble(heightText.getText().toString());
                StringBuilder result = new StringBuilder();
                Double tmpResult;
                if (mass > 0 && height > 0) {
                    tmpResult = mass / Math.pow(height / 100, 2);
                    result.append(tmpResult);
                    if (tmpResult >= 18.5 && tmpResult <= 24.9) {
                        resultText.setTextColor(Color.GREEN);
                        result.append("\nYou are perfect");
                    } else if (tmpResult < 18.5) {
                        resultText.setTextColor(Color.RED);
                        result.append("\nYou should eat more");
                    } else {
                        resultText.setTextColor(Color.RED);
                        result.append("\nYou should stop eating");
                    }

                } else {
                    result.append("INVALID FORMAT DATA");
                    resultText.setTextColor(Color.RED);
                }
                resultText.setText(result);
            }
        });
    }
}