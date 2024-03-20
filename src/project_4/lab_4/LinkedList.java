/*
File Name:   LinkedList.java
Author:      Francis O'Hara
Date:        3/19/2024
Description: Basic implementation of the LinkedList data structure with a pointer to the head and tail of the list.
How to Run:  N/A
*/
package project_4.lab_4;

import java.util.Iterator;

public class LinkedList<T> implements Queue<T>, Iterable<T> {
    /**
     * An implementation of the Node in a LinkedList data structure.
     *
     * @param <T> The type of values stored in the LinkedList.
     */
    private static class Node<T> {
        /**
         * The data stored in the current node of the LinkedList.
         */
        T value;

        /**
         * A reference to the next node in the LinkedList if any.
         */
        Node<T> next;

        /**
         * Create a node containing `item` as its data.
         *
         * @param item The item to be set as the data value for the created node.
         */
        public Node(T item) {
            value = item;
        }

        /**
         * Returns the data value of the node.
         *
         * @return The data value of the node.
         */
        public T getValue() {
            return value;
        }

        /**
         * Sets Node `n` as the next node for the current node in the LinkedList.
         *
         * @param n The node to be set as the next node.
         */
        public void setNext(Node<T> n) {
            next = n;
        }

        /**
         * Returns the next node to the current node in the LinkedList if any.
         *
         * @return The node in the `next` field of the current node.
         */
        public Node<T> getNext() {
            return next;
        }
    }

    /**
     * Iterator for traversing the LinkedList.
     */
    private class LinkedListIterator implements Iterator<T> {
        /**
         * The current node in the traversal.
         */
        Node<T> node;

        /**
         * Creates a LinkedListIterator object.
         *
         * @param head The first node of the LinkedList from which the traversal will begin.
         */
        public LinkedListIterator(Node<T> head) {
            node = head;
        }

        /**
         * Returns a boolean indicating whether the iterator has reached the end of the LinkedList.
         *
         * @return `true` if there are still values to traverse. Otherwise, return `false`.
         */
        public boolean hasNext() {
            return node != null;
        }

        /**
         * Returns the next item in the LinkedList and moves the traversal to the next node in the list.
         *
         * @return The value of the current node reached in the traversal of the LinkedList.
         */
        public T next() {
            T result = node.value;
            node = node.next;
            return result;
        }

        /**
         * Optional method.
         */
        public void remove() {
        }

    }

    /**
     * The head of the LinkedList.
     */
    private Node<T> head;

    /**
     * The tail of the LinkedList.
     */
    private Node<T> tail;

    /**
     * The number of items stored in the LinkedList.
     */
    private int size;

    /**
     * Creates an empty LinkedList.
     */
    public LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Returns the number of items in the LinkedList.
     *
     * @return The length of the LinkedList.
     */
    public int size() {
        return size;
    }

    /**
     * Empties the LinkedList.
     */
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Returns a boolean indicating whether the list is empty.
     *
     * @return `true` if the list is empty and `false` otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a textual representation of the current and following nodes in the LinkedList.
     *
     * @return A String representing the current and following nodes in the LinkedList.
     */
    public String toString() {
        String result = "";
        Node<T> nextNode = head;
        while (nextNode != null) {
            result += nextNode.getValue();
            nextNode = nextNode.getNext();
            if (nextNode != null)
                result += " --> ";
        }
        return result;
    }

    /**
     * Returns a new LinkedListIterator pointing to the head of the list.
     *
     * @return The newly instantiated LinkedListIterator.
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator(head);
    }

    /**
     * Inserts the value `item` at the beginning of the LinkedList.
     *
     * @param item the item to be inserted at the beginning of the list.
     */
    public void add(T item) {
        Node<T> newHead = new Node<>(item);
        newHead.setNext(head);
        head = newHead;

        if (size == 0)
            tail = newHead;

        size++;
    }


    /**
     * Returns a boolean indicating whether the value `o` is present in the LinkedList.
     *
     * @param o The value to be searched within the LinkedList.
     * @return `true` if `o` is present in the LinkedList and `false` otherwise.
     */
    public boolean contains(Object o) {
        Node<T> nextNode = head;

        while (nextNode != null) {
            if (nextNode.getValue().equals(o))
                return true;
            nextNode = nextNode.getNext();
        }
        return false;
    }

