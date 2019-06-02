# RNBarcodeScanner

 A package for scan all of barcode with device camera

# Overview

 This package provides barcode scanner for android device

## Installation

### < RN 0.47
```bash
npm install react-native-rnbarcodescannerutils@1.0.4 --save
```

### >= RN 0.47
```bash
npm install react-native-rnbarcodescannerutils --save
```

## Project setup and initialization


* In `android/settings.gradle`

```gradle
...
include ':react-native-rnbarcodescannerutils', ':app'
project(':react-native-rnbarcodescannerutils').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-rnbarcodescannerutils/android')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    compile "com.facebook.react:react-native:+"
    compile project(":react-native-rnbarcodescannerutils") // <--- add this
}

```

* Register Module (in MainApplication.java)

```java
import com.rnbarcodescanner.BarcodeScannerPackage;  // <--- import

public class MainActivity extends ReactActivity {
  ......

  @Override
  protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new BarcodeScannerPackage() // <--- Add this
      );
  }

  ......

}
```


## Usage

#### Import

```javascript
import RNScanner from "react-native-rnbarcodescannerutils";
```

#### Scan barcode

```javascript
RNScanner.scan().then(value => {
  console.log(value);
});
```
