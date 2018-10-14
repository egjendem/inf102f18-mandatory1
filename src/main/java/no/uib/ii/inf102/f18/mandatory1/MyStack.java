package no.uib.ii.inf102.f18.mandatory1;

import java.util.Iterator;

/**
 * MyStack is a simplified implementation of the java Stack utility.
 * @author Amalie Rovik
 */
public class MyStack<T> implements Iterable {
    Node<T> head;
    Node<T> top;
    int count;

    /**
     * Run the constructor when an MyStack instance is created
     * and initialize the stack with top equal to null.
     */
    MyStack() {
        top = null;
        count = 0;
    }

    public void push(T d) {
        Node<T> node = new Node<>(d);

        if (!isEmpty()) {
            top.setNext(node);
            top = node;
        } else {
            head = node;
            top = node;
        }

        count++;
    }

    /**
     * Takes the outermost node an removes it from the
     * stack and returns the data contained inside the node.
     *
     * @return Node's data
     */
    public T pop() {
        Node<T> current = head;

        if (count > 1) {
            Node<T> prev = null;

            while (current.getNext() != null) {
                prev = current;
                current = current.getNext();
            }

            top = prev;
            top.next = null;
            count--;
            return current.getData();
        } else if (count == 1) {
            head = null;
            top = null;
            count--;
            return current.getData();
        }

        return null;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return top == null ? true : false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    /**
     * This Node class will represent a node object in an MyStack instance.
     * @author Amalie Rovik
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
            return next;
        }
    }

    /**
     * MyStackIterator is an inner class of MyStack which work
     * as an Iterator instance when iterator() is called.
     * @author Amalie Rovik
     * @param <T>
     */
    /* class MyStackIterator<T> implements Iterator<T> {
        Node<T> current = head;

        public boolean hasNext() {
            return current.getNext() != null ? true : false;
        }

        public T next() {
            Node<T> tmp = current;
            current = current.getNext();
            return tmp;
        }
    } */
}