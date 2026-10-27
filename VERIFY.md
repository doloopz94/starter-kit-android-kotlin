# VERIFY.md — Hasil verifikasi starter kit ini (2026-10-27)

Dicek dengan skrip Python (parse XML + cocokkan referensi), bukan dengan
build Gradle — baca catatan di bawah.

## Lolos

- Semua file XML valid (tidak ada tag tak tertutup).
- Id Kotlin ↔ layout cocok tipenya:
  - `etNama` → EditText ✓
  - `btnSapa` → Button ✓
  - `tvHasil` → TextView ✓
- Semua string yang dirujuk Kotlin ada di `strings.xml` (8 string).
- Semua warna yang dirujuk layout ada di `colors.xml`
  (primary, surface, text_muted).
- Tema di AndroidManifest (`@style/Theme.StarterMobile`) ada di `themes.xml`.
- Ikon launcher (`@mipmap/ic_launcher`, `@mipmap/ic_launcher_round`)
  tersedia di semua folder mipmap (hdpi–xxxhdpi).
- Versi build: Gradle 8.7, AGP 8.5.2, Kotlin 2.0.20,
  compile/target SDK 34, min SDK 24, AppCompat 1.7.0, core-ktx 1.13.1 —
  sama persis dengan proyek Kartu Profil P7.

## Belum terverifikasi (jujur)

- **Build APK (`.\gradlew installDebug`) belum dicoba di lingkungan ini**
  karena lingkungan ini tidak bisa menjalankan build Gradle Android
  sampai tuntas. Langkah pertama saat memakai kit ini adalah mencoba
  build di laptop + HP seperti biasa, dan bila gagal, kirimkan pesan
  error persisnya.
- Uji jalan aplikasi (klik tombol, kasus nama kosong) juga belum
  dicoba di HP — skenario ujinya sudah ditulis di
  `docs/build-spec.md` dan `docs/plan/m1-foundation.md`.
