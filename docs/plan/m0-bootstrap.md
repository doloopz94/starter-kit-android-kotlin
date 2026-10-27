# Plan m0 — Bootstrap (SELESAI)

## Tujuan

Kerangka proyek Android yang bisa dibuka di VS Code dan di-build
dengan Gradle, dengan versi yang sama persis dengan proyek P7.

## File yang dibuat

- [x] `settings.gradle`, `build.gradle`, `gradle.properties`
- [x] `gradle/wrapper/*`, `gradlew`, `gradlew.bat`
- [x] `app/build.gradle`, `app/proguard-rules.pro`
- [x] `app/src/main/AndroidManifest.xml`
- [x] `.gitignore`

## Langkah

1. [x] Salin konfigurasi build dari proyek P7 (versi dikunci).
2. [x] Ganti package menjadi `com.example.starter` dan nama proyek
       menjadi `StarterMobile`.
3. [x] Verifikasi XML valid dan struktur folder lengkap.

## Cara menguji

- Buka folder di VS Code, jalankan `.\gradlew installDebug`
  (diuji pengguna di laptop/HP — lihat VERIFY.md).
- Status: kerangka selesai, aplikasi 1 layar ditambahkan di m1.

## Persetujuan

- [x] Disetujui sebagai bagian dari starter kit (2026-10-27).
