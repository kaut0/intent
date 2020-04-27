package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {
    private EditText eNim, eNama, eHp, email;
    private RadioGroup rg;
    private RadioButton jenisKelamin;
    private String[] data = {"S1 TI", "D3 TI", "D3 MI", "S1 DKV"};
    private Spinner jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Inputan Biodata");

        eNim = (EditText) findViewById(R.id.eNIM);
        eNama = (EditText) findViewById(R.id.eNama);
        eHp = (EditText) findViewById(R.id.eHp);
        email = (EditText) findViewById(R.id.eMail);
        jurusan = (Spinner) findViewById(R.id.spinJurusan);
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jurusan.setAdapter(adapters);

    }

    public void btnTampil(View view) {
        Intent i = new Intent(this, Output.class);

        rg = (RadioGroup) findViewById(R.id.rg);
        String id = ((RadioButton)findViewById(rg.getCheckedRadioButtonId() )).getText().toString();


        if (TextUtils.isEmpty(eNim.getText()) || TextUtils.isEmpty(eNama.getText()) ||
                TextUtils.isEmpty(eHp.getText()) || TextUtils.isEmpty(email.getText())) {

            if (TextUtils.isEmpty(eNim.getText())) {
                eNim.setError("Nim Belum diisi");
            }
            if (TextUtils.isEmpty(eNama.getText())) {
                eNama.setError("Nama Belum diisi");
            }
            if (TextUtils.isEmpty(eHp.getText())) {
                eHp.setError("No Handphone Belum diisi");
            }
            if (TextUtils.isEmpty(email.getText())) {
                email.setError("Email Belum diisi");
            }

            } else {
                i.putExtra("NIM", eNim.getText().toString());
                i.putExtra("Nama", eNama.getText().toString());
                i.putExtra("No Hp", eHp.getText().toString());
                i.putExtra("Email", email.getText().toString());
                i.putExtra("jeniskelamin",id);
                i.putExtra("jurusan",jurusan.getSelectedItem().toString());
                startActivity(i);

            }
        }
    }
