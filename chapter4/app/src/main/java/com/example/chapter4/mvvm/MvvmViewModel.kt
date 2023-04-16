/*
* View는 ViewModel을 계속 확인하고 있고, ViewModel은 데이터가 바뀌면 View에 데이터를 전달해줌.
* */

package com.example.chapter4.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chapter4.mvvm.model.Image
import com.example.chapter4.mvvm.repository.ImageRepository
import io.reactivex.disposables.CompositeDisposable

class MvvmViewModel(private val imageRepository: ImageRepository) : ViewModel() {

    // LiveData : 실시간 데이터 관리
    // Layout이랑 연결해줌. (countLiveData, imageLiveData)
    private val _countLiveData = MutableLiveData<String>()
    val countLiveData: LiveData<String> by lazy { _countLiveData } // 호출될 때의 최종 값을 담음.

    private val _imageLiveData = MutableLiveData<Image>()
    val imageLiveData: LiveData<Image> by lazy { _imageLiveData } // 실제 이미지를 셋팅해주기 위한

    private var disposable: CompositeDisposable? = CompositeDisposable()
    private var imageCount = 0

    fun loadRandomImage() {
        disposable?.add(imageRepository.getRandomImage()
            .doOnSuccess {
                imageCount++
            }
            .subscribe { item ->
                _imageLiveData.value = item
                _countLiveData.value = "불러온 이미지 수 : $imageCount"
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }

    // View에서 ViewModel을 호출할 때 파라미터를 가지고 올 때 사용
    class MvvmViewModelFactory(private val imageRepository: ImageRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MvvmViewModel(imageRepository) as T
        }
    }
}