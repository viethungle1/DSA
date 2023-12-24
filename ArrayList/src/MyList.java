import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] element;
    public MyList(){
        element = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        element = new Object[capacity];
    }
    private void ensureCapacity(){
        int newSize = element.length * 2;
        element = Arrays.copyOf(element,newSize);
    }
    private void checkIndex(int index){
        if(index < 0 || index>=size()){
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
    }
    public void add(int index, E data){
        while (index<element.length){
            ensureCapacity();
        }
        for (int i = element.length-1; i > index ; i--) {
            element[i] = element [i-1];
        }
        element[index] = data;
        size++;
    }
    public int size(){
        return size;
    }
    public E remote(int index){
        checkIndex(index);
        E e = (E) element[index];
        for (int i = index; i < element.length; i++) {
            element[index] = element[i+1];
        }
        element[size-1] = null;
        size--;
        return e;
    }
    public E clone(){
        E newArr;
        newArr = (E)Arrays.copyOf(element, size);
        return newArr;
    }
    public boolean contains(E o){
        for (int i = 0; i < size; i++)
            if (o.equals(element[i]))
                return true;
        return false;
    }
    public int indexOf(E o){
        for (int i = 0; i < size; i++)
            if (o.equals(element[i])) return i;
        return -1;
    }
    public boolean add(E e){
        return true;
    }
    public E get(int i){
        return (E)element[i];
    }
    public void clear(){
        element = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
