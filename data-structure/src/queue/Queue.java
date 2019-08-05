package queue;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/18 15:30
 * @Version V1.0
 **/
public interface Queue<E> {
    /**
     * 获取当前队列的元素数
     * @return
     */
    int getSize();

    /**
     * 判断当前队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入队操作
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队操作
     * @return
     */
    E dequeue();

    /**
     * 获取队列头元素
     * @return
     */
    E getFront();
}
