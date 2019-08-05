package queue;


/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/18 15:34
 * @Version V1.0
 **/
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(){
        array = new Array<>();
    }

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    public int getCapacity(){
        return this.array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        this.array.addLast(e);
    }

    @Override
    public E dequeue() {
        return this.array.removeFirst();
    }

    @Override
    public E getFront() {
        return this.array.getFirst();
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
