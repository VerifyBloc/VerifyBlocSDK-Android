# VerifyBlocSDK-Android
## Configuration Overview

```kotlin
minSdkVersion = 21

targetSdkVersion = 31

android.useAndroidX=true

Kotlin = 1.3+
```

---

## How to Onboard

1. Contact support@verifybloc.com for VerifyBloc service details and retrieve your `partnerId`, `applicationId` and `privateKey`
2. Provide us with the following:
   1. Callback path
   2. KYC Flow
   3. Country list
   4. Contact email
   5. App logo or profile photo
3. With the first 2 steps finished, we'll provide you with VerifyBloc SDK(s) and Demo App(s)

---

## 集成方法

提示：以下说明及截图的开发环境为 Android Studio Dolphin

### Step 1. Create aar module

新建或打开一个 Android Project，切换到 Project 视图

![image](https://github.com/VerifyBloc/VerifyBlocSDK-Android/blob/master/image/image1.png)

导入SDK，鼠标右击 Project，选择 New, 在弹出列表选择 Directory

![image](https://github.com/VerifyBloc/VerifyBlocSDK-Android/blob/master/image/image2.png)

在弹出的 New Directory Dialog 中，填写 Directory Name，例如：mylib

![image](https://github.com/VerifyBloc/VerifyBlocSDK-Android/blob/master/image/image3.png)

### Step 2. Edit mylib

右击 mylib，在弹出列表中选择 New，然后选择 File

![image](https://github.com/VerifyBloc/VerifyBlocSDK-Android/blob/master/image/image4.png)

弹出的 New File Dialog 中填写 build.gradle

![image](https://github.com/VerifyBloc/VerifyBlocSDK-Android/blob/master/image/image5.png)

打开 build.gradle，输入以下内容

```groovy
configurations.maybeCreate("default")
artifacts.add("default", file('verify_bloc_0.0.1.aar'))
dependencies.add("default","com.google.android.flexbox:flexbox:3.0.0")
dependencies.add("default","androidx.appcompat:appcompat:1.0.0")
dependencies.add("default","androidx.constraintlayout:constraintlayout:1.1.3")
dependencies.add("default","com.google.android.material:material:1.2.0-alpha03")
dependencies.add("default","androidx.multidex:multidex:2.0.0")
dependencies.add("default","androidx.databinding:viewbinding:7.1.2")
dependencies.add("default","com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.8")
dependencies.add("default","com.github.bumptech.glide:glide:4.13.2")
dependencies.add("default","androidx.activity:activity-ktx:1.6.1")
dependencies.add("default","com.squareup.okhttp3:logging-interceptor:4.9.1")
dependencies.add("default","com.squareup.retrofit2:retrofit:2.9.0")
dependencies.add("default","com.squareup.retrofit2:converter-gson:2.9.0")
dependencies.add("default","com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
dependencies.add("default","com.blankj:utilcodex:1.31.0")
dependencies.add("default","com.google.mlkit:face-detection:16.1.5")

def camerax_version = "1.2.0-beta01"
dependencies.add("default","androidx.camera:camera-core:${camerax_version}")
dependencies.add("default","androidx.camera:camera-camera2:${camerax_version}")
dependencies.add("default","androidx.camera:camera-lifecycle:${camerax_version}")
dependencies.add("default","androidx.camera:camera-video:${camerax_version}")
dependencies.add("default","androidx.camera:camera-view:${camerax_version}")
dependencies.add("default","androidx.camera:camera-mlkit-vision:${camerax_version}")
dependencies.add("default","androidx.camera:camera-extensions:${camerax_version}")
```

---

把下载的 sdk 文件拷贝到 mylib 文件夹里，最后 mylib 的文件结构如图

![image](https://github.com/VerifyBloc/VerifyBlocSDK-Android/blob/master/image/image6.png)

#### Step 3. 项目中导入 aar 模块

打开 Project 目录下的 setting.gradle，在后面加上 include ':mylib'，mylib 是文件夹的名称。

![image](https://github.com/VerifyBloc/VerifyBlocSDK-Android/blob/master/image/image7.png)

#### Step 4. 在app module 中添加依赖 aar 包

打开 app module 下面的 build.gradle，在 dependencies 块中添加mylib module，如下图：

![image](https://github.com/VerifyBloc/VerifyBlocSDK-Android/blob/master/image/image8.png)

最后点击 Sync Now 同步下工程代码

---
## 方法介绍

所有 Export 的接口在 VerifyBlocManager 类里

### 页面风格及设计接口

**config(partnerId: String, appId: String, privateKey: String)**

功能描述：初始化用户信息

返回值：无

参数说明：

| 参数 | 类型 | 描述 |
| --- | --- | --- |
| partnerId | String | 申请成功后的 partnerId |
| appId | String | 申请成功后的 appId |
| privateKey | String | 申请成功后的 privateKey |

**updateStyle(style: VerifyBlocStyle)**

功能描述：更新风格

返回值：无

参数说明：

| 参数 | 类型 | 描述 |
| --- | --- | --- |
| style | VerifyBlocStyle | 风格枚举值 |

**updateThemeColor(color: Int)**

功能描述：更新主题颜色

返回值：无

参数说明：

| 参数 | 类型 | 描述 |
| --- | --- | --- |
| color | Int | 颜色值（不支持alpha通道） |

**updateButtonBackgroundColor(color: Int)**

功能描述：更新底部按钮背景颜色（纯色）

返回值：无

参数说明：

| 参数 | 类型 | 描述 |
| --- | --- | --- |
| color | Int | 颜色值（不支持alpha通道） |

**updateButtonBackgroundGradient(startColor : Int, endColor : Int)**

功能描述：更新底部按钮背景颜色（水平从左到右渐变）

返回值：无

参数说明：

| 参数 | 类型 | 描述 |
| --- | --- | --- |
| startColor | Int | 开始颜色值（不支持alpha通道） |
| endColor | Int | 结束颜色值（不支持alpha通道） |

**updateButtonTextColor(color: Int)**

功能描述：更新底部按钮文字颜色

返回值：无

参数说明：

| 参数 | 类型 | 描述 |
| --- | --- | --- |
| color | Int | 颜色值（不支持alpha通道） |

**updateButtonRoundRadius(roundRadius : Float)**

功能描述：更新底部按钮圆角

返回值：无

参数说明：

| 参数 | 类型 | 描述 |
| --- | --- | --- |
| roundRadius | Float | 圆角值 |

### 验证接口

**fun queryVerificationStatus(userId: String)**

功能描述：查询验证状态

返回值：VerifyStatus

参数说明：

| 参数 | 类型 | 描述 |
| --- | --- | --- |
| userId | Float | 用户的id |

**verify(activity: AppCompatActivity, userId: String)**

功能描述：开始验证

返回值：无

参数说明：

| 参数 | 类型 | 描述 |
| --- | --- | --- |
| activity | AppCompatActivity | 启动activity |
| userId | Float | 用户的id |

### 枚举介绍

**VerifyBlocStyle**

功能描述：页面风格定义

枚举值描述：

| 枚举名 | 描述 |
| --- | --- |
| LIGHT | Light mode (Default) |
| DARK | Dark mode |

**VerifyStatus**

功能描述：验证状态

枚举值描述：

| 枚举名 | 描述 |
| --- | --- |
| SUBMISSION_REQUESTED | 待提交 |
| PENDING | 待审核 |
| PROCESSING | 审核中 |
| APPROVED | 审核通过 |
| REJECTED | 审核不通过，且无法重新提交申请 |
| REQUIRE_ACTION | 申请可能存在问题，待审核 |
| RESUBMISSION_REQUESTED | 审核不通过，可以重新提交申请 |