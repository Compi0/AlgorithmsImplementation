/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
import java.util.Scanner;
public class DLList {
    static Node cabeza=null;
    static Node nil= new Node(Integer.MAX_VALUE);
    private static final Scanner e = new Scanner(System.in);
    
    public static Node listBusqueda(int k){
        Node x = cabeza;
        while(x!=null && x.key!=k){
            x=x.sig;
        }
        return x;
    }
    
    public static void listInserta(Node x){
        x.sig=cabeza;
        if(cabeza!=null){
            cabeza.previo=x;
        }
        cabeza=x;
        x.previo=null;
    }
    
    public static void listborrado(Node x){
        if(x.previo!=null){
            x.previo.sig=x.sig;
        }else{
            cabeza=x.sig;
        }
        if(x.sig!=null){
            x.sig.previo=x.previo;
        }
    }
    
    public static void listD(Node x){
        x.previo.sig=x.sig;
        x.sig.previo=x.previo;
    }
    
    public static Node listS(int k){
        Node x=nil.sig;
        while(x!=nil && x.key!=k){
            x=x.sig;
        }
        return x;
    }
    
    public static void listI(Node x){
        x.sig=nil.sig;
        nil.sig.previo=x;
        nil.sig=x;
        x.previo=nil;
    }
    
    public static void imprecionList(){
        Node x = cabeza;
        while(x!=null){
            System.out.print(x.key+" ");
            x=x.sig;
        }
        System.out.println("");
    }
    
    public static void printL(){
        Node x = nil.sig;
        while(x!=nil){
            System.out.print(x.key+" ");
            x=x.sig;
        }
        System.out.println("");
    }
    
    public static void accion1(){
        int op=1;
        while(op!=0){
            System.out.println("Menu\n1\tInsertar\n2\tBuscar\n3\tBorrar\n4\tMostrar lista\n0\tSalir");
            op = e.nextInt();
            switch(op){
                case 1 -> {
                    System.out.print("Ingresa el valor del nodo: ");
                    Node x = new Node(e.nextInt());
                    listInserta(x);
                }
                case 2 -> {
                    System.out.print("Ingresa el valor del nodo a buscar: ");
                    Node y=listBusqueda(e.nextInt());
                    if(y!=null){
                        System.out.println("Nodo encontrado");
                    }else{
                        System.out.println("Nodo no existente en la lista");
                    }
                }
                case 3 -> {
                    System.out.print("Ingresa el valor del nodo a borrar: ");
                    Node z=listBusqueda(e.nextInt());
                    if(z!=null){
                        listborrado(z);
                        System.out.println("Nodo eliminado");
                    }else{
                        System.out.println("Nodo no existente en la lista");
                    }
                }
                case 4 -> imprecionList();
            }
        }
    }
    
    
    public static void main(String[] a){
        nil.sig=nil;
        nil.previo=nil;     
        System.out.println("Menu\n1\tLista sin centinela\n2\tLista con centinela\n0\tSalir");
        accion1();
    }
}
