# Setup

## Yang dibutuhkan

- JDK 17 (Gradle 8.7 dan Kotlin 2.0.20 memakai Java 17)
- Android SDK (Command-line Tools) + platform SDK 34
- VS Code + HP Android dengan USB debugging aktif (atau adb wireless)
- Internet untuk build pertama (mengunduh Gradle + dependency)

## Langkah

1. Buka folder proyek di VS Code (folder yang berisi `gradlew.bat`).
2. Cek perangkat: `adb devices` — status harus `device`.
3. Jalankan dari terminal PowerShell: `.\gradlew installDebug`
4. Aplikasi terpasang di HP, buka dan uji sesuai build-spec.

## Bila "SDK location not found"

Buat file `local.properties` di folder akar proyek (jangan di-commit
bila proyek memakai git — file ini berisi path lokal komputer itu):

```
sdk.dir=C\:\\Users\\NamaKamu\\AppData\\Local\\Android\\Sdk
```

Sesuaikan `NamaKamu` dengan username Windows di komputer itu.

## Troubleshooting singkat

- `adb devices` kosong → cek kabel, USB debugging di HP, dan
  izinkan dialog "Allow USB debugging" di HP.
- Build gagal karena jaringan → build pertama butuh internet;
  ulangi setelah koneksi stabil, jangan ubah versi dependency.
- Error lain → salin pesan error persisnya (bukan ringkasannya)
  dan bawa ke AI/ke forum; jangan menebak penyebabnya.
