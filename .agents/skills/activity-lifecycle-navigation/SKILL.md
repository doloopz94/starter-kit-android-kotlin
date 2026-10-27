---
name: activity-lifecycle-navigation
description: Handle Android Activity lifecycle and explicit Intent navigation correctly, including exported flags and single-defined Intent extra keys. Use when working with Activities or moving between screens.
---

# Skill: Activity Lifecycle & Navigation

Dipakai: setiap kali bekerja dengan Activity, Intent, dan perpindahan layar.

## Aturan wajib

- `setContentView` dan `findViewById` hanya di `onCreate`, setelah
  `super.onCreate(savedInstanceState)`.
- Pindah layar memakai Intent eksplisit:

  ```kotlin
  val intent = Intent(this, SecondActivity::class.java)
  intent.putExtra("NAMA", nama)
  startActivity(intent)
  ```

- Kunci extra didefinisikan sekali sebagai konstanta di Activity
  tujuan (mis. `companion object { const val EXTRA_NAMA = "NAMA" }`)
  dan dipakai di kedua Activity — jangan menulis string kunci mentah
  di dua tempat yang bisa salah ketik.
- Layar kedua yang hanya dibuka dari dalam aplikasi wajib
  `android:exported="false"` di AndroidManifest; layar utama
  `android:exported="true"` dengan intent-filter MAIN/LAUNCHER.
- Tombol kembali di layar kedua cukup memanggil `finish()` — jangan
  membuat Intent baru kembali ke layar pertama (akan menumpuk Activity).
- `Toast` hanya untuk konfirmasi singkat; pesan error validasi memakai
  `EditText.error` + `requestFocus()` (lihat skill input-validation-logic).
