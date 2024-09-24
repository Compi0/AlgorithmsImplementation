/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class NodoArbol {
    int key;
    NodoArbol left;
    NodoArbol right;
    NodoArbol p;

    public NodoArbol(int key) {
        this.key = key;
        left = null;
        right = null;
        p = null;
    }
}
