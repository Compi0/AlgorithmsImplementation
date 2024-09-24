/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class VerticeBellman{
    int nombre;
    int d;
    VerticeBellman pi;
    
     VerticeBellman(int nombre) {
        this.nombre = nombre;
        this.d = Integer.MAX_VALUE;
        this.pi = null;
        }
}
