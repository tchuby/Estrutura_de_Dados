public class LinkedStack {
    private Node start;
    private Node end;
    private int counter;

    public LinkedStack(){
        this.start = null;
        this.end = null;
        this.counter = 0;
    }

    public void push(Integer value){
        var newNode = new Node();

        newNode.setPayload(value);

        if(isEmpty())
            this.start = newNode;
        else
            this.end.setNextNode(newNode);

        this.end = newNode;

        this.counter++;
    }

    public Integer pop(){
        if(isEmpty())
            return null;

        var outPut = this.start.getPayload();

        this.start = this.start.getNextNode();

        this.counter--;

        return outPut;
    }

    public boolean isEmpty(){
        if(size() == 0)
            return true;

        return false;
    }

    public void clear(){
        this.start = null;
        this.end = null;
        this.counter = 0;
    }

    public int size(){
        return this.counter;
    }
}
