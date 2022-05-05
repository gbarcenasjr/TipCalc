package com.example.tipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BlendMode;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextPercent,editTextAmount;
    TextView textViewPercent,textViewAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init()
    {
        editTextAmount = findViewById(R.id.et_amount);
        editTextPercent = findViewById(R.id.et_tip_percent);
        textViewAmount = findViewById(R.id.tv_tip_amount);
        textViewPercent = findViewById(R.id.tv_total_amount);


    }
    public void calculate(View view){
        try {
            double tipPercent = Double.parseDouble(editTextPercent.getText().toString());
            double amount = Double.parseDouble(editTextAmount.getText().toString());
            tipPercent = tipPercent / 100;
            double tipAmount = amount * tipPercent;
            double total = amount + tipAmount;
            textViewPercent.setText("Tip Amount: " + NumberFormat.getCurrencyInstance().format(tipAmount));
            textViewAmount.setText("Total Amount: " + NumberFormat.getCurrencyInstance().format(total));
        }
        catch (IllegalArgumentException ex)
        {
            Toast.makeText(this,ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}