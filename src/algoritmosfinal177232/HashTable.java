/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */
public class HashTable {
    public HashNode[] T = new HashNode[9];
    
    public int h(int k){
        return k%9;
    }
    
    public void chInsert(HashNode x){
        T[h(x.key)].next.prev = x;
        x.next = T[h(x.key)].next;
        T[h(x.key)].next = x;
    }
    
    public HashNode chSearch(int k){
        HashNode x = T[h(k)];
        while(x!=null && x.key!=k){
            x=x.next;
        }
        return x;
    }
    
    public void chDelete(HashNode x){
        if(x.prev!=null){
            x.prev.next=x.next;
        }else{
            T[h(x.key)].next=x.next;
        }
        if(x.next!=null){
            x.next.prev=x.prev;
        }
}
}
