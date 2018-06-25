package com.psw.javatokotin

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
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
        five_highfunction("[네]를 눌러야 호출됩니다", { WriteLn("[네]를 눌렀습니다")})
        six_newFunction()
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

    // 5. 고차함수(함수를 매개변수로 받는 함수)
    // 고차함수를 사용하면 람다식을 이용하여
    // 자바보다 편리한 이벤트핸들러를 구현할 수 있다.
    private fun five_highfunction(s : String,  pFunc : () -> Unit){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("확인")
        builder.setMessage(s)
        builder.setPositiveButton("네", DialogInterface.OnClickListener { dialog, which ->
            pFunc()
        })

        builder.setNegativeButton("아니오", DialogInterface.OnClickListener { dialog, which ->

        })

        val alert = builder.create()
        alert.show()
    }

    // 6. 함수형언어의 장점과 단점은 아직은 평가못하겠다.
    // 단지, 쓰잘데없는 지역변수를 선언하지 않고 처리할 수 있다는 점은 매력적이다.
    // 그것을 위해 코틀린에서는 let, apply, .. 등이 자주사용된다.
    private fun six_newFunction() {
        ( findViewById<View>(R.id.btnOk) as Button ).apply{
            text = "이젠 누르면 반응합니다"
            setOnClickListener {
                inlineFunc().let{
                    WriteLn(" inlineFunc()의 결과는 " + it + "입니다")
                }
            }
        }
    }

    // six_newFunction를 위한 인라인함수
    internal fun inlineFunc(): Int {
        return 3
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


