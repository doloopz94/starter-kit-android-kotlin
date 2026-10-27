---
name: input-validation-logic
description: Validate user input in layers before processing — empty, format, numeric with toIntOrNull, and sensible range — with error plus requestFocus plus return, and never navigate while input is invalid. Use when processing any user input.
---

# Skill: Input Validation & Logic

Dipakai: setiap kali memproses input pengguna sebelum dihitung/dikirim.

## Pola validasi berlapis (dari P7, wajib diikuti urutannya)

1. Ambil teks, ubah ke string, `trim()` bila perlu.
2. Periksa kosong → set `error`, `requestFocus()`, `return`.
3. Periksa format (mis. email harus mengandung "@" dan ".") →
   `error`, `requestFocus()`, `return`.
4. Periksa angka dengan `toIntOrNull()` — kalau `null`, `error`,
   `requestFocus()`, `return`. Jangan pernah `toInt()` langsung.
5. Periksa rentang yang masuk akal (mis. tahun lahir 1900–tahun
   sekarang) → `error`, `requestFocus()`, `return`.
6. **Baru** hitung dan pindah layar. Selama ada yang belum valid,
   aplikasi TIDAK boleh pindah layar.

## Contoh benar

```kotlin
val tahun = etTahun.text.toString().toIntOrNull()
if (tahun == null) {
    etTahun.error = "Tahun lahir harus berupa angka"
    etTahun.requestFocus()
    return
}
val tahunSekarang = Calendar.getInstance().get(Calendar.YEAR)
if (tahun < 1900 || tahun > tahunSekarang) {
    etTahun.error = "Tahun lahir di luar rentang yang masuk akal"
    etTahun.requestFocus()
    return
}
val umur = tahunSekarang - tahun
```

## Logika dengan when

Kategori, status, atau pilihan bertingkat selalu memakai `when`
dengan rentang yang tidak tumpang tindih dan `else` sebagai penangkap.
