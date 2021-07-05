package com.algebra.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_web )

        webView = findViewById( R.id.webView )
        webView.loadUrl( "https://www.dnevnik.hr" )
        webView.canGoBack()
        webView.settings.javaScriptEnabled = true
    }
}