/*
* MVVM 패턴 적용
* */

package com.example.chapter4.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.chapter4.R
import com.example.chapter4.databinding.ActivityMvvmBinding
import com.example.chapter4.mvvm.repository.ImageRepositoryImpl

class MvvmActivity : AppCompatActivity() {

    // ViewModel을 지켜보고 있는 변수
    private val viewModel: MvvmViewModel by viewModels {
        MvvmViewModel.MvvmViewModelFactory(ImageRepositoryImpl())
    }

    private lateinit var binding: ActivityMvvmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.lifecycleOwner = this // lifecycler가 필요함.
            it.view = this
            it.viewModel = viewModel // ViewModel과 연결
        }
    }

    fun loadImage() {
        viewModel.loadRandomImage()
    }
}