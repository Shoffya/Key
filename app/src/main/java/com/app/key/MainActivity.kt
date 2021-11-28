package com.app.key

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toast_custumization_error_character.*
import kotlinx.android.synthetic.main.toast_custumization_error_null.*


class MainActivity : AppCompatActivity() {

    lateinit var Character: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Character = findViewById(R.id.nCharacter)
        Character.transformationMethod = null

        val animDrawable = root_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(3)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val generatedPassword:Button = findViewById(R.id.gerarSenha)
        generatedPassword.setOnClickListener {
                view -> onButtonKey()
        }
    }

    fun onButtonKey(){
        if(validaEdit()){
            toastErrorNull()
        }else{
            if(Integer.parseInt(Character.text.toString()) in 6..100){
                val intent = Intent(this, SenhaGeradaActivity::class.java)
                intent.putExtra("caracter", Character.text.toString())

                startActivity(intent)
            }else{
                toastErrorCharacter()
            }
        }

    }

    private fun toastErrorNull(){
        val view = layoutInflater.inflate(R.layout.toast_custumization_error_null,container_error_null)

        val toast_error_null = Toast(this)
        toast_error_null.view = view
        toast_error_null.duration = Toast.LENGTH_LONG
        toast_error_null.show()
    }

    private fun toastErrorCharacter(){
        val view = layoutInflater.inflate(R.layout.toast_custumization_error_character,container_error_character)

        val toast_error_character = Toast(this)
        toast_error_character.view = view
        toast_error_character.duration = Toast.LENGTH_LONG
        toast_error_character.show()
    }

    private fun validaEdit():Boolean{
        var error = false

        if(Character.text.isEmpty()) {
            Character.text.isDigitsOnly()
            Character.error = "Digite tamanho de caracter!"
            error = true
        }
        return error
    }
}