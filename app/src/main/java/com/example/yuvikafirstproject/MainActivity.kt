package com.example.yuvikafirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.*
import androidx.core.widget.doOnTextChanged
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
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
//        etName = findViewById(R.id.etName)
//        etPassword = findViewById(R.id.etPassword)
//        etOtherName = findViewById(R.id.etOtherName)
//        tvForgotPassword = findViewById(R.id.tvForgotPassword)
//        btnLogin = findViewById(R.id.btnLogin)
        rbHe = findViewById(R.id.rbHe)
        rbShe = findViewById(R.id.rbShe)
        rbOther = findViewById(R.id.rbOthers)
        rgGender = findViewById(R.id.rgGender)
        etPassword.doOnTextChanged { text, _, _, _ ->
            if ((text?.length ?: 0) < 6) {
                etPassword.error = resources.getString(R.string.please_enter_password)
            } else {
                etPassword.error = null
            }
        }
        rbHe = findViewById(R.id.rbHe)
        rbShe = findViewById(R.id.rbShe)
        rbOther = findViewById(R.id.rbOthers)
        rgGender = findViewById(R.id.rgGender)
        rgGender.setOnCheckedChangeListener() { RadioGroup, id ->
            when (id) {
                R.id.rbOthers -> {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.others),
                        Toast.LENGTH_LONG
                    ).show()
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
            btnLogin.setOnClickListener {
                etName.text.clear()
                System.out.println("Clicked")
                var name = etName.text.toString()
                var password = etPassword.text.toString()
                System.out.println("name $name")
                if(name.isNullOrEmpty()){
                    etName.error = resources.getString(R.string.please_enter_name)
                    etName.requestFocus()
                }else if(password.isNullOrEmpty()){
                    etPassword.error = resources.getString(R.string.please_enter_password)
                    etPassword.requestFocus()
                }else if(password.length<6){
                etPassword.error = resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
            }
                else{
                Toast.makeText(this, resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
                var intent = Intent(this, ForgotPasswrodActivity::class.java)
                startActivity(intent)
                finish()
            }
            }
        }



    }
    }








