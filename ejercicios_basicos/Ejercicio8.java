/** Lee un número por teclado y comprueba que 
 *  este numero es mayor o igual que cero,
 *  si no lo es lo volverá a pedir (do while),
 *  después muestra ese número por consola.
 */
import java.util.Scanner;
public class Ejercicio8 {
  
    public static void main(String[] args) {
  
        /* Declaramos la varible ya que sino no podemos usarla
         * en el while por el tema de ámbito
         */
        int codigo;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Introduce un numero mayor que 0");
            codigo=sc.nextInt();
        }while(codigo<=0);
  
        System.out.println(codigo);
    }
}
