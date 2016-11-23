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
public class grafoL<T> {
    nodo<T> vertices[];
    boolean visitado[];    
    int numVertices;
    
    grafoL(int n){
        numVertices=n;
        vertices= new GrafoG[1];
    }
     
    public void creaArista(int a, int b){
        if (a<0 || a>numVertices || b<0 || b>numVertices) {
            return;
        }
        
        nodo<T> v1,v2;
        v1= new nodo(a);
        v2= new nodo(b);
        
        v1.setNext(vertices[v1.getindex()]);
        vertices[v1.getindex()]=v1;
        v1.setNext(vertices[v1.getindex()]);
        vertices[v1.getindex()]=v1;
    }
    
    public void DFS(nodo<T> vert, int reco[],int cont){
        nodo<T> hermano= vertices[vert.getindex()];
        if (visitado[vert.getindex()]) {
            return ;
        }
        visitado[vert.getindex()]=true;
        reco[cont]=vert.getindex();
        if (cont==numVertices) {
            System.out.println(reco);
        }
        while (hermano != null) {
            DFS(hermano,reco,cont++);
            hermano=hermano.getNext();
        }
        visitado[vert.getindex()]=false;
    }
    
    public  camHam(){
        boolean ban=false;
        int i= 0;
        int []reco= new int[numVertices];
        while (i<numVertices && !ban) {
            ban=Ham(i,reco,0);
            i++;
        }
    }
    
    public boolean Ham(int vert, int reco[],int cont){
        nodo<T> hermano= vertices[vert];
        boolean ban=false;
        if (visitado[vert]) {
            return false;
        }
        visitado[vert]=true;
        reco[cont]=vert;
        if (cont==numVertices) {
            return true;
        }
        while (hermano != null) {
            ban=Ham(hermano.getindex(),reco,cont++);
            hermano=hermano.getNext();
        }
        visitado[vert]=false;
        return ban;
    }
    
}
