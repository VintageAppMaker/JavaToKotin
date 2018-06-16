package com.psw.javatokotin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJavaTest.setOnClickListener{
            var i = Intent(this@MainActivity, JavaActivity::class.java)
            startActivity(i)
        }

        btnKotlinTest.setOnClickListener {
            var i = Intent(this@MainActivity, KotlinActivity::class.java)
            startActivity(i)
        }
    }
}