    /**
     * Returns the item specified by the given index.
     *
     * @param index The index of the item to be returned.
     * @return The data value of the node at the given index in the LinkedList. Returns `null` if no such node exists.
     */
    public T get(int index) {
        if (index >= 0 && index <= size) {
            if (index == size)
                return getLast();

            else {
                int currentIndex = 0;
                Node<T> currentNode = head;

                while (currentIndex < size) {
                    if (currentIndex == index)
                        return currentNode.getValue();
                    currentIndex += 1;
                    currentNode = currentNode.getNext();
                }
            }
        }
        return null; // todo: throw custom exception;
    }

    /**
     * Removes the first Node in the LinkedList and returns its value.
     *
     * @return The data value of the first Node in the LinkedList. Returns `null` if LinkedList is empty.
     */
    public T remove() {
        T value = head.value;
        head = head.next;
        size--;

        if (size == 0)
            tail = null;

        return value;
        // todo: throw custom exception.
    }

    /**
     * Add the specified item `item` at the specified index `index` in the LinkedList.
     *
     * @param index An integer denoting the position at which `item` should be added.
     * @param item  The value to be added to the LinkedList.
     */
    public void add(int index, T item) {
        if (index >= 0 && index <= size) {
            if (index == 0) { // insert new node at beginning of linked list.
                add(item);
            } else if (index < size) { // insert new node in middle of linked list
                Node<T> newNode = new Node<>(item);
                Node<T> previousNode = null;
                Node<T> currentNode = head;
                int currentIndex = 0;

                while (currentNode != null) {
                    if (currentIndex == index - 1) {
                        previousNode = currentNode;
                    } else if (currentIndex == index) {
                        newNode.next = currentNode;
                        previousNode.next = newNode;
                        size++;
                    }
                    currentIndex++;
                    currentNode = currentNode.next;
                }
            } else {  // insert new node at end of linked list.
                addLast(item);
            }
        } else {
            // todo: throw exception.
        }
    }

    /**
     * Removes the item at the position in the list specified by `index`.
     *
     * @param index An integer denoting the index of the item to be removed from the linked list.
     * @return The removed item. Returns null if no such index exists in the list.
     */
    public T remove(int index) {
        if (index >= 0 && index <= size - 1) {

            if (index == 0)  // remove first item
                return remove();

            else if (index == size - 1) { // remove last item;
                int currentIndex = 0;
                Node<T> currentNode = head;
                while (currentNode != null) {
                    if (currentIndex == index - 1) {
                        T result = currentNode.next.value;
                        currentNode.next = null;
                        size--;
                        return result;
                    }
                    currentNode = currentNode.next;
                    currentIndex++;
                }
            } else {
                int currentIndex = 1;
                Node<T> previousNode = head;
                Node<T> currentNode = head.next;
                while (currentNode != null) {
                    if (currentIndex == index) {
                        T result = currentNode.value;
                        previousNode.next = currentNode.next;
                        size--;
                        return result;
                    }
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                    currentIndex++;
                }

            }
        }
        return null;  // todo: throw exception
    }

    /**
     * Inserts an item at the end of the LinkedList.
     *
     * @param item The item to be inserted at the end of the list.
     */
    public void addLast(T item) {
        if (size == 0) {
            Node<T> newNode = new Node<>(item);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node<>(item);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Removes the last node in the LinkedList and returns its value.
     *
     * @return The value of the last node in the LinkedList.
     */
    public T removeLast() {
        if (size == 1) {
            T result = tail.value;
            head = null;
            tail = null;
            size--;
            return result;
        } else if (size > 1) {
            Node<T> currentNode = head;

            while (currentNode != null) {
                if (currentNode.next == tail) {
                    T result = tail.value;
                    currentNode.next = null;
                    tail = currentNode;
                    size--;
                    return result;
                }
                currentNode = currentNode.next;
            }
        }
        return null; // todo: throw exception
    }

    /**
     * Returns the item at the end of the LinkedList.
     *
     * @return The value of the node at the end of the LinkedList.
     */
    public T getLast() {
        if (size > 0)
            return tail.value;
        return null;
    }

    /**
     * Compares two lists and returns a boolean denoting the result of the comparison.
     *
     * @param o The LinkedList to be compared with the current LinkedList.
     * @return `true` if the lists are equal. Otherwise, returns `false`.
     */
    public boolean equals(Object o) {
        if (o instanceof LinkedList)
            return toString().equals(o.toString());
        else
            return false;
    }

    /**
     * Inserts the specified element into the queue.
     *
     * @param e the element to add
     */
    public void offer(T e) {
        addLast(e);
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns `null` if this queue is empty.
     *
     * @return the head of this queue, or `null` if this queue is empty
     */
    public T poll() {
        return remove();
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns `null` if this queue is empty.
     *
     * @return the head of this queue, or `null` if this queue is empty
     */
    public T peek() {
        return getLast();
    }
}
