package com.example.v10t1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class ListInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_info);

        CarDataStorage storage = CarDataStorage.getInstance();

        TextView cityText = findViewById(R.id.CityText);
        TextView yearText = findViewById(R.id.YearText);
        TextView carInfoText = findViewById(R.id.CarInfoText);

        cityText.setText(storage.getCity());
        yearText.setText(String.valueOf(storage.getYear()));

        ArrayList<CarData> data = storage.getCarData();
        StringBuilder sb = new StringBuilder();
        int total = 0;

        for (CarData car : data) {
            sb.append(car.getType()).append(": ").append(car.getAmount()).append("\n");
            total += car.getAmount();
        }

        sb.append("\nYhteensä: ").append(total);
        carInfoText.setText(sb.toString());
    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}