# Decisions (ADR sederhana)

Setiap keputusan penting dicatat di sini: apa, kenapa, dan apa
konsekuensinya. Keputusan baru ditambahkan di atas (paling baru dulu).

## ADR-004 — 17 skill upstream ditambahkan apa adanya di `.github/skills/`

- **Tanggal:** 2026-10-29
- **Keputusan:** 17 `SKILL.md`, 11 skrip otomasi emulator, dan file
  `Agent.md` dari repositori
  `new-silvermoon/awesome-android-agent-skills` (commit
  `82900eacc8dbe13de93c6310af27b9df4b2bd2f6`, lisensi Apache-2.0)
  disalin verbatim tanpa edit ke `.github/skills/` dan `Agent.md`.
  Provenance dicatat di `README.md`.
- **Alasan:** Referensi modern (Compose, Hilt, Room, Retrofit) untuk
  pengembangan lanjutan dan proyek sendiri, atas permintaan dosen
  agar ditambahkan apa adanya.
- **Konsekuensi:** Opsional, bukan syarat Tugas Akhir/P1–P7. Layout
  `.github/skills/` dipertahankan agar isi upstream utuh, terpisah
  dari 5 skill inti di `.agents/skills/`. Bila bertentangan dengan
  `AGENTS.md`/ADR-001 (XML/AppCompat), `AGENTS.md` yang berlaku
  untuk tugas kuliah. Skrip emulator butuh ADB/emulator dan tidak
  dijalankan otomatis. Muat skill per topik saja agar hemat token.

## ADR-003 — Ikon launcher vector drawable, bukan PNG mipmap

- **Tanggal:** 2026-10-27 (saat menyiapkan versi siap-mahasiswa)
- **Keputusan:** `AndroidManifest.xml` merujuk ke
  `@drawable/ic_launcher` (file XML vector), bukan lagi
  `@mipmap/ic_launcher` (PNG).
- **Alasan:** Repo GitHub hanya berisi file teks (konektor GitHub
  tidak bisa mengunggah PNG), sehingga mahasiswa yang clone harus
  bisa langsung build tanpa file biner tambahan.
- **Konsekuensi:** Ikonnya sederhana (kotak ungu + lingkaran).
  Mahasiswa boleh menggantinya dengan ikon sendiri nanti, termasuk
  kembali ke mipmap PNG bila mau. File PNG lama di ZIP bersifat
  opsional dan tidak lagi dirujuk manifest.

## ADR-001 — UI XML + AppCompat, bukan Compose

- **Tanggal:** 2026-10-27 (saat starter kit dibuat)
- **Keputusan:** Layout memakai XML dan AppCompat.
- **Alasan:** Selaras dengan materi praktikum P4–P7 yang sudah
  diajarkan (findViewById, layout XML, Activity lifecycle).
- **Konsekuensi:** Layar baru harus dibuat dalam XML, bukan Composable.

## ADR-002 — Versi build dikunci mengikuti P7

- **Tanggal:** 2026-10-27
- **Keputusan:** Gradle 8.7, AGP 8.5.2, Kotlin 2.0.20,
  compile/target SDK 34, min SDK 24.
- **Alasan:** Versi ini sudah terbukti jalan di proyek Kartu Profil P7.
- **Konsekuensi:** Menaikkan versi butuh persetujuan dan uji ulang
  build di HP.

## ADR-003 — [Judul keputusan berikutnya]

- **Tanggal:** [ISI]
- **Keputusan:** [ISI]
- **Alasan:** [ISI]
- **Konsekuensi:** [ISI]
