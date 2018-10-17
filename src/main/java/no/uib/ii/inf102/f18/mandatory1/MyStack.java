package no.uib.ii.inf102.f18.mandatory1;

import java.awt.event.ItemEvent;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MyStack is a simplified implementation of the java Stack utility.
 *
 * @author Amalie Rovik
 */
public class MyStack<Item extends Comparable<Item>> implements Iterable<Item> {
    private Node<Item> top; // stack top
    private int count;

    public static class Node<Item> {
        private Item item;
        private Node<Item> getNext;
    }

    /**
     * initialize the stack properties.
     * Empty stack
     */
    public MyStack(int size) {
        top = null;
        count = 0;
    }

    /**
     * Push an element of type T into the stack.
     *
     * @param d Data of type T
     */

    /*
    public void push(T d) {
        Node<T> node = new Node<>(d);

        if (!isEmpty()) {
            node.setNext(top);
            top = node;
        } else {
            top = node;
        }

        count++;
    }*/

    public void push(Item d) {
        if(isEmpty()) throw new NoSuchElementException();
        Node<Item> initFirst = top;
        top = new Node<Item>();
        top. = ;
        top.getNext = initFirst;
        count++
        Node<Item> node = new Node<>(d);


    }

    /**
     * Takes the top node an removes it from the
     * stack and returns the contained data.
     *
     * @return Node's data
     */
    public Item pop() {
        Node<Item> tmp;

        if (!isEmpty()) {
            tmp = top;
            top = top.getNext();
            count--;
            //return tmp.getData();
        }

        return null;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = top.item;
        top = top.getNext;
        count--;
        return item;
        }
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
     * @return Iterator
     */
    /*
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
    */
    /**
     * This Node class will represent a node object in an MyStack instance.
     *
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


public class Iterator<Item> iterator() {
    return new StackIterator<Item>(top);
    }

private class StackIterator<Item> implements Iterator<Item> {
    private MyStack.Node<Item> current = top;

    public StackIterator(MyStack.Node<Item> top) {
        current = top;
    }

    public booleanhasNext() {
        return current != null;
    }

    public Item next() {
        if (!hasNext()) throw new NoSuchElementException();
        Item item = current.item;
        current = current.getNext;
        return item;
    }
}