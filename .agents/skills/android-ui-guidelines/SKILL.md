---
name: android-ui-guidelines
description: Build Android XML layouts correctly — all text in strings.xml, all colors in colors.xml, dp for layout, sp for text, and clear view ids. Use when creating or changing any layout or resource file.
---

# Skill: Android UI Guidelines

Dipakai: setiap kali membuat atau mengubah layout XML dan resources.

## Aturan wajib

- Semua teks tampil di `res/values/strings.xml`, semua warna di
  `res/values/colors.xml`. Dilarang teks/warna hardcode di layout.
- Ukuran teks pakai `sp`, ukuran layout/jarak pakai `dp`.
- Setiap view yang diakses dari Kotlin harus punya `android:id`
  yang jelas (`@+id/etNama`, `@+id/btnSimpan`, `@+id/tvHasil`).
- `EditText` selalu diberi `android:hint` (dari strings) dan
  `android:inputType` yang sesuai (`text`, `textEmailAddress`, `number`).
- Struktur layout: satu `LinearLayout`/`ConstraintLayout` induk yang
  mudah dibaca mahasiswa, bukan layout bersarang dalam-dalam tanpa alasan.
- Warna latar kartu/bidang memakai drawable terpisah (mis. `bg_card.xml`)
  bila dipakai di lebih dari satu tempat, bukan warna inline berulang.

## Contoh benar

```xml
<EditText
    android:id="@+id/etNama"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="@string/hint_nama"
    android:inputType="text" />
```
