package com.example.omikuji

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.animation.doOnEnd
import com.google.android.gms.oss.licenses.OssLicensesActivity
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val license = findViewById<Button>(R.id.license)
        val image = findViewById<ImageView>(R.id.image)
        val result = arrayOf("大吉","中吉","小吉","吉","末吉","凶","大凶")
        val intent = Intent(this,ResultActivity::class.java) //結果画面のIntent
        findViewById<Button>(R.id.btn).setOnClickListener {

            val animatorList: MutableList<Animator> = ArrayList()
            animatorList.add(ObjectAnimator.ofFloat(image,"rotation",0f,150f).setDuration(1000)) //回転
            animatorList.add(ObjectAnimator.ofFloat(image,"translationY",0f,200f).setDuration(250)) //下
            animatorList.add(ObjectAnimator.ofFloat(image,"translationY",200f,0f).setDuration(500)) //上
            animatorList.add(ObjectAnimator.ofFloat(image,"translationY",0f,200f).setDuration(250)) //下
            animatorList.add(ObjectAnimator.ofFloat(image,"translationY",200f,0f).setDuration(500)) //上
            val set = AnimatorSet()
            set.playSequentially(animatorList)
            set.start()
            set.doOnEnd {
                val num = result.size - 1
                intent.putExtra("result",result[(0..num).random()])
                startActivity(intent)
                ObjectAnimator.ofFloat(image,"rotation",150f,360f).start()
            }

        }
        license.setOnClickListener {
            val intent = Intent(this,OssLicensesMenuActivity::class.java)
            intent.putExtra("title","ライセンス一覧")
            startActivity(intent)
        }
    }
}