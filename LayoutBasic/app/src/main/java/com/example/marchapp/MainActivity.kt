package com.example.marchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Toast
import com.example.marchapp.databinding.ActivityMainBinding
import kotlin.math.pow

// View는 UI Component
// 모든 View들의 부모 클래스
// id: 뷰의 식별자
// View Group은 Layout

// 이벤트 처리 방식
// 델리게이션 이벤트 모델
// 이벤트 소스(뷰객체) ---리스너---> 이벤트 핸들러(처리 내용을 가진 객체)

// Hierarchy 이벤트 모델
// 직접 터치 이벤트와 키 이벤트를 처리할 때 사용
// 이벤트에 대한 콜백 함수를 정의하면 됨

class MainActivity : AppCompatActivity() {
    //, View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
//        bindInit()
        imageInit() // -> 이거 viewBinding으로 바꾸는게 과제
//        init()
//        val basicButton = findViewById<Button>(R.id.button)
//        // 1
//        basicButton.setOnClickListener {
//            Toast.makeText(this, "Button Click", Toast.LENGTH_SHORT).show()
//        }
//
//        // 3-1
//        basicButton.setOnClickListener(ClickHandler())
    }

    fun imageInit() {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val imageView = findViewById<ImageView>(R.id.imageView2)
        radioGroup.setOnCheckedChangeListener { radioGroup, checkedID ->
            when (checkedID) {
                R.id.radioButton1 -> imageView.setImageResource(R.drawable.image0)
                R.id.radioButton2 -> imageView.setImageResource(R.drawable.image1)
                R.id.radioButton3 -> imageView.setImageResource(R.drawable.image2)
            }
        }
    }

    fun bindInit() {
        binding.button.setOnClickListener {
            val bmi =
                binding.weight.text.toString().toDouble() / (binding.height.text.toString()
                    .toDouble() / 100).pow(2)
            var resultString: String
            when {
                bmi >= 35 -> {
                    resultString = "고도 비만"
                    binding.imageView.setImageResource(R.drawable.baseline_sentiment_very_dissatisfied_24)
                }
                bmi >= 23 -> {
                    resultString = "과체중"
                    binding.imageView.setImageResource(R.drawable.baseline_sentiment_dissatisfied_24)
                }
                bmi >= 23 -> {
                    resultString = "정상"
                    binding.imageView.setImageResource(R.drawable.baseline_sentiment_satisfied_alt_24)
                }

                else -> {
                    resultString = "저체중"
                    binding.imageView.setImageResource(R.drawable.baseline_sentiment_satisfied_24)
                }
            }
            Toast.makeText(this, resultString, Toast.LENGTH_SHORT).show()
        }
    }

    fun init() {
        val button = findViewById<Button>(R.id.button)
        val weight = findViewById<EditText>(R.id.weight)
        val height = findViewById<EditText>(R.id.height)
        val imageView = findViewById<ImageView>(R.id.imageView)

        button.setOnClickListener {
            val bmi =
                weight.text.toString().toDouble() / (height.text.toString().toDouble() / 100).pow(2)
            var resultString: String
            when {
                bmi >= 35 -> {
                    resultString = "고도 비만"
                    imageView.setImageResource(R.drawable.baseline_sentiment_very_dissatisfied_24)
                }
                bmi >= 23 -> {
                    resultString = "과체중"
                    imageView.setImageResource(R.drawable.baseline_sentiment_dissatisfied_24)
                }
                bmi >= 23 -> {
                    resultString = "정상"
                    imageView.setImageResource(R.drawable.baseline_sentiment_satisfied_alt_24)
                }

                else -> {
                    resultString = "저체중"
                    imageView.setImageResource(R.drawable.baseline_sentiment_satisfied_24)
                }
            }
            Toast.makeText(this, resultString, Toast.LENGTH_SHORT).show()
        }
    }

    // 2
//    override fun onClick(p0: View?) {
//        when (p0?.id) {
//            R.id.button -> {
//                Toast.makeText(this, "Button Click", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

    // 4
//    fun clickHandler(v: View?): Unit {
//        Toast.makeText(this, "Button Click", Toast.LENGTH_SHORT).show()
//    }
    // android:onClick="fire"

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var posX: Float = 0.0f
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                println(event)
                posX = event.rawX
            }
            MotionEvent.ACTION_UP -> {
                println(event)
                val distX = posX - event.rawX
                if (distX > 0) {
                    Toast.makeText(this, "Left Touch", Toast.LENGTH_SHORT).show()
                } else if (distX < 0) {
                    Toast.makeText(this, "Right Touch", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return true
    }

//    var initTime: Long = 0
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        when (keyCode) {
//            KeyEvent.KEYCODE_BACK -> {
//                if ((System.currentTimeMillis() - initTime) > 3000) {
//                    Toast.makeText(this, "종료하려면 한번더 누르세요.", Toast.LENGTH_SHORT).show()
//                    initTime = System.currentTimeMillis()
//                } else {
//                    finish()
//                }
//                return true
//            }
//        }
//        return super.onKeyDown(keyCode, event)
//    }
}

// 3
class ClickHandler : View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button -> {
                Toast.makeText(p0.context, "Button Click", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

