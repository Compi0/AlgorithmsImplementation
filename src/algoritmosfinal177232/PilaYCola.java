/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosfinal177232;


/**
 *
 * @author 52444
 */

public class PilaYCola {

    static int top = 0;
    static int tail = 0;
    static int head = 0;
    
    
    public static void main(String[] args) {
        int A[] = new int[10];
        /*
        push(A,1);
        push(A,5);
        push(A,7);
        pop(A);
        imprimirPila(A);
        
        Enqueue(A,1);
        Enqueue(A,5);
        Enqueue(A,7);
        Dequeue(A);
        Dequeue(A);
        imprimirCola(A);*/
       
       ListaGenerica<Integer> l = new ListaGenerica<Integer>();
       l.ListInsert(new NodoGenerico<Integer>(5));
       l.ListInsert(new NodoGenerico<Integer>(10));
       l.imprimirLista();
       /*
       List l = new List();
       Node x = new Node();
       x.key = 177232;
       l.ListInsert(x);
       Node k = new Node();
       k.key = 2;
       /*
       l.ListInsert(k);
       l.ListDelete(x);
       l.imprimirLista();*/
       
    }
    
    public static boolean StackEmpty(int s[]){
        if(top==0)
            return true;
        else
            return false;
    }
    
    public static void push(int s[], int x){
        s[top] = x;
        top += 1;
    }
    
    public static int pop(int s[]){
        if (StackEmpty(s)){
                System.out.println("Error, underflow");
                return 0;
        }
        else{
            top -= 1;
            return s[top];
        }
    }
    
    public static void imprimirCola(int s[]){
        for (int i = head; i < tail; i++) {
            System.out.print(s[i] + " ");
        }
    }
    
    public static void imprimirPila(int s[]){
        for (int i = top-1; i >= 0; i--) {
            System.out.println(s[i] + " ");
        }
    }
    
    
    public static void Enqueue(int Q[], int x){
        Q[tail] = x;
        if(tail == Q.length)
           tail = 1;
        else
            tail += 1;
    }
    
    public static void Dequeue(int Q[]){
        int x = Q[head];
        if (head == Q.length)
            head = 1;
        else{
            head += 1;}
    }
    
    
}
