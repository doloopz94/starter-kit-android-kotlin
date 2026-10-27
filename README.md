# Starter Kit Android Kotlin

Starter kit ini meniru 4 pilar dari video itu, disesuaikan untuk mata kuliah
Pemrograman Mobile (Kotlin, Android di VS Code) yang kamu ajarkan:

1. **Skills sendiri** → folder `.agents/skills/` (5 skill, lihat di bawah)
2. **Dokumentasi dulu** → folder `docs/` (product-overview, build-spec,
   architecture, decisions, roadmap, setup, extending, open-questions)
3. **Plan dulu, baru eksekusi** → folder `docs/plan/` (m0, m1, m2 + template)
4. **Boilerplate yang di-clone** → folder `app/` + Gradle, versi build sama
   persis dengan proyek Kartu Profil P7 yang sudah terbukti jalan

## Versi build (sama persis dengan P7)

- Gradle 8.7, Android Gradle Plugin 8.5.2, Kotlin 2.0.20
- Compile/Target SDK 34, Min SDK 24, AppCompat 1.7.0, core-ktx 1.13.1
- Package: `com.example.starter` (ganti di `settings.gradle`, `app/build.gradle`
  bagian `namespace`/`applicationId`, dan nama package di `MainActivity.kt`)
- App name: ganti di `app/src/main/res/values/strings.xml` (`app_name`)

## Penting: kit ini BUKAN fullstack seperti di video

Kit ini adalah boilerplate **Android Kotlin
saja**: 1 layar, tanpa server, tanpa database, tanpa login/RBAC,
tanpa API. Yang sama dengan video hanyalah **cara kerjanya**
(skills + dokumen + plan dulu + boilerplate yang dipakai ulang),
bukan isi teknisnya. Kalau kamu mau varian fullstack web juga,
itu paket terpisah yang harus dibuat dengan stack yang dipilih dulu.

## Kalau clone dari GitHub: 11 file biner belum ada di repo

Repo GitHub kit ini hanya berisi file teks, karena konektor GitHub
tidak bisa mengunggah file biner. Setelah clone, lengkapi dulu 11
file ini dari ZIP starter kit (atau buat ulang ikon launcher di
Android Studio via Image Asset):

- `app/src/main/res/mipmap-*/ic_launcher.png` dan
  `ic_launcher_round.png` (10 file, 5 densitas)
- `gradle/wrapper/gradle-wrapper.jar`

Tanpa file-file itu build akan gagal (manifest merujuk ke
`@mipmap/ic_launcher`, dan `gradlew` butuh wrapper jar-nya).
Setelah file-file itu disalin ke tempatnya, build seperti biasa.

## Pakai di VS Code dengan OpenCode (atau agent lain)

Muse (aku) memang **bukan** extension/agent di dalam VS Code, jadi
eksekusi di VS Code harus lewat agent lain seperti OpenCode.
Kit ini sengaja dibuat dari file Markdown biasa supaya bisa dibaca
agent lain:

1. Ekstrak ZIP, buka folder proyek di VS Code.
2. Jalankan OpenCode di terminal VS Code pada folder itu.
   OpenCode membaca `AGENTS.md` di root proyek, dan mencari skill di
   `.opencode/skills/`, `.claude/skills/`, dan `.agents/skills/` —
   jadi folder `.agents/skills/` di kit ini sudah berada di lokasi
   yang dicari OpenCode. Tiap `SKILL.md` di kit ini sudah diberi
   frontmatter `name` + `description` yang wajib agar skill
   ditemukan.
3. Di prompt pertama, tulis eksplisit (jangan mengandalkan tebakan):
   `Ikuti AGENTS.md di proyek ini. Buat plan dulu di docs/plan/ dan
   tunggu persetujuanku item per item sebelum menulis kode.`
4. Kalau satu agent tidak menemukan skill secara otomatis, sebut
   nama skillnya langsung, mis. `pakai skill input-validation-logic`,
   atau salin folder skill itu ke folder skill bawaan agent tersebut
   (untuk OpenCode: `.opencode/skills/`).
5. Aku tetap bisa membantumu dari chat ini untuk plan, dokumen,
   dan review — tapi untuk mengetik/mengubah kode langsung di
   VS Code, agent di VS Code-lah yang mengeksekusinya.

