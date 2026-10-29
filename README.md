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

## Kalau clone dari GitHub: satu langkah sebelum build pertama

Repo GitHub kit ini berisi file teks saja, dan itu sudah cukup
untuk build — dengan dua catatan:

- **Ikon sudah vector:** manifest merujuk ke
  `@drawable/ic_launcher` (file XML), bukan lagi PNG mipmap,
  jadi tidak ada file ikon yang perlu disalin. Lihat ADR-003 di
  `docs/decisions.md`.
- **Wrapper jar dibuat sekali:** `gradle-wrapper.jar` tidak ada di
  repo. Bila Gradle sudah terpasang, jalankan sekali di folder
  proyek: `gradle wrapper --gradle-version 8.7`, lalu build dengan
  `.\gradlew installDebug` seperti biasa. Panduan lengkap untuk
  mahasiswa ada di `PANDUAN-MAHASISWA.md`.

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
   yang dicari OpenCode. Skill upstream di `.github/skills/` dibaca
   lewat `opencode.json` di root proyek (lihat bagian Skill tambahan
   dari upstream di bawah). Tiap `SKILL.md` di kit ini sudah diberi
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
Agent.md                      Panduan arsitektur upstream (lihat "Skill tambahan dari upstream" di bawah)
opencode.json                 Konfigurasi OpenCode: skill upstream terbaca tanpa disalin
.agents/skills/               5 skill yang dipakai AI di setiap proyek
  kotlin-clean-code/
  android-ui-guidelines/
  activity-lifecycle-navigation/
  input-validation-logic/
  code-review-checklist/
.github/skills/               17 skill upstream, apa adanya (opsional, lihat di bawah)
  architecture/  ui/  migration/  performance/
  concurrency_and_networking/  testing_and_automation/  build_and_tooling/
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

## Skill tambahan dari upstream (opsional, 17 skill)

Folder `.github/skills/` berisi 17 skill yang disalin **apa adanya,
tanpa edit**, dari repositori
[new-silvermoon/awesome-android-agent-skills](https://github.com/new-silvermoon/awesome-android-agent-skills)
(commit `82900eacc8dbe13de93c6310af27b9df4b2bd2f6`, 29 Oktober 2026),
lisensi Apache License 2.0, beserta file `Agent.md` upstream di root
proyek dan 11 skrip otomasi emulator di dalam skill
`android-emulator-skill`. Kategorinya: `architecture` (android-architecture,
android-viewmodel, android-data-layer), `ui` (compose-ui,
compose-navigation, coil-compose, android-accessibility), `migration`
(xml-to-compose-migration, rxjava-to-coroutines-migration), `performance`
(compose-performance-audit, gradle-build-performance),
`concurrency_and_networking` (kotlin-concurrency-expert,
android-coroutines, android-retrofit), `testing_and_automation`
(android-testing, android-emulator-skill), dan `build_and_tooling`
(android-gradle-logic).

Skill-skill ini **opsional dan bukan syarat** Tugas Akhir maupun materi
P1–P7, yang tetap memakai XML/AppCompat sesuai ADR-001. Isinya
Compose-first dan modern (Hilt, Room, Retrofit) untuk pengembangan
lanjutan atau proyek sendiri. Bila isinya bertentangan dengan
`AGENTS.md` atau dokumen kit ini, `AGENTS.md` dan dokumen kit yang
berlaku untuk tugas kuliah. `Agent.md` upstream berbeda dari
`AGENTS.md` kit ini: `AGENTS.md` tetap aturan utama kit.

Cara pakai: sebutkan file skillnya ke agent, mis.
`baca .github/skills/ui/compose-ui/SKILL.md lalu ...`, atau salin
folder skill yang dibutuhkan ke folder skill bawaan agent yang dipakai
(mis. `.opencode/skills/` atau `.claude/skills/`). Muat satu topik
saja per sesi, jangan semua sekaligus. Skrip emulator hanya jalan
bila ada emulator/ADB dan tidak dijalankan otomatis oleh kit ini.

### Peta pemakaian (mana dipakai kapan)

- **Wajib tiap tugas:** 5 skill inti di `.agents/skills/` (gaya Kotlin,
  layout XML, lifecycle/navigasi, validasi, checklist akhir).
- **Referensi lanjutan, hanya bila plan menyebutkannya:** 17 skill di
  `.github/skills/`. Contoh: `android-testing` bila menambah unit test,
  `gradle-build-performance` bila build terasa lambat,
  `android-accessibility` bila memeriksa aksesibilitas layar. Jangan
  memuat skill migrasi (XML ke Compose / RxJava ke Coroutines) untuk
  tugas yang harus tetap XML. Aturan lengkapnya ada di bagian 6
  `AGENTS.md`.
- File `opencode.json` di root proyek mendaftarkan `.github/skills`
  sebagai sumber skill OpenCode, jadi 17 skill itu terbaca tanpa
  disalin. Syaratnya: jalankan OpenCode dari root proyek (bukan
  subfolder), restart OpenCode setelah file ini ditambahkan, dan pakai
  OpenCode versi yang mendukung array `skills` (teruji di 1.19.5; cek
  dengan `opencode debug skill` — harus tampil 23 skill: 1 bawaan +
  5 inti + 17 upstream).

## Cara menambah skill baru

Buat folder baru di `.agents/skills/<nama-skill>/SKILL.md` berisi:
kapan skill ini dipakai, aturan wajib, contoh benar, dan contoh salah.
Satu skill = satu topik saja. Jangan menumpuk semua aturan di satu file.
