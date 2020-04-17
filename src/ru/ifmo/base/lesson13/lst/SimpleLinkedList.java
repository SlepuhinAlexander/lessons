package ru.ifmo.base.lesson13.lst;

public class SimpleLinkedList {
    private Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        find(-1).next = new Node(value);
    }

    public int get(int ind) { // 1
        Node result = find(ind);
        return result == null ? null : result.value;
    }

    private Node find(int ind) { // 1
        if (ind == 0) return head;
        int cnt = 0;

        Node node = head;

        while (node != null) {
            if (cnt++ == ind) return node;
            if (ind < 0 && node.next == null) return node;
            node = node.next;
        }
        return null;
    }
}


class Node {

    int value;
    Node next; // null

    public Node(int value) {
        this.value = value;
    }
}