package com.example.pertemuan_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nama;
    RadioButton gender;
    RadioGroup pilihGender;
    AutoCompleteTextView kota;
    Spinner hobby;
    CheckBox setuju;
    String[] namaKota = {"Jakarta", "Jambi", "Bali", "Balikpapan", "Tangerang", "Tasikmalaya"};
    String[] namaHobby = {"Pilih Hobby", "Badminton", "Futsal", "Menyanyi", "Voli"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Funfsi on Create", Toast.LENGTH_LONG).show();

        nama = findViewById(R.id.txtNama);
        setuju = findViewById(R.id.txtSetuju);

        kota = findViewById(R.id.txtKota);
        ArrayAdapter<String> adapterKota = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, namaKota);
        kota.setAdapter(adapterKota);

        hobby = findViewById(R.id.txtHobby);
        ArrayAdapter<String> adapterHobby = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, namaHobby);
        hobby.setAdapter(adapterHobby);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "Fungsi on Start", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "Fungsi on Resume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "Fungsi on Pause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "Fungsi on Stop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, "Fungsi on Restart", Toast.LENGTH_LONG).show();
    }

    protected void save(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Konfirmasi")
                .setMessage("Apakah Data sudah sesuai?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(setuju.isChecked()){
                    pilihGender = findViewById(R.id.txtGender);
                    gender = findViewById(pilihGender.getCheckedRadioButtonId());
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("nama", nama.getText().toString());
                    intent.putExtra("gender", gender.getText().toString());
                    intent.putExtra("kota", kota.getText().toString());
                    intent.putExtra("hobby", hobby.getSelectedItem().toString());
                    startActivity(intent);
                } else{
                    Toast.makeText(MainActivity.this, "Silahkan centang setuju", Toast.LENGTH_LONG).show();
                }
            }
        });

        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
//        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setBackgroundColor(Color.RED);
        dialog.show();
    }
}