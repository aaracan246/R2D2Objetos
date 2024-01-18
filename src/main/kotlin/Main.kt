import javax.imageio.metadata.IIOInvalidTreeException

/**
 *POO - Robots - Parte 1:
 *
 * Crear una versión del programa realizado en la tarea ¿Dónde está R2D2?, pero ORIENTADO A OBJETOS.
 *
 * La clase Robot debe tener 4 propiedades: nombre, posX, posY y dir. También tendrá un comportamiento por medio de 3 métodos: mover(), mostrarPosicion() y obtenerDireccion().
 *
 * El método mover() debe recibir un array de elementos enteros y no retornará nada, ya que los cambios quedarán almacenados en las propiedades del mismo.
 *
 * El método obtenerDireccion() no recibe parámetros y retorna una cadena de caracteres con la dirección PositiveX, NegativeX, PositiveY o NegativeY.
 *
 * El método mostrarPosicion() debe mostrar por consola la posición y dirección. Ejemplo: "R2D2 está en (10, -5) PositiveX"
 *
 * Un objeto de la clase Robot debe inicializarse siempre en la posición (0, 0) y la dirección eje Y positivo (hacia arriba) cuando se instancia.
 *
 * En este programa, vamos a realizar los mismos movimientos, pero el robot comenzará cada movimiento en la posición final después de realizar el movimiento anterior.
 *
 * En el main debes crear un objeto de Robot (o una variable de tipo Robot) con el nombre "R2D2". El nombre de la variable que utilices para crearlo puede ser robot1.
 *
 * Cread los movimientos en un array de arrays y recorrerlos para realizar en cada iteración los movimientos del robot y mostrar la posición del mismo al finalizar cada uno.
 *
 * En cada iteración del bucle llamaremos a los métodos mover() y mostrarPosicion().
 *
 * Un ejemplo de una estructura que podéis utilizar para los movimientos sería la siguiente:
 * [
 *     [1, -5, 0, -9],
 *     [3, 3, 5, 6, 1, 0, 0, -7],
 *     [2, 1, 0, -1, 1, 1, -4],
 *     [],
 *     [3, 5]
 * ]
 *
 *
 */



class Robot(private val nombre: String){

    private var posX: Int = 0
    private var posY: Int = 0
    private var dir: Int = 0

    fun mover(movs: IntArray){

        //0 => POSITIVEY; 1 => NEGATIVEX; 2 => NEGATIVEY; 3 => POSITIVEX
        for (pasos in movs){
            when(this.dir){
                0 -> this.posY += pasos
                1 -> this.posX -= pasos
                2 -> this.posY -= pasos
                3 -> this.posX += pasos
            }
            if (this.dir == 3) this.dir = 0 else this.dir++
        }
    }

    fun mostrarPosicion(){

        println("${this.nombre} está en (${this.posX}, ${this.posY}) ${obtenerDireccion()}")
    }


    fun obtenerDireccion() = when(this.dir){
            0 -> "POSITIVEY"
            1 -> "NEGATIVEX"
            2 -> "NEGATIVEY"
            3 -> "POSITIVEX"
            else ->""
        }
    }


fun main() {

    val robot1 = Robot("R2D2")

    val movimientos = arrayOf(
        intArrayOf(1, -5, 0, -9),
        intArrayOf(3, 3, 5, 6, 1, 0, 0, -7),
        intArrayOf(2, 1, 0, -1, 1, 1, -4),
        intArrayOf(),
        intArrayOf(3, 5)
    )

    for (movimiento in movimientos){

        robot1.mover(movimiento)
        robot1.mostrarPosicion()
    }

}