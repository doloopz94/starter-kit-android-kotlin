---
name: kotlin-clean-code
description: Write clean, null-safe Kotlin for Android — naming, val/var, when categories, and no unsafe operators without a reason in the plan. Use when writing or changing any .kt file.
---

# Skill: Kotlin Clean Code

Dipakai: setiap kali menulis atau mengubah file `.kt`.

## Aturan wajib

- Gunakan `val` kecuali nilai memang harus berubah, baru `var`.
- Null safety: pakai `?.`, `?:`, dan `toIntOrNull()` untuk input angka.
  Dilarang `!!` kecuali alasannya ditulis di plan.
- Satu fungsi = satu tugas. Fungsi yang sudah lebih dari ~30 baris
  harus dipecah atau alasannya ditulis di plan.
- Penamaan: class `PascalCase`, fungsi/variabel `camelCase`,
  konstanta `UPPER_SNAKE_CASE`. Nama harus menjelaskan isi, bukan
  singkatan misterius (`btnSimpan` boleh, `b1` tidak boleh).
- Logika kategori/pilihan bertingkat memakai `when`, bukan rantai
  `if-else` yang panjang. Contoh pola dari P7:

  ```kotlin
  val kategori = when (umur) {
      in 0..12 -> "Anak"
      in 13..17 -> "Remaja"
      in 18..59 -> "Dewasa"
      else -> "Lansia"
  }
  ```

- Komentar hanya untuk "kenapa", bukan "apa" yang sudah jelas dari kode.
  Komentar "versi pertemuan" di atas class boleh dipertahankan untuk
  keperluan praktikum.

## Contoh salah

```kotlin
val umur = etTahun.text.toString().toInt() // crash kalau kosong/huruf
val x = findViewById<Button>(R.id.btn)!!   // !! tanpa alasan
```
