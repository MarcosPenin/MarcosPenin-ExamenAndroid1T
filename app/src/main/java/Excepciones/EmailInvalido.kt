package Excepciones

class EmailInvalido() : RuntimeException() {

    override val message: String
        get() = "Debe introducir un email válido"

}