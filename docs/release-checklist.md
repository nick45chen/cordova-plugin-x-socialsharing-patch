# Release Checklist

這份清單用於 `cordova-plugin-x-socialsharing-patch` 的發版流程，確保 GitHub Release 與 Cordova 引用都可正常運作。

## 1) 發版前確認

- [ ] 工作目錄乾淨：`git status` 無未提交變更。
- [ ] 已完成必要修正與測試。
- [ ] `package.json` 的 `version` 已更新為目標版本（例如 `6.0.5-patch.2`）。
- [ ] `plugin.xml` 的 `version` 與 `package.json` 一致。
- [ ] `README.md`（如有）已更新版本或說明。

## 2) 提交版本更新

```bash
git add package.json plugin.xml README.md
git commit -m "chore(release): v<version>"
```

## 3) 建立並推送 Tag

> 本 repo 已設定 GitHub Actions：推送 `v*` tag 會自動建立 GitHub Release。

```bash
git tag v<version>
git push origin <branch>
git push origin v<version>
```

範例：

```bash
git tag v6.0.5-patch.2
git push origin work
git push origin v6.0.5-patch.2
```

## 4) 驗證 GitHub Release

- [ ] 打開 Actions，確認 `Release plugin` workflow 執行成功。
- [ ] 打開 Releases 頁面，確認 `v<version>` 已建立。
- [ ] Release Notes 與安裝指令內容正確。

## 5) 驗證 Cordova 安裝

以新版本 tag 進行安裝測試：

```bash
cordova plugin add https://github.com/nick45chen/cordova-plugin-x-socialsharing-patch.git#v<version>
cordova prepare
```

如需 npm 安裝路徑，也可測：

```bash
cordova plugin add cordova-plugin-x-socialsharing-patch
cordova prepare
```

## 6) （可選）發布到 npm

如果本次要同步發布 npm：

```bash
npm publish
```

發布後確認：

- [ ] `npm view cordova-plugin-x-socialsharing-patch version` 顯示新版本。
- [ ] README 安裝指令可用。

---

## 快速版（最小步驟）

```bash
# 1) 更新版本
# package.json + plugin.xml

# 2) commit
git add package.json plugin.xml
git commit -m "chore(release): v<version>"

# 3) tag + push
git tag v<version>
git push origin <branch>
git push origin v<version>

# 4) 等待 GitHub Actions 自動建立 Release
```
