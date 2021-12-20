package Excepciones

class ContrasenaNoCoincide() : RuntimeException() {

    override val message: String
        get() = "Las contraseñas deben coincidir"

}