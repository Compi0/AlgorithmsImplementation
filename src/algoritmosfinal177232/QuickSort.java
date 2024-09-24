/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class QuickSort {
        static int contador = 0;
    public  void Quicksort(int A[], int p, int r){
        if(p<r){
            int q = Partition(A,p,r);
            Quicksort(A, p, q-1);
            Quicksort(A, q+1, r);
        }
    }
    
    public static int Partition(int A[], int p, int r){
        int x = A[r];
        int i= p-1;
        int temp = 0;
        for (int j = p; j <= (r-1); j++) {
            contador++;
            if(A[j] <= x){
                i++;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
    
    
        }
    temp = A[i+1];
    A[i+1] = A[r];
    A[r] = temp;
    return (i+1);
    }
}
