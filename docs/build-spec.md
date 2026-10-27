# Build Spec

Spesifikasi tiap fitur: apa inputnya, apa aturannya, apa outputnya,
dan bagaimana cara mengujinya. Satu fitur = satu bagian.

## Fitur 1: [Nama fitur]

- **Input:** [ISI — view apa, tipe data apa]
- **Aturan/validasi:** [ISI — kosong? format? rentang? Urutkan sesuai
  skill input-validation-logic]
- **Proses:** [ISI — rumus/logika, pakai `when` bila berkategori]
- **Output:** [ISI — apa yang tampil, apa yang dikirim ke layar lain]
- **File yang diubah:** [ISI]
- **Cara menguji:**
  - Valid: [input] → [hasil yang diharapkan]
  - Tidak valid: [input] → [pesan error, tidak pindah layar]

## Fitur 2: [Nama fitur]

(Salin format di atas.)

## Contoh terisi (fitur starter bawaan)

- **Input:** `etNama` (teks), tombol `btnSapa`.
- **Aturan:** nama tidak boleh kosong (setelah `trim()`).
- **Proses:** sapaan = "Halo, {nama}!" — tidak ada perhitungan lain.
- **Output:** `tvHasil` menampilkan sapaan, Toast "Sapaan ditampilkan".
- **File:** `activity_main.xml`, `MainActivity.kt`, `strings.xml`.
- **Cara menguji:**
  - Valid: nama "Rifki" → tvHasil "Halo, Rifki!"
  - Tidak valid: nama kosong → error "Nama tidak boleh kosong",
    fokus ke kolom nama, tidak ada sapaan.
