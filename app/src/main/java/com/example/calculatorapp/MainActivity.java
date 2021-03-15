package com.example.calculatorapp;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button Calculate;
    private EditText ValueOne;
    private EditText ValueTwo;
    private EditText Result;
    private ArrayAdapter<CharSequence> myAdapter;
    private Add add;
    private Multiply multiply;
    private Subtract subtract;
    private Divide divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=new Add();
        subtract=new Subtract();
        divide=new Divide();
        multiply=new Multiply();
        Calculate = (Button) findViewById(R.id.btnCalculate);
        ValueOne = (EditText) findViewById(R.id.value1);
        ValueTwo = (EditText) findViewById(R.id.value2);
        spinner = (Spinner) findViewById(R.id.spinner);
        Result = (EditText) findViewById(R.id.results);
        myAdapter =
                ArrayAdapter.createFromResource(this,
                        R.array.Operation_options,
                        android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);
        spinner.setSelection(myAdapter.getPosition("add"));

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinner.getSelectedItemPosition()==0)
                {
                    Result.setText(add.add(Double.valueOf(ValueOne.getText().toString()),Double.valueOf(ValueTwo.getText().toString())));
                }
                else if(spinner.getSelectedItemPosition()==1)
                {
                    Result.setText(subtract.subtract(Double.valueOf(ValueOne.getText().toString()),Double.valueOf(ValueTwo.getText().toString())));
                }
                else if(spinner.getSelectedItemPosition()==2)
                {
                    Result.setText(multiply.multiply(Double.valueOf(ValueOne.getText().toString()),Double.valueOf(ValueTwo.getText().toString())));
                }
                else if(spinner.getSelectedItemPosition()==3)
                {
                    if(Double.valueOf(ValueTwo.getText().toString())==0)
                    {
                        Toast.makeText(MainActivity.this,"Division By Zero Is Not Allowed",Toast.LENGTH_SHORT).show();
                    }
                    Result.setText(divide.divide(Double.valueOf(ValueOne.getText().toString()),Double.valueOf(ValueTwo.getText().toString())));
                }
            }
        });

    }
}