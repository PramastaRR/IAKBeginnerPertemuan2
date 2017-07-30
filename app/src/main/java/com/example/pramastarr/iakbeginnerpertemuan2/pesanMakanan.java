package com.example.pramastarr.iakbeginnerpertemuan2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class pesanMakanan extends AppCompatActivity {

    int jumlahMakanan = 0;

    private void tampilkanLaporan(String namaMakanan, boolean pedas, int jumlahMakanan, int harga) {

        String laporan = "Anda memesan " + namaMakanan;
        laporan += "\nPedas?: " + pedas;
        laporan += "\nJumlah pesanan: " + jumlahMakanan + " porsi";
        laporan += "\nTotal pembayaran: Rp" + harga;

        TextView text_penghitung = (TextView) findViewById(R.id.text_penghitung);
        text_penghitung.setText("" + jumlahMakanan);

        TextView text_laporan = (TextView) findViewById(R.id.text_laporan);
        text_laporan.setText(laporan);
    }

    private String cekMakanan() {

        RadioButton radio_nasiGoreng = (RadioButton) findViewById(R.id.radio_nasiGoreng);
        RadioButton radio_miGoreng = (RadioButton) findViewById(R.id.radio_miGoreng);

        String namaMakanan = "";

        if (radio_nasiGoreng.isChecked()) {
            namaMakanan = "Nasi Goreng";
        }
        else if (radio_miGoreng.isChecked()) {
            namaMakanan = "Mi Goreng";
        }
        return namaMakanan;
    }

    private boolean cekPedas() {

        boolean pedas = false;
        CheckBox check_pedas = (CheckBox) findViewById(R.id.check_pedas);
        if (check_pedas.isChecked()) {
            pedas = true;
        }

        return pedas;
    }

    private void hitungHarga(int jumlahMakanan) {
        String namaMakanan = cekMakanan();
        boolean pedas = cekPedas();


        int harga = 0;

        if (namaMakanan == "Nasi Goreng") {
            harga += 10000;
        }
        else if (namaMakanan == "Mi Goreng") {
            harga += 12000;
        }

        if (pedas == true) {
            harga += 1000;
        }

        harga = jumlahMakanan * harga;

        tampilkanLaporan(namaMakanan, pedas, jumlahMakanan, harga);
    }


    public void tambahMakanan(View view) {
        jumlahMakanan += 1;
        hitungHarga(jumlahMakanan);
    }

    public void kurangMakanan(View view) {
        jumlahMakanan -= 1;
        hitungHarga(jumlahMakanan);
    }

    public void updateHarga(View view) {
        hitungHarga(jumlahMakanan);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_makanan);

        setTitle("Pemesanan Makanan");

        TextView text_laporan = (TextView) findViewById(R.id.text_laporan);
        text_laporan.setText("");

    }
}
