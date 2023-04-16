// View와 Repository(Model에 속함)의 연결

package com.example.chapter4.mvp

import com.example.chapter4.mvp.model.ImageCountModel
import com.example.chapter4.mvp.repository.ImageRepository

class MvpPresenter(
    private val model: ImageCountModel,
    private val imageRepository: ImageRepository
    ) : MvpContractor.Presenter, ImageRepository.CallBack {

    private var view: MvpContractor.View? = null

    // MvpContractor.Presenter
    override fun attachView(view: MvpContractor.View) {
        this.view = view
    }

    override fun detechView() {
        view = null
    }

    override fun loadRandomImage() {
        imageRepository.getRandomImage(this)
    }

    // ImageRepository.CallBack
    override fun loadImage(url: String, color: String) {
        model.increase()
        view?.showImage(url, color)
        view?.showImageCountText(model.count)
    }
}