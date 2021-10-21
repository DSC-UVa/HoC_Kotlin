import java.util.*

open class Baraja(){
    private val NUM_CARTAS = 40
    private val PALOS = arrayOf( "ESPADAS" ,"OROS", "COPAS", "BASTOS")
    private val LIMITE_CARTA_PALO = 12
    private var posSiguienteCarta: Int =0
    private var cartas= arrayOfNulls<Carta>(NUM_CARTAS)

    init {
        crearBaraja()
        barajar()
    }

    fun crearBaraja(){
        for (i in PALOS.indices){
            for(j in 0 until LIMITE_CARTA_PALO){
                if(!(j == 7 || j==8)){
                    if(j >=9){
                        // Solo para Sota, Caballo y Rey
                        cartas[((i * (LIMITE_CARTA_PALO-2)) + (j-2))] = Carta(j+1,PALOS[i])
                    }else {
                        //Para los casos de 1 a 7
                        cartas[((i * (LIMITE_CARTA_PALO - 2)) + j)] = Carta(j + 1, PALOS[i])
                    }
                }
            }
        }
    }

    fun barajar(){
        var posAleatoria:Int
        var carta:Carta
        val random= Random()

        for(i in cartas.indices){
            posAleatoria= random.nextInt(((NUM_CARTAS-1) -0) + 0)

            carta= cartas[i]!!
            cartas[i] = cartas[posAleatoria]
            cartas[posAleatoria]= carta
        }

        posSiguienteCarta = 0
    }

    fun siguienteCarta():Carta?{
        var carta: Carta? = null

        if (posSiguienteCarta == NUM_CARTAS) {
            println("Ya no hay mas cartas, barajea de nuevo")
        }else{
            carta = cartas[posSiguienteCarta++]!!
        }

        return carta
    }

    fun darCartas(numCartas:Int):Array<Carta?>?{


        when {
            numCartas>NUM_CARTAS -> println("No se puede dar mas cartas de las que hay")

            cartasDisponible()<numCartas -> println("No hay suficientes cartas que mostrar")

            else -> {
                val cartasDar = arrayOfNulls<Carta>(numCartas)

                for(i in cartasDar.indices)
                    cartasDar[i]= siguienteCarta()

                return cartasDar
            }
        }

        return null
    }

    fun cartasDisponible():Int{
        return NUM_CARTAS-posSiguienteCarta
    }


    fun cartasMonton(){
        if(cartasDisponible() == NUM_CARTAS)
            println("No se ha sacado ninguna carta")
        else{
            for(i in 0 until posSiguienteCarta){
                cartas[i]?.imprimir()
            }
        }
    }

    fun mostrarBaraja(){
        if(cartasDisponible() == NUM_CARTAS)
            println("No se ha sacado ninguna carta")
        else{
            for(i in posSiguienteCarta until cartas.size){
                println(cartas[i]?.imprimir())
            }
        }
    }


}