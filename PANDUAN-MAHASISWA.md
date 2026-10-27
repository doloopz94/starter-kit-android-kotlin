# Panduan Mahasiswa — Memulai Tugas Akhir dari Starter Kit Ini

> Kamu sedang membaca salinan starter kit Android Kotlin.
> Starter ini HANYA titik awal: 1 layar (nama → sapa + validasi).
> Tugas akhirmu adalah mengembangkannya sesuai brief dosen.

## [DOSEN ISI — wajib dilengkapi sebelum dibagikan]

- **Tema / ruang lingkup tugas akhir:** Pendukung Sistem UMKM
- **Tenggat pengumpulan:** -
- **Cara pengumpulan:** link repo
- **Format yang dikumpulkan:** link repo + video demo

Bagian di bawah ini berlaku apa pun isi brief di atas, kecuali
dosen mengubahnya secara eksplisit.

## 1. Dapatkan salinanmu sendiri (JANGAN kerjakan di repo dosen)

Pilih SATU cara, yang disarankan dosen:

- **A. Template (bila dosen mengaktifkan):** di halaman repo dosen,
  klik "Use this template" → buat repo baru atas namamu.
- **B. Fork:** di halaman repo dosen, klik "Fork" → repo salinan
  atas namamu.
- **C. Clone + repo baru sendiri:** clone repo dosen, lalu push ke
  repo baru atas namamu (jangan push kembali ke repo dosen).

**Dilarang:** push langsung ke repo dosen, mengubah branch main
repo dosen, atau mengerjakan tugas di dalam folder starter kit
milik dosen. Repo dosen adalah master yang harus tetap bersih.

## 2. Langkah pertama setelah clone (sekali saja)

Repo ini sengaja berisi file teks saja. Dua hal ini wajib dilakukan
sebelum build pertama:

1. **Buat Gradle wrapper sekali:**
   Bila Gradle sudah terpasang di laptopmu, jalankan di folder
   proyek:
   ```
   gradle wrapper --gradle-version 8.7
   ```
   Perintah ini membuat `gradle-wrapper.jar` di laptopmu (file ini
   tidak ada di repo). Setelah itu, build memakai `gradlew` seperti
   biasa. Bila Gradle belum terpasang, pasang dulu Gradle 8.7
   (lihat `docs/setup.md`), atau build dengan perintah `gradle`
   langsung.
2. **Buka folder proyek di VS Code** (folder root proyek, bukan
   subfolder `app/`), hubungkan HP (`adb devices` harus `device`),
   lalu build:
   ```
   .\gradlew installDebug
   ```
   (di Windows PowerShell; di macOS/Linux pakai `./gradlew`).
   Uji di HP: nama kosong → error dan tidak pindah layar; nama
   terisi → muncul sapaan. Kalau build gagal, salin pesan error
   persisnya — jangan menebak penyebabnya.

Catatan: ikon aplikasi di starter ini adalah vector drawable
sederhana (`res/drawable/ic_launcher.xml`). Kamu boleh
menggantinya dengan ikonmu sendiri nanti.

## 3. Cara kerja yang diharapkan (plan-first)

Ikuti `AGENTS.md` di proyek ini:

1. **Isi dokumen dulu** — `docs/product-overview.md` dan
   `docs/build-spec.md` untuk fitur yang akan kamu buat.
2. **Buat plan dulu** — tulis di `docs/plan/` (pakai
   `plan-template.md`): tujuan, file yang diubah, langkah
   berurutan, cara menguji. Baca ulang plan-mu sendiri sebelum
   eksekusi; plan yang asal-asalan menghasilkan kode asal-asalan.
3. **Eksekusi satu milestone saja** per sesi kerja. Jangan
   mengerjakan 3 fitur sekaligus dalam satu sesi panjang.
4. **Jalankan checklist** di `.agents/skills/code-review-checklist/`
   sebelum menganggap satu fitur selesai.
5. **Catat keputusan** di `docs/decisions.md` bila kamu mengubah
   struktur, versi, atau package.

Aturan kode yang tidak boleh dilanggar (lihat `AGENTS.md`):
semua teks di `strings.xml`, semua warna di `colors.xml`,
id Kotlin ↔ layout harus cocok, Kotlin null-safe (dilarang `!!`
tanpa alasan tertulis di plan), dan versi build dikunci
(Gradle 8.7, AGP 8.5.2, Kotlin 2.0.20, SDK 34, min 24) — jangan
menaikkan versi tanpa alasan dan tanpa catatan.

## 4. Menggunakan AI dengan benar

- Gunakan AI (OpenCode, Copilot, atau tool lain — lihat
  `PANDUAN-PAKAI.md`) untuk plan, review, dan eksekusi per
  milestone, BUKAN untuk "buatkan aplikasi lengkap" dalam satu
  prompt.
- Satu milestone = satu sesi AI. Sebut path file yang relevan
  saja, minta perubahan kecil (bukan file utuh), dan periksa diff
  per file sebelum menerima.
- Kamu tetap bertanggung jawab atas kode yang kamu kumpulkan:
  pahami setiap barisnya, dan pastikan kamu bisa menjelaskan
  plan, keputusan, dan cara ujinya saat ditanya.
- Aturan khusus soal AI untuk tugas ini mengikuti bagian
  [DOSEN ISI] di atas — bila bertentangan, aturan dosen yang menang.

## 5. Checklist sebelum dikumpulkan

- [ ] Build `installDebug` berhasil dan aplikasi berjalan di HP.
- [ ] Kasus valid DAN tidak valid sudah diuji (kosong, format
      salah, di luar rentang — aplikasi tidak crash).
- [ ] `docs/` dan `docs/plan/` diperbarui sesuai fitur yang dibuat.
- [ ] Keputusan penting dicatat di `docs/decisions.md`.
- [ ] Tidak ada hardcode teks/warna di layout maupun Kotlin.
- [ ] Versi build tidak berubah tanpa catatan.
- [ ] Repo yang dikumpulkan adalah repo atas namamu sendiri,
      bukan repo dosen, dan link-nya bisa dibuka dosen.
- [ ] [DOSEN ISI: item checklist tambahan bila ada]

## 6. Troubleshooting

- **Build gagal karena wrapper:** jalankan perintah
  `gradle wrapper --gradle-version 8.7` di folder proyek, lalu
  ulangi `.\gradlew installDebug`.
- **HP tidak terdeteksi:** cek `adb devices`, kabel, dan mode
  USB Debugging (lihat `docs/setup.md`).
- **Aplikasi crash saat input tidak valid:** cek validasi berlapis
  di skill `input-validation-logic` — jangan pindah layar selama
  ada input yang belum valid.
- **Hasil AI meleset:** perbaiki plan dan build-spec-nya dulu,
  bukan mengulang prompt eksekusi yang sama.
