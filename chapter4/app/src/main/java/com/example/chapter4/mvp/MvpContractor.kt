// View 와 Present 연결을 위한 함수를 정의해줌.

package com.example.chapter4.mvp

interface MvpContractor {

    // 이미지를 보여주는 곳
    interface View {
        // 보여줌.
        fun showImage(url: String, color: String)
        // 갯수
        fun showImageCountText(count: Int)
    }

    //
    interface Presenter {
        // 초기화 할 부분에
        fun attachView(view: View)
        // Activity가 종료될 때
        fun detechView()
        // 이미지를 불러옴
        fun loadRandomImage()
    }

}