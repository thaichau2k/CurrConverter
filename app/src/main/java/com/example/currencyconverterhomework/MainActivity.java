package com.example.currencyconverterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    EditText value;
    TextView result;
    int from,to;
    double GBPToVND = 30200, EURToVND = 27400, USDToVND = 23175, CZKToVND = 1002, CNYToVND = 3400, THBToVND = 740, RUBToVND = 300, JPYToVND = 220, KRWToVND = 20.3;

    Spinner start_curr;
    Spinner finish_curr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_curr = findViewById(R.id.start_currency);
        finish_curr = findViewById(R.id.finish_currency);

        List<String> curr = new ArrayList<String>();
        curr.add("Việt Nam Đồng(VND)");
        curr.add("Bảng Anh(GBP)");
        curr.add("Nhân Dân Tệ(CNY)");
        curr.add("Koruna Séc(CZK)");
        curr.add("EURO(EUR)");
        curr.add("Yên Nhật(JPY)");
        curr.add("Rúp Nga(RUB)");
        curr.add("WON Hàn Quốc(WON)");
        curr.add("Dollar Mỹ(USD)");
        curr.add("Bạt Thái(BAT)");

        ArrayAdapter<String> adapter_start = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,curr);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter_finish = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,curr);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        start_curr.setAdapter(adapter_start);

        start_curr.setOnItemSelectedListener(this);

        finish_curr.setAdapter(adapter_finish);
        finish_curr.setOnItemSelectedListener(this);

        value = findViewById(R.id.amount_value);
        result = findViewById(R.id.result_value);

        value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                result.setText(vndToResult(value.getText().toString()) + " ");
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        to = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public double inputToVND(String s) {
        double s_double = Double.parseDouble(s);
        double vnd = 0.0;
        switch (from) {
            case 0:
                vnd = s_double;
                break;
            case 1:
                vnd = s_double * GBPToVND;
                break;
            case 2:
                vnd = s_double * CNYToVND;
                break;
            case 3:
                vnd = s_double * CZKToVND;
                break;
            case 4:
                vnd = s_double * EURToVND;
                break;
            case 5:
                vnd = s_double * JPYToVND;
                break;
            case 6:
                vnd = s_double * RUBToVND;
                break;
            case 7:
                vnd = s_double * KRWToVND;
                break;
            case 8:
                vnd = s_double * USDToVND;
                break;
            case 9:
                vnd = s_double * THBToVND;
                break;
        }
        return vnd;
    }

    public double vndToResult(String s) {
        double vnd = inputToVND(s);
        double result = 0.0;
        switch (to) {
            case 0:
                result = vnd;
                break;
            case 1:
                result = vnd / GBPToVND;
                break;
            case 2:
                result = vnd / CNYToVND;
                break;
            case 3:
                result = vnd / CZKToVND;
                break;
            case 4:
                result = vnd / EURToVND;
                break;
            case 5:
                result = vnd / JPYToVND;
                break;
            case 6:
                result = vnd / RUBToVND;
                break;
            case 7:
                result = vnd / KRWToVND;
                break;
            case 8:
                result = vnd / USDToVND;
                break;
            case 9:
                result = vnd / THBToVND;
                break;
        }
        return result;
    }
}