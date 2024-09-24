/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

import java.lang.reflect.Array;
/**
 *
 * @author omar.montano
 */
public class InsertionSortGeneric {
    
    public static <W extends Comparable<W>> void sort(W A[]) {
        for (int j = 1; j < A.length; j++) {
//            T elements[] = (T[]) Array.newInstance(A[0].getClass(), 10);
            W key = A[j];
            int i = j-1;
            while (i >= 0 && A[i].compareTo(key) > 0){
                A[i+1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
    }
    
}
