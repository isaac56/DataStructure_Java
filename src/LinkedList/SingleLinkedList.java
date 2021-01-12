package LinkedList;
import CustomInterface.CustomList;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedList<T> implements CustomList<T>{
    private Node head;

    public SingleLinkedList(){
        head = new Node(null);
    }

    private void add(Node node, Node newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }

    public void add(T val) {
        Node curNode = head;
        while(curNode.next != null) {
            curNode = curNode.next;
        }

        Node newNode = new Node(val);
        add(curNode, newNode);
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
        Node newNode = new Node(val);
        add(curNode, newNode);
    }

    public boolean remove(T val) {
        if(head.next == null)
            return false;

        Node curNode = head;
        while(curNode.next != null) {
            if(curNode.next.value.equals(val))
            {
                curNode.next = curNode.next.next;
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