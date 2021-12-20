package Excepciones

class ContrasenaAusente() : RuntimeException() {

    override val message: String
        get() = "Debe introducir una contraseña"

}