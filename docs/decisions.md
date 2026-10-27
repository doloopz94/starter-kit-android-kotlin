# Decisions (ADR sederhana)

Setiap keputusan penting dicatat di sini: apa, kenapa, dan apa
konsekuensinya. Keputusan baru ditambahkan di atas (paling baru dulu).

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
