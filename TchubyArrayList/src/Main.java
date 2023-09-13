public class Main {
    public static void main(String[] args) {
        arrayListTest();
    }
    private static void arrayListTest(){
        var lista = new TchubyArrayList(true);

        System.out.println("A lista está vazia? " + lista.isEmpty());

        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(9);
        lista.add(10); //Esse não adiciona quando resizeble = false, pq estrapola o tamanho da coleção.
        lista.add(10);
        lista.add(11);

        for(int i = 0; i < lista.size(); i++){
            print("" + lista.get(i));
        }
        print(lista.toString());

        lista.remove(3);
        print(lista.toString());

        lista.removeFirst(10);
        print(lista.toString());

        print("A lista está vazia? " + lista.isEmpty());

        lista.clear();
        print("A lista está vazia? " + lista.isEmpty());
    }

    private static void print(String message){
        System.out.println(message);
    }
}