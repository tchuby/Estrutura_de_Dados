public class Node {
    private Integer payload;
    private Node nextNode;

    public Node(){
        this.payload = null;
        this.nextNode = null;
    }

    public Node(Integer payload, Node nextNode) {
        this.payload = payload;
        this.nextNode = nextNode;
    }

    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer payload) {
        this.payload = payload;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Value: " + this.payload + ", next: " +
                this.nextNode.getPayload() + ".";
    }
}
