package com.example.joshuarosenthal.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] currency={"Dollar","Pound","Cad","Euro","Peso","Yuan"};
    int images[] = {R.drawable.dollar, R.drawable.pound, R.drawable.cad, R.drawable.euro, R.drawable.peso, R.drawable.yen };
    double euroV = .91;
    double yuanV = 7.15;
    double cadV = 1.33;
    double poundV = .82;
    double pesoV = 19.79;
    double dollarV = 1.00;

    double firstValue;
    double secondVaue;

    int calculateResult(int c1, int c2, int value, int pos)
    {
        int result = value/c1;
        if(pos == 0)
        {
            return result;
        }
        result = result * c2;
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin1 = (Spinner) findViewById(R.id.spinner1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You Select Position: "+position+" "+currency[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinnerAdapter customAdapter1 = new SpinnerAdapter(getApplicationContext(),images,currency);
        spin1.setAdapter(customAdapter1);


        Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Two Select Position: "+position+" "+currency[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinnerAdapter customAdapter2 = new SpinnerAdapter(getApplicationContext(),images,currency);
        spin2.setAdapter(customAdapter2);

    }
}
