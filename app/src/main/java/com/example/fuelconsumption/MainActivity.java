package com.example.fuelconsumption;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText distanceEditText, fuelConsumptionEditText, fuelPriceEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distanceEditText = findViewById(R.id.distance_edit_text);
        fuelConsumptionEditText = findViewById(R.id.fuel_consumption_edit_text);
        fuelPriceEditText = findViewById(R.id.fuel_price_edit_text);
        Button calculateButton = findViewById(R.id.calculate_button);
        resultTextView = findViewById(R.id.result_text_view);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFuelConsumption();
            }
        });
    }

    private void calculateFuelConsumption() {
        double distance = Double.parseDouble(distanceEditText.getText().toString());
        double fuelConsumption = Double.parseDouble(fuelConsumptionEditText.getText().toString());
        double fuelPrice = Double.parseDouble(fuelPriceEditText.getText().toString());

        double totalFuelCost = (distance / 100.0) * fuelConsumption * fuelPrice;
        resultTextView.setText(String.format("Общая стоимость топлива: %.2f", totalFuelCost));
    }
}
