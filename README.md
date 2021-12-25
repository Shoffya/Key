# Key Generator

### Informações:
***

O aplicativo cria senhas de forma aleatória com 6 a 100 caracteres, que incluem:

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

E se isso acontecer, retorna também uma outra mensagem através de uma função de toast personalizado:

        ```kotlin
        ...
            if(validationEdit()) {
                toastErrorNull()
            }
        ...
        ```

        private fun toastErrorNull(){
        val view = layoutInflater.inflate(R.layout.toast_customization_error_null,container_error_null)

        val toast_error_null = Toast(this)
        toast_error_null.view = view
        toast_error_null.duration = Toast.LENGTH_LONG
        toast_error_null.show()
    }

