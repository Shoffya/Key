# Key Generator

### Informações:
***

O aplicativo cria senhas de forma aleatória de 6 a 100 caracteres, que incluem:

* Números
* Letras
* Caracteres especiais

### Funcionamento:
***

A aplicação funciona da seguinte forma:

* Uma função analisa se o campo caracter esta vazio, pois é necessário que o usuário informe a quantidade de caracteres desejados e, caso estiver, retorna um alerta de campo obrigatório com uma mensagem:

        ```kotlin
        ...
        private fun validaEdit():Boolean{
            var error = false

            if(Character.text.isEmpty()) {
                Character.text.isDigitsOnly()
                Character.error = "Digite tamanho de caracter!"
                error = true
            }
            return error
        }
        ...
        ```

  * E se isso acontecer, retorna também uma outra mensagem através de uma função de toast personalizado:

        ```kotlin
        ...
            if(validationEdit()) {
                toastErrorNull()
            }
        ...
       
        ...
        private fun toastErrorNull(){
            val view = layoutInflater.inflate(R.layout.toast_customization_error_null,container_error_null)

            val toast_error_null = Toast(this)
            toast_error_null.view = view
            toast_error_null.duration = Toast.LENGTH_LONG
            toast_error_null.show()
        }
        ...
        ```

* Depois das dependencias citadas a cima, é verificado se a quantidade de caracteres desejada pelo usuário é de 6 a 100 e, caso for, esse valor é colocado em uma "chave" (que será usada mais a diante), e a outra tela (activity) é chamada. Caso a condição não seja verdadeira, é retornado uma mensagem através de outra função de toast personalizado:


        ```kotlin
        ...
            else{
                if(Integer.parseInt(Character.text. toString()) in 6..100){
                    val intent = Intent(this, SenhaGeradaActivity::class.java)
                    intent.putExtra("caracter", Character.text.toString())

                    startActivity(intent)
            }else{
                toastErrorCharacter()
            }
        }
        ...
       
        ...
        private fun toastErrorCharacter(){
            val view = layoutInflater.inflate(R.layout.toast_customization_error_character,container_error_character)

            val toast_error_character = Toast(this)
            toast_error_character.view = view
            toast_error_character.duration = Toast.LENGTH_LONG
            toast_error_character.show()
        }
        ...
        ```

* Na próxima activity, de acordo com a "chave" puxada da primeira activity, é gerada a senha através de uma função, e a mesma é mostrada em um campo text:



        ```kotlin
        ...
        val senha = intent.extras
        val senhaGerada = senha?.getString("caracter").toString().toInt()

        val k = makeKey(senhaGerada)

        key.text = ("$k")
        ...

        ...
        fun makeKey (n:Int): String {
            val allowed = ('!'..'~')
            var key = (1..n).map{
                allowed.random()
            }.joinToString("")

            return key
        }
        ```

* Essa senha é copiada através de uma função e, a mesma pode ser colada em qualquer outra plataforma como, por exemplo, uma página de cadastro que necessita de uma senha, e por fim, uma mensagem é retornada através de outra função de toast personalizado, mostrando que a senha foi copiada com sucesso:

        ´´´kotlin
        ...
        val copyPassword: Button = findViewById(R.id.Copia)
            copyPassword.setOnClickListener {
                onClickCopy(key.text)
            }
        
        ...

        ...
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

        ´´´

* Se caso a senha não for do agrado, o usuário pode retornar a primeira activity através do botão de voltar e realisar o processo novamente.

### Observações:
***

Em breve o app será lançado na Play Store para download gratuito.