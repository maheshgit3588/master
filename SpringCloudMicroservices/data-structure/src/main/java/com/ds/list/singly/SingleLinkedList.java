package com.ds.list.singly;

public class SingleLinkedList<T> {


    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

    }

    private Node<T> head;

    public void insertNode(T data) {
        if (head == null) {
            head = new Node<>(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);

    }

    public void insertAtHead(T data){
        if(head==null){
            head=new Node<>(data);
            return;
        }

        Node newHead=new Node(data);
        newHead.next=head;
        head=newHead;

    }

    public void display() {
        System.out.println("Elements in single linked list : ");
        if (head == null)
            return;

        Node current = head;
        while (current.next != null) {
            System.out.print("\t" + current.data);
            current = current.next;
        }

        System.out.print("\t" + current.data + "\n");
    }

    public int length() {
        int count = 0;
        if (head == null)
            return count;

        Node current = head;
        while (current.next != null) {
            count++;
            current = current.next;
        }

        return count++;
    }




    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.insertNode(3);
        linkedList.insertNode(45);
        linkedList.insertNode(2);
        linkedList.insertNode(98);
        linkedList.insertNode(54);

        linkedList.display();

        System.out.println("Length of single linked list : " + linkedList.length());

        System.out.println("Inserting element at the begining of list");
        linkedList.insertAtHead(100);
        linkedList.display();
    }
}
