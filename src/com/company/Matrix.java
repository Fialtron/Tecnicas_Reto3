package com.company;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Matrix {
    Scanner input = new Scanner(System.in).useLocale(Locale.US);
    double[][] matrix;
    double nRows;
    double nCol;
    boolean exit = true;

    public Matrix() {
        this.matrix();
    }

    private void matrix() {
        while (exit) {
            try {
                System.out.println("\nDigite el numero de filas: ");
                nRows = Integer.parseInt(input.next());
                System.out.println("Digite el numero de columnas: ");
                nCol = Integer.parseInt(input.next());
                if (nRows > 0 && nCol > 0) {
                    matrix = new double[(int) nRows][(int) nCol];

                    System.out.println("Digite la matriz: ");
                    for (int i=0; i<nRows; i++) {
                        for(int j=0; j<nCol; j++){
                            System.out.print("Matriz ["+i+"]["+j+"]: ");
                            String number = input.next();
                            while (!validate(number)) {
                                System.out.println("Por favor ingrese un numero valido");
                                System.out.print("Matriz ["+i+"]["+j+"]: ");
                                number = input.next();
                            }
                            matrix[i][j] = Double.parseDouble(number);
                        }
                    }

                    System.out.println("\nLa matriz es : ");
                    String name1 = "Matriz\n";
                    String result = "";
                    for (int i=0; i<nRows; i++) {
                        for(int j=0; j<nCol; j++){
                            result+= matrix[i][j];
                            result+= "      ";
                        }
                        result += "\n";
                    }
                    result += "\n";
                    System.out.println(name1 + result);
                    exit = false;
                } else {
                    System.out.println("Inserte un numero mayor a cero. Por favor intente nuevamente\n");
                }

            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Inserte un numero valido. Por favor intente nuevamente\n");
            }
        }
    }

    private boolean validate(String input) {
        return input.matches("[0-9]{1,13}(\\.[0-9]*)?");
    }
}
