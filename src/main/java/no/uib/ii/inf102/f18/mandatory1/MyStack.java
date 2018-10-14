package no.uib.ii.inf102.f18.mandatory1;

import java.util.Iterator;

/**
 * MyStack is a simplified implementation of the java Stack utility.
 * @author Amalie Rovik
 */
public class MyStack<T> /* implements Iterable */ {
    Node<T> head, tail;
    int count = 0;

    /**
     * Run the constructor when an MyStack instance is created
     * and initialize the stack with head/tail equal to null.
     */
    MyStack() {
        head = null;
        tail = null;
    }

    public void add(T d) {
        Node<T> node = new Node<>(d);

        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
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
            Node<T> former = null;

            while (current != tail) {
                former = current;
                current = current.getNext();
            }

            tail = former;
            count--;
            return current.getData();
        } else if (count == 1) {
            head = null;
            count--;
            return current.getData();
        }

        return null;
    }

    public int getCount() {
        return count;
    }

    public Node<T> getHeadNode() {
        return head;
    }

    public boolean isEmpty() {
        return head == null ? true : false;
    }

    /* public MyStackIterator<T> iterator() {
        return null;
    } */

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

        public void setNextToNull() {
            next = null;
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