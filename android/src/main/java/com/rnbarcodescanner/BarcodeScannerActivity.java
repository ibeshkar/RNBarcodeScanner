package com.rnbarcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.react.ReactActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class BarcodeScannerActivity extends ReactActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private static final int _REQ_CODE = 1410;

    @Override
    public void onResume() {
        super.onResume();

        // Register ourselves as a handler for scan results.
        mScannerView.setResultHandler(this);

        // Start camera on resume
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();

        // Stop camera on pause
        mScannerView.stopCamera();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void handleResult(Result result) {

        // Get barcode data and return to request activity
        String data = result.getText();
        Intent intent = new Intent();
        intent.putExtra("data", data);
        setResult(_REQ_CODE, intent);
    }
}
