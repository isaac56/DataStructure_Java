package LinkedList;
import CustomInterface.CustomList;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList<T> implements CustomList<T>{
    private Node head;
    private Node tail;
    int size;

    public DoubleLinkedList(){
        head = new Node(null);
        tail = new Node(null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    private void add(Node node, Node newNode) {
        newNode.next = node.next;
        newNode.prev = node;
        if(newNode.next != null)
            newNode.next.prev = newNode;
        if(newNode.prev != null)
            newNode.prev.next = newNode;

        if(newNode.next == null)
            tail.next = newNode;

        size++;
    }

    public void add(T val) {
        if(tail.next != null)
            add(tail.next, new Node(val));
        else
            add(head, new Node(val));
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

    private void remove(Node node) {
        if(node.next == null)
            tail.next = node.prev;

        if(node.prev != null)
            node.prev.next = node.next;
        if(node.next != null)
            node.next.prev = node.prev;
        node.next = null;
        node.prev = null;

        size--;
    }

    public boolean remove(T val) {
        Node curNode = head.next;
        while(curNode != null) {
            if(curNode.value.equals(val))
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
        private Node prev;

        private Node(T value) {
            this.value = value;
        }

        protected T getValue(){ return value; }
        protected Node getNext(){ return next; }
        protected Node getPrev(){ return prev;}
    }
}
