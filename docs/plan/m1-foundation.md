# Plan m1 — Foundation: UI dasar + resources (SELESAI)

## Tujuan

Aplikasi starter 1 layar yang mendemonstrasikan pola dasar:
input → validasi → hasil, dengan semua teks/warna di resources.

## File yang dibuat

- [x] `app/src/main/java/com/example/starter/MainActivity.kt`
- [x] `app/src/main/res/layout/activity_main.xml`
- [x] `app/src/main/res/values/strings.xml`
- [x] `app/src/main/res/values/colors.xml`
- [x] `app/src/main/res/values/themes.xml`

## Langkah

1. [x] Buat layout: judul, EditText nama, tombol Sapa, TextView hasil.
2. [x] Buat MainActivity: findViewById, setOnClickListener,
       validasi nama kosong (error + requestFocus + return),
       tampilkan sapaan + Toast.
3. [x] Pindahkan semua teks ke strings.xml, semua warna ke colors.xml.
4. [x] Verifikasi: XML valid, id Kotlin↔layout cocok,
       string/color yang dirujuk terdefinisi.

## Cara menguji

- Valid: nama "Rifki" → tvHasil "Halo, Rifki!" + Toast.
- Tidak valid: nama kosong → error "Nama tidak boleh kosong",
  fokus ke kolom nama, tidak ada sapaan.

## Persetujuan

- [x] Disetujui sebagai bagian dari starter kit (2026-10-27).
