package com.example.yuvikafirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        System.out.println("on start is called")

    }
    fun onresume()
{
    super.onResume()
    System.out.println("on resume is called")
}

    override fun onPause() {
        super.onPause()
 System.out.println("on pause is called")
    }

    override fun onStop() {
        super.onStop()
System.out.println("on stop is called")
    }

    override fun onDestroy() {
        super.onDestroy()
 System.out.println("on destroy is called")
    }

}
