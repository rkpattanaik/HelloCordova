package com.rkpattanaik.hellocordova

import android.content.Context
import org.apache.cordova.ConfigXmlParser

class DynamicConfigXmlParser(private val configResId: Int): ConfigXmlParser() {

    override fun parse(context: Context) {
        val xmlResParser = context.resources.getXml(configResId)
        parse(xmlResParser)
    }
}