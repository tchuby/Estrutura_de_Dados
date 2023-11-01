public class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node insert(int value, Node left, Node right){
        Node node = new Node(value, left, right);
        this.root = node;
        return node;
    }

    @Override
    public String toString(){
        return toStringPos(this.root);
    }

    private String toStringPos(Node node){
        String s = "";
        if(node != null){
            s += toStringPos(node.getLeft());
            s += toStringPos(node.getRight());
            s += node.getInfo() + " ";
        }
        return s;
    }

    public boolean belong(Integer value){
        return belong(this.root, value);
    }

    private boolean belong(Node node, Integer value){
        if(node == null)
            return false;

        //Percorrendo PreOrdem(root, left, right)
        boolean output = node.getInfo().equals(value) ||
                         belong(node.getLeft(), value) ||
                         belong(node.getRight(), value);
        return output;
    }
}
