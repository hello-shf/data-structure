package link;


/**
 * 描述：递归实现版
 *
 * @Author shf
 * @Date 2019/7/26 17:04
 * @Version V1.0
 **/
public class LinkedListR<E> {
    private class Node{
        private Node next;
        private E e;
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
        @Override
        public String toString(){
            return e.toString();
        }
    }
    private Node dummyHead;
    private int size;
    public LinkedListR(){
        this.dummyHead = new Node();
        this.size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向 index 索引位置 添加元素 e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        add(index, e, dummyHead, 0);
    }

    /**
     * 向 index 索引位置 添加元素 e 递归实现
     * @param index 索引位置
     * @param e 要添加的元素 e
     * @param prev index 索引位置的前一个元素
     * @param n
     */
    private void add(int index, E e, Node prev, int n){
        if(index == n){
            size ++;
            prev.next = new Node(e, prev.next);
            return;
        }
        add(index, e, prev.next, n+1);
    }

    /**
     * 向链表 头 添加元素
     * @param e
     */
    public void addFirst(E e){
        this.add(0, e);
    }

    /**
     * 向链表 尾 添加元素
     * @param e
     */
    public void addLast(E e){
        this.add(this.size, e);
    }

    /**
     * 获取索引位置为 index 处的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index 参数非法");
        }
        return get(index, 0, dummyHead.next);
    }
    private E get(int index, int n, Node node){
        if(index == n){
            return node.e;
        }
        return get(index, (n + 1), node.next);
    }
    public E getFirst(){
        return this.get(0);
    }
    public E getLast(){
        return this.get(this.size - 1);
    }
    public boolean contains(E e){
        return contains(e, dummyHead.next);
    }
    private boolean contains(E e, Node node){
        if(node == null){
            return false;
        }
        if(node.e.equals(e)){
            return true;
        }
        return contains(e, node.next);
    }
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Index is illegal");
        }
        return remove(dummyHead, index, 0);
    }
    private E remove(Node prev, int index, int n){
        if(n == index){
            Node cur = prev.next;
            prev.next = cur.next;
            cur.next = null;
            return cur.e;
        }
        return remove(prev.next, index, (n + 1));
    }
    public E removeElement(E e){
        return removeElement(e, dummyHead);
    }

    private E removeElement(E e, Node prev){
        if(prev.next != null && e.equals(prev.next.e)){
            Node cur = prev.next;
            prev.next = cur.next;
            cur.next = null;
            return cur.e;
        }
        return removeElement(e, prev.next);
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
