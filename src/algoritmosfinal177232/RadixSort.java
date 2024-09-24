/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class RadixSort {

    public static int digit(int x, int k, int d) {
        return (x >> d) & k;
    }

    public static void countingSort(int A[], int B[], int k, int d) {
        int C[] = new int[k + 1];
        for (int j = 0; j < A.length; j++) {
            C[digit(A[j], k, d)]++;
        }
        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        for (int j = A.length - 1; j >= 0; j--) {
            B[--C[digit(A[j], k, d)]] = A[j];
        }
    }

    public static void radixSort(int A[]) {
        int B[] = new int[A.length];
        countingSort(A, B, 255, 0);
        countingSort(B, A, 255, 8);
        countingSort(A, B, 255, 16);
        countingSort(B, A, 255, 24);
    }

    public static void main(String a[]) {
        int A[] = {4, 5, 1, 8, 2, 9, 0, 3};
        radixSort(A);
        for (int x : A) {
            System.out.println(x);
        }
    }

}
