# Android App 開發練習

大學期間修習**行動裝置程式設計**課程的練習內容，以 Java 撰寫，共 27 個 Android app。`CHx` 為課堂練習，`_hw` 為作業，`Mid_*`、`Final_*` 為期中與期末考題。

| 主題 | 練習內容 | App |
|---|---|---|
| CH2–3<br>基本元件 | TextView、EditText、顏色 | [變大變小](CH2_hw/)、[通訊錄](CH3/)、[變變變](CH3_5/)、[變變變 Ver.2](CH3_5_hw/) |
| CH4<br>事件處理 | 點擊、長按、觸控、震動 | [計數器](CH4/)、[開關燈](CH4_hw/)、[震動按摩器](CH4_5/)、[七彩動霓虹](CH4_5hw/) |
| CH5<br>選擇元件 | RadioButton、CheckBox、TextWatcher | [買票](CH5_1/)、[溫度換算](CH5_1_2/)、[買地瓜](CH5_1_hw/)、[文字 foodMenu](CH5_2/)、[圖文整合 foodMenu](CH5_2_hw/) |
| CH6<br>清單 | Spinner、ListView、Adapter | [電影訂票](CH6_1/)、[電費計算](CH6_2/)、[關東煮](CH6_3/)、[地區選擇](CH6_3_2/) |
| CH7<br>對話框 | AlertDialog、Snackbar、Date / TimePicker | [腦筋急轉彎](CH7_1/)、[畢業問卷調查](CH7_2/)、[時間選擇器](CH7_3/) |
| CH8<br>多頁面 | Intent、Activity 間傳遞資料 | [歡迎光臨長庚大學](CH8_1/)、[體重計算機](CH8_2/)、[記帳本](CH8_3/)、[備忘錄](CH8_4/) |
| 期中<br>期末 | 綜合以上 | 期中：[隨機數遊戲](Mid_1/)、[購物車](Mid_3/)；期末：[點飲料](Final_1/) |

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
