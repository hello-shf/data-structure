package heap;
/**
 * 描述：优先队列
 *
 * @Author shf
 * @Date 2019/7/18 17:31
 * @Version V1.0
 **/
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize(){
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront(){
        // 获取队列的头元素，在最大堆中就是获取堆顶元素
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e){
        // 压栈 直接向最大堆中添加，让最大堆的add方法维护 元素的优先级
        maxHeap.add(e);
    }

    @Override
    public E dequeue(){
        // 出栈 将最大堆的堆顶元素取出
        return maxHeap.extractMax();
    }
}
