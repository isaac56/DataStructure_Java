package LinkedList;
import CustomInterface.CustomList;

import java.util.ArrayList;
import java.util.List;

public class DoublyCircularLinkedList<T> implements CustomList<T> {
    protected Node head;

    private void add(Node node, Node toAdd) {
        toAdd.next = node.next;
        toAdd.prev = node;
        toAdd.next.prev = toAdd;
        toAdd.prev.next = toAdd;
    }

    public void add(T val) {
        Node toAdd = new Node(val);
        if(head == null) {
            toAdd.next = toAdd;
            toAdd.prev = toAdd;
            head = toAdd;
        }
        else{
            add(head.prev, toAdd);
        }
    }

    public void add(int index, T val) throws IndexOutOfBoundsException {
        if(index < 0)
            throw new IndexOutOfBoundsException("Index can't be lower than 0.");

        if(head == null) {
            add(val);
            return;
        }

        Node toAdd = new Node(val);
        if(index == 0) {
            add(head.prev, toAdd);
            head = toAdd;
            return;
        }

        Node curNode = head;
        int curIdx = 0;
        while(curNode.next != head && curIdx < index-1) {
            curNode = curNode.next;
            curIdx++;
        }
        add(curNode, toAdd);
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    public void remove(T val){
        if(head == null)
            return;
        Node curNode = head;
        while(curNode.next != head){
            if(curNode.value.equals(val)){
                break;
            }
            curNode = curNode.next;
        }
        if(curNode.value.equals(val)){
            if(curNode == head) {
                if(curNode.next == head)
                    head = null;
                else
                    head = curNode.next;
            }
            remove(curNode);
            return;
        }
    }

    public List<T> getList(){
        if(head == null){
            return new ArrayList<>();
        }
        List<T> list = new ArrayList<>();
        Node curNode = head;
        while(curNode.next != head) {
            list.add(curNode.value);
            curNode = curNode.next;
        }
        list.add(curNode.value);
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

        protected Node getNext(){
            return this.next;
        }

        protected Node getPrev(){
            return this.prev;
        }
    }



    public void show(){
        if(head == null) {
            System.out.println("Empty.");
            return;
        }
        Node curNode = head;
        while(curNode.next != head) {
            System.out.print(curNode.value + ", ");
            curNode = curNode.next;
        }
        System.out.println(curNode.value);
    }
}
