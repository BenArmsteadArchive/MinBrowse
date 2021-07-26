package com.benarmstead.minbrowse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = findViewById<WebView>(R.id.webView)
        view.webViewClient = WebViewClient()
        view.loadUrl("https://www.duckduckgo.com")
        val settings = view.settings
        settings.javaScriptEnabled = true
    }
}