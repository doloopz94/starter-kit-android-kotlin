# AGENTS.md — Aturan kerja AI di proyek ini

Aturan ini dibaca AI (termasuk Muse) setiap kali mengerjakan proyek ini.
Tujuannya meniru alur kerja dari video: dokumentasi dulu, plan dulu,
baru eksekusi, dan tidak pernah asal jadi.

## 1. Plan dulu, eksekusi belakangan (aturan terpenting)

- Untuk setiap tugas, AI **wajib** menulis plan dulu di `docs/plan/`
  (pakai `plan-template.md`): tujuan, file yang diubah/dibuat, langkah
  berurutan, dan cara menguji.
- Plan harus **dibaca dan disetujui pengguna item per item**. Jangan
  pernah mengeksekusi plan yang belum disetujui, dan jangan pernah
  menganggap diam = setuju.
- Kalau plan berubah di tengah jalan, perbarui file plan-nya dulu,
  baru lanjutkan eksekusi. Jangan mengubah kode tanpa memperbarui plan.

## 2. Dokumentasi adalah sumber kebenaran

- Sebelum menambah fitur, baca `docs/product-overview.md`,
  `docs/build-spec.md`, dan `docs/architecture.md`.
- Fitur baru harus dicatat di build-spec dan roadmap; keputusan yang
  berubah dicatat di `docs/decisions.md`; pertanyaan yang belum terjawab
  dicatat di `docs/open-questions.md`, bukan ditebak.
- Jangan mengubah struktur proyek, versi build, atau package tanpa
  mencatat alasannya di `docs/decisions.md`.

## 3. Ikuti skill di .agents/skills/

- `kotlin-clean-code` — gaya penulisan Kotlin.
- `android-ui-guidelines` — layout, strings, colors, resources.
- `activity-lifecycle-navigation` — lifecycle dan Intent antar layar.
- `input-validation-logic` — validasi input dan logika `when`.
- `code-review-checklist` — checklist akhir sebelum tugas dianggap selesai.
- Kalau ada konflik antara skill dan permintaan sesaat, tanyakan dulu;
  jangan diam-diam melanggar skill.

## 4. Aturan kode yang tidak boleh dilanggar

- Semua teks yang tampil di layar harus di `strings.xml`, semua warna
  di `colors.xml`. Dilarang hardcode teks/warna di layout maupun Kotlin.
- Setiap `id` yang dipakai di Kotlin **harus** ada di layout, dan setiap
  `id` di layout yang dipakai harus cocok tipenya (EditText, Button, dll).
- XML harus valid; Kotlin harus null-safe (`?.`, `?:`, `toIntOrNull()`).
  Dilarang memakai `!!` kecuali ada alasan yang ditulis di plan.
- Layar kedua yang hanya dibuka dari dalam aplikasi memakai
  `android:exported="false"` di AndroidManifest.
- Versi build dikunci: Gradle 8.7, AGP 8.5.2, Kotlin 2.0.20,
  compile/target SDK 34, min SDK 24. Jangan menaikkan versi tanpa
  persetujuan dan tanpa catatan di `docs/decisions.md`.

## 5. Cara menguji

- Setelah mengubah kode, jalankan checklist di
  `code-review-checklist/SKILL.md` dan laporkan hasilnya.
- Uji kasus valid DAN kasus tidak valid (kolom kosong, format salah,
  angka di luar rentang). Aplikasi tidak boleh crash dan tidak boleh
  pindah layar selama ada input yang belum valid.
- Kalau build gagal di laptop pengguna, minta pesan error persisnya;
  jangan menebak penyebabnya dan jangan mengklaim build berhasil
  tanpa bukti.

## 6. Skill upstream dan hemat token (pagar kit ini)

- File `Agent.md` di root adalah panduan upstream berbahasa Inggris
  (Compose/Hilt). Untuk tugas kuliah, file itu DIABAIKAN. Urutan yang
  berlaku: `AGENTS.md` ini, lalu dokumen di `docs/`, lalu 5 skill inti
  di `.agents/skills/`. Skill upstream di `.github/skills/` hanya
  referensi lanjutan.
- Stack terkunci untuk tugas kuliah: UI XML + AppCompat, Kotlin 2.0.20,
  SDK 34/min SDK 24, tanpa database/server. Dilarang memakai Compose,
  Hilt, Room, Retrofit, atau menaikkan versi tanpa persetujuan pengguna
  yang ditulis di plan dan dicatat di `docs/decisions.md`.
- Hemat token: satu tugas = maksimal 2 skill, sebutkan namanya
  eksplisit di plan. Jangan memuat semua skill, dan jangan memuat
  skill yang tidak relevan dengan tugas itu. Satu milestone = satu
  sesi, diff kecil, perbaiki plan dulu bila plan berubah, jangan
  mengulang eksekusi dari nol.
- Skill upstream hanya dipakai bila plan menyebutkannya eksplisit,
  untuk topik lanjutan di luar materi P1–P7 (mis. testing atau
  performa build). Bila skill upstream bertentangan dengan aturan
  di atas, aturan di atas yang menang.
