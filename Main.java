import by.epam.money.structures.BinaryTree;
import by.epam.money.structures.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(2);
        list.addLast(3);
        list.addFirst(7);
        list.addFirst(9);
        list.addLast(5);
        list.addIndex(4,1);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));

        System.out.println("index = " + list.indexOf(7));

        list.removeFirst();
        list.removeLast();
        list.removeIndex(1);

        System.out.println();
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(14);
        tree.add(4);
        tree.add(7);
        tree.add(13);
        tree.traverseLevelOrder();
        System.out.println(tree.containsNode(7));
        System.out.println(tree.containsNode(70));
        System.out.println();
        tree.delete(6);
        tree.traverseLevelOrder();

    }
}
