package com.example.omikuji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val view = findViewById<ImageView>(R.id.resultview)
        val show = intent.getStringExtra("result")
        when(show){
            "大吉" -> view.setImageResource(R.drawable.greatgoodfortune)
            "中吉" -> view.setImageResource(R.drawable.moderatelygoodfortune)
            "小吉" -> view.setImageResource(R.drawable.limitedgoodfortune)
            "吉" -> view.setImageResource(R.drawable.fortune)
            "末吉" -> view.setImageResource(R.drawable.goodfortuneintheend)
            "凶" -> view.setImageResource(R.drawable.misfortune)
            "大凶" -> view.setImageResource(R.drawable.bigbadmisfortune)
            else -> Toast.makeText(this,"エラー",Toast.LENGTH_LONG).show()
        }
        Log.d("結果", show.toString())

        findViewById<Button>(R.id.button).setOnClickListener {
            finish()
        }
    }
}