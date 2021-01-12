package LinkedList;
import CustomInterface.CustomList;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedList<T> implements CustomList<T>{
    private Node head;
    private int size;

    public SingleLinkedList(){
        head = new Node(null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    private void add(Node node, Node newNode) {
        newNode.next = node.next;
        node.next = newNode;

        size++;
    }

    public void add(T val) {
        Node curNode = head;
        while(curNode.next != null) {
            curNode = curNode.next;
        }
        add(curNode, new Node(val));
    }

    public void add(int index, T val) throws IndexOutOfBoundsException {
        if(index < 0)
            throw new IndexOutOfBoundsException("Index can't be lower than 0");

        Node curNode = head;
        int curIdx = -1;
        while(curNode.next != null && curIdx < index-1) {
            curNode = curNode.next;
            curIdx++;
        }
        add(curNode, new Node(val));
    }

    private void remove(Node prev) {
        prev.next = prev.next.next;

        size--;
    }

    public boolean remove(T val) {
        Node curNode = head;
        while(curNode.next != null) {
            if(curNode.next.value.equals(val))
            {
                remove(curNode);
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    public List<T> getList() {
        ArrayList<T> list = new ArrayList<>();
        Node curNode = head.next;
        while(curNode != null) {
            list.add(curNode.value);
            curNode = curNode.next;
        }
        return list;
    }

    protected class Node {
        private T value;
        private Node next;

        private Node(T value) {
            this.value = value;
        }

        protected T getValue(){ return value; }
        protected Node getNext(){ return next; }
    }
}
