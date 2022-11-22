package com.rkpattanaik.hellocordova

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnGoogle).setOnClickListener {
            startActivity(Intent(this, GoogleCordovaActivity::class.java))
        }

        findViewById<Button>(R.id.btnCpb).setOnClickListener {
            startActivity(Intent(this, CpbCordovaActivity::class.java))
        }
    }
}