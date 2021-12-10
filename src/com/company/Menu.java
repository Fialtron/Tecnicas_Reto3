package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    boolean exit = false;
    int option;
    int [] vec1 = new int[] { 1,2,3,4 };
    int [] vec2 = new int[] { 4,2,3,1 };

    public Menu() {
        this.menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        while (!exit) {
            System.out.print("Menu Basico \n 1. Diferentes calculos con notas entre 0 y 5 \n " +
                    "2. Multiplicacion escalar con vectores. \n " +
                    "3. Construcción de de matriz aleatoria. \n " +
                    "4. Salir \n");
            System.out.print("Ingrese una opcion: ");
            try {
                option = Integer.parseInt(sc.next());
                switch (option) {
                    case 1:
                        System.out.print("Estas en opcion 1");
                        break;
                    case 2:
                        scalarProduct(vec1,vec2);
                        break;
                    case 3:
                        new Matrix();
                        break;
                    case 4:
                        System.out.print("Hasta luego!");
                        exit = true;
                        break;
                    default:
                        System.out.print("Opcion no valida!\n\n");
                }
            } catch (NumberFormatException ex ){
                System.out.println("Inserte un numero valido. Por favor intente nuevamente\n\n");
            }
        }
    }

    private void scalarProduct(int v1[], int v2[]) {
        System.out.println("Primer vector" + Arrays.toString(v1));
        System.out.println("Segundo vector" + Arrays.toString(v2));

        if(v1.length != v2.length){
            System.out.println("Los vectores deben tener la misma dimension");
        }else{
            int result = 0;
            for (int i = 0; i < v1.length; i++) {
                result = result + v1[i] * v2[i];
            }
            System.out.println("El producto escalar es: " + result);
        }
    }
}
