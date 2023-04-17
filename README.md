# FastCampusStudy-3

## 2023-04-04 ~ 2023-04-17

이미지 추출 앱(chapter04)
1. 구현기술
- Coil : 이미지를 가지고 오는 open api
2. 데이터 아키텍처를 공부하기 위한 앱
3. 몰랐던 것
- MVC 장단점
    - 장점: 
        - 구현이쉽고 단순
        - 개발기간 단축
        - Model과 View 분리
        - Model의 비종속성으로 재사용 가능
    - 단점:
        - Contorller에 많은 코드가 생김
        - 유지보수의 어려움
        - View와 Model의 결합도 상승
        - 테스트코드 작성의 어려움
- MVP 장단점
    - 장점:
        - View와 Model간의 의존성이 없음
        - UI와 비즈니스 로직 분리
        - Unit Test 수월
    - 단점:
        - View와 Presenter가 1:1 관계
        - View가 많아지면 Presenter도 많아짐
        - 기능이 추가 될수록 Presenter가 비대해짐
- MVVM 장단점
    - 장점:
        - View가 데이터를 실시간으로 관찰
        - 생명주기로 부터 안전
        - View와 ViewModel 결합도가 느슨
        - 모듈별로 분리하여 개발 가능
        - Unit Test 수월
    - 단점:
        - 다른 디자인 패턴에 비해 복잡
        - DataBinding, LiveData 등 다른 라이브러리를 필수적으로 학습
- MVI
    - Intent: 앱 내에서 발생하는 Action
    - SideEffects: 상태 변경이 필요 없는 API나 DB접근 등의 이벤트
    - 장점:
        - 하나의 상태만 관리하기 때문에 상태 충돌이 없음
        - 선순환 구조라 흐름을 이해하기 쉬움
        - 불변 객체 이기 때문에 스레드에 안전
    - 단점:
        - 다른 패턴에 비해 러닝커브가 높다
        - 작은 변경에도 Intent를 거쳐야 함
        - 보일러플레이트(최소한의 변경으로 여러곳에서 재사용되며, 반복적으로 비슷한 형태를 띄는 코드) 코드가 발생한다.



미디어 검색 앱(chapter5)
1. 구현
- openAPI사용
- Image, Video 검색리스트
- 시간 순으로 정렬하여 출력
- 즐겨찾기 기능 추가
- 중요 로직 테스트 코드 작성(작성되면 안 되는 것들을 작성하여 유자보수를 좋게 만들어줌.)
  2. 구현기술
- MVVM
- LiveData
- Retrofit
- RX
    - Debounce(데이터가 입력되고, 특정 시간동안 들어오지 않으면 발생하는 이벤트)
    - Zip(두 개의 결과를 하나로 합침)
- Mockitos(Test 코드 작성)
2. 몰랐던 것
- Unit Test 사용하는 방법
- Kakao API 사용 방법


쇼핑몰 앱(chapter6)
1. 구현기능
- DI 적용
    - Hilt
- List 공통화
- 여러 뷰타입의 Json을 동적으로 List에 표현
- Coroutine, Paging3 적용
2. 구현 기술
- MVVM
- Hilt
- Coroutine
- Flow
- Paging3
- JsonDeserializer
    - 리스트를 동적으로 가지고 오는데 핵심적인 역할
3. 몰랐던 것
- Hilt
    - Application (@HiltAndroidApp)
    - viewModel (@HiltViewModel)
    - Annotation
        - @Module : Hilt 모듈인지 여부를 판단
        - @Installin : Component 범위를 지정
        - @Binds : 인터페이스 삽입
        - @Provides : 인터페이스 삽입
        - @Qualifier : 동일한 유형에 대해 여러 결합 제공
        - @ApplicationContext : Application의 Context를 제공하는 한정자
- 코루틴 
    - 경량 스레드
    - 비동기적으로 실행되는 코드를 간소화하기 위해 Android에서 사용할 수 있는 동시 실행 설계 패턴
    - 구성요소
        - CoroutineContext: 코루틴이 실행될 Context
            - Dispatcher: 코루틴을 처리할 스레드를 Setting하고 할당하는 역할 
        - CoroutineScope: 코루틴을 제어할 수 있는 범위
        - Builder: 코루틴을 생성하는 메소드
- Flow
    - 여러 값을 순차적으로 내보낼 수 있는 유형
    - 생산자: 스트림에 추가되는 데이터 생산
    - 중개자: 스트림에 내보내는 각각의 값이나 스트림 자체를 수정
    - 소비자: 스트림의 값을 사용
    - Flow 생산
        - NewsApi 사용
    - 스트림 수정
        - 값을 소비하지 않고 데이터 소스를 수정할 수 있음
        - 값이 나중에 사용될 때까지 대기할 수 있음
    - Flow 수집
        - Collect 사용
        - 코루틴 내부에서만 collect 사용 가능
- Paging3
    - 데이터를 순차적으로 불러 올 수 있는 Jetpact 라이브러리
        - Repository
            - PagingSource
            - RemoteMediator
        - ViewModel
            - Pager
            - Flow<PagingData>
        - UI
            - PagingDataAdapter
    - 개발 시간 단축


Todo앱 (chapter7)
1. 구현 기능
	- Hilt 활용한 DI
	- Room Crud
	- Style 공통화 처리
1. 구현 기능
	- DI (Hilt)
	- Room
	- Style/Theme 적용 (공통화 시키기)
	- Coroutine
	- Flow
1. 몰랐던 것
	- ROOM
		- AAC(Android Architecture Components)로써 Android DB 에 데이터를 저장하는 ORM 라이브러리
	- Android Styling System
		- ViewAttributes
		- Styles
		- Default Style
		- Themes
		- TextAppearance


Blind 앱 (chapter8)
1. 구현 기능
	- DI
	- Room
	- Coroutine
	- Clean Architecture
	- 네트워크 ㅇ벗는 상황에서도 앱 리스트 노출
1. 구현 기술
	- MVVM
	- Hilt
	- Coroutine
	- Flow
	- Retrofit2
	- Room
	- Clean Architecture
1. 몰랐던 것
	- 클린아키텍처
		- 필요한 이유: A배달앱이 B배달앱과 통합될 때 A앱의 기능을 그대로 사용하고 UI만 바꿔달라고 했을 때.. 프레임워크와 드라이버와 인터페이스만 바꾸면 됨.
	- Presentation Layer: view 와 Presenter로 구성됨
	- Domain Layer: UseCase, Model
	- Data Layer: DataStore, Entity