## Cara pakai untuk proyek baru (5 menit)

1. **Copy** folder ini, ganti namanya jadi nama proyek baru. Jangan edit
   folder starter kit aslinya — dia adalah master yang di-clone.
2. **Isi dulu** `docs/product-overview.md` dan `docs/build-spec.md`:
   aplikasi apa, siapa penggunanya, fitur apa saja, apa yang TIDAK dibuat.
   Kalau dua dokumen ini kosong, jangan mulai ngoding.
3. **Buat plan** di `docs/plan/mX-....md` (pakai `plan-template.md`).
   Tiap plan berisi: tujuan, file yang diubah/dibuat, langkah berurutan,
   dan cara menguji. Minta AI membuat plan, lalu **baca dan setujui item
   per item** — jangan pernah menyetujui plan secara buta. Ini aturan
   terpenting dari video itu, dan sudah ditulis di `AGENTS.md`.
4. **Baru eksekusi** sesuai plan. Setelah selesai, jalankan checklist di
   `.agents/skills/code-review-checklist/SKILL.md` sebelum dianggap selesai.
5. **Catat keputusan** yang berubah di `docs/decisions.md` dan pertanyaan
   yang belum terjawab di `docs/open-questions.md`.

## Cara menjalankan (VS Code, sama seperti P4–P7)

1. Buka folder proyek (yang berisi `gradlew.bat`) di VS Code.
2. Hubungkan HP (USB debugging atau adb wireless), cek `adb devices`
   statusnya `device`.
3. Dari terminal PowerShell:

   ```powershell
   .\gradlew installDebug
   ```

4. Bila muncul "SDK location not found", buat `local.properties` di folder
   akar proyek berisi `sdk.dir=<path SDK di komputer itu>`, contoh:
   `sdk.dir=C\:\\Users\\NamaKamu\\AppData\\Local\\Android\\Sdk`
5. Build pertama mengunduh Gradle 8.7 + dependency — perlu internet.

Catatan jujur: starter kit ini **tidak** di-build menjadi APK di komputer
ini (lingkungan ini tidak bisa menjalankan build Gradle Android sampai
tuntas). Strukturnya, versinya, dan kecocokan id Kotlin↔layout sudah
diverifikasi dengan skrip cek (lihat `VERIFY.md`). Build pertama tetap
harus kamu coba di laptop/HP seperti biasa — dan kalau ada error build,
kirimkan pesan errornya, jangan ditebak-tebak.

## Isi folder

```
AGENTS.md                     Aturan kerja untuk AI (plan-first, wajib dibaca AI)
.agents/skills/               5 skill yang dipakai AI di setiap proyek
  kotlin-clean-code/
  android-ui-guidelines/
  activity-lifecycle-navigation/
  input-validation-logic/
  code-review-checklist/
docs/
  product-overview.md         Aplikasi apa, untuk siapa, fitur apa
  build-spec.md               Spesifikasi build per fitur
  architecture.md             Struktur layar, data, dan navigasi
  decisions.md                Catatan keputusan (ADR sederhana)
  roadmap.md                  Urutan milestone
  setup.md                    JDK/SDK/ADB/VS Code + troubleshooting
  extending.md                Cara menambah layar/fitur baru
  open-questions.md           Pertanyaan yang belum terjawab
  plan/
    m0-bootstrap.md           Milestone 0 (sudah dikerjakan: kerangka ini)
    m1-foundation.md          Milestone 1 (UI dasar + resources)
    m2-main-feature.md        Milestone 2 (fitur utama + validasi)
    plan-template.md          Template plan untuk milestone berikutnya
app/                          Boilerplate aplikasi starter (1 layar)
  src/main/AndroidManifest.xml
  src/main/java/com/example/starter/MainActivity.kt
  src/main/res/layout/activity_main.xml
  src/main/res/values/{strings,colors,themes}.xml
VERIFY.md                     Hasil verifikasi starter kit ini
```

## Cara menambah skill baru

Buat folder baru di `.agents/skills/<nama-skill>/SKILL.md` berisi:
kapan skill ini dipakai, aturan wajib, contoh benar, dan contoh salah.
Satu skill = satu topik saja. Jangan menumpuk semua aturan di satu file.
