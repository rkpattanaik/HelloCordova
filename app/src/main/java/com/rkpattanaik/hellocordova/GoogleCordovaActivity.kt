package com.rkpattanaik.hellocordova

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.apache.cordova.AllowListPlugin
import org.apache.cordova.CordovaInterfaceImpl
import org.apache.cordova.CordovaWebViewImpl
import org.apache.cordova.PluginEntry
import org.apache.cordova.engine.SystemWebView
import org.apache.cordova.engine.SystemWebViewEngine

class GoogleCordovaActivity : AppCompatActivity() {

    companion object {
        const val GOOGLE_URL = "https://google.com"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_cordova)

        val webView = findViewById<SystemWebView>(R.id.googleWebView)
        val parser = DynamicConfigXmlParser(R.xml.google_config).apply { parse(this@GoogleCordovaActivity) }
        val cordova = CordovaInterfaceImpl(this)
        val cordovaWebView = CordovaWebViewImpl(SystemWebViewEngine(webView))
        cordovaWebView.run {
            init(cordova, parser.pluginEntries, parser.preferences)
            pluginManager.addService(
                PluginEntry(AllowListPlugin.PLUGIN_NAME, AllowListPlugin(resources.getXml(R.xml.google_config)))
            )
            loadUrl(GOOGLE_URL)
        }
    }
}