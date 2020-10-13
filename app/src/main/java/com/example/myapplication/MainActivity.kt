package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ans: String = "0"
        var cur: String = "0"
        var operator: String = ""

        val resultTextView : TextView = findViewById(R.id.result) as TextView

        fun numberBtnPressed(value: String){
            if (cur.length == 1 && cur == "0"){
                cur = value
                resultTextView.text = cur
            }
            else
                if(cur.length < 8){
                    cur += value
                    resultTextView.text = cur
                }
        }

        fun operatorBtnPressed(value: String) {
            Log.i("ans", ans)
            Log.i("cur", cur)
            Log.i("operator", operator)
            if (operator == "") {
                ans = cur
                cur = "0"
                operator = value
            }
            else {
                when(operator) {
                    "/" -> ans = (ans.toInt() / cur.toInt()).toString()
                    "+" -> ans = (ans.toInt() + cur.toInt()).toString()
                    "-" -> ans = (ans.toInt() - cur.toInt()).toString()
                    "*" -> ans = (ans.toInt() * cur.toInt()).toString()
                }
                resultTextView.text = ans
                cur = "0"
                operator = value
            }
        }

        findViewById<Button>(R.id.btn_ce).setOnClickListener{
            ans = "0"
            cur = "0"
            operator = ""
            resultTextView.text = cur
        }

        findViewById<Button>(R.id.btn_divide).setOnClickListener{
            operatorBtnPressed("/")
        }
        findViewById<Button>(R.id.btn_multiply).setOnClickListener{
            operatorBtnPressed("*")
        }
        findViewById<Button>(R.id.btn_minus).setOnClickListener{
            operatorBtnPressed("-")
        }
        findViewById<Button>(R.id.btn_plus).setOnClickListener{
            operatorBtnPressed("+")
        }
        findViewById<Button>(R.id.btn_equals).setOnClickListener{
            operatorBtnPressed("=")
        }

        findViewById<Button>(R.id.btn_c).setOnClickListener{
            cur = "0"
            resultTextView.text = cur
        }

        findViewById<Button>(R.id.btn_bs).setOnClickListener{
            if (cur.length == 1 )
                cur = "0"
            else
                cur = cur.substring(0, cur.length-1)

            resultTextView.text = cur
        }

        findViewById<Button>(R.id.btn_0).setOnClickListener{
            numberBtnPressed("0")
        }
        findViewById<Button>(R.id.btn_1).setOnClickListener{
            numberBtnPressed("1")
        }
        findViewById<Button>(R.id.btn_2).setOnClickListener{
            numberBtnPressed("2")
        }
        findViewById<Button>(R.id.btn_3).setOnClickListener{
            numberBtnPressed("3")
        }
        findViewById<Button>(R.id.btn_4).setOnClickListener{
            numberBtnPressed("4")
        }
        findViewById<Button>(R.id.btn_5).setOnClickListener{
            numberBtnPressed("5")
        }
        findViewById<Button>(R.id.btn_6).setOnClickListener{
            numberBtnPressed("6")
        }
        findViewById<Button>(R.id.btn_7).setOnClickListener{
            numberBtnPressed("7")
        }
        findViewById<Button>(R.id.btn_8).setOnClickListener{
            numberBtnPressed("8")
        }
        findViewById<Button>(R.id.btn_9).setOnClickListener{
            numberBtnPressed("9")
        }

    }
}