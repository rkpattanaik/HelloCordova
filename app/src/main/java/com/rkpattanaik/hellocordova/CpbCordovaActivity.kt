package com.rkpattanaik.hellocordova

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.apache.cordova.*
import org.apache.cordova.AllowListPlugin
import org.apache.cordova.engine.SystemWebView
import org.apache.cordova.engine.SystemWebViewEngine

class CpbCordovaActivity : AppCompatActivity() {

    companion object {
        private const val CPB_URL = "https://privatebank.citibank.com"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cpb_cordova)

        val webView = findViewById<SystemWebView>(R.id.cpbWebView)
        val parser = DynamicConfigXmlParser(R.xml.cpb_config).apply { parse(this@CpbCordovaActivity) }
        val cordova = CordovaInterfaceImpl(this)
        val cordovaWebView = CordovaWebViewImpl(SystemWebViewEngine(webView))
        cordovaWebView.run {
            init(cordova, parser.pluginEntries, parser.preferences)
            pluginManager.addService(
                PluginEntry(AllowListPlugin.PLUGIN_NAME, AllowListPlugin(resources.getXml(R.xml.cpb_config)))
            )
            loadUrl(CPB_URL)
        }
    }
}