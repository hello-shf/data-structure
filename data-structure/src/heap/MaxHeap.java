package heap;


/**
 * 描述：最大堆
 *
 * @Author shf
 * @Date 2019/7/29 10:13
 * @Version V1.0
 **/
public class MaxHeap<E extends Comparable<E>> {
    //使用数组存储
    private Array<E> data;
    public MaxHeap(){
        data = new Array<>();
    }
    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    /**
     * Heapify
     * @param arr
     */
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1); i >= 0; i --){
            siftDown(i);
        }
    }
    public int size(){
        return this.data.getSize();
    }
    public boolean isEmpty(){
        return this.data.isEmpty();
    }

    /**
     * 根据当前节点索引 index 计算其父节点的 索引
     * @param index
     * @return
     */
    private int parent(int index) {
        if(index ==0){
            throw new IllegalArgumentException("该节点为根节点");
        }
        return (index - 1) / 2;//这里为什么不分左右？因为java中 / 运算符只保留整数位。
    }

    /**
     * 返回索引为 index 节点的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index*2 + 1;
    }

    /**
     * 返回索引为 index 节点的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index*2 + 2;
    }

    /**
     * 向堆中添加元素
     * 时间复杂度 O（logn）
     * @param e
     */
    public void add(E e){
        // 向数组尾部添加元素
        this.data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮操作
     * 时间复杂度 O（logn）
     * @param k
     */
    private void siftUp(int k) {
        // 上浮，如果大于父节点，进行交换
        while(k > 0 && get(k).compareTo(get(parent(k))) > 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 获取 index 索引位置的元素
     * 时间复杂度 O（1）
     * @param index
     * @return
     */
    private E get(int index){
        return this.data.get(index);
    }

    /**
     * 查找堆中的最大元素
     * 时间复杂度 O（1）
     * @return
     */
    public E findMax(){
        if(this.data.getSize() == 0){
            throw new IllegalArgumentException("当前heap为空");
        }
        return this.data.get(0);
    }

    /**
     * 取出堆中最大元素
     * 时间复杂度 O（logn）
     * @return
     */
    public E extractMax(){
        E ret = findMax();
        this.data.swap(0, (data.getSize() - 1));
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 下沉操作
     * 时间复杂度 O（logn）
     * @param k
     */
    public void siftDown(int k){
        while(leftChild(k) < data.getSize()){// 从左节点开始，如果左节点小于数组长度，就没有右节点了
            int j = leftChild(k);
            if(j + 1 < data.getSize() && get(j + 1).compareTo(get(j)) > 0){// 选举出左右节点最大的那个
                j ++;
            }
            if(get(k).compareTo(get(j)) >= 0){// 如果当前节点大于左右子节点，循环结束
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出最大的元素，并替换成元素 e
     * 时间复杂度 O（logn）
     * @param e
     * @return
     */
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
