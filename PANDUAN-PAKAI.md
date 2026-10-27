# Panduan Pakai Starter Kit Android Kotlin — Hemat Token, Hasil Sesuai Harapan

> Fokus panduan ini: starter kit Android dulu (bukan fullstack).
> Kit ini hanya file Markdown + kode Kotlin/XML biasa, jadi **tidak
> terikat ke satu model AI atau satu tool**. Model apapun yang didukung
> tool yang kamu pakai bisa dipakai — yang menentukan hemat atau tidak
> bukan nama modelnya, melainkan **alur kerjanya**.

## Prinsip yang bikin hemat token

Token boros bukan karena modelnya mahal, tapi karena agent disuruh:
membaca ulang seluruh proyek, menebak maksudmu, membuat ulang file
utuh, lalu memperbaiki hasil tebakannya berulang-ulang.
Plan-first membalik itu: maksudmu ditulis sekali di `docs/` dan
`docs/plan/`, agent membaca dokumen itu (bukan seluruh riwayat chat),
dan mengeksekusi satu milestone kecil yang sudah kamu setujui.
Hasilnya lebih sesuai harapan karena kamu memeriksa **plan** —
yang murah dibaca — sebelum membayar eksekusi yang mahal.

Skill di kit ini juga dirancang hemat: agent mula-mula hanya membaca
`name` + `description` tiap skill, dan baru memuat isi lengkap skill
itu saat tugasnya cocok. Jadi jangan pernah menempel isi SKILL.md
ke dalam prompt — itu justru memboroskan token.

## Persiapan sekali saja (5 menit)

1. Ekstrak ZIP starter kit, lalu **copy foldernya** dengan nama
   proyek baru (mis. `aplikasi-catatan`). Jangan kerjakan proyek
   di dalam folder master starter kit — master harus tetap bersih
   untuk di-clone lagi nanti.
2. Buka **folder proyek baru itu** di VS Code (bukan subfolder
   `app/`-nya). Agent hanya membaca `AGENTS.md` dan `.agents/skills/`
   kalau folder yang dibuka adalah root proyek.
3. Pastikan setup Android sudah jalan seperti biasa: HP terhubung
   (`adb devices` = `device`), dan `local.properties` sudah berisi
   `sdk.dir` bila diperlukan (lihat `docs/setup.md`).

## Pilih SATU jalur per proyek (jangan dicampur dalam satu sesi)

Mencampur dua agent dalam satu sesi pada file yang sama adalah
penyebab konflik dan token terbuang. Pilih satu, pakai sampai
milestone selesai.

### Jalur A — CLI di terminal VS Code (paling hemat & paling terkontrol)

Cocok kalau kamu mau melihat persis apa yang agent kerjakan dan
mengganti model dengan cepat. Contoh tool-nya: OpenCode, Gemini CLI,
Claude Code, Codex — langkahnya sama polanya:

1. Di VS Code, buka Terminal (Terminal → New Terminal).
2. Pindah ke folder proyek, lalu jalankan agent-nya, mis. `opencode`
   untuk OpenCode atau `gemini` untuk Gemini CLI.
3. Pilih model: di OpenCode pakai `/models`, di Gemini/Claude/Codex
   pakai `/model`. Aturan praktis: model kecil/murah untuk plan dan
   edit sederhana, model besar hanya untuk logika sulit atau debug
   rumit.
4. Tempel Prompt 0 di bawah, lalu ikuti alur 7 langkah.

Perintah hemat token yang perlu dihafal:
- OpenCode/Claude/Codex: `/compact` untuk memadatkan sesi panjang,
  `/new` untuk sesi baru yang bersih.
- Gemini CLI: `/compress` untuk memadatkan, `/clear` untuk sesi baru.
- Semua tool: tutup sesi di akhir milestone, jangan membiarkan satu
  sesi mengerjakan 5 milestone berturut-turut.

### Jalur B — Plugin / Agent Mode langsung di VS Code

Cocok kalau kamu lebih nyaman klik daripada terminal. Contohnya:
GitHub Copilot Chat (mode Agent), Cursor, Cline, Roo Code, Kilo Code.

1. Install extension-nya, buka panel Chat, pilih mode **Agent**
   (bukan Ask/Edit), lalu pilih model dari dropdown.
2. Pastikan folder yang dibuka adalah root proyek. Di Copilot,
   skill di `.agents/skills/` bisa dicek dengan mengetik `/skills`
   di chat — kalau skill kit ini muncul di daftar, berarti sudah
   terbaca; kalau tidak, cek lagi folder yang dibuka atau sebut
   nama skillnya langsung di prompt.
3. Tempel Prompt 0 di bawah, lalu ikuti alur 7 langkah yang sama.
   Periksa diff per file sebelum menekan Accept — jangan Accept All
   tanpa membaca.

### Jalur C — Hybrid dengan Muse (aku)

