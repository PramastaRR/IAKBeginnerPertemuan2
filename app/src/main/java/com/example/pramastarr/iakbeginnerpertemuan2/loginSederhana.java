package com.example.pramastarr.iakbeginnerpertemuan2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class loginSederhana extends AppCompatActivity {

    int percobaan = 3;

    private boolean cekPassword(String username, String password) {
        if (username.equals("pramasta") && password.equals("keboencoding")) {
            return true;
        }
        else {
            return false;
        }
    }

    private void tampilkanPercobaan() {
        TextView text_percobaan = (TextView) findViewById(R.id.text_percobaan);
        text_percobaan.setText("Sisa Percobaan: " + percobaan);
    }

    public void loginPengguna(View view){

        EditText text_username = (EditText) findViewById(R.id.edit_username);
        EditText text_password = (EditText) findViewById(R.id.edit_password);
        String username = text_username.getText().toString();
        String password = text_password.getText().toString();

        boolean a = cekPassword(username, password);
        if (a == true) {

            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(loginSederhana.this, pesanMakanan.class);
            startActivity(i);
        }
        else {

            Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show();
            percobaan -= 1;

            tampilkanPercobaan();
            if (percobaan == 0) {
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sederhana);

        setTitle("Login Pengguna");

        tampilkanPercobaan();

    }
}
