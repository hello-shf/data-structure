package queue;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/18 16:02
 * @Version V1.0
 **/
public class LoopQueue<E> implements Queue<E> {

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}