Cocok kalau kamu mau perencanaan yang matang tanpa membakar token
agent VS Code untuk berpikir:

1. Di chat ini, minta aku membuat/merevisi plan di `docs/plan/`
   dan dokumen di `docs/` (aku tidak bisa mengedit file di VS Code-mu).
2. Salin plan yang sudah kamu setujui itu ke agent VS Code-mu,
   lalu agent VS Code yang mengeksekusinya.
3. Kalau hasilnya meleset, kirimkan diff/error-nya ke aku untuk
   direview — jangan langsung menyuruh agent VS Code mengulang
   dari nol.

## Alur kerja baku — 7 langkah per milestone (wajib diikuti)

1. **Isi dokumen dulu** — `docs/product-overview.md` dan
   `docs/build-spec.md` untuk fitur itu. Dokumen kosong = belum
   boleh ngoding.
2. **Agent membuat plan** — pakai Prompt 1. Plan ditulis ke
   `docs/plan/mX-....md`, bukan hanya di chat.
3. **Kamu setujui item per item** — baca plan, coret/ubah yang
   tidak sesuai langsung di file plan, baru katakan setuju.
   Ini satu-satunya gerbang penghematan terbesar: memperbaiki plan
   (murah) jauh lebih murah daripada memperbaiki kode jadi (mahal).
4. **Agent mengeksekusi SATU milestone saja** — pakai Prompt 2.
   Jangan menambahkan fitur lain di tengah eksekusi.
5. **Agent menjalankan checklist** — pakai Prompt 4 (skill
   code-review-checklist): XML valid, id cocok, tidak ada hardcode,
   validasi berlapis, manifest benar.
6. **Build & uji sekali per milestone** — `.\gradlew installDebug`,
   uji kasus valid DAN tidak valid di HP. Jangan build berulang
   untuk tiap edit kecil.
7. **Tutup sesi, catat, sesi baru** — catat keputusan ke
   `docs/decisions.md`, pertanyaan ke `docs/open-questions.md`,
   lalu `/new` (atau sesi baru) untuk milestone berikutnya.
   Sesi baru membaca dokumen, bukan riwayat chat lama — di sinilah
   token benar-benar dihemat.

## Prompt siap tempel (salin, ganti bagian [KURUNG])

### Prompt 0 — Pembuka sesi (tempel sekali di awal proyek)

```
Ikuti AGENTS.md di proyek ini. Kerja dengan aturan plan-first:
buat plan dulu di docs/plan/, tunggu persetujuanku item per item,
baru menulis kode. Pakai skill di .agents/skills/ sesuai tugasnya,
jangan memuat semua skill sekaligus. Jangan mengubah versi build,
package, atau struktur proyek tanpa mencatat di docs/decisions.md.
Jangan menulis ulang file utuh kalau hanya perlu mengubah sebagian
kecil — buat perubahan sekecil mungkin.
```

### Prompt 1 — Minta plan (sebelum ada kode baru)

```
Buatkan plan di docs/plan/m2-[nama-fitur].md untuk fitur berikut:
[DESKRIPSIKAN FITUR DALAM 3-5 KALIMAT: input apa, aturan apa,
output apa, layar apa].
Plan harus berisi: tujuan, file yang diubah/dibuat, langkah
berurutan, dan cara menguji kasus valid dan tidak valid.
Jangan menulis kode dulu. Setelah plan selesai, berhenti dan
tunggu persetujuanku.
```

### Prompt 2 — Eksekusi plan yang sudah disetujui

```
Eksekusi plan di docs/plan/m2-[nama-fitur].md yang sudah
kusetujui, langkah demi langkah. Setelah selesai, jalankan
skill code-review-checklist dan laporkan hasilnya item per item.
Jangan menambah fitur di luar plan.
```

### Prompt 3 — Perbaiki bug (jangan pernah hanya bilang "kok error")

```
Terjadi error berikut saat [build / menjalankan aplikasi]:
[PESAN ERROR PERSIS, disalin lengkap]
File terkait: [path file, mis. app/src/main/java/.../MainActivity.kt]
Yang sudah kucoba: [ISI].
Perbaiki dengan perubahan sekecil mungkin, jelaskan penyebabnya
dalam 2-3 kalimat, dan jangan mengubah file lain yang tidak terkait.
```

### Prompt 4 — Review sebelum dianggap selesai

```
Review perubahan terakhir dengan skill code-review-checklist.
Sebutkan tiap item: lolos / tidak lolos / belum bisa diverifikasi
beserta alasannya. Jangan katakan selesai bila ada item yang
belum terverifikasi.
```

## 10 aturan hemat token (tempel di dekat laptop kalau perlu)

1. Satu milestone = satu sesi. Sesi baru membaca dokumen, bukan
   riwayat chat panjang.
2. Sebut path file yang relevan saja. Jangan pernah menyuruh agent
   "baca semua file di proyek ini".
3. Minta diff kecil, bukan file utuh. "Ubah fungsi X di file Y"
   jauh lebih murah daripada "buat ulang MainActivity.kt".
4. Kalau hasil salah, perbaiki **plan**-nya, bukan mengulang prompt
   eksekusi yang sama dengan harapan hasil berbeda.
5. Sebut nama skill, jangan tempel isi SKILL.md ke prompt.
6. Jangan suruh agent browsing internet kalau jawabannya sudah ada
   di `docs/` atau di skill.
7. Model kecil untuk plan/edit ringan, model besar hanya untuk
   logika sulit/debug rumit.
8. Sesi mulai panjang → `/compact`/`/compress`, atau lebih baik
   tutup dan buka sesi baru dengan ringkasan keputusan.
9. Build sekali per milestone, bukan tiap edit kecil. Logcat hanya
   bila memang sedang menelusuri bug.
10. Semua keputusan dan plan tersimpan di `docs/` — supaya sesi
    berikutnya tidak mulai dari nol dan tidak mengulang pertanyaan
    yang sama.

## Yang boros token dan bikin hasil meleset (JANGAN dilakukan)

- "Buatkan aplikasi lengkap dari nol" dalam satu prompt.
- "Perbaiki semuanya" tanpa menyebut file, error, dan hasil yang
  diharapkan.
- Menyetujui plan tanpa membaca, lalu mengeluh hasilnya meleset.
- Membiarkan agent menaikkan versi Gradle/Kotlin/SDK sendiri.
- Accept All diff tanpa membaca, lalu menyuruh agent memperbaiki
  hasil Accept All itu.
- Meminta agent yang sama mengerjakan 3 fitur sekaligus dalam
  satu sesi panjang.

## Checklist sebelum menekan Enter (5 pertanyaan)

- [ ] Apakah tugas ini SATU milestone saja?
- [ ] Apakah plan-nya sudah ada dan sudah kusetujui?
- [ ] Apakah path file dan hasil yang diharapkan sudah kusebut?
- [ ] Apakah ini perubahan kecil, bukan regenerasi file utuh?
- [ ] Apakah aku tahu model apa yang sedang dipakai agent ini?

Kalau ada yang belum YA, perbaiki prompt-nya dulu — itu lebih
murah daripada memperbaiki hasilnya nanti.

## Contoh sesi lengkap (mini, dari starter kit ini)

Tugas: tambah kolom email + validasi + layar kedua, seperti pola P7.

1. Isi `docs/build-spec.md` untuk fitur email (aturan: tidak kosong,
   harus mengandung "@" dan ".").
2. Prompt 1 → plan `docs/plan/m2-email-dan-layar-kedua.md`.
3. Kamu baca plan, coret yang tidak perlu, katakan setuju.
4. Prompt 2 → agent membuat layout, SecondActivity, Intent extra,
   validasi berlapis.
5. Prompt 4 → checklist, lalu kamu build sekali dan uji:
   email kosong → error, email tanpa "@" → error,
   email benar → pindah layar kedua.
6. Catat di `docs/decisions.md` bila ada keputusan baru, tutup sesi.

## Troubleshooting

- **Agent tidak membaca AGENTS.md / skill:** pastikan folder yang
  dibuka adalah root proyek (bukan `app/`), lalu tempel Prompt 0
  dan sebut nama skillnya. Kalau tetap tidak terbaca, salin folder
  skill ke folder skill bawaan tool itu (OpenCode: `.opencode/skills/`).
- **Agent mengubah terlalu banyak file:** hentikan, kembali ke
  plan, pakai mode plan/agen plan (di OpenCode: agen Plan, di tool
  lain: mode plan) dan minta diff dulu sebelum eksekusi.
- **Token habis di tengah jalan:** `/compact`, atau tutup sesi dan
  buka sesi baru dengan ringkasan: "Lanjutkan milestone X, plan ada
  di docs/plan/..., yang sudah selesai: ..., yang belum: ...".
- **Build gagal:** jangan menebak — salin pesan error persisnya dan
  pakai Prompt 3.
- **Hasil tidak sesuai harapan padahal plan disetujui:** yang salah
  biasanya plan-nya kurang spesifik. Perbaiki build-spec dan plan,
  bukan menyuruh agent menebak ulang.

## Catatan soal model dan biaya

Kit ini tidak terikat provider. Di OpenCode kamu bisa mengganti
provider/model lewat `/models` dan login provider lewat auth tool
itu; di Gemini/Claude/Codex lewat `/model`; di plugin VS Code lewat
dropdown model di panel Chat. Paket gratis/berbayar tiap provider
berubah-ubah — cek halaman harga/kuota provider itu pada saat kamu
memakai, jangan mengandalkan klaim "gratis selamanya" dari video
atau artikel lama. Prinsip hemat di panduan ini berlaku untuk
model gratis maupun berbayar: sesi pendek + plan tertulis selalu
lebih murah daripada sesi panjang yang mengulang-ulang.
