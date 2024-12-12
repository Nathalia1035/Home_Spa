package com.ldss.proyectosandroid.home_spa;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MapaActivity extends AppCompatActivity {

    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mapa);


        webView = (WebView) findViewById(R.id.mapa);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");



        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:(function() { " +
                        "document.getElementById('searchboxinput').addEventListener('change', function() {" +
                        "var address = this.value;" +
                        "Android.showAddress(address);" +
                        "});" +
                        "})()");
            }
        });

        webView.loadUrl("https://www.google.com/maps");
    }

    public class WebAppInterface {
        Context mContext;

        WebAppInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void showAddress(String address) {
            // Busca el EditText en el layout
            EditText editText = ((ReservaActivity) mContext).findViewById(R.id.txtDireccionReserva);
            // Establece la dirección en el EditText
            editText.setText(address);
        }
    }
}