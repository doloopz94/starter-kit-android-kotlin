package com.example.starter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Starter Kit m1 — Foundation.
// Pola dasar: input → validasi berlapis → hasil.
// Lihat .agents/skills/input-validation-logic/SKILL.md untuk pola lengkapnya.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val btnSapa = findViewById<Button>(R.id.btnSapa)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnSapa.setOnClickListener {
            val nama = etNama.text.toString().trim()

            // Validasi berlapis: kosong → error + fokus + return.
            // Aplikasi tidak boleh menampilkan sapaan bila input belum valid.
            if (nama.isEmpty()) {
                etNama.error = getString(R.string.error_nama_kosong)
                etNama.requestFocus()
                return@setOnClickListener
            }

            val sapaan = getString(R.string.hasil_sapaan, nama)
            tvHasil.text = sapaan
            Toast.makeText(this, getString(R.string.toast_sapaan), Toast.LENGTH_SHORT).show()
        }
    }
}
