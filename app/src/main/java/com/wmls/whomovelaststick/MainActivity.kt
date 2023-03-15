package com.wmls.whomovelaststick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wmls.whomovelaststick.databinding.ActivityMainBinding
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val imgSticks = listOf<Int>(R.drawable.put_sticks_empty,R.drawable.put_sticks_1, R.drawable.put_sticks_2,
        R.drawable.put_sticks_3,R.drawable.put_sticks_4,R.drawable.put_sticks_5,R.drawable.put_sticks_6,
        R.drawable.put_sticks_7,R.drawable.put_sticks_8,R.drawable.put_sticks_9,R.drawable.put_sticks_10,
        R.drawable.put_sticks_11,R.drawable.put_sticks_12)

    var valueOfSticks = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GlobalScope.async{ delay(3000); binding.textView.text = "!!!!!!!"}

        binding.imageView2.setOnClickListener { valueOfSticks += 1;redrawImgUser(); GlobalScope.async{ delay(3000); redrawImgComp()} }
        binding.imageView3.setOnClickListener { valueOfSticks += 2;redrawImgUser(); GlobalScope.async{ delay(3000); redrawImgComp()} }
        binding.imageView4.setOnClickListener { valueOfSticks += 3;redrawImgUser(); GlobalScope.async{ delay(3000); redrawImgComp()} }

    }
    fun redrawImgUser(){
        if (valueOfSticks>12) valueOfSticks = 12
        binding.imageView.setImageResource(imgSticks[valueOfSticks])
        binding.textView.text = "Computer Turn"
        if (valueOfSticks==12) binding.textView.text = "You Win!!!"
        if (valueOfSticks<12) valueOfSticks += (1..3).random()
    }

    fun redrawImgComp(){

        binding.textView.text = "Your Turn"
        if ((valueOfSticks>=12) && (binding.textView.text.toString() != "You Win!!!")) binding.textView.text = "Computer Win!!!"
        if (valueOfSticks>12) valueOfSticks = 12
        binding.imageView.setImageResource(imgSticks[valueOfSticks])


    }
}