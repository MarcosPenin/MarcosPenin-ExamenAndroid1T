package Excepciones

class ContrasenaCorta() : RuntimeException() {

    override val message: String
        get() = "La contraseña debe tener más de ocho caracteres"

}