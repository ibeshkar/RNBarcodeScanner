package com.rnbarcodescanner;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class BarcodeScanner extends ReactContextBaseJavaModule implements ActivityEventListener {

    private final ReactApplicationContext mReactContext;
    private static final int _REQ_CODE = 1410;
    private Promise mPromise;


    public BarcodeScanner(ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
        reactContext.addActivityEventListener(this);
    }

    @Override
    public String getName() {
        return "RNBarcodeScanner";
    }

    /**
     * Start barcode scan process
     */
    @ReactMethod
    public void scan(Promise promise) {
        mPromise = promise;
        Activity activity = getCurrentActivity();
        try {
             Intent intent = new Intent(activity, BarcodeScannerActivity.class);
             activity.startActivityForResult(intent, _REQ_CODE);
        } catch (Exception e) {
             mPromise.reject(e.getMessage());
             mPromise = null;
        }
    }

    @Override
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {

        if (mPromise == null || requestCode != _REQ_CODE || data == null)
            return;

        String barcodeData = data.getStringExtra("data");
        if (barcodeData != null)
            mPromise.resolve(barcodeData);
        else
            mPromise.reject("null");
    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        mReactContext.removeActivityEventListener(this);
    }

}
