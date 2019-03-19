package com.example.drawtutorial

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var percentValue=50

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        percentET.setText(percentValue.toString())
        percentET.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = s.toString().toIntOrNull()

                text?.run {
                    if(this==percentValue)
                        return
                    if (this in 0..100){
                        percentValue=this
                        circle_view.fillPercent = percentValue
                    }

                    else{
                        circle_view.fillPercent = percentValue
                        percentET.setText(percentValue.toString())
                        percentET.setSelection(percentET.length())
                    }

                    circle_view.invalidate()

                }

            }

        })
    }
}
