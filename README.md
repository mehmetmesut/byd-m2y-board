# M2Y Board

**A lean Turkish Q keyboard for the BYD Seal U DM-i touch screen.**
Developed by **Yeşil Dönüşüm Mühendisi - M2Y** and shared free for every BYD owner.

[Türkçe açıklama aşağıda](#türkçe) · Downloads: **[byd.mehmetmesut.com](https://byd.mehmetmesut.com)**

---

## Why it exists

The stock keyboard on DiLink 3.0 is built around Chinese input, and most store keyboards need Google services or send data online. M2Y Board is a trimmed fork of HeliBoard (100 % offline, no internet permission) set up for the car:

| Head unit | Design decision |
|---|---|
| Android 10, arm64, no Google services | Fully offline, arm64-only release (about 5 MB), no voice input |
| 1920×1080 landscape screen at 240 dpi | Height 82 % so the input field stays visible; number row always on; keys about 50 dp tall |
| Turkish driver, occasional Russian | **Turkish Q** enabled and selected on a fresh install whatever the system language; Russian installed but off |
| SM6125 CPU, must never stutter | Only three layouts compiled in (Turkish, Russian, English fallback); gesture typing, emoji suggestions and file copies of the clipboard off by default |
| Copy/paste and emoji while parked | **Clipboard** button always visible on the toolbar, emoji key on the bottom row |
| No data collection, minimal settings | HeliBoard's gesture data gathering (active and background collection, review/share screens, its database table) is removed; advanced, layout, dictionary and debug screens are removed, the other settings keep their defaults; timestamps default to `dd-MM-yyyy HH:mm:ss` |

## Features

- Turkish Q layout (ı, ğ, ü, ş, ö, ç, ₺), number row, Turkish dictionary and spell check.
- Russian (Cyrillic) layout and dictionary, ready to switch on.
- Emoji and clipboard history one tap away; clipboard history stays on the device.
- No microphone button, no network access, no backup of typed words.

## Install

```
adb connect <car-ip>:5555
adb install -r M2YBoard_1.25.07.68.0.apk
adb shell ime enable com.m2y.board/helium314.keyboard.latin.LatinIME
adb shell ime set com.m2y.board/helium314.keyboard.latin.LatinIME
```

## Build

```
./gradlew assembleRelease   # JDK 21, Android SDK
```
Signing reads a properties file outside the repository (`m2y.signingProps` in `local.properties`).

## Licence and credits

M2Y Board is a fork of **[HeliBoard](https://github.com/HeliBorg/HeliBoard)** and is licensed under the **GNU General Public License v3.0** ([LICENSE](LICENSE)).
M2Y changes © 2026 Yeşil Dönüşüm Mühendisi - M2Y, under the same licence.

- HeliBoard by Helium314 and [contributors](https://github.com/HeliBorg/HeliBoard/graphs/contributors), based on [OpenBoard](https://github.com/openboard-team/openboard) and the [AOSP Keyboard](https://android.googlesource.com/platform/packages/inputmethods/LatinIME/) (Apache 2.0, see [LICENSE-Apache-2.0](LICENSE-Apache-2.0)).
- Icon by [Fabian OvrWrt](https://github.com/FabianOvrWrt) with contributions from [The Eclectic Dyslexic](https://github.com/the-eclectic-dyslexic), [CC BY-SA 4.0](LICENSE-CC-BY-SA-4.0).
- Also credited by HeliBoard: LineageOS, Simple Keyboard, Indic Keyboard, FlorisBoard.
- Dictionaries from [Helium314/aosp-dictionaries](https://codeberg.org/Helium314/aosp-dictionaries).

**Not affiliated with BYD.** Layout and theme documentation: [HeliBoard wiki](https://github.com/HeliBorg/HeliBoard/wiki).

---

## Türkçe

**BYD Seal U DM-i dokunmatik ekranı için sade bir Türkçe Q klavye.**
**Yeşil Dönüşüm Mühendisi - M2Y** tarafından kendi aracım için geliştirildi ve tüm BYD sahiplerinin kullanımına ücretsiz sunuldu.

- HeliBoard tabanlı, tamamen çevrim dışı (internet izni yok), ~5 MB, yalnız arm64.
- Temiz kurulumda sistem dili ne olursa olsun **Türkçe Q** açık ve seçili; Rusça kurulu ama kapalı.
- Rakam satırı her zaman açık, klavye yüksekliği %82 (giriş alanı görünür kalır).
- **Emoji** ve **pano** düğmeleri araç çubuğunda hep görünür; mikrofon düğmesi yok.
- Kaydırarak yazma, emoji önerisi ve panoya dosya yazımı varsayılan kapalı; yazılan sözcükler yedeklenmez.
- HeliBoard'un hareket verisi toplama özelliği tamamen kaldırıldı (etkin ve arka planda toplama, inceleme/paylaşım ekranları, veritabanı tablosu).
- Sade ayarlar: gelişmiş, ikincil düzen, sözlük ve hata ayıklama ekranları yok; zaman damgası `dd-MM-yyyy HH:mm:ss`; araç çubuğunda yalnız pano sabit, emoji alt satırda.

Kurulum: `adb install -r M2YBoard_1.25.07.68.0.apk`, ardından `ime enable` / `ime set` komutları (yukarıda).
Lisans: GPL-3.0 (HeliBoard, OpenBoard, AOSP atıfları korunmuştur). BYD ile bağlantılı değildir.
