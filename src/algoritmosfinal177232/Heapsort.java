/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class Heapsort {
    static int contador = 0;
    static int heapSize = 0;
        public static int Parent(int i){
        return (i/2);
    }
    
    public static int Left(int i){
        return (2*i);
    }
    
    public static int Right(int i){
                return (2*i + 1);

    }   
    
    public static void MaxHeapify(int A[],int i){
        int largest, temp;
        int l = Left(i);
        int r = Right(i);
        if(l <= heapSize && A[l-1] > A[i-1]){
            contador++;
            largest = l;
        }
            
        else largest = i;
        
        if(r <= heapSize && A[r-1] > A[largest-1]){
            largest = r;
            contador++;
        }
        if (largest != i){
            temp = A[i-1];
            A[i-1] = A[largest-1];
            A[largest-1] = temp;
            MaxHeapify(A, largest);
        }
    }
    
    public static void BuildMaxHeap(int A[]){
        heapSize = A.length;
        for (int i = (A.length/2); i >=1; i--) {
            MaxHeapify(A,i);
        }
        
    }
    
    public void Heapsort(int A[]){
        BuildMaxHeap(A);
        int temp;
        
        for (int i = (A.length); i >= 2; i--) {
            temp = A[1-1];
            A[1-1] = A[i-1];
            A[i-1] = temp;
            heapSize = heapSize -1 ;
            MaxHeapify(A,1);
        }
    }
    
}
