/**
 * Lista com alocação de memória contígua.
 */
public class TchubyArrayList {
    private Integer[] array;
    private boolean resizable;
    private int initialCapacity;
    private int counter;
    private final static int X = 10;

    public TchubyArrayList(){
        this.initialCapacity = this.X;
        this.counter = 0;
        this.array = new Integer[this.X];
        this.resizable = false;
    }

    /**
     * Adiciona o elemento passado por parâmetro ao final da lista. Caso
     * a lista seja redimensionável faz a chamada para o método responsável
     * por redimensionar o array.
     * Retorna verdadeiro se foi possível e falso se não foi possível
     * adicioná-lo.
     *
     */
    public boolean add(Integer value){
        if(resizable){
            resizeArrayList();
        }
        else if(this.counter == array.length){
            return false;
        }

        array[this.counter] = value;

        this.counter++;

        return true;
    }

    public boolean add(int index, Integer value){
        return true;
    }
    private void resizeArrayList(){
        //foo...
    }
    public Integer remove(int indice){
        if(indice < 0 || indice >= counter){
            return null;
        }
        var valorRemovido = array[indice];

        for(; indice < counter -1; indice++){
            array[indice] = array[indice + 1];
        }

        counter--;

        return valorRemovido;
    }
    public boolean removeFirst(Integer objeto){
        return true;
    }
    public Integer get(int indice){
        if(indice >= 0 && indice < this.counter){
            return this.array[indice];
        }

        return null;
    }
    public void clear(){

    }
    public Integer set(int index, Integer objeto){
        return 0;
    }
    public int size(){
        return this.counter;
    }
    public boolean isEmpty(){
        return this.counter == 0;
    }
    public boolean isFull(){
        return false;
    }
    public boolean contains(){
        return false;
    }
    public int indexOf(Integer object){
        return 0;
    }
    public int lastIndexOf(Integer object){
        return 0;
    }
    public Integer[] toArray(){
        Integer novoArray[] = new Integer[10];
        return novoArray;
    }
    @Override
    public String toString(){
        var saida = "";
        for(int i = 0; i < counter; i++){
            saida += array[i] + " ";
        }
        return saida;
    }
}
