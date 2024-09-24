/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class Countingsort {
    
    public static void CountingSort(int A[], int B[], int k){
        int C[] = new int[k+1];
        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }
        for (int i = 1; i <= A.length; i++) {
            C[A[i-1]] = C[A[i-1]] +1;
        }
        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i-1];
        }
        for (int i = A.length; i >=1; i--) {
            B[C[A[i-1]]-1] = A[i-1];
            C[A[i-1]] = C[A[i-1]]-1;
        }
        
        for(int x : B)
            System.out.println(x + " ");
    }
}
