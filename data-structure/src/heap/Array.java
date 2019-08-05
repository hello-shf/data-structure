package heap;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/18 10:48
 * @Version V1.0
 **/
public class Array<E> {
    private final static int DEFAULT_SIZE = 10;

    private E[] data;
    private int size;

    public Array(int capacity){
        this.data = (E[])new Object[capacity];
        this.size = 0;
    }
    public Array(){
        this(DEFAULT_SIZE);
    }
    public Array(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i ++)
            data[i] = arr[i];
        size = arr.length;
    }
    /**
     * 获取容量
     * @return
     */
    public int getCapacity(){
        return this.data.length;
    }

    /**
     * 获取当前数组中的元素个数
     * @return
     */
    public int getSize(){
        return this.size;
    }

    /**
     * 判断当前数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * 在 index 的位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || this.size < index){ // TODO: ?
            throw new IllegalArgumentException("添加失败，要求参数index >= 0 并且 index <= size");
        }
        if(size == data.length){
            this.resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 向所有元素后添加一个新元素 e
     * @param e
     */
    public void addLast(E e){
        this.add(this.size, e);
    }

    /**
     * 向所有元素前添加一个元素 e
     * @param e
     */
    public void addFirst(E e){
        this.add(0, e);
    }

    /**
     * 获取 index 索引位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("获取失败，Index 参数不合法");
        }
        return this.data[index];
    }

    /**
     * 获取第一个
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个
     * @return
     */
    public E getLast(){
        return get(this.size - 1);
    }

    /**
     * 修改 index 元素位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("获取失败，Index 参数不合法");
        }
        this.data[index] = e;
    }

    /**
     * 查找数组中是否有元素 e
     * @param e
     * @return
     */
    public Boolean contains(E e){
        for (int i = 0; i< size; i++){
            if(this.data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for(int i=0; i< this.size; i++){
            if(this.data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定位置上的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || this.size <= index){
            throw new IllegalArgumentException("删除失败，Index 参数不合法");
        }
        E ret = this.data[index];
        for(int i=index+1; i< this.size; i++){
            data[i-1] = data[i];
        }
        size --;
        this.data[this.size] = null;
        if(size == this.data.length / 4 && this.data.length / 2 != 0){
            this.resize(this.data.length / 2);
        }
        return ret;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst(){
        return this.remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     * @return
     */
    public E removeLast(){
        return this.remove(this.size - 1);
    }

    /**
     * 删除指定的元素 e
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            this.remove(index);
        }
    }

    /**
     * 交换两个索引的元素
     * @param i
     * @param j
     */
    public void swap(int i, int j){
        if(i < 0 || i >= size || j < 0 || j >= size){
            throw new IllegalArgumentException("Index is illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /**
     * 将数组容量调整为 newCapacity 大小
     * @param newCapacity
     */
    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i< this.size; i++){
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
