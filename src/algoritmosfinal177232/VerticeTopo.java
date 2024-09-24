/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class VerticeTopo<E> {
        E nombre;
        Color color;
        int d;
        int f;

        public VerticeTopo(E nombre) {
            this.nombre = nombre;
            this.color = Color.WHITE;
            this.d = 0;
            this.f = 0;
        }
}
