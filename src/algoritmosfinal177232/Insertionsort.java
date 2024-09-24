/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class Insertionsort {
    static int contador = 0;
    public static void sort(int A[]) {
        contador = 0;
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j-1;
            while (i >= 0 && compara(A[i],key)){
                A[i+1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
    }
    
    public static boolean compara(int x, int y) {
        contador++;
        return x > y;
    }
}
