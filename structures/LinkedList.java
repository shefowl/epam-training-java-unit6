package by.epam.money.structures;

public class LinkedList <E> {
    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        size = 0;
    }

    public void addFirst(E element){
        Node node = new Node(element);
        if(first == null){
            first = node;
            last = node;
            size++;
            return;
        }
        Node temp = first;
        first = node;
        node.right = temp;
        temp.left = first;
        size++;
    }

    public void addLast(E element){
        Node node = new Node(element);
        if(last == null){
            first = node;
            last = node;
            size++;
            return;
        }
        Node temp = last;
        last = node;
        node.left = temp;
        temp.right = last;
        size++;
    }

    public void addIndex(E element, int index){
        if(index >= size || index < 0){
            return;
        }

        if(index == size - 1){
            addLast(element);
            return;
        }

        if(index == 0){
            addFirst(element);
            return;
        }

        Node node = first;
        Node insert = new Node(element);
        for (int i = 0; i < size; ++i){
            if(i == index){
                Node temp = node.left;
                node.left = insert;
                insert.right = node;
                temp.right = insert;
                insert.left = temp;
                size++;
                return;
            }
            else{
                node = node.right;
            }
        }
    }

    public E removeFirst(){
        Node temp = first;
        first = first.right;
        first.left = null;
        size--;
        return (E)temp.data;
    }

    public E removeLast(){
        Node temp = last;
        last = last.left;
        last.right = null;
        size--;
        return (E)temp.data;
    }

    public E removeIndex(int index){
        if(index >= size || index < 0){
            return null;
        }

        if(index == size - 1){
           return removeLast();
        }

        if(index == 0){
            return removeFirst();
        }

        Node node = first;
        for (int i = 0; i < size; ++i){
            if(i == index){
                node.left.right = node.right;
                node.right.left = node.left;
                size--;
                return (E)node.data;
            }
            else{
                node = node.right;
            }
        }
        return null;
    }

    public E getFirst(){
        return (E)first.data;
    }

    public E getLast(){
        return (E)last.data;
    }

    public E get(int index){
        if(index >= size || index < 0){
            return null;
        }

        if(index == size - 1){
            return getLast();
        }

        if(index == 0){
            return getFirst();
        }

        Node node = first;
        for (int i = 0; i < size; ++i){
            if(i == index){
                return (E)node.data;
            }
            else{
                node = node.right;
            }
        }
        return null;
    }

    public void set(E element, int index){
        if(index >= size || index < 0){
            return;
        }

        if(index == size - 1){
            addLast(element);
            return;
        }

        if(index == 0){
            addFirst(element);
            return;
        }

        Node node = first;
        for (int i = 0; i < size; ++i){
            if(i == index){
                node.data = element;
                return;
            }
            else{
                node = node.right;
            }
        }
    }

    public int indexOf(E element){
        Node node = first;
        for (int i = 0; i < size; ++i){
            if(node.data == element){
                return i;
            }
            else{
                node = node.right;
            }
        }
        return -1;
    }

    private class Node<V>{
        private V data;
        private Node left;
        private Node right;

        private Node(V data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
