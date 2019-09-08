package com.example.joshuarosenthal.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.text.Editable;
import android.widget.TextView;
import android.text.TextWatcher;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String[] currency={"Dollar","Pound","Cad","Euro","Peso","Yuan", "Franc", "Rupee", "Ruble"};
    int images[] = {R.drawable.dollar, R.drawable.pound, R.drawable.cad,
            R.drawable.euro, R.drawable.peso, R.drawable.yen, R.drawable.franc, R.drawable.rupee, R.drawable.ruble };
    /*
    double euroV = .91;
    double yuanV = 7.15;
    double cadV = 1.33;
    double poundV = .82;
    double pesoV = 19.79;
    double dollarV = 1.00;
    double francV = .99;
    double rupeeV = 71.65;
    double rubleV = 65.72;
    */
    double values[] = {1, .82, 1.33, .91, 19.54, 7.15, .99, 71.65, 65.72};

    double firstValue;
    double secondValue;
    double calcValue;
    double resValue = 0;
    public String text;

    private Button calcButton;

    double calculateResult(double c1, double c2, double value)
    {
        double result = value/c1;
        result = result * c2;
        //Toast.makeText(MainActivity.this, "The result is "+result, Toast.LENGTH_SHORT).show();
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
                //Toast.makeText(MainActivity.this, "You Select Position: "+position+" "+currency[position], Toast.LENGTH_SHORT).show();
                firstValue = values[position];
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
                //Toast.makeText(MainActivity.this, "Two Select Position: "+position+" "+currency[position], Toast.LENGTH_SHORT).show();
                secondValue = values[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinnerAdapter customAdapter2 = new SpinnerAdapter(getApplicationContext(),images,currency);
        spin2.setAdapter(customAdapter2);

        final EditText editText = (EditText) findViewById(R.id.editText1);
        //text = editText.getText().toString();


        editText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //resNum.setText("");
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            public void afterTextChanged(CharSequence s, int start, int before, int count) {
                //text = editText.getText().toString();
                //Toast.makeText(MainActivity.this, "The value is: "+ text, Toast.LENGTH_SHORT).show();
            }
            public void afterTextChanged(Editable s) {
                text = editText.getText().toString();
                //resNum.setText("You have entered : " + editText.getText());
            }
        });

        //calcValue = Double.valueOf(text);
        calcButton = (Button) findViewById(R.id.button);
        calcButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        final TextView resNum = (TextView) findViewById(R.id.result);
        switch (view.getId()) {
            case R.id.button:
                calcValue = Double.valueOf(text);
                resValue = calculateResult(firstValue, secondValue, calcValue);
                double number = Math.round(resValue * 100);
                number = number/100;
                resNum.setText(""+number);
        }
    }

}
