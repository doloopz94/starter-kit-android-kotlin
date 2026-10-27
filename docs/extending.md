# Extending — Cara menambah layar / fitur baru

Ikuti urutan ini persis. Jangan melompati langkah 1–3 langsung ke kode.

1. **Perbarui dokumen dulu:** tambah fitur ke `product-overview.md`
   dan `build-spec.md`, tambah layar ke `architecture.md`.
2. **Buat plan baru** di `docs/plan/` dari `plan-template.md`,
   minta persetujuan item per item.
3. **Baru tulis kode** sesuai plan:
   - Layout baru di `res/layout/`, teks di `strings.xml`,
     warna di `colors.xml`.
   - Activity baru di package yang sama, daftarkan di
     `AndroidManifest.xml` (`exported="false"` bila hanya dibuka
     dari dalam aplikasi).
   - Kunci Intent extra didefinisikan sekali di Activity tujuan.
4. **Validasi** mengikuti skill input-validation-logic.
5. **Checklist akhir** dari skill code-review-checklist, lalu
   perbarui `roadmap.md` dan `decisions.md` bila ada keputusan baru.

## Contoh: menambah layar kedua "Tentang"

- Layout: `activity_second.xml` dengan TextView hasil + tombol Kembali.
- Activity: `SecondActivity`, tombol Kembali memanggil `finish()`.
- Manifest: `SecondActivity` dengan `exported="false"`.
- Intent dari MainActivity membawa data lewat extra yang kuncinya
  didefinisikan di `SecondActivity`.
