/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class Mergesort {
    static int contador = 0;
        public static void merge(int A[], int p, int q, int r){
        int n1 = q - p +1;
        int n2 = r - q;
        int L[] = new int[n1+1];
        int R[] = new int[n2+1];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p+1];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = A[q+i+1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            contador++;
            if(L[i] <= R[j]){
                
                A[k] = L[i++];
            }else{
               A[k] = R[j++]; 
            }
        }
    }
    
    public static void mergeSort(int A[], int p, int r){
        if(p<r){
            int q = (p+r)/2;
            mergeSort(A,p,q);
            mergeSort(A,q+1,r);
            merge(A,p,q,r);
        }
    }
}
