/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosfinal177232;

import java.util.Random;

/**
 *
 * @author 52444
 */
public class ArbolesRojinegros {

    static NodoARN nil;
    static NodoARN root;
    static int contador = 0;
    
    public static void main(String[] args) {
        root = new NodoARN();
        root.color = "RED";
        nil = new NodoARN();
        nil.left = nil; nil.right = nil; nil.p = nil;
        root.left = nil; root.right = nil; root.p = nil;
        
        
        
        Random rnd = new Random();
        
        for (int i = 1000; i <= 35000; i += 1000) {
            int prom = promediar(rnd, i, 10);
            System.out.println(i + "-" + prom);
        }
    }
    
    
    
    public static void InOrder(NodoARN x){
        if(x != nil){
            InOrder(x.left);
            System.out.println(x.key);
            InOrder(x.right);
        }
    }
    
    public static void LeftRotate(NodoARN T, NodoARN x){
        NodoARN y = x.right;
        x.right = y.left;
        if(compara3(y.left, nil))  
            y.left.p = x;
        y.p = x.p;
        contador++;
        if(compara4(x.p, nil))
            T = y; //checar
        else if(compara4(x, x.p.left))
            x.p.left = y;
        else x.p.right = y;
        y.left = x;
        x.p = y;
    }
    
    public static void RightRotate(NodoARN T, NodoARN x){
        NodoARN y = x.left;
        x.left = y.right;
        contador++;
        if(compara3(y.right, nil))  
            y.right.p = x;
        y.p = x.p;
        contador++; 
        if(compara4(x.p, nil))
            T = y; 
        else if(compara4(x, x.p.right))
            x.p.right = y;
        else x.p.left = y;
        y.right = x;
        x.p = y;
    }

    public static void RBInsert(NodoARN T, NodoARN z){
        NodoARN x = T;
        NodoARN y = nil;
        
        while(compara3(x,nil)){
            y = x;
            if(compara(z.key, x.key))
                x = x.left;
            else x = x.right;
        }
        z.p = y;
        if(compara4(y, nil)){
            T = z;
        }
        else if(compara(z.key, y.key))
            y.left = z;
        else y.right = z;
        z.left = nil;
        z.right = nil;
        z.color = "RED";
        RBInsertFixup(T,z);
    }
    
    public static void RBInsertFixup(NodoARN T, NodoARN z){
    while(compara2("RED",z.p.color))
            {
        if(compara4(z.p, z.p.p.left)
                ){
            NodoARN y = z.p.p.right;
            if(compara2("RED",y.color)){
                z.p.color = "BLACK";
                y.color = "BLACK";
                z.p.p.color = "RED";
                z=z.p.p;
            }else{
                contador++;
                if(compara4(z,z.p.right)
                        ){
                    z = z.p;
                    LeftRotate(T,z);
                }
                z.p.color = "BLACK";
                z.p.p.color = "RED";
                RightRotate(T,z.p.p);
            }
        }else{
            NodoARN y = z.p.p.left;
            contador++;
            
            if(compara2("RED",y.color)){
                z.p.color = "BLACK";
                y.color = "BLACK";
                z.p.p.color = "RED";
                z = z.p.p;
            }else{
                contador++;
                if(compara4(z, z.p.left)
                        ){
                    z = z.p;
                    RightRotate(T,z);
                }
                z.p.color = "BLACK";
                z.p.p.color = "RED";
                LeftRotate(T,z.p.p);
            }
        }
            
        }
    T.color = "BLACK";
    }
    
    public static void RBTransplant(NodoARN T, NodoARN u, NodoARN v){
        if(u.p == nil)
            T = v;
        else if(u == u.p.left)
            u.p.left = v;
        else u.p.right = v;
        v.p = u.p;
    }
    
    public static void RBDelete(NodoARN T, NodoARN z){
        NodoARN y = z;
        NodoARN x;
        String yOriginalColor = y.color;
        if(z.left == nil){
            x = z.right;
            RBTransplant(T,z,z.right);
        }
        else if(z.right == nil){
            x = z.left;
            RBTransplant(T,z,z.left);
        }
        else {
            y = TreeMinimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if(y != z.right){
                RBTransplant(T,y,y.right);
                y.right = z.right;
                y.right.p = y;
            }else x.p = y;
            RBTransplant(T,z,y);
            y.left = z.left;
            y.left.p = y;
            y.color = z.color;
        }
        if("BLACK".equals(yOriginalColor))
            RBDeleteFixup(T,x);
    }
    
    public static void RBDeleteFixup(NodoARN T, NodoARN x){
        NodoARN w;
        while(x != T && "BLACK".equals(x.color)){
            if(x == x.p.left){
                w = x.p.right;
                if("RED".equals(w.color)){
                    w.color = "BLACK";
                    x.p.color = "RED";
                    LeftRotate(T, x.p);
                    w = x.p.right;
                }
                if("BLACK".equals(w.left.color) &&"BLACK".equals(w.right.color)){
                    w.color = "RED";
                    x = x.p;
                }else{
                    if("BLACK".equals(w.right.color)){
                        w.left.color =  "BLACK";
                        w.color = "RED";
                        RightRotate(T,w);
                        w = x.p.right;
                    }
                    w.color = x.p.color;
                    x.p.color = "BLACK";
                    w.right.color = "BLACK";
                    LeftRotate(T,x.p);
                    x = T;
                }
                    
            }else{
                w = x.p.left;
                if("RED".equals(w.color)){
                    w.color = "BLACK";
                    x.p.color = "RED";
                    RightRotate(T, x.p);
                    w = x.p.left;
                }
                if("BLACK".equals(w.right.color) &&"BLACK".equals(w.left.color)){
                    w.color = "RED";
                    x = x.p;
                }else{
                    if("BLACK".equals(w.left.color)){
                        w.right.color =  "BLACK";
                        w.color = "RED";
                        LeftRotate(T,w);
                        w = x.p.left;
                    }
                    w.color = x.p.color;
                    x.p.color = "BLACK";
                    w.left.color = "BLACK";
                    RightRotate(T,x.p);
                    x = T;
                }
            }
        }
        x.color = "BLACK";
    }
    
    public static NodoARN TreeMinimum(NodoARN x){
        while(x.left != nil)
            x = x.left;
        return x;
    }
    
    
    public static int promediar(Random rnd, int n, int m) {
        long comparaciones = 0;
        for (int i = 0; i < m; i++) {
            int A[] = construir(rnd, n);
            contador = 0;
            for (int j = 0; j < A.length; j++) {
                RBInsert(root, new NodoARN(A[j]));
            }
            comparaciones += contador;
        }
        return (int) (comparaciones / m);
    }
    
    public static int[] construir(Random rnd, int n) {
        int A[] = new int[n];
        for (int i = 0; i < A.length; i++)
            A[i] = rnd.nextInt(100000);
        return A;
    }
    
    public static boolean compara(int x, int y) {
        contador++;
        return x < y;
    }
    
    public static boolean compara2(String x, String y) {
        contador++;
        return x.equals(y);
    }
    
    public static boolean compara3(NodoARN x, NodoARN y) {
        contador++;
        return x != y;
    }
    
    public static boolean compara4(NodoARN x, NodoARN y) {
        contador++;
        return x == y;
    }
    
}
