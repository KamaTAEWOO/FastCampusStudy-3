/*
* MVP 패턴 적용
* Activity : Presenter <-> View 상호작용
* */

package com.example.chapter4.mvp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.chapter4.R
import com.example.chapter4.databinding.ActivityMvpBinding
import com.example.chapter4.mvp.model.ImageCountModel
import com.example.chapter4.mvp.repository.ImageRepositoryImpl

class MvpActivity : AppCompatActivity(), MvpContractor.View {

    private lateinit var binding: ActivityMvpBinding
    private lateinit var presenter: MvpContractor.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }

        presenter = MvpPresenter(ImageCountModel(), ImageRepositoryImpl())
        presenter.attachView(this) // Activity connect
    }

    override fun onDestroy() {
        presenter.detechView() // Presenter & View 연결 해제
        super.onDestroy()
    }

    fun loadImage() {
        presenter.loadRandomImage() // 버튼 클릭 시 호출
    }

    // MvpContractor.View override
    // loadImage() 호출 시
    override fun showImage(url: String, color: String) {
        binding.imageView.run {
            setBackgroundColor(Color.parseColor(color))
            load(url) {
                crossfade(300) // 이미지를 불러올 때 부드럽게 하기 위해 사용
                                           // 안 쓰면 끊김...
            }
        }
    }

    // MvpContractor.View override
    override fun showImageCountText(count: Int) {
        binding.imageCountTextView.text = "불러온 이미지 수: $count"
    }
}