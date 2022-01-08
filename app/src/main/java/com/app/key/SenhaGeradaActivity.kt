package com.app.key

import android.content.ClipData
import android.content.*
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_senha_gerada.*
import kotlinx.android.synthetic.main.toast_customization_copy.*

class SenhaGeradaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_senha_gerada)

        val actionBar = supportActionBar

        actionBar!!.title = "Voltar"
        actionBar.setDefaultDisplayHomeAsUpEnabled(true)

        val animDrawable = root_layout_password.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(3)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val senha = intent.extras
        val senhaGerada = senha?.getString("caracter").toString().toInt()

        val k = makeKey(senhaGerada)

        key.text = ("\n $k")

        val copyPassword: Button = findViewById(R.id.Copia)
        copyPassword.setOnClickListener {
            onClickCopy(k)
        }
    }

    fun onClickCopy(text: CharSequence){
        val clipboard =  getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip: ClipData = ClipData.newPlainText("Copiar Senha",text)
        clipboard.setPrimaryClip(clip)

        toastCopySuccess()
    }

    private fun toastCopySuccess(){
        val view = layoutInflater.inflate(R.layout.toast_customization_copy,container_copy_success)

        val toast_Success = Toast(this)
        toast_Success.view = view
        toast_Success.duration = Toast.LENGTH_LONG
        toast_Success.show()
    }
    fun makeKey (n:Int): String {
        val allowed = ('!'..'~')
        var key = (1..n).map{
            allowed.random()
        }.joinToString("")

        return key
    }

}