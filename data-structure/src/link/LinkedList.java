package link;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/18 16:45
 * @Version V1.0
 **/
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e, null);
        }
        public Node(){
            this(null, null);
        }
    }
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }
    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在 index 位置添加新元素
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("添加失败，Index 参数不合法");
        }
        Node prev = dummyHead;// TODO 不理解这一行就是没有理解java中引用的含义
        for(int i=0; i< index; i++){
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 在链表头添加元素
     * @param e
     */
    public void addFirst(E e){
        this.add(0, e);
    }

    /**
     * 在链表尾添加元素
     * @param e
     */
    public void addLast(E e){
        this.add(size, e);
    }

    /**
     * 获取链表的第index个位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("获取失败，Index 参数非法");
        }
        Node cur = dummyHead.next;
        for(int i=0; i< index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取头元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取尾元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改 index 位置的元素 e
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("操作失败，Index 参数不合法");
        }
        Node cur = this.dummyHead.next;
        for(int i=0; i< index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否存在元素 e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        for(int i=0; i<size; i++){
            if(cur.e == e){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表 index 位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("操作失败，Index 参数不合法");
        }
        Node prev = dummyHead;
        for(int i=0; i< index; i++){
            prev = prev.next;
        }
        Node rem = prev.next;
        prev.next = rem.next;
        rem.next = null;// 看不懂这行就是还没理解链表
        size--;
        return rem.e;
    }

    /**
     * 删除第一个
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }
    public void reverseList(){
        reverseList(dummyHead);
    }
    public Node reverseList(Node root){
        if(root.next == null){
            return root;
        }
        Node node = reverseList(root.next);
        root.next.next = root;
        root.next = null;
        return node;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("NULL");
        res.append("----size=" + size);
        return res.toString();
    }
}














