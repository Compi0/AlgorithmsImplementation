/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 177232
 */
public class Vertice<E> {
    public Color color;
    public int d;
    public Vertice pi;
    public E nombre;
    public int f;
    
    public Vertice(E nombre){
        this.nombre = nombre;
        this.color = Color.WHITE;
            this.pi = null;
            this.d = 0;
            this.f = 0;
    }
    
    
    
}
