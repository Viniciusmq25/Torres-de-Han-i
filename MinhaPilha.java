public class MinhaPilha {

    private int [] pilha;
    private int nElementos;

    public MinhaPilha() {
        // capacidade de armazenamento da pilha
        pilha = new int[100];
        nElementos=0;
    }

    //push(e): insere o elemento e no topo da pilha
    public boolean push(int elemento){
        if(nElementos==pilha.length)
            return false;
        
        pilha[nElementos]=elemento;
        nElementos++;

        return true;
    }

    //pop(): remove e retorna o elemento do topo da pilha (erro se a pilha estiver vazia)
    public int pop(){
        //Alternativa 1: posso reutilizar o top
        //int result=top();
        //nElementos--;
        //return result--;
        
        //Alternativa 2: implemento do zero
        if(nElementos==0)
            throw new RuntimeException("A pilha está vazia");        
        nElementos--;
        return pilha[nElementos];
    }
    //top(): retorna, mas não remove, o elemento do topo pilha (erro se a pilha estiver vazia)
    public int top(){
        if(nElementos>0)
            return pilha[nElementos-1];
        
        throw new RuntimeException("Não existem elementos na pilha");

    }

    //size(): retorna o número de elementos da pilha
    public int size(){
        return nElementos;
    }

    //isEmpty(): retorna true se a pilha estiver vazia, e false caso contrário
    public boolean isEmpty(){
        return (nElementos==0);
    }

    //clear(): esvazia a pilha
    public void clear(){
        nElementos=0;
    }

}