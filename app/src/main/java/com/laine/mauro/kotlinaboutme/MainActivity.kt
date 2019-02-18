package com.laine.mauro.kotlinaboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.laine.mauro.kotlinaboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val myName:MyName = MyName("Mauricio Laine")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    fun addNickname(view: View) {
        binding.apply {
            invalidateAll()
            view.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
            nicknameText.text = nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
        }
        //hide keyword
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
