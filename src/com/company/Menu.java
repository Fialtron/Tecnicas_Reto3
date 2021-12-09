package com.company;

import java.util.Scanner;

public class Menu {
    boolean exit = false;
    int option;

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
                        System.out.print("Estas en opcion 2");
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
}
