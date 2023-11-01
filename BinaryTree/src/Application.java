public class Application {
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.insert(1,
                tree.insert(2,
                        null,
                        tree.insert(4, null, null)
                ),
                tree.insert(3,
                        tree.insert(5, null, null),
                        tree.insert(6, null, null)
                )
        );

        System.out.println(tree.toString());
        System.out.println(tree.belong(7));
    }
}
