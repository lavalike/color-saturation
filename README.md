# color-saturation
> 一行代码实现全局变灰，支持指定View

[![Platform](https://img.shields.io/badge/Platform-Android-00CC00.svg?style=flat)](https://www.android.com)
[![](https://jitpack.io/v/lavalike/color-saturation.svg)](https://jitpack.io/#lavalike/color-saturation)

### 依赖导入

项目根目录

``` gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

模块目录

``` gradle
dependencies {
	implementation 'com.github.lavalike:color-saturation:0.0.1'
}
```

### 属性说明

**饱和度范围**(0.0~1.0)
> SaturationScale.GRAY = 0
> SaturationScale.IDENTITY = 1

### 代码示例

**全局变灰**

Application#onCreate初始化

```java
ColorSaturation.init(SaturationScale.GRAY | SaturationScale.IDENTITY);
```

![](https://tva1.sinaimg.cn/large/007S8ZIlgy1gjvnd1fmbaj30u01o0t9n.jpg)

**指定View变灰**

```java
ColorSaturation.apply(View, SaturationScale.GRAY | SaturationScale.IDENTITY);
```

![](https://tva1.sinaimg.cn/large/007S8ZIlgy1gjvnd9sh59j30u01o0t9n.jpg)