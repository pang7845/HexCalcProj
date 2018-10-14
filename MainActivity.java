package com.example.agent.hexcalc;

import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private TextView Title;
    private TextView TDec;
    private TextView TBi;
    private TextView THex;

    private EditText InDec;
    private EditText InBi;
    private EditText InHex;

    private Button BDec;
    private Button BBi;
    private Button BHex;
    private Button Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Title = (TextView) findViewById(R.id.Title);
        TDec = (TextView) findViewById(R.id.TDec);
        TBi = (TextView) findViewById(R.id.TBi);
        THex = (TextView) findViewById(R.id.THex);

        InDec = (EditText) findViewById(R.id.InDec);
        InBi = (EditText) findViewById(R.id.InBi);
        InHex = (EditText) findViewById(R.id.InHex);

        BDec = (Button) findViewById(R.id.BDec);
        BBi = (Button) findViewById(R.id.BBi);
        BHex = (Button) findViewById(R.id.BHex);

        Clear = (Button) findViewById(R.id.Clear);




//Decimal >> Binary and Hex
        BDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//bi
                if(InDec.getText().toString().contains(".")){
                    Toast toast= Toast.makeText(MainActivity.this,"Do Not Add a Decimal Point",Toast.LENGTH_LONG);
                    toast.show();
                    InBi.getText().clear();
                    InDec.getText().clear();
                    InHex.getText().clear();
                }
                else{ int DecBiValue = Integer.parseInt(InDec.getText().toString(),10);
                InBi.setText(Integer.toBinaryString(DecBiValue));
//hex
                InHex.setText(Integer.toHexString(DecBiValue));}
            }

        });

//Binary >> Decimal and Hex
        BBi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//decimal
                String f = InBi.getText().toString();

                if(f.contains("2")||f.contains("3")||f.contains("4")||f.contains("5")||f.contains("6")||f.contains("7")||f.contains("8")||f.contains("9")||f.contains(".")){
                    Toast toast= Toast.makeText(MainActivity.this,"Enter a Binary Number",Toast.LENGTH_LONG);
                    toast.show();
                    InBi.getText().clear();
                    InDec.getText().clear();
                    InHex.getText().clear();
            }
                else{
                    int BiDecValue = Integer.parseInt(InBi.getText().toString(),2);
                    InDec.setText(Integer.toString(BiDecValue));
//hex
                    InHex.setText(Integer.toHexString(BiDecValue));
                }
            }
        });

//Hex >> Decimal and Binary
        BHex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//decimal
                if(InHex.getText().toString().matches("[a-fA-G0-9]+")){
                    int HexDecValue = Integer.parseInt(InHex.getText().toString(),16);
                    InDec.setText(Integer.toString(HexDecValue));
//bi
                    InBi.setText(Integer.toBinaryString(HexDecValue));
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this, "Enter a Hex Number", Toast.LENGTH_LONG);
                    toast.show();
                    InBi.getText().clear();
                    InDec.getText().clear();
                    InHex.getText().clear();
                }
            }
        });
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InBi.getText().clear();
                InDec.getText().clear();
                InHex.getText().clear();

            }

        });

    }
}
