package com.pandi.hima;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Perform1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perform1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Spinner spinner =(Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.restaurants, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void buttonContinueOnClick(View v) {
        Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(), Perform2.class));
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myText = (TextView) view;
        EditText edt = (EditText) findViewById(R.id.editText);    //name
        EditText edt2 = (EditText) findViewById(R.id.editText2);  //phone
        EditText edt3 = (EditText) findViewById(R.id.editText3); //Street Address
        EditText edt4 = (EditText) findViewById(R.id.editText4); //Town
        EditText edt5= (EditText) findViewById(R.id.editText5); //Date Established

        if(myText.getText().equals("Select Existing Restaurant")){
            edt.setText("");
            edt2.setText("");
            edt3.setText("");
            edt4.setText("");
            edt5.setText("");
        }
        if(myText.getText().equals("McDonald")){
            edt.setText("McDonald");
            edt2.setText("413-582-0176");
            edt3.setText("374 Russell St.");
            edt4.setText("Amherst");
            edt5.setText("2/16/2000");
        }

        if(myText.getText().equals("Wendy")){
            edt.setText("Wendy");
            edt2.setText("413-785-3486");
            edt3.setText("134 Russell St.");
            edt4.setText("Amherst");
            edt5.setText("2/16/1995");
        }

        if(myText.getText().equals("Burger King")){
            edt.setText("Burger King");
            edt2.setText("413-238-8573");
            edt3.setText("220 Russell St.");
            edt4.setText("Amherst");
            edt5.setText("12/16/2004");
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
