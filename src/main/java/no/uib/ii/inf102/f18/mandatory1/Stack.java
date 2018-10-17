package no.uib.ii.inf102.f18.mandatory1;

        import java.util.Iterator;
        import java.util.NoSuchElementException;
        import java.util.Spliterator;
        import java.util.function.Consumer;

public class Stack<E> implements Iterable<E> {
    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.data = (E[]) new Object[size];
        this.size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    public E pop() {
        E item = data[--size];
        data[size] = null;
        return item;
    }

    public E peek() {
        return data[size - 1];
    }

    public void push(E item) {
        data[size++] = item;
    }

    public int getSize() {
        return data.length;
    }

    public void printPile() {
        String print = "";
        for (int i = 0; i < data.length; i++) {
            print += (data[i].toString());
        }
        System.out.println(print);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return peek()!=null;
            }

            @Override
            public E next() {
                if(hasNext()){
                    E nextEl = peek();
                    return nextEl;
                }
                else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}
