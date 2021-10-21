
fun main(){
    val baraja = Baraja()
    println("Hay ${baraja.cartasDisponible()} cartas disponibles")

    baraja.siguienteCarta()
    baraja.darCartas(5)

    println("Hay ${baraja.cartasDisponible()} cartas disponibles")

    println("Cartas sacadas de momento")
    baraja.cartasMonton()

    baraja.barajar()
    val cartas:Array<Carta?>? = baraja.darCartas(5)
    println("Cartas sacadas despues de barajar")
    if (cartas != null) {
        for(carta in cartas){
            carta?.imprimir()
        }
    }

}