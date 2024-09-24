/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class Map<K, V> {
    K x;
    V y;
    
    public Map(K x, V y){
        this.x = x;
        this .y = y;
    }
    
    public int hashCode(){
        return x.hashCode();
    }
}
