package com.example.v10t1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    private EditText cityNameEdit;
    private EditText yearEdit;
    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        cityNameEdit = findViewById(R.id.CityNameEdit);
        yearEdit = findViewById(R.id.YearEdit);
        statusText = findViewById(R.id.StatusText);
    }

    public void onSearchClicked(View view) {
        String city = cityNameEdit.getText().toString().trim();
        String yearStr = yearEdit.getText().toString().trim();

        if (city.isEmpty()) {
            statusText.setText("Haku epäonnistui, syötä kaupungin nimi");
            return;
        }

        int year;
        try {
            year = Integer.parseInt(yearStr);
        } catch (NumberFormatException e) {
            statusText.setText("Haku epäonnistui, syötä kelvollinen vuosi");
            return;
        }

        statusText.setText("Haetaan");

        CarDataStorage storage = CarDataStorage.getInstance();
        storage.clearData();
        storage.setCity(city);
        storage.setYear(year);
        storage.addCarData(new CarData("Henkilöautot", 276910));
        storage.addCarData(new CarData("Pakettiautot", 35855));
        storage.addCarData(new CarData("Kuorma-autot", 10177));
        storage.addCarData(new CarData("Linja-autot", 2140));
        storage.addCarData(new CarData("Erikoisautot", 465));

        statusText.setText("Haku onnistui");
    }

    public void switchToListInfo(View view) {
        Intent intent = new Intent(this, ListInfoActivity.class);
        startActivity(intent);
    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}