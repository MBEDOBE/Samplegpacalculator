package com.mbedobe.android.samplegpacalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] grades = {"A", "B+", "B", "C+", "C", "D+", "D", "E"};

    String[] credits = {"1", "2", "3", "4"};
    double[] points1 = {4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0};


    Spinner spinner, spin2;
    TextView TextView1;
    TextView TextView2;
    Double point = -1.0;
    Double value = -1.0;
    AdapterView.OnItemSelectedListener onItemSelectedListener1 = new
            AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            point = points1[position];
            TextView1.setText(String.valueOf(point));

            if (value != -1.0) {
                double res = (double) point * value;
                TextView2.setText(String.valueOf(res));
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView1 = (TextView) findViewById(R.id.gradePoints);
        TextView2 = (TextView) findViewById(R.id.gradeValue);

        spinner = (Spinner) findViewById(R.id.spinner);


        ArrayAdapter<String> adapter1 =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,
                        grades);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(onItemSelectedListener1);

        spin2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (MainActivity.this, android.R.layout.simple_spinner_item, credits);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter2);
        spin2.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        Toast.makeText(this, "Your choice :" + credits[position], Toast.LENGTH_SHORT).show();

        String valueStr = credits[position];
        value = Double.parseDouble(valueStr);

        if (point != -1.0) {
            double res = (double) point * value;
            TextView2.setText(String.valueOf(res));
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Choose grades :", Toast.LENGTH_SHORT).show();
    }
}
