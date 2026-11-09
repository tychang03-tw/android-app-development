# Android App 開發練習

大學期間修習**行動裝置程式設計**課程的練習內容，以 Java 撰寫，共 27 個 Android app。`CHx` 為課堂練習，`_hw` 為作業，`Mid_*`、`Final_*` 為期中與期末考題。

| 資料夾 | App | 練習重點 |
|---|---|---|
| [`CH2_hw`](CH2_hw/) | 變大變小 | `EditText`、`setTextSize()`、`android:onClick` |
| [`CH3`](CH3/) | 通訊錄 | `EditText` 讀取輸入、字串比對 |
| [`CH3_5`](CH3_5/) | 變變變 | `Random`、`Color.rgb()` |
| [`CH3_5_hw`](CH3_5_hw/) | 變變變 Ver.2 | `EditText` 輸入 RGB、`setBackgroundColor()` |
| [`CH4`](CH4/) | 計數器 | `OnClickListener`、`OnLongClickListener`（匿名類別） |
| [`CH4_hw`](CH4_hw/) | 開關燈 | Activity 實作 Listener 介面，用 `getId()` 分辨按鈕 |
| [`CH4_5`](CH4_5/) | 震動按摩器 | `OnTouchListener`、`Vibrator` |
| [`CH4_5hw`](CH4_5hw/) | 七彩動霓虹 | `OnTouchListener`（`ACTION_MOVE`）、`Vibrator`、隨機變色 |
| [`CH5_1`](CH5_1/) | 買票 | `RadioGroup`、`RadioButton` |
| [`CH5_1_2`](CH5_1_2/) | 溫度換算 | `RadioGroup.OnCheckedChangeListener`、`TextWatcher` 即時計算 |
| [`CH5_1_hw`](CH5_1_hw/) | 買地瓜 | 兩組 `RadioGroup`、`TextWatcher` |
| [`CH5_2`](CH5_2/) | 文字 foodMenu | `CheckBox`、`isChecked()` |
| [`CH5_2_hw`](CH5_2_hw/) | 圖文整合 foodMenu | `CheckBox.OnCheckedChangeListener`、`ImageView`、`setVisibility()` |
| [`CH6_1`](CH6_1/) | 電影訂票 | `Spinner`、`string-array` |
| [`CH6_2`](CH6_2/) | 電費計算 | `Spinner.OnItemSelectedListener`、`TextWatcher` |
| [`CH6_3`](CH6_3/) | 關東煮 | `ListView`、`OnItemClickListener` |
| [`CH6_3_2`](CH6_3_2/) | 地區選擇 | `ArrayAdapter`、兩個 `Spinner` 連動 |
| [`CH7_1`](CH7_1/) | 腦筋急轉彎 | `ListView`、`ArrayAdapter`、`Snackbar` |
| [`CH7_2`](CH7_2/) | 畢業問卷調查 | `AlertDialog`、`ImageView` |
| [`CH7_3`](CH7_3/) | 時間選擇器 | `DatePickerDialog`、`TimePickerDialog` |
| [`CH8_1`](CH8_1/) | 歡迎光臨長庚大學 | `Intent` 切換多個 Activity |
| [`CH8_2`](CH8_2/) | 體重計算機 | `Intent.putExtra()` 傳遞資料 |
| [`CH8_3`](CH8_3/) | 記帳本 | `startActivityForResult()`、`setResult()`、`DatePickerDialog` |
| [`CH8_4`](CH8_4/) | 備忘錄 | `ListView`、`startActivityForResult()`、`Toast` |
| [`Mid_1`](Mid_1/) | 期中：隨機數遊戲 | `CheckBox` 勾選上限、`RadioGroup`、`TextWatcher`、`Random` |
| [`Mid_3`](Mid_3/) | 期中：購物車 | `CheckBox`、`RadioGroup` 幣別換算、`setVisibility()` |
| [`Final_1`](Final_1/) | 期末：點飲料 | `Spinner` 連動、`AlertDialog`、`startActivityForResult()` |

## 環境需求

- Android Studio（Android Gradle Plugin 8.8.0、Gradle 8.10.2）
- JDK 11 以上
- compileSdk / targetSdk 35，minSdk 24（Android 7.0 以上）

## 執行方式

- 每個資料夾都是獨立的 Android Studio 專案。請用 Android Studio 的 **File → Open** 開啟**單一資料夾**，例如 `CH8_4/`，不要開啟最外層。
- 等待 Gradle Sync 完成後，選擇模擬器或實體手機，按 ▶ Run 即可。
- `CH4_5`、`CH4_5hw` 會用到震動，需要在實體手機上才感受得到。

## 作者

- 張茲逸｜中興大學 電機工程研究所
