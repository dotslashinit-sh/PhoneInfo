package dev.dot.phoneinfo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.content.ComponentName
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val launchBtn: Button = findViewById(R.id.launchBtn)
        launchBtn.setOnClickListener(onLaunchBtnClick)
    }

    val onLaunchBtnClick = View.OnClickListener {
        val radioInfoIntent = Intent().setComponent(
            ComponentName("com.android.phone", "com.android.phone.settings.RadioInfo")
        )
        try {
            startActivity(radioInfoIntent)
        } catch(err: Exception) {
            Toast.makeText(this, err.message, Toast.LENGTH_LONG).show()
        }
    }
}