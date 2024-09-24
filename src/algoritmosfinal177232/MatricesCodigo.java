/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class MatricesCodigo {

    
    static class Resultado {
        int[][] m;
        int[][] s;

        Resultado(int[][] m, int[][] s) {
            this.m = m;
            this.s = s;
        }
    }

    public static int[][] matrixMultiply(int[][] A, int[][] B) {
        if (A[0].length != B.length) {
            throw new IllegalArgumentException("Dimensiones incompatibles");
        }

        int aRows = A.length;
        int aCols = A[0].length;
        int bCols = B[0].length;

        int[][] C = new int[aRows][bCols];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                C[i][j] = 0;
                for (int k = 0; k < aCols; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static Resultado matrixChainOrder(int[] p) {
        int n = p.length - 1;

        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n][n + 1];

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        return new Resultado(m, s);
    }

    public static void printOptimalParens(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        int[] dimensiones = {30, 35, 15, 5, 10, 20, 25}; 
        Resultado resultado = matrixChainOrder(dimensiones);
        System.out.println("Numero minimo multiplicaciones: " + resultado.m[1][dimensiones.length - 1]);
        System.out.print("Orden para multiplicar: ");
        printOptimalParens(resultado.s, 1, dimensiones.length - 1);
    }
}    
