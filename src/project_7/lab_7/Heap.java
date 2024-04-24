/*
File Name:   Heap.java
Author:      Francis O'Hara
Date:        4/23/24
Description: Heap class for implementing a priority queue.
How to Run:  N/A
*/
package project_7.lab_7;

import java.util.Comparator;
import java.util.ArrayList;

public class Heap<T> implements PriorityQueue<T> {
    /**
     * Comparator for comparing elements in the heap.
     */
    private Comparator<T> comparator;

    /**
     * ArrayList that stores the data in the heap.
     */
    private ArrayList<T> heap;

    /**
     * Creates a Heap object with the given comparator.
     * The heap will either be a min-heap or max-heap depending on the value of the `maxHeap` parameter.
     *
     * @param comparator A comparator for comparing items stored in the heap.
     * @param maxHeap    A boolean indicating the type of max-Heap. If `true` a max-heap will be created. Otherwise, a min-heap will be created.
     */
    public Heap(Comparator<T> comparator, boolean maxHeap) {
        heap = new ArrayList<T>();

        if (maxHeap) {
            this.comparator = new Comparator<T>() {
                @Override
                public int compare(T obj1, T obj2) {
                    return -1 * comparator.compare(obj1, obj2);
                }
            };
        } else
            this.comparator = comparator;

    }

    public Heap(Comparator<T> comparator) {
        this(comparator, false);
    }

    /**
     * Swaps the data at `index1` and `index2`.
     *
     * @param index1 index whose data will be swapped with data at `index2`
     * @param index2 index whose data will be swapped with the data at `index1`
     */
    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    /**
     * Returns the index of the parent.
     *
     * @param index
     * @return The index of the parent of the item at `index`.
     */
    private int getParentIdx(int index) {
        if (index % 2 == 0) {
            return (index / 2) - 1;
        } else
            return (index / 2);
    }

    /**
     * Returns the index of the left child.
     *
     * @param index The index whose left child's index is to be returned.
     * @return an integer denoting the index of the left child of `index`.
     */
    private int getLeftChildIdx(int index) {
        return (index * 2) + 1;
    }

    /**
     * Returns the index of the right child.
     *
     * @param index The index whose right child's index is to be returned.
     * @return an integer denoting the index of the right child of `index`.
     */
    private int getRightChildIdx(int index) {
        return (index * 2) + 2;
    }

    /**
     * Recursively ensures the item at index `index` is at its appropriate position in the heap by shifting up.
     *
     * @param index An integer denoting the index of the item to be bubbled up in the heap.
     */
    private void bubbleUp(int index) {
        if (index == 0)
            return;
        if (comparator.compare(heap.get(index), heap.get(getParentIdx(index))) > 0) {
            swap(index, getParentIdx(index));
            bubbleUp(getParentIdx(index));
        }
    }

    /**
     * Recursively ensures the item at index `index` is at its appropriate position in the heap by shifting down.
     *
     * @param index An integer denoting the index of the item to be bubbled down in the heap.
     */
    private void bubbleDown(int index) {
        boolean leftChildExists = getLeftChildIdx(index) < heap.size();
        boolean rightChildExists = getRightChildIdx(index) < heap.size();
        if (leftChildExists && rightChildExists) {
            if (comparator.compare(heap.get(getLeftChildIdx(index)), heap.get(index)) < 0) {
                if (comparator.compare(heap.get(getRightChildIdx(index)), heap.get(index)) < 0) {
                    if (comparator.compare(heap.get(getLeftChildIdx(index)), heap.get(getRightChildIdx(index))) < 0) {
                        swap(index, getLeftChildIdx(index));
                        bubbleDown(getLeftChildIdx(index));
                    } else {
                        swap(index, getRightChildIdx(index));
                        bubbleDown(getRightChildIdx(index));
                    }
                } else {
                    swap(index, getLeftChildIdx(index));
                    bubbleDown(getLeftChildIdx(index));
                }
            } else if (comparator.compare(heap.get(getRightChildIdx(index)), heap.get(index)) < 0) {
                swap(index, getRightChildIdx(index));
                bubbleDown(getRightChildIdx(index));
            }
        } else if (leftChildExists && !(rightChildExists)) {
            if (comparator.compare(heap.get(getLeftChildIdx(index)), heap.get(index)) < 0)
                swap(index, getLeftChildIdx(index));
        }
    }

    /**
     * Returns a textual representation of the heap.
     *
     * @return A string of text that represents the heap.
     */
    public String toString() {
        int depth = 0 ;
        return toString( 0 , depth );
    }

    /**
     * Recursive helper method for the public toString() method.
     *
     * @param idx Current index.
     * @param depth Current depth.
     * @return A String denoting a textual representation of a piece of the heap.
     */
    private String toString( int idx , int depth ) {
        if (idx >= this.size() ) {
            return "";
        }
        String left = toString(getLeftChildIdx( idx ) , depth + 1 );
        String right = toString(getRightChildIdx( idx ) , depth + 1 );

        String myself = "\t".repeat(depth) + this.heap.get( idx ) + "\n";
        return right + myself + left;
    }

    /**
     * Returns the size of the heap.
     *
     * @return An integer denoting the size of the heap.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Returns the item of highest priority in the heap.
     *
     * @return The item of highest priority in the heap.
     */
    public T peek() {
        return heap.getFirst();
    }

    /**
     * Adds the specified item into the heap.
     *
     * @param item the item to add to the heap.
     */
    public void offer(T item){
        heap.add(item);
        bubbleUp(heap.size() - 1);
    }

    /**
     * Returns and removes the item of highest priority in the heap.
     *
     * @return The item of highest priority.
     */
    public T poll() {
        T result = heap.getFirst();
        heap.set(0, heap.getLast());
        heap.removeLast();
        bubbleDown(0);
        return result;
    }

    /**
     * Updates the priority of the given item.
     *
     * T item The item whose priority is to be updated.
     */
    public void updatePriority(T item){

    }
}
