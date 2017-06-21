package com.example.babarmustafa.qr;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity {
    private ZXingScannerView mScannerView;
    Button scanner ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanner = (Button) findViewById(R.id.QrScanner);
        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QrScanner(view);
            }});
    }
    public void QrScanner(View view){
       mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view<br />
        setContentView(mScannerView);
                mScannerView.setResultHandler(); // Register ourselves as a handler for scan results.<br />
        mScannerView.startCamera();         // Start camera<br />
    }
    public void handleResult(Result rawResult) {
    // Do something with the result here</p>

           // show the scanner result into dialog box.<br />
        Log.d("text",rawResult.getText());
        Toast.makeText(this, ""+rawResult.getText(), Toast.LENGTH_SHORT).show();
        Log.d("extra",rawResult.getBarcodeFormat().toString());
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Scan Result");
            builder.setMessage(rawResult.getText());
    AlertDialog alert1 = builder.create();
            alert1.show();
     // If you would like to resume scanning, call this method below:<br />
    // mScannerView.resumeCameraPreview(this);<br />
}
    public void onPause() {
            super.onPause();
            mScannerView.stopCamera();   // Stop camera on pause<br />
    }
        }

