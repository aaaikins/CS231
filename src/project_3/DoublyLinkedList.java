/*
File Name:   DoublyLinkedList.java
Author:      Francis O'Hara
Date:        3/30/24
Description: An implementation of a Doubly Linked List.
How to Run:  N/A
*/
package project_3;

public class DoublyLinkedList<E> {
    /**
     * The Node in the Doubly LinkedList data structure.
     *
     * @param <F> The type of values stored in the LinkedList.
     */
    private static class Node<F> {
        /**
         * The data value stored in the node.
         */
        F val;

        /**
         * The node before and the node after the current node in the list.
         */
        Node<F> prev, next;

        /**
         * Creates a Node object.
         * @param v The data value to be stored in the node.
         * @param p The node before the current node in the list.
         * @param n The node after the current node in the list.
         */
        public Node(F v, Node<F> p, Node<F> n) {
            val = v;
            p = prev;
            next = n;
        }
    }

    /**
     * The first and last nodes in the list.
     */
    Node<E> first, last;

    /**
     * The number of items stored in the list.
     */
    int size;

    /**
     * Creates a DoublyLinkedList object.
     */
    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Returns the number of items in the list.
     * @return the number of items in the list.
     */
    public int size(){
        return size;
    }

    /**
     * Returns the first item in the list.
     *
     * @return the first item in the list.
     */
    public E getFirst() {
        return first.val;
    }

    /**
     * Returns the last item in the list.
     *
     * @return the last item in the list.
     */
    public E getLast() {
        return last.val;
    }

    /**
     * Adds the given item to the start of the list.
     *
     * @param item the item to be added.
     */
    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item, null, first);
        if (size == 0){
            first = newNode;
            last = newNode;
        }
        else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size ++;
    }

    /**
     * Adds the given item to the end of the list.
     *
     * @param item the item to be added.
     */
    public void addLast(E item) {
        Node<E> newNode = new Node<E>(item, last, null);
        if (size == 0) {
            last = newNode;
            first = newNode;
        }
        else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size ++;
    }

    /**
     * Returns and removes the first item in the list.
     *
     * @return the first item in the list.
     */
    public E removeFirst() {
        E firstItem = first.val;
        first = first.next;
        if (size == 1)
            last = null;
        else if (size > 1)
            first.prev = null;
        size --;
        return firstItem;
    }

    /**
     * Returns and removes the last item in the list.
     *
     * @return the last item in the list.
     */
    public E removeLast() {
        E lastItem = last.val;
        last = last.prev;
        if (size == 1)
            first = null;
        else if (size > 1)
            last.next = null; // todo
        size --;
        return lastItem;
    }
}
