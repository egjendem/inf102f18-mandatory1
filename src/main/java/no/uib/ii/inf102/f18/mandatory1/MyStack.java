package no.uib.ii.inf102.f18.mandatory1;

import java.util.Iterator;

/**
 * MyStack is a simplified implementation of the java Stack utility.
 *
 * @author Amalie Rovik
 * @author Espen Gjendem
 */
public class MyStack<T> implements Iterable<T> {
    Node<T> top;
    int count;

    /**
     * initialize the stack properties.
     */
    MyStack() {
        top = null;
        count = 0;
    }

    /**
     * Push an element of type T into the stack.
     *
     * @param d Data of type T
     */
    public void push(T d) {
        Node<T> node = new Node<>(d);

        if (!isEmpty()) {
            node.setNext(top);
            top = node;
        } else {
            top = node;
        }

        count++;
    }

    /**
     * Takes the top node an removes it from the
     * stack and returns the contained data.
     *
     * @return Node's data
     */
    public T pop() {
        Node<T> tmp;

        if (!isEmpty()) {
            tmp = top;
            top = top.getNext();
            count--;
            return tmp.getData();
        }

        return null;
    }

    /**
     * Return the size of the stack.
     *
     * @return Int
     */
    public int size() {
        return count;
    }

    /**
     * Check if the stack is an empty set.
     *
     * @return Boolean
     */
    public boolean isEmpty() {
        return top == null ? true : false;
    }

    /**
     * Stack iterator singleton for simplicity.
     * Important notice! This will iterate from the top down and not
     * bottom up like the conventional way in Java.
     * Though it is common in other languages like
     * C and other lower level languages.
     *
     * @author Espen Gjendem
     * @return Iterator
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> n = null;
            int iteratorCount = 0;

            @Override
            public boolean hasNext() {
                return iteratorCount < size() ? true : false;
            }

            @Override
            public T next() {
                if (n == null && hasNext()) {
                    n = top;
                    iteratorCount++;
                    return n.getData();
                } else if (hasNext()) {
                    n = n.getNext();
                    iteratorCount++;
                    return n.getData();
                }

                return null;
            }
        };
    }

    /**
     * This Node class will represent a node object in an MyStack instance.
     *
     * @author Espen Gjendem
     * @param <E>
     */
    class Node<E> {
        private E data;
        private Node<E> next;

        Node(E d) {
            data = d;
            next = null;
        }

        public E getData() {
            return data;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public Node<E> getNext() {
            return next != null ? next : null;
        }
    }
}