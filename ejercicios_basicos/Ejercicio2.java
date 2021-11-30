/* Declara 2 variables numéricas (con el valor que desees), 
   he indica cual es mayor de los dos. Si son iguales indicarlo también.
   Ves cambiando los valores para comprobar que funciona.*/

public class Ejercicio2 {
    public static void main(String[] args) {
 
        //Declaramos las variables
        int num1=30;
        int num2=15;
 
        //Hacemos la comprobación
        if (num1>=num2){
            //If anidado
            if(num1==num2){
                System.out.println("Los numeros "+num1+" y "+num2+" son iguales");
            }else{
                System.out.println("El número "+num1+" es mayor que el número "+num2);
            }
        }else{
            System.out.println("El número "+num2+" es mayor que el número "+num1);
        }
    }
}
