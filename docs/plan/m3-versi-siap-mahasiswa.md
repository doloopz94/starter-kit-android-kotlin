# Plan m3 — Versi siap-mahasiswa

- **Tujuan:** Repo GitHub bisa langsung dipakai mahasiswa sebagai
  titik awal tugas akhir: clone → build → kembangkan, tanpa file
  biner tambahan dan tanpa akses tulis ke repo dosen.
- **Disetujui oleh:** Rifki (pemilik repo), 2026-10-27, lewat
  persetujuan menyiapkan versi siap-mahasiswa.
- **Status:** Dilaksanakan 2026-10-27.

## File yang diubah/dibuat

1. `app/src/main/res/drawable/ic_launcher.xml` (BARU) — ikon vector.
2. `app/src/main/AndroidManifest.xml` (UBAH) — icon/roundIcon
   dari `@mipmap/ic_launcher` menjadi `@drawable/ic_launcher`.
3. `docs/decisions.md` (UBAH) — tambah ADR-003.
4. `PANDUAN-MAHASISWA.md` (BARU) — panduan mulai, aturan kerja,
   checklist pengumpulan, dan bagian [DOSEN ISI] yang harus diisi
   Rifki sebelum dibagikan.
5. `README.md` (UBAH) — ganti bagian file biner dengan penjelasan
   baru: ikon sudah vector, wrapper jar dibuat sekali dengan
   perintah `gradle wrapper`.

## Langkah berurutan

1. Buat drawable vector dan ubah manifest.
2. Catat ADR-003 di decisions.
3. Tulis PANDUAN-MAHASISWA.md dengan placeholder [DOSEN ISI].
4. Perbarui README.
5. Validasi: semua XML valid, referensi `@drawable/ic_launcher`
   ada, tidak ada lagi referensi `@mipmap` di manifest.
6. Push ke GitHub (branch main), lalu verifikasi README dan
   manifest dari GitHub.

## Cara menguji

- XML: parser XML untuk manifest dan drawable (di lingkungan ini).
- Build APK: TIDAK bisa diverifikasi di lingkungan ini (Gradle
  Android tidak bisa build sampai selesai di sini) — wajib diuji
  Rifki/mahasiswa di laptop dengan perintah di PANDUAN-MAHASISWA.md
  dan dilaporkan pesan error persisnya bila gagal.
- Kasus valid/invalid aplikasi tetap diuji setelah build berhasil
  di HP (kolom kosong vs terisi).

## Yang TIDAK diubah oleh milestone ini

- Versi build (tetap Gradle 8.7, AGP 8.5.2, Kotlin 2.0.20, SDK 34/24).
- Package `com.example.starter` dan logika MainActivity.
- Isi tugas akhir, tenggat, dan rubrik — itu wewenang dosen dan
  sengaja dibiarkan sebagai [DOSEN ISI] di panduan mahasiswa.
