/**
 * Clase Espectador, lleva todo lo relativo a la información del espectador
 */
public class Espectador {
 
    /*Atributos*/
    private String nombre;
    private int edad;
    private double dinero;
 
    /*Constructores*/
    public Espectador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }
 
    /*Metodos*/
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public int getEdad() {
        return edad;
    }
 
    public void setEdad(int edad) {
        this.edad = edad;
    }
 
    public double getDinero() {
        return dinero;
    }
 
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
 
    /**
     * Pagamos la entrada del cine
     *
     * @param precio
     */
    public void pagar(double precio) {
        dinero -= precio;
    }
 
    /**
     * Indicamos si el espectador tiene edad para ver la pelicula (en el video
     * estaba en la clase pelicula tiene mas sentido que sea un metodo del
     * espectador)
     *
     * @param edadMinima
     * @return
     */
    public boolean tieneEdad(int edadMinima) {
        return edad >= edadMinima;
    }
 
    /**
     * Indicamos si el espectador tiene dinero (en el video estaba en la clase
     * cine tiene mas sentido que sea un metodo del espectador)
     *
     * @param precioEntrada
     * @return
     */
    public boolean tieneDinero(double precioEntrada) {
        return dinero >= precioEntrada;
    }
 
    @Override
    public String toString() {
        return "el nombre del espectador es " + nombre + " de " + edad + " años y con " + dinero + " euros en su bolsillo";
    }
 
}

// Clase Asiento

/**
 * Clase asiento, se usa para manejar toda la informacion relativa al asiento
 */
public class Asiento {
 
    /*Atributos*/
    private char letra;
    private int fila;
    private Espectador espectador; // informacion del espectador que esta sentado, null si es vacio
 
    /*Constructores*/
    public Asiento(char letra, int fila) {
        this.letra = letra;
        this.fila = fila;
        this.espectador = null; //al iniciar el asiento, no habrá nadie sentado
    }
 
    /*Metodos*/
    public char getLetra() {
        return letra;
    }
 
    public void setLetra(char letra) {
        this.letra = letra;
    }
 
    public int getFila() {
        return fila;
    }
 
    public void setFila(int fila) {
        this.fila = fila;
    }
 
    public Espectador getEspectador() {
        return espectador;
    }
 
    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }
 
    /**
     * Indica si el asiento esta ocupado
     *
     * @return
     */
    public boolean ocupado() {
        return espectador != null;
    }
 
    @Override
    public String toString() {
        if (ocupado()) {
            return "Asiento: " + fila + letra + " y " + espectador;
        }
 
        return "Asiento: " + fila + letra + " y este asiento está vacio ";
 
    }
 
}

// Clase Pelicula

/**
 * Clase Pelicula, lleva todo lo relacionado con la pelicula
 */
public class Pelicula {
 
    /*Atributos*/
    private String titulo;
    private int duracion;
    private int edadMinima;
    private String director;
 
    /*Constructor*/
    public Pelicula(String titulo, int duracion, int edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }
 
    /*Metodos*/
    public String getTitulo() {
        return titulo;
    }
 
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
 
    public int getDuracion() {
        return duracion;
    }
 
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
 
    public int getEdadMinima() {
        return edadMinima;
    }
 
    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }
 
    public String getDirector() {
        return director;
    }
 
    public void setDirector(String director) {
        this.director = director;
    }
 
    @Override
    public String toString() {
        return "'" + titulo + "' del director " + director + ", con una duracion de " + duracion + " minutos y la edad minima es de " + edadMinima + " años";
    }
 
}

// Clase Cine

/**
 * Clase Cine, lleva todo lo relativo al cine
 */
public class Cine {
 
    /*Atributos*/
    private Asiento asientos[][];
    private double precio;
    private Pelicula pelicula;
 
    /*Constructor*/
    public Cine(int filas, int columnas, double precio, Pelicula pelicula) {
 
        asientos = new Asiento[filas][columnas];
        this.precio = precio;
        this.pelicula = pelicula;
        rellenaButacas();
    }
 
