package com.example.lottonumgenerator

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_constellation.*
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    val lottoImageStartId = R.drawable.ball_01

    fun updateLottoBallImage(result: List<Int>){
        imageView8.setImageResource(lottoImageStartId + (result[0] - 1))
        imageView9.setImageResource(lottoImageStartId + (result[1] - 1))
        imageView10.setImageResource(lottoImageStartId + (result[2] - 1))
        imageView11.setImageResource(lottoImageStartId + (result[3] - 1))
        imageView12.setImageResource(lottoImageStartId + (result[4] - 1))
        imageView13.setImageResource(lottoImageStartId + (result[5] - 1))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntegerArrayListExtra("result")
        val name = intent.getStringExtra("name")
        val constellation = intent.getStringExtra("constellation")
        resultLabel.text = "랜덤으로 생성된\n로또번호입니다"
        if(!TextUtils.isEmpty(name)){
            resultLabel.text = "${name} 님의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또번호입니다"
        }
        if(!TextUtils.isEmpty(constellation)){
            resultLabel.text = "${constellation} 의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또 번호입니다"
                }
            result?.let {
                updateLottoBallImage(result.sortedBy { it })
            }

    }
}