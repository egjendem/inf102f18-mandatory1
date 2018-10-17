package no.uib.ii.inf102.f18.mandatory1;

import java.util.NoSuchElementException;

class NewStack<T> {
    private Node<T> head = null;
    private int size = 0;

    class Node<E> {
        private E data;
        private Node next = null;

        Node(E i) {
            data = i;
        }

        public void setNext(Node n) {
            next = n;
        }

        public void addData(E d) {
            data = d;
        }

        public E getData() {
            return data;
        }
    }

    public boolean empty() {
        if (head != null) {
            return false;
        }

        return true;
    }

    public T pop() {
        Node<T> tmp = head;
        Node<T> prev = null;

        if (tmp != null) {
            while (tmp.next != null) {
                prev = tmp;
                tmp = tmp.next;
            }

            prev.next = null;
            size--;
            return tmp.getData();
        }

        return null;
    }

    public T peek() {
        Node<T> tmp = head;

        if (head != null) {
            while (tmp.next != null) {
                tmp = tmp.next;
            }

            return tmp.getData();
        }

        return null;
    }

    public void push(T item) {
        if (head != null) {
            Node<T> n = new Node<>(item);
            n.next = head;
            head = n;
            size++;
        }
    }

    public int getSize() {
        return size;
    }


    @Override
    public class Iterator<Item> iterator() {
        return new StackIterator<Item>(top);
    }

    private class StackIterator<Item> implements no.uib.ii.inf102.f18.mandatory1.Iterator<Item> {
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
}

