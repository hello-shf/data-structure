package stack;


/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/18 14:19
 * @Version V1.0
 **/
public class ArrayStack<E> implements Stack<E> {
    Array<E> array;
    public ArrayStack(){
        array = new Array<>();
    }
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }
    @Override
    public int getSize() {
        return this.array.getSize();
    }

    public int getCapacity(){
        return this.array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public void push(E e) {
        this.array.addLast(e);
    }

    @Override
    public E pop() {
        return this.array.removeLast();
    }

    @Override
    public E peek() {
        return this.array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
