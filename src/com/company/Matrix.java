package com.company;

import java.util.Scanner;

public class Matrix {
    Scanner input = new Scanner(System.in);
    int matrix[][], nRows, nCol;
    boolean exit = true;

    public Matrix() {
        this.matrix();
    }

    private void matrix() {
        while (exit) {
            System.out.println("\nDigite el numero de filas: ");
            try {
                nRows = Integer.parseInt(input.next());
                System.out.println("Digite el numero de columnas: ");
                nCol = Integer.parseInt(input.next());
                if (nRows > 0 && nCol > 0) {
                    matrix = new int[nRows][nCol];
                } else {
                    System.out.println("Inserte un numero mayor a cero. Por favor intente nuevamente\n");
                }

            } catch (NumberFormatException e) {
                System.out.println("Inserte un numero valido. Por favor intente nuevamente\n");
            }
        }

    }
}
