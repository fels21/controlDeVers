
package calculadora;

import static calculadora.Dividir.divisio;
import static calculadora.Modul.modul;
import static calculadora.Multiplicacio.multiplicacio;
import static calculadora.Resta.resta;
import static calculadora.Sumar.suma;
import java.util.Scanner;
/**
 *
 * @author I.Ch.
 */
public class Calculadora {
    boolean  error=false;
    static final int MAX = 2147483647;
    static final int MIN = -2147483648;
    
    public static void main(String[] args) {
        Calculadora calc = new Calculadora("Versió 1.7");
    }
    
    public Calculadora(String x){
        System.out.println(x);
        Scanner sc = new Scanner(System.in);
        String cadena = "0";
        int part1;
        int part2;
        int resultat = 0;
        String[] parts = null;
        
        
        while(!cadena.equals("666")){ ///qualsevol condicio de sortida finalment es pot posar EOF
            cadena = sc.nextLine();
            control(cadena);
            
            if(!error){
                try{
                    if (cadena.contains("-")) {
                       parts = cadena.split("-");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       resultat=resta(part1,part2);
                    }
                    if (cadena.contains("+")) {
                       parts = cadena.split("\\+");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       resultat=suma(part1,part2);
                    }
                    if (cadena.contains("/")) {
                       parts = cadena.split("/");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       resultat=divisio(part1,part2);
                    }
                    if (cadena.contains("*")) {
                       parts = cadena.split("\\*");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       resultat=multiplicacio(part1,part2);
                    }
                    if (cadena.contains("%")) {
                       parts = cadena.split("%");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       resultat=modul(part1,part2);
                    }

                    System.out.println(resultat);
                }catch(NumberFormatException e){
                    System.out.println("Error");
                }
            }
            error = false;
        }
    }
    
    public void control(String x){
        if(x.startsWith("/") ||x.startsWith("+")||x.startsWith("*")||x.startsWith("%")||x.startsWith("-")){
            error=true;
            System.out.println("Error");
        }
        else if (!(x.contains("-"))&&!(x.contains("/"))&&!(x.contains("+"))&&!(x.contains("*"))&&!(x.contains("%"))){
            error=true;
            System.out.println("Error syntax");
        }
    }
    
    
    
}

 