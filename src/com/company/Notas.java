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
                System.out.println(cadena);
                notes = new float[cadena.split(",").length];

                for (int i = 0; i < cadena.split(",").length; i++) {
                    notes[i] = Float.parseFloat(cadena.split(",")[i]);
                    if (notes[i] > 5 || notes[i] < 0 ) {
                        System.out.println("Inserte un numero mayor a cero y menor a 5. Por favor intente nuevamente\n");
                        return;
                    }
                }
                ordenamiento();
                System.out.println("La mayor nota es: "+notes[notes.length-1] +"\n");
                System.out.println("La menor nota es: "+ notes[0]+"\n");
                System.out.println("El promedio es: "+ promedio() +"\n");
                System.out.println("La desviacion estandar es: "+ desviacion() +"\n");



                exit = false;

            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("En algina parte del proceso ingreso un dato invalido. Por favor intente nuevamente\n"+
                        "No olvide: No colocar espacios entre los numeros, No colocar letras ni otros caracteres diferente de numeros");
            }
        }
    }

    private void ordenamiento(){
        for (int x = 0; x < notes.length; x++) {
            for (int y = 0; y < notes.length - 1; y++) {
                float elementoActual = notes[y],
                        elementoSiguiente = notes[y + 1];
                if (elementoActual > elementoSiguiente) {

                    notes[y] = elementoSiguiente;
                    notes[y + 1] = elementoActual;
                }
            }
        }

    }

    private float promedio(){
        float prom = 0;
        for (int i = 0; i < notes.length; i++) {
            prom += notes[i];
        }
        return prom/notes.length;
    }

    private float desviacion(){
        float des = 0;
        float prom = promedio();
        for (int i = 0; i < notes.length; i++) {
            des+= Math.pow(notes[i] - prom, 2);
        }
        des = des/notes.length;
        des =(float) Math.sqrt(des) ;
        return des;
    }
    
}