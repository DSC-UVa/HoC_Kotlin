// Revolver

public class Revolver {
 
    //Atributos
    private int posicionBalaActual;
    private int posicionBala;
 
    //Constructor
    public Revolver() {
        posicionBalaActual = Metodos.generaNumeroAleatorio(1, 6);
        posicionBala = Metodos.generaNumeroAleatorio(1, 6);
    }
 
    //Metodos
     
    //Dispara el revolver
    public boolean disparar() {
 
        boolean exito = false;
 
        if (posicionBalaActual == posicionBala) {
            exito = true; //Alguien va a morir...
        }
 
        siguienteBala();
 
        return exito;
 
    }
 
    //Cambia a la siguiente posicion
    public void siguienteBala() {
 
        if (posicionBalaActual == 6) {
            posicionBalaActual = 1; //posicion incial
        } else {
            posicionBalaActual++;
        }
 
    }
 
    public String toString() {
        return "Posicion Bala Actual: " + posicionBalaActual + ", Posicion bala: " + posicionBala;
    }
 
}
// Jugador


public class Jugador {
 
    //Atributos
    private int id;
    private String nombre;
    private boolean vivo;
 
    //Contructor
    public Jugador(int id) {
        this.id = id;
        this.nombre = "Jugador " + id;
        this.vivo = true;
    }
 
    //Propiedades
     
    /**
     * El jugador dispara el revolver
     * @param r 
     */
    public void disparar(Revolver r) {
 
        System.out.println("El " + nombre + " se apunta con la pistola");
 
        //El jugador se pone el revolver y...
        if (r.disparar()) {
            this.vivo = false; //muere
            System.out.println("El " + nombre + " ha muerto...");
        } else {
            System.out.println("El " + nombre + " se ha librado..."); //No muere
        }
 
    }
 
    public boolean isVivo() {
        return vivo;
    }
 
}
// Metodos


/**
 * Genera aleatorio
 */
public class Metodos {
 
    /**
     * Genera un numero aleatorio entre dos numeros
     * @param minimo
     * @param maximo
     * @return 
     */
    public static int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }
 
}
// Juego

/**
 * Crear el juego
 */
public class Juego {
 
    //atributos
    private Jugador[] jugadores;
    private Revolver revolver;
 
    //Constructor
    public Juego(int numJugadores) {
 
        jugadores = new Jugador[comprobarJugadores(numJugadores)];
 
        crearJugadores();
 
        revolver = new Revolver();
 
    }
 
    //Comprueba que el numero de jugadores esta en el rango correcto
    private int comprobarJugadores(int numJugadores) {
 
        //Sino esta en el rango correcto se pone a 6
        if (!(numJugadores >= 1 && numJugadores <= 6)) {
            numJugadores = 6;
        }
 
        return numJugadores;
    }
 
    //Crea los jugadores
    private void crearJugadores() {
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new Jugador(i + 1);
        }
    }
 
    //indica si el juego acaba o no
    public boolean finJuego() {
 
        for (int i = 0; i < jugadores.length; i++) {
            if (!jugadores[i].isVivo()) {
                //Acabo el juego
                return true;
            }
        }
        return false; //No termina el juego
    }
 
    //Realiza una ronda (si muere algun jugador todos participan igualmente)
    public void ronda() {
 
        for (int i = 0; i < jugadores.length; i++) {
            //El jugador se dispara
            jugadores[i].disparar(revolver);
        }
 
    }
     
    //Realiza una ronda (si muere algun jugador, los siguientes no participan)
    public void rondaV2() {
 
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i].disparar(revolver);
             
            //Si muere, terminamos
            if(!jugadores[i].isVivo()){
                return;
            }
        }
 
    }
 
}
// Main

public class Ejercicio_POO_DDR_07 {
 
    public static void main(String[] args) {
         
        Juego juego = new Juego(2);
         
        while( !juego.finJuego() ){
            juego.ronda();            
            //juego.rondaV2();
        }
         
        System.out.println("El juego ha terminado");
         
    }
     
}
