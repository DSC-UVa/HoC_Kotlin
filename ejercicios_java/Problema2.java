
Spoiler Inside	SelectHide
// Carta

/**
 * Clase Carta
 */
public class Carta {
     
    //Atributos
    private int numero;
    private String palo;
     
    //Constantes
    public static final String[] PALOS={"ESPADAS", "OROS", "COPAS", "BASTOS"};
    public static final int LIMITE_CARTA_PALO=12;
 
    //Constructor
    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }
 
    @Override
    public String toString() {
        return "numero=" + numero + ", palo=" + palo;
    }
     
}
// Baraja


/**
 * Clase Baraja
 */
public class Baraja {
 
    //Atributos
    private Carta cartas[];
    private int posSiguienteCarta;
 
    //Cartas
    public static final int NUM_CARTAS = 40;
 
    public Baraja() {
        this.cartas = new Carta[NUM_CARTAS];
        this.posSiguienteCarta = 0;
        crearBaraja(); //Creamos la baraja
        barajar(); // barajamos la baraja
    }
 
    /**
     * Crea la baraja ordenada
     */
    private void crearBaraja() {
 
        String[] palos = Carta.PALOS;
 
        //Recorro los palos
        for (int i = 0; i < palos.length; i++) {
 
            //Recorro los numeros
            for (int j = 0; j < Carta.LIMITE_CARTA_PALO; j++) {
                //Las posiciones del 8 y del 9 son el 7 y el 8 (emepzamos en 8)
                if (!(j == 7 || j == 8)) {
                    if (j >= 9) {
                        //Solo para la sota, caballo y rey
                        cartas[((i * (Carta.LIMITE_CARTA_PALO - 2)) + (j - 2))] = new Carta(j + 1, palos[i]);
                    } else {
                        //Para los casos de 1 a 7
                        cartas[((i * (Carta.LIMITE_CARTA_PALO - 2)) + j)] = new Carta(j + 1, palos[i]);
                    }
 
                }
            }
 
        }
 
    }
 
    /**
     * Baraja todas las cartas
     */
    public void barajar() {
 
        int posAleatoria = 0;
        Carta c;
 
        //Recorro las cartas
        for (int i = 0; i < cartas.length; i++) {
 
            posAleatoria = Metodos.generaNumeroEnteroAleatorio(0, NUM_CARTAS - 1);
 
            //intercambio
            c = cartas[i];
            cartas[i] = cartas[posAleatoria];
            cartas[posAleatoria] = c;
 
        }
 
        //La posición vuelve al inicio
        this.posSiguienteCarta = 0;
 
    }
 
    /**
     * Devuelve la casta donde se encuentre "posSiguienteCarta"
     * @return carta del arreglo
     */
    public Carta siguienteCarta() {
 
        Carta c = null;
 
        if (posSiguienteCarta == NUM_CARTAS) {
            System.out.println("Ya no hay mas cartas, barajea de nuevo");
        } else {
            c = cartas[posSiguienteCarta++];
        }
 
        return c;
 
    }
 
    /**
     * Devuelve un numero de cartas. Controla si hay mas cartas de las que se piden 
     * @param numCartas
     * @return 
     */
    public Carta[] darCartas(int numCartas) {
 
        if (numCartas > NUM_CARTAS) {
            System.out.println("No se puede dar mas cartas de las que hay");
        } else if (cartasDisponible() < numCartas) {
            System.out.println("No hay suficientes cartas que mostrar");
        } else {
 
            Carta[] cartasDar = new Carta[numCartas];
 
            //recorro el array que acabo de crear para rellenarlo
            for (int i = 0; i < cartasDar.length; i++) {
                cartasDar[i] = siguienteCarta(); //uso el metodo anterior
            }
             
            //Lo devuelvo
            return cartasDar;
 
        }
 
        //solo en caso de error
        return null;
 
    }
 
    /**
     * Indica el numero de cartas que hay disponibles
     * @return 
     */
    public int cartasDisponible() {
        return NUM_CARTAS - posSiguienteCarta;
    }
 
    /**
     * Muestro las cartas que ya han salido
     */
    public void cartasMonton() {
 
        if (cartasDisponible() == NUM_CARTAS) {
            System.out.println("No se ha sacado ninguna carta");
        } else {
            //Recorro desde 0 a la posSiguienteCarta
            for (int i = 0; i < posSiguienteCarta; i++) {
                System.out.println(cartas[i]);
            }
        }
 
    }
 
    /**
     * Muestro las cartas que aun no han salido
     */
    public void mostrarBaraja() {
 
        if (cartasDisponible() == 0) {
            System.out.println("No hay cartas que mostrar");
        } else {
            for (int i = posSiguienteCarta; i < cartas.length; i++) {
                System.out.println(cartas[i]);
            }
        }
 
    }
 
}
// Métodos

/**
 * Clase Metodos, contiene métodos estaricos sueltos
 */
public class Metodos {
 
    public static int generaNumeroEnteroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }
 
}
// Main

public class Ejercicio_POO_DDR_05 {
 
    public static void main(String[] args) {
         
        //Creamos la baraja
        Baraja b = new Baraja();
         
        //Mostramos las cartas disponibles (40)
        System.out.println("Hay "+b.cartasDisponible()+" cartas disponibles");
        
        //Saco una carta
        b.siguienteCarta();
         
        //Saco 5 cartas
        b.darCartas(5);
         
        //Mostramos las cartas disponibles (34)
        System.out.println("Hay "+b.cartasDisponible()+" cartas disponibles");
        
        System.out.println("Cartas sacadas de momento");
         
        b.cartasMonton();
         
         
        //Barajamos de nuevo
        b.barajar();
        
        //Saco 5 cartas
        Carta[] c = b.darCartas(5);
         
        System.out.println("Cartas sacadas despues de barajar ");
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
         
    }
     
}