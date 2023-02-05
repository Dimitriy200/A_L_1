package com.example.lab_2;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TextView;
//import android.view.Menu;
//import android.annotation.SuppressLint;
//import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class MainActivity extends Activity implements OnClickListener {//AppCompatActivity

    public Button btnConvert;
    public EditText binText;
    public EditText decText;
    public EditText hexText;
    String textBin;
    String textDec;
    String textHex;
    String hex;
    String bin;
    Integer dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConvert = findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        binText = findViewById(R.id.textBin);
        decText = findViewById(R.id.textDec);
        hexText = findViewById(R.id.textHex);

        textBin = binText.getText().toString();
        textDec = decText.getText().toString();
        textHex = hexText.getText().toString();


        //convert from dec and hex
        if(!textBin.isEmpty() && binText.isFocused()){
            //dec
            dec = Integer.parseInt(textBin,2);
            decText.setText(dec.toString());    //(String.format("", "%f", dec));
            //hex
            hex = Integer.toHexString(dec).toUpperCase(Locale.ROOT);
            hexText.setText(hex);
        }

        //convert from bin and hex
        if(!textDec.isEmpty() && decText.isFocused()){
            //bin
            dec = Integer.parseInt(textDec);
            bin = Integer.toBinaryString(dec);
            binText.setText(bin);
            //hex
            hex = Integer.toHexString(dec).toUpperCase(Locale.ROOT);
            hexText.setText(hex);
        }

        //convert from bin and dex
        if(!textHex.isEmpty() && hexText.isFocused()){
            //dec
            dec = Integer.parseInt(textHex, 16);
            decText.setText(dec.toString());
            //bin
            bin = Integer.toBinaryString(dec);
            binText.setText(bin);
        }
    }
}