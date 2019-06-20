import com.sun.tools.corba.se.idl.StringGen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {


    public static void main(String[] args){
        //CASOS DE PRUEBA
        //Dado un numero entero de 8 cifras, y un alfabeto, pasar el numero entero al equivalente en caracteres en el alfabeto (por ejemplo, a=1, b=2)
        /*SUPUESTO:
         El orden del alfabeto determina su valor numerico: alfabeto dado: A,B,C,D,E,F,G,1,2,4,5,6,7,A,D,G,H == A:0, B:1, C:2...etc
         ya que es por numeros, solo se reciben alfabetos de 10 letras. para definir los numeros del 0-9 */

        String[] alfabeto = {"A", "%", "~", "B", "&", "l", "^", "*", "M", "?"};

        //numero no entero
        translateTo( "11111.222", alfabeto ); //No es un numero entero

        //numero no entero
        translateTo( "11111AST", alfabeto ); //No es un numero entero

        //numero menor de 8 cifras
        translateTo( "123456", alfabeto ); //No es un numero entero de 8 cifras

        //numero mayor de 8 cifras
        translateTo( "112312342", alfabeto ); //No es un numero entero de 8 cifras

        //alfabeto de 1 letra
        String[] alfabeto1 = {"A"};
        translateTo( "11111111", alfabeto1 ); //El alfabeto no cuenta con suficientes numeros para realizar una conversión. deben ser 10. para definir digitos del 0-9.

        //Todos igual numero
        translateTo( "11111111", alfabeto ); //AAAAAAAA

        //Multiples numeros alfabeto normal
        translateTo( "12342243", alfabeto ); //B%%B~%A



    }

    private static void translateTo(String number, String[] alfabeto ) {
        if (alfabeto.length == 10) {
            int integerNumber;
            boolean flag = false;
            int length = number.length();
            for (int i = 0; i < length; i++) {
                if (number.charAt(i) == '.') {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("No es un numero entero");
                return;
            } else {
                try {
                    integerNumber = Integer.parseInt(number);
                    if (number.length() != 8) {
                        System.out.println("No es un numero entero de 8 cifras");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("No es un numero entero");
                    return;
                }
            }

            //validar si todos los digitos estan en el alfabeto
            List<String> listCharacters = new ArrayList<>();
            for (int i=0;i<number.length() - 1;i++) {
                listCharacters.add(alfabeto[number.indexOf(number.charAt(i))]);
            }

            Collections.reverse(listCharacters);
            System.out.println("Tu numero escrito en el formato del alfabeto es: ");
            listCharacters.stream().forEach(character -> System.out.print(character));
            System.out.println();
        } else {
            System.out.println("El alfabeto no cuenta con suficientes numeros para realizar una conversión. deben ser 10. para definir digitos del 0-9.");
        }
    }

}
