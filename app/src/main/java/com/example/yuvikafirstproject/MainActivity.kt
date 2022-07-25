package com.example.yuvikafirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged
import android.widget.Toast.makeText as toastMakeText

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etPassword: EditText
    lateinit var tvForgotPassword: TextView
    lateinit var btnLogin: Button
    lateinit var rgGender: RadioGroup
    lateinit var rbHe: RadioButton
    lateinit var rbShe: RadioButton
    lateinit var rbOther: RadioButton
    lateinit var etOtherName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassword)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)
        btnLogin = findViewById(R.id.btnLogin)
        etPassword.doOnTextChanged { text, _, _, _ ->
            if ((text?.length ?: 0) < 6) {
                etPassword.error = resources.getString(R.string.please_enter_password)
            } else {
                etPassword.error = null
            }
        }
        rbHe = findViewById(R.id.rbHe)
        rbShe = findViewById(R.id.rbShe)
        rbOther = findViewById(R.id.rbOther)
        rgGender = findViewById(R.id.rgGender)
        rgGender.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.rbOther -> {
                    toastMakeText(resources.getString(R.string.others), this, Toast.LENGTH_LONG)

                    etOtherName.visibility = View.VISIBLE
                }
                else -> {
                    etOtherName.visibility = View.INVISIBLE
                }
            }
        }

        rbOther.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                etOtherName.visibility = View.VISIBLE
            } else {
                etOtherName.visibility = View.INVISIBLE
            }
        }

        btnLogin.setOnClickListener {
            etName.text.clear()

            System.out.println("Clicked")
            var name = etName.text.toString()
            var password = etPassword.text.toString()

        }


    }
}




