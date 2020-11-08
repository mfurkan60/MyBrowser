package com.example.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnGo;
    WebView webview;
    EditText txtAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //acses to url adres
        txtAddress = findViewById(R.id.txtAddress);

        //accses to webview area
        webview = findViewById(R.id.WebView);
        webview.setWebViewClient(new WebViewClient()); //bunue ekledik

        if((getIntent()!= null) && (getIntent().getData()!= null)){
            getIntent().getData().toString();
            txtAddress.setText(getIntent().getData().toString());
            webview.loadUrl(getIntent().getData().toString());
        }

        //access to button
        btnGo =findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.loadUrl("http://"+ txtAddress.getText());
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menüyü bu aktiviyt içerisinde göstermek için
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}