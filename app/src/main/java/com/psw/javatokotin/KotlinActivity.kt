package com.psw.javatokotin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        first_findViewByID()
        two_setOnClickListner()
        three_VariableTypeCasting()
        four_properties()
    }

    // 1. findViewByID 비교
    private fun first_findViewByID() {
        // 0. 변수선언(X) -> XML에 지정된 id가 변수명으로 존재한다.
        // 1. findViewById 필요없다.

        // 주의할 것은 import 할 때, XML의 위치이다.
        // 복사붙여넣기를 하다보면 가끔 다른 Activity로 연결될 경우가 있다.
        // 이 소스의 예: import kotlinx.android.synthetic.main.activity_kotlin.*

        // 변수가 이미 존재하기에 아래는 에러없음.
        btnOk

    }

    // 2. 람다식에 의한 코딩량 감소
    private fun two_setOnClickListner() {
        btnOk.setOnClickListener {
            // 람다식은 코딩량을 현격하게 줄여준다.
        }
    }

    // 3. 변수의 형변환
    private fun three_VariableTypeCasting() {
        // 한쪽 형이 확실하면 나머지 코드는 알아서 이해하고 캐스팅해주려고 한다.
        // (거의 완벽하다. 정확하지는 않지만 가끔 틀린 적도 있는 듯하다)
        val txt : TextView? = findViewById(R.id.txtMessage)
        val txt2 = findViewById(R.id.txtMessage) as TextView?
    }

    // 4. 프로퍼티 (Set / Get 구별)
    private fun four_properties() {
        // 코틀린은 C#처럼 프로퍼티를 설정할 수 있다.
        val p = Person()
        p.name = " Test "
        WriteLn(p.name!!)
    }


    inner class Person {
        var name: String? = null
            get() {return field + "입니다"}
            set(s : String? ){
                field = this.javaClass.toString() + ":" + s
            }
    }
}

/*
*  kotlin의 불편한 점
*
*  1. null 채크(immutable, mutable 에러)
*  변수를 ?형으로 선언하고 !!로 지정해주어야 java와 호환하기 쉽다
*
*  2. [기본적]으로 다른 파일이라도 internal 키워드를 사용하지않아도
*     같은 패키지에서 변수명, 함수명이나 클래스명을
*     중복해서 사용할 수 없다.
*
* */


