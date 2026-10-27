# Architecture

## Struktur proyek

- `MainActivity` — layar utama, pemilik semua interaksi layar ini.
- Layar tambahan (bila ada) dibuat sebagai Activity baru, didaftarkan
  di `AndroidManifest.xml`, dan dibuka lewat Intent eksplisit.
- Tidak ada database/server di starter ini. Data hanya berpindah
  antar layar lewat Intent extra (lihat skill activity-lifecycle-navigation).

## Alur data

```
Pengguna mengisi input
  → validasi berlapis di MainActivity (skill input-validation-logic)
  → proses/logika (when bila berkategori)
  → tampilkan hasil di layar yang sama, atau
  → kirim lewat Intent extra ke layar kedua
```

## Keputusan arsitektur (ringkas; detail di decisions.md)

- UI memakai XML + AppCompat (bukan Compose) agar selaras dengan
  materi praktikum P4–P7.
- Build memakai Gradle + VS Code + HP fisik via ADB (bukan emulator),
  sama seperti setup praktikum.
- Versi build dikunci (Gradle 8.7, AGP 8.5.2, Kotlin 2.0.20,
  compile/target SDK 34, min SDK 24).

## Menambah layar baru (ringkas; detail di extending.md)

1. Buat layout baru + Activity baru.
2. Daftarkan di AndroidManifest (`exported="false"` bila hanya
   dibuka dari dalam aplikasi).
3. Definisikan kunci Intent extra sekali di Activity tujuan.
4. Perbarui dokumen ini, build-spec, dan roadmap.
