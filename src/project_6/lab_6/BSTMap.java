/*
File Name:   BSTMap.java
Author:      Francis O'Hara
Date:        4/9/24
Description: A Binary Search tree that maps a set of keys to specific values.
How to Run:  N/A
*/
package project_6.lab_6;

import java.util.ArrayList;
import java.util.Comparator;

public class BSTMap<K, V> implements MapSet<K, V> {
    /**
     * A node in the Binary Search Tree.
     *
     * @param <K> The datatype of the key stored in each node.
     * @param <V> The datatype of the value stored in each node.
     */
    public static class Node<K, V> extends KeyValuePair<K, V> {
        /**
         * A reference to the left node the current node in the tree.
         */
        Node<K, V> leftChild;

        /**
         * A reference to the right node of the current node in the tree.
         */
        Node<K, V> rightChild;

        /**
         * Creates a new node in the tree.
         *
         * @param key   The key stored in the node.
         * @param value The value stored in the node.
         */
        public Node(K key, V value) {
            super(key, value);
            leftChild = null;
            rightChild = null;
        }
    }

    /**
     * The root node of the tree.
     */
    Node<K, V> root;

    /**
     * The number of nodes in the tree.
     */
    int size;

    /**
     * Comparator for organizing the nodes in the tree according to their keys.
     */
    Comparator<K> comparator;

    /**
     * Creates a new Binary Search Tree with the specified comparator.
     * If `comparator` is null, the keys of the tree are assumed to be of comparable type and are used to construct a
     * new comparator for the tree.
     *
     * @param comparator The comparator to be used for comparing the keys in the tree.
     */
    public BSTMap(Comparator<K> comparator) {
        if (comparator != null)
            this.comparator = comparator;
        else
            this.comparator = new Comparator<K>() {
                @Override
                public int compare(K o1, K o2) {
                    return ((Comparable<K>) o1).compareTo(o2);
                }
            };
    }

    /**
     * Creates a new Binary Search Tree.
     * Calls the previous constructor with `comparator` as null.
     */
    public BSTMap() {
        this(null);
    }

    /**
     * Returns a textual representation of the tree.
     *
     * @return A String representing the state of the tree.
     */
    public String toString() {
        return this.toString(this.root, 0);
    }

    /**
     * Recursive helper method for the public `toString()` method.
     *
     * @param cur      The current root node.
     * @param curDepth The current height of the tree.
     * @return A String.
     */
    private String toString(Node cur, int curDepth) {
        if (cur == null) {
            return "";
        } else { //Ordering of these call matters for it to be sorted
            String output = this.toString(cur.leftChild, curDepth + 1);
            output += "\t".repeat(curDepth) + cur.toString() + "\n";
            output += this.toString(cur.rightChild, curDepth + 1);
            return output;
        }
    }

    /**
     * Returns the number of nodes in the tree.
     *
     * @return An integer denoting the number of nodes in the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Resets all the fields in the tree to their default values.
     */
    public void clear() {
        size = 0;
        root = null;
        comparator = null;
    }

    /**
     * Associates the specified value with the specified key in the map.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return The previous value associated with the key or `null` if there was no mapping for key.
     */
    public V put(K key, V value) {
        if (root != null)
            return put(key, value, root);
        root = new Node<K, V>(key, value);
        return null;
    }

    /**
     * Recursive helper method for the public put() method.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @param cur   The current node in the recursion.
     * @return The previous value associated with the key or `null` if there was no mapping for key.
     */
    private V put(K key, V value, Node<K, V> cur) {
        if (comparator.compare(key, cur.getKey()) < 0) {
            if (cur.leftChild != null) {
                return put(key, value, cur.leftChild);
            } else {
                cur.leftChild = new Node<K, V>(key, value);
                return null;
            }
        } else if (comparator.compare(key, cur.getKey()) > 0) {
            if (cur.rightChild != null) {
                return put(key, value, cur.rightChild);
            } else {
                cur.rightChild = new Node<K, V>(key, value);
                return null;
            }
        } else { // in this case, cur.getKey() == key
            cur.setValue(value);
            return null;
        }
    }

    /**
     * Returns the value to which the specified key is mapped.
     *
     * @param key the key whose associated value is to be returned
     * @return The value of the node in the tree that has the specified key.
     */
    public V get(K key) {
        if (root != null)
            return get(key);
        return null;
    }

    /**
     * Recursive helper method for the get() method.
     * @param key The target key.
     * @param cur The current node in the recursion.
     * @return null if no such key exists or the value of the node that has the key otherwise.
     */
    private V get(K key, Node<K, V> cur){
        if (comparator.compare(key, cur.getKey()) < 0){
            if (cur.leftChild != null)
                return get(key, cur.leftChild);
            else
                return null;
        }
        else if (comparator.compare(key, cur.getKey()) > 0) {
            if (cur.rightChild != null)
                return get(key, cur.rightChild);
            else
                return null;
        }
        else
            return cur.getValue();
    }

    /**
     * Returns true if the map contains a mapping for the specified key to a value.
     *
     * @param key The key whose presence in this map is to be tested
     * @return A boolean indicating whether or not `key` exists in the map.
     */
    public boolean containsKey(K key){
        return true;
    }

    /**
     * Removes the mapping for a key from this map if it is present. More formally,
     * if this map contains a mapping from key {@code k} to value {@code v} such
     * that {@code key.equals(k)}, that mapping is removed. (The map can contain at
     * most one such mapping.)
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     */
    public V remove(K key){
        return null;
    };

    /**
     * Returns an ArrayList of all the keys in the map.
     *
     * @return an ArrayList of all the keys in the map.
     */
    public ArrayList<K> keySet(){
        return null;
    };

    /**
     * Returns an ArrayList of all the values in the map in the same order as the
     * keys as returned by keySet().
     *
     * @return an ArrayList of all the values in the map in the same order as the
     *         keys as returned by keySet().
     */
    public ArrayList<V> values(){
        return null;
    };

    /**
     * Returns an ArrayList of each {@code KeyValuePair} in the map in the same
     * order as the keys as returned by keySet().
     *
     * @return an ArrayList of each {@code KeyValuePair} in the map in the same
     *         order as the keys as returned by keySet().
     */
    public ArrayList<KeyValuePair<K, V>> entrySet(){
        return null;
    };

    /**
     * Returns the maximal number of iterations to find any particular element of
     * the Map.
     *
     * @return
     */
    public int maxDepth(){
        return 0;
    };
}