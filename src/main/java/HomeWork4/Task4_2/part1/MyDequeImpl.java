package HomeWork4.Task4_2.part1;

import java.util.NoSuchElementException;

/**
 * Created by gaara on 4/24/17.
 */
public class MyDequeImpl <E>  implements MyDeque<E> {

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
}
