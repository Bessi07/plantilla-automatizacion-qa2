package automatizacion;

public class TC001CondicionalesEnJava {

    public static void main(String[] args){

        //Declarar Variables
        String nombre = "Bessi";
        int edad = 15;
        boolean estudiante = false;

        //Mostrar variables en consola
        System.out.println( "=== DATOS DE VARIABLES ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Estudiante de este curso: " + estudiante);


        //Condicionales IF - ELSE
        System.out.println( "=== CONDICIONALES ===");

        //Ejemplo 1: Validar si es mayor de edad
        if (edad >= 18){
            System.out.println(nombre + " es mayor de edad");
        } else {
            System.out.println(nombre + " es menor de edad");
        }

        //Ejemplo 2: Validar si es estudiante de este curso
        if (estudiante){
            System.out.println(nombre + " si es estudiante de este curso");
        } else {
            System.out.println(nombre + " no es estudiante de este curso");
        }
        //Ejemplo Ciclo FOR
    System.out.println( "\n=== EJEMPLO CICLO FOR  ===");
        for (int i = 1; i <= 5; i++){
            System.out.println("Iteracion FOR numero: " + i);
        }
        //Ejemplo Ciclo WHILE
         System.out.println( "\n=== EJEMPLO CICLO WHILE ===");
        int contador = 1;
        while (contador <= 5){
            System.out.println("Iteracion WHILE numero: " + contador);
            contador++;
        }

           System.out.println( "\n=== FINALIZAN LOS EJEMPLOS DE JAVA ===");

    }
    
}
