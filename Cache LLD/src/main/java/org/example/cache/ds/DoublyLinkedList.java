package org.example.cache.ds;

public class DoublyLinkedList<K> {
    DoublyLinkedListNode<K> head;
    DoublyLinkedListNode<K> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public DoublyLinkedListNode<K> appendNode(K key) {
        DoublyLinkedListNode<K> node = new DoublyLinkedListNode<>(key);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }

        tail = node;
        return node;
    }

    public DoublyLinkedListNode<K> prependNode(K key) {
        DoublyLinkedListNode<K> node = new DoublyLinkedListNode<>(key);

        if (head == null) {
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
        }

        head = node;
        return node;
    }

    public DoublyLinkedListNode<K> detachNode(DoublyLinkedListNode<K> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.next = null;
        node.prev = null;
        return node;
    }

    public DoublyLinkedListNode<K> removeFromStart() throws IllegalAccessException {
        if (head == null) {
            throw new IllegalAccessException("doubly linked list is empty");
        }

        DoublyLinkedListNode node = head;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        return node;
    }
}
