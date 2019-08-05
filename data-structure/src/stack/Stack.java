package stack;

public interface Stack<E> {
    /**
     * 获取栈 size
     * @return
     */
    int getSize();

    /**
     * 判断当前栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 压栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 获取栈首元素
     * @return
     */
    E peek();
}
