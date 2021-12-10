package com.company;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Notas {

    Scanner input = new Scanner(System.in).useLocale(Locale.US);
    boolean exit = true;
    String cadena;
    float[] notes;
    public Notas(){ this.notas(); }

    private void notas(){

        while (exit) {
            try {
                System.out.println("\nDigite las de notas que desea evaluar separadas cada una por una coma ( 3,4,2 ) y en el rango de 0 a 5" +
                        "\nNo deje espacios entre las notas, no inserte numeros negativos, no inserte carcteres diferente a numeros");
                cadena= input.next();
                notes = new float[cadena.split(",").length];
                for (int i = 0; i < cadena.split(",").length; i++) {
                    notes[i] = Float.parseFloat(cadena.split(",")[i]);
                    if (!(notes[i] <= 5 && notes[i] >= 0)) {
                        System.out.println("Inserte un numero mayor a cero y menor a 5. Por favor intente nuevamente\n");
                        i -= 1;
                    }
                }
                ordenamiento();

                for (int i = 0; i < notes.length; i++) {
                    System.out.println("\n"+notes[i]);
                }


                exit = false;

            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("En algina parte del proceso ingreso un dato invalido. Por favor intente nuevamente\n"+
                        "No olvide: No colocar espacios entre los numeros, No colocar letras ni otros caracteres diferente de numeros");
            }
        }
    }

    private void ordenamiento(){
        int i = 0;
        float auxiliar = 0;
        while (i < notes.length ){
            for (int j = 0; j < notes.length - i; j++) {
                if(notes[j] > notes[j+1]){
                    auxiliar = notes[j];
                    notes[j] = notes[j+1];
                    notes[j+1] = auxiliar;
                }
            }
            i++;
        }
    }


/*



 */




}