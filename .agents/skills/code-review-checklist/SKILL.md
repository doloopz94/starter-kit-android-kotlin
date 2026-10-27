---
name: code-review-checklist
description: Run the final pre-completion check for an Android task — valid XML, matching Kotlin and layout ids, no hardcoded text or colors, layered validation, correct manifest entries, and an updated plan. Use at the end of every task before reporting it done.
---

# Skill: Code Review Checklist

Dipakai: di akhir setiap tugas, sebelum tugas dilaporkan selesai.
AI wajib menjalankan dan melaporkan checklist ini — bukan sekadar
mengaku sudah memeriksa.

## Checklist (semua harus YA, atau alasannya ditulis)

- [ ] XML di semua layout valid (tidak ada tag tak tertutup).
- [ ] Setiap `id` yang dipakai di Kotlin ada di layout dan tipenya cocok.
- [ ] Setiap teks tampil ada di `strings.xml`, setiap warna ada di
      `colors.xml` (tidak ada hardcode).
- [ ] Input sudah divalidasi berlapis (kosong, format, angka, rentang)
      dan aplikasi tidak pindah layar bila ada yang belum valid.
- [ ] Tidak ada `!!` tanpa alasan di plan, tidak ada `toInt()` langsung
      untuk input pengguna.
- [ ] Activity baru sudah didaftarkan di AndroidManifest dengan
      `exported` yang benar.
- [ ] Versi build tidak berubah tanpa catatan di `docs/decisions.md`.
- [ ] Plan di `docs/plan/` sudah diperbarui sesuai kode yang jadi.
- [ ] Kasus uji valid dan tidak valid sudah dicoba/dijelaskan
      (apa inputnya, apa hasil yang diharapkan).

Kalau satu item tidak bisa diverifikasi (mis. build APK belum dicoba
di laptop), tulis dengan jujur: "belum terverifikasi karena ..." —
jangan ditulis sudah berhasil.