    /*Metodos*/
    public Asiento[][] getAsientos() {
        return asientos;
    }
 
    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }
 
    public double getPrecio() {
        return precio;
    }
 
    public void setPrecio(double precio) {
        this.precio = precio;
    }
 
    public Pelicula getPelicula() {
        return pelicula;
    }
 
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
 
    /**
     * Rellena nuestros asientos, dandoles una fila y una letra
     */
    private void rellenaButacas() {
 
        int fila = asientos.length;
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[0].length; j++) {
                //Recuerda que los char se pueden sumar
                asientos[i][j] = new Asiento((char) ('A' + j), fila);
            }
            fila--; //Decremento la fila para actualizar la fila
        }
 
    }
 
    /**
     * Indicamos si hay sitio en el cine, cuando vemos una vacia salimos de la
     * función
     *
     * @return
     */
    public boolean haySitio() {
 
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[0].length; j++) {
 
                if (!asientos[i][j].ocupado()) {
                    return true;
                }
 
            }
        }
 
        return false;
    }
 
    /**
     * Indico si en una posicion concreta esta ocupada
     *
     * @param fila
     * @param letra
     * @return
     */
    public boolean haySitioButaca(int fila, char letra) {
        return getAsiento(fila, letra).ocupado();
    }
 
    /**
     * Indicamos si el espectador cumple lo necesario para entrar: - Tiene
     * dinero - Tiene edad El tema de si hay sitio, se controla en el main
     *
     * @param e
     * @return
     */
    public boolean sePuedeSentar(Espectador e) {
        return e.tieneDinero(precio) && e.tieneEdad(pelicula.getEdadMinima());
    }
 
    /**
     * Siento al espectador en un asiento
     *
     * @param fila
     * @param letra
     * @param e
     */
    public void sentar(int fila, char letra, Espectador e) {
        getAsiento(fila, letra).setEspectador(e);
    }
 
    /**
     * Devuelvo un asiento concreto por su fila y letra
     *
     * @param fila
     * @param letra
     * @return
     */
    public Asiento getAsiento(int fila, char letra) {
        return asientos[asientos.length - fila - 1][letra - 'A'];
    }
 
    /**
     * Numero de filas de nuestro cine
     *
     * @return
     */
    public int getFilas() {
        return asientos.length;
    }
 
    /**
     * Numero de columas de nuestro cine
     *
     * @return
     */
    public int getColumnas() {
        return asientos[0].length;
    }
 
    /**
     * Mostramos la información de nuestro cine (Tambien se puede hacer en un
     * toString pero hay que devolver un String)
     */
    public void mostrar() {
 
        System.out.println("Información cine");
        System.out.println("Pelicula reproducida: " + pelicula);
        System.out.println("Precio entrada: " + precio);
        System.out.println("");
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[0].length; j++) {
                System.out.println(asientos[i][j]);
            }
            System.out.println("");
        }
    }
 
}
// Clase Metodos

/**
 * Clase Metodos, contiene funciones útiles para nuestro programa
 */
public class Metodos {
 
    public static final String nombres[] = {"Fernando", "Laura", "Pepe", "Eufrasio"};
 
    public static int generaNumeroEnteroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }
 
}


// Clase Principal

import java.util.Scanner;
 
/**
 * Clase ejecutable
 */
public class Principal {
 
    public static void main(String[] args) {
 
        //Creo la pelicula
        Pelicula pelicula = new Pelicula("Mi vida", 90, 16, "DDR");
         
        // Pido datos (esto no se mostro en el video por falta de tiempo)
        // No valida nada al respecto de tamaños (siguiente version)
        Scanner sn = new Scanner(System.in);
         
        System.out.println("Introduce el numero de filas");
        int filas=sn.nextInt();
         
        System.out.println("Introduce el numero de columnas");
        int columnas=sn.nextInt();
         
        System.out.println("Introduce el precio de la entrada de cine");
        double precio=sn.nextDouble();
         
        //Creo el cine, necesito la pelicula para ello
        Cine cine = new Cine(filas, columnas, precio, pelicula);
 
        //Numero de espectadores que seran creados
        System.out.println("Introduce el numero de espectadores a crear");
        int numEspectadores = sn.nextInt();
 
        //Variables y objetos usados
        Espectador e;
        int fila;
        char letra;
 
        System.out.println("Espectadores generados: ");
        //Termino cuando no queden espectadores o no haya mas sitio en el cine
        for (int i = 0; i < numEspectadores &amp;&amp; cine.haySitio(); i++) {
 
            //Generamos un espectador
            e = new Espectador(
                    Metodos.nombres[Metodos.generaNumeroEnteroAleatorio(0, Metodos.nombres.length - 1)], //Nombre al azar
                    Metodos.generaNumeroEnteroAleatorio(10, 30), //Generamos una edad entre 10 y 30
                    Metodos.generaNumeroEnteroAleatorio(1, 10)); //Generamos el dinero entre 1 y 10 euros
 
            //Mostramos la informacion del espectador
            System.out.println(e);
             
            //Generamos una fila y letra
            //Si esta libre continua sino busca de nuevo
            do {
 
                fila = Metodos.generaNumeroEnteroAleatorio(0, cine.getFilas() - 1);
                letra = (char) Metodos.generaNumeroEnteroAleatorio('A', 'A' + (cine.getColumnas()-1));
 
            } while (cine.haySitioButaca(fila, letra));
 
            //Si el espectador cumple con las condiciones
            if (cine.sePuedeSentar(e)) {
                e.pagar(cine.getPrecio()); //El espectador paga el precio de la entrada
                cine.sentar(fila, letra, e); //El espectador se sienta
            }
 
        }
 
        System.out.println("");
        cine.mostrar(); //Mostramos la información del cine, tambien se puede usar un toString
         
        System.out.println("Fin");
 
    }
 
}
