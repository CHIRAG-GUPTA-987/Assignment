package com.aditya.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.aditya.assignment.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Taking the Website Link from the user
        val websiteLink : String? = intent.getStringExtra("WebsiteLink")

        //This prevents WebView to open system default browser
        binding.webView.webViewClient = WebViewClient()

        //Loading Website in the webview
        binding.webView.loadUrl(websiteLink!!)
    }
}