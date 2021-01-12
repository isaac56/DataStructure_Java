package LinkedList;
import CustomInterface.CustomList;

import java.util.ArrayList;
import java.util.List;

public class DoublyCircularLinkedList<T> implements CustomList<T> {
    protected Node head;
    private int size;

    public DoublyCircularLinkedList(){
        head = new Node(null);
        head.next = head;
        head.prev = head;
    }

    public int getSize(){
        return size;
    }

    private void add(Node node, Node newNode) {
        newNode.next = node.next;
        newNode.prev = node;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;

        size++;
    }

    public void add(T val) {
        add(head.prev, new Node(val));
    }

    public void add(int index, T val) throws IndexOutOfBoundsException {
        if(index < 0)
            throw new IndexOutOfBoundsException("Index can't be lower than 0.");

        Node curNode = head;
        int curIdx = -1;
        while(curNode.next != head && curIdx < index-1) {
            curNode = curNode.next;
            curIdx++;
        }
        add(curNode, new Node(val));
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;

        size--;
    }

    public boolean remove(T val){
        Node curNode = head.next;
        while(curNode != head) {
            if(curNode.value.equals(val)){
                remove(curNode);
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    public List<T> getList(){
        List<T> list = new ArrayList<>();
        Node curNode = head.next;
        while(curNode != head) {
            list.add(curNode.value);
            curNode = curNode.next;
        }
        return list;
    }

    protected class Node{
        private T value;
        private Node next;
        private Node prev;

        protected Node(T value) {
            this.value = value;
            next = null;
        }

        protected T getValue(){
            return this.value;
        }
        protected Node getNext(){ return this.next; }
        protected Node getPrev(){
            return this.prev;
        }
    }
}
