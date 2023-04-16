/*
* MVC 패턴 적용
* Activity 안에 View, Controller의 역할이 들어가 있음.
* */

package com.example.chapter4.mvc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter4.databinding.ActivityMvcBinding
import com.example.chapter4.mvc.provider.ImageProvider

class MvcActivity : AppCompatActivity(), ImageProvider.Callback{
    private lateinit var binding: ActivityMvcBinding

    private val model = ImageCountModel() // image count
    private val imageProvider = ImageProvider(this) // 가지고 온 이미지 공유

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }
    }

    fun loadImage() {
        imageProvider.getRandomImage()
    }

    // ImageProvider class 함수를 implement 해줌.
    override fun loadImage(url: String, color: String) {
        model.increase()
        with(binding) {
            imageView.run {
                setBackgroundColor(Color.parseColor(color))
            }
            imageCountTextView.text = "불러온 이미지 수 : ${model.count} "
        }
    }
}