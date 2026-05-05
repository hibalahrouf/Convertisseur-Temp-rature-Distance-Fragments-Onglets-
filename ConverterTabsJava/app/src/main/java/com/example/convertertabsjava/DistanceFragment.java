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

public class DistanceFragment extends Fragment {

    private static final double KM_TO_MI = 0.6214;

    private RadioButton optKmToMi, optMiToKm;
    private EditText inputDist;
    private TextView labelDistResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_distance, container, false);
        bindViews(view);
        setupButton(view);
        return view;
    }

    private void bindViews(View view) {
        optKmToMi       = view.findViewById(R.id.optKmToMi);
        optMiToKm       = view.findViewById(R.id.optMiToKm);
        inputDist       = view.findViewById(R.id.inputDist);
        labelDistResult = view.findViewById(R.id.labelDistResult);
    }

    private void setupButton(View view) {
        view.findViewById(R.id.btnCalcDist).setOnClickListener(v -> performConversion());
    }

    private void performConversion() {
        String raw = inputDist.getText().toString().trim();

        if (TextUtils.isEmpty(raw)) {
            Toast.makeText(getContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        double input  = Double.parseDouble(raw);
        double output = optKmToMi.isChecked()
                ? kmToMiles(input)
                : milesToKm(input);

        String unit = optKmToMi.isChecked() ? "mi" : "km";
        labelDistResult.setText(String.format("Result: %.2f %s", output, unit));
    }

    private double kmToMiles(double km) { return km * KM_TO_MI; }
    private double milesToKm(double mi) { return mi / KM_TO_MI; }
}