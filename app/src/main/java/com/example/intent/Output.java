package com.example.intent;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Output extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        setTitle("Hasil");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView hasilNim =(TextView) findViewById(R.id.hasilNim);
        TextView hasilNama =(TextView) findViewById(R.id.hasilNama);
        TextView hasilHp =(TextView) findViewById(R.id.hasilHP);
        TextView hasilEmail =(TextView) findViewById(R.id.hasilEmail);
        TextView jurusan =(TextView) findViewById(R.id.hasilJurusan);
        TextView hasilJK = (TextView) findViewById(R.id.hasilJK);

        Intent i = getIntent();
        hasilNim.setText(String.valueOf("NIM : "+ i.getStringExtra("NIM")));
        hasilNama.setText(String.valueOf("Nama : "+ i.getStringExtra("Nama")));
        hasilHp.setText(String.valueOf("No Hp : "+ i.getStringExtra("No Hp")));
        hasilEmail.setText(String.valueOf("Email : "+ i.getStringExtra("Email")));
        hasilJK.setText("Jenis Kelamin : "+i.getStringExtra("jeniskelamin"));
        jurusan.setText("Jurusan : "+i.getStringExtra("jurusan"));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
