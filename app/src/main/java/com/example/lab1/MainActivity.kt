package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //可以發現這裡用R類別進行呼叫


        btn_mora.setOnClickListener{    //設置監聽器setOnClickListener 為btn_mora為猜拳鍵按下時
            if(ed_name.length()<1)   //判斷使用者是否輸入姓名  ed_name為 Edit name可輸入的標籤
            {
                tv_text.text="請輸入玩家姓名" //未輸入則顯示輸入玩家姓名
            }
            else{
                tv_name.text="名字\n${ed_name.text}"
                tv_mmora.text="我方出拳\n${if(btn_scissor.isChecked)"剪刀" else if(btn_stone.isChecked) "石頭" else "布"}"
                //利用isChecked來確認radiobutton是否被按下

                val computer= (Math.random()*3).toInt()  //*3指的是設置三個隨意數值0到2 (Math.random()*3).toInt()


                tv_cmora.text="電腦出拳\n" + "${if(computer==0) "剪刀" else if(computer==1) "石頭" else "布"}"

                /*like java
                * if(computer==0){System.out.println("剪刀")else if(computer==1){System.out.println("石頭")else{System.out.println("布")}}}*/
                when{
                    btn_scissor.isChecked && computer==2 ||
                            btn_stone.isChecked && computer==0 ||
                            btn_paper.isChecked && computer==1 ->{
                        tv_winner.text="勝利者\n${ed_name.text}"
                        tv_text.text="恭喜你獲勝了!!!"

                    }
                    btn_scissor.isChecked && computer==1 ||
                            btn_stone.isChecked && computer==2 ||
                            btn_paper.isChecked && computer==0 ->{
                        tv_winner.text="勝利者\n電腦"
                        tv_text.text="可惜 電腦贏了~"

                    }
                    else ->{
                        tv_winner.text="勝利者\n平手"
                        tv_text.text="平局，請再試一次"
                    }


                }
            }
        }


    }
}
