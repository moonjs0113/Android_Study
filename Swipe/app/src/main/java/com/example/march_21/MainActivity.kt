package com.example.march_21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Toast
import com.example.march_21.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private var posX: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        bindingRadioWidgets()
    }

    fun bindingRadioWidgets() {
        mainBinding.radioGroup.setOnCheckedChangeListener { radioGroup, checkedID ->
            when (checkedID) {
                mainBinding.radioButton.id -> mainBinding.imageView.setImageResource(R.drawable.image3)
                mainBinding.radioButton2.id -> mainBinding.imageView.setImageResource(R.drawable.image4)
                mainBinding.radioButton3.id -> mainBinding.imageView.setImageResource(R.drawable.image5)
            }
        }
    }

    fun swipeLeft(checkedRadioButtonId: Int) {
        when (checkedRadioButtonId) {
            mainBinding.radioButton.id -> mainBinding.radioGroup.check(mainBinding.radioButton3.id)
                else -> mainBinding.radioGroup.check(checkedRadioButtonId - 1)
        }
    }

    fun swipeRight(checkedRadioButtonId: Int) {
        when (checkedRadioButtonId) {
            mainBinding.radioButton3.id -> mainBinding.radioGroup.check(mainBinding.radioButton.id)
            else -> mainBinding.radioGroup.check(checkedRadioButtonId + 1)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                posX = event.rawX
            }
            MotionEvent.ACTION_UP -> {
                val checkedRadioButtonId = mainBinding.radioGroup.checkedRadioButtonId
                val distX: Float = posX - event.rawX
                if (distX > 0) {
                    swipeLeft(checkedRadioButtonId)
                } else if (distX < 0) {
                    swipeRight(checkedRadioButtonId)
                }
            }
        }
        return true
    }
}