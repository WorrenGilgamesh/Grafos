/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cosas;

/**
 *
 * @author dai
 */
public class nodo<T> {
    T elem;
    int indice;    
    nodo<T> next;
    
   public nodo(int d){
       indice = d;
       next=null;
       elem=null;
   }
   
   int getindex(){
       return indice;
   }
   
   public void setNext(nodo<T> next){
       this.next = next;
   }
}
