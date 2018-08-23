package HomeWork4.Task4_2.part3;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by gaara on 4/24/17.
 */
public class MyDequeImpl<E>  implements MyDeque<E> {

    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    protected transient int modCount = 0;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public void addFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }

    @Override
    public void addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    @Override
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    @Override
    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    @Override
    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    @Override
    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> itr = first;
        while (itr != null) {
            if (itr.item.equals(o)) {
                return true;
            }
            itr = itr.next;
        }
        return false;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsAll(MyDeque<? extends E> deque) {
        if (deque.size() > this.size()) {
            return false;
        }
        E []deq = (E[])deque.toArray();
        for (E e : deq) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("{");
        E [] result = (E[]) new Object[size];
        int i=0;
        for (Node<E> x = first; x != null; x = x.next)
        {
            if(x != last)
            {
                sb.append(x.item).append(", ");
            }
            else
            {
                sb.append(x.item);
            }
        }
        return sb.append("}").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<E> {
        Node<E> actual = first;
        Node<E> justDeleted = null;
        int counter = 0;

        public boolean hasNext() {
            if (counter == size()) {
                return false;
            } else return true;
        }

        public E next() {
            E e = actual.item;
            actual = actual.next;
            justDeleted = null;
            counter++;
            return e;
        }


        public void remove() {
            if (counter == 0 || justDeleted != null) {
                throw new IllegalStateException();
            } else if (counter == 1) {
                removeFirst();
                counter--;
                if (counter < size) justDeleted = actual.prev;
            } else if (counter == size() - 1) {
                removeLast();
                counter--;
                justDeleted = actual.prev;
            } else {
                justDeleted = actual.prev;
                actual.prev = justDeleted.prev;
                actual.prev.prev.next = actual.prev.prev != null ? actual : null;
                size--;
                counter--;
            }
        }

    }

    public ListIterator<E> listIterator()
    {
        return new ListIteratorImpl();
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator<E>
    {
    Node<E> nextNode = first;
    Node<E> previousNode = last;
    Node<E> lastReturned = null;
    int vector = 0;

    int counter = 0;


    public boolean hasNext() {
        if (counter == size()) {
            return false;
        } else return true;
    }

    @Override
    public boolean hasPrevious() {
        if (counter == 0) {
            return false;
        } else return true;
    }


    public E next() {
        E e = nextNode.item;
        lastReturned = nextNode;
        previousNode = nextNode;
        nextNode = nextNode.next;
        vector = 1;
        counter++;
        return e;
    }

    @Override
    public E previous() {
        E e = previousNode.item;
        lastReturned = previousNode;
        nextNode = previousNode;
        previousNode = previousNode.prev;
        vector = -1;
        counter--;
        return e;
    }



    @Override
    public void set(E e)
    {
        if (lastReturned != null) {
            lastReturned.item = e;
        } else {
            throw new IllegalStateException();
        }

    }

    public void remove() {
        if (lastReturned == null) {
            throw new IllegalStateException();
        } else {
            if (vector == -1) {
                if (counter == 1) {
                    removeFirst();
                    previousNode = null;
                } else if (counter == size() - 1) {
                    removeLast();
                    nextNode = null;
                } else {
                    previousNode = previousNode.prev;
                    nextNode.prev = previousNode;
                    previousNode.next = nextNode;
                }
            } else if (vector == 1) {
                if (counter == 1) {
                    removeFirst();
                    previousNode = null;
                } else if (counter == size() - 1) {
                    removeLast();
                    nextNode = null;
                } else {
                    nextNode = nextNode.next;
                    nextNode.prev = previousNode;
                    previousNode.next = nextNode;
                }
            }
            lastReturned = null;
            counter--;
        }
    }
    }
}
