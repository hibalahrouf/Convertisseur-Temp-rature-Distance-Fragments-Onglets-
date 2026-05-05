package com.example.convertertabsjava;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TemperatureFragment extends Fragment {

    private RadioButton optCelsiusToFahr, optFahrToCelsius;
    private EditText inputTemp;
    private TextView labelTempResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_temperature, container, false);
        bindViews(view);
        setupButton(view);
        return view;
    }

    private void bindViews(View view) {
        optCelsiusToFahr  = view.findViewById(R.id.optCelsiusToFahr);
        optFahrToCelsius  = view.findViewById(R.id.optFahrToCelsius);
        inputTemp         = view.findViewById(R.id.inputTemp);
        labelTempResult   = view.findViewById(R.id.labelTempResult);
    }

    private void setupButton(View view) {
        view.findViewById(R.id.btnCalcTemp).setOnClickListener(v -> performConversion());
    }

    private void performConversion() {
        String raw = inputTemp.getText().toString().trim();

        if (TextUtils.isEmpty(raw)) {
            Toast.makeText(getContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        double input  = Double.parseDouble(raw);
        double output = optCelsiusToFahr.isChecked()
                ? celsiusToFahrenheit(input)
                : fahrenheitToCelsius(input);

        String unit = optCelsiusToFahr.isChecked() ? "°F" : "°C";
        labelTempResult.setText(String.format("Result: %.2f %s", output, unit));
    }

    private double celsiusToFahrenheit(double c) { return (c * 1.8) + 32; }
    private double fahrenheitToCelsius(double f) { return (f - 32) / 1.8; }
}