package link;

/**
 * 描述：单向链表实现
 * 对应 java 集合类 linkedList
 *
 * @Author shf
 * @Date 2019/7/18 16:45
 * @Version V1.0
 **/

public class MyLinkedList<E> {
    /**
     * 私有的 Node
     */
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
        @Override
        public String toString(){
            return e.toString() + "-->" + next;
        }
    }
    private Node dummyHead;
    private int size;

    public MyLinkedList(){
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
     * 在 index 位置 添加元素
     * 时间复杂度：O（n）
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
     * 在链表头 添加元素
     * 时间复杂度：O（1）
     * @param e
     */
    public void addFirst(E e){
        this.add(0, e);
    }

    /**
     * 在链表尾 添加元素
     * 时间复杂度：O（n）
     * @param e
     */
    public void addLast(E e){
        this.add(size, e);
    }

    /**
     * 获取链表的第index个位置的元素
     * 时间复杂度：O（n）
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
     * 时间复杂度：O（1）
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取尾元素
     * 时间复杂度：O（n）
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改 index 位置的元素 e
     * 时间复杂度：O（n）
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
     * 时间复杂度：O（n）
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
        rem.next = null;// 看不懂这行就是还没理解链表。将rem断开与链表的联系。
        size--;
        return rem.e;
    }

    /**
     * 删除 头元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除 尾元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 链表反转
     */
    public void reverseList(){
        dummyHead.next = reverseList(dummyHead.next, 0);
    }
    public void reverseList1(){
        dummyHead.next = reverseList1(dummyHead.next);
    }
    private Node reverseList1(Node node){
        if(node.next == null){
            return node;
        }
        Node cur = reverseList1(node.next);
        node.next.next = node;
        node.next = null;
        return cur;
    }

    /**
     * 链表反转 - 递归实现
     * @param root
     * @return
     */
    private Node reverseList(Node root, int deap){
        System.out.println("递归深度==>" + deap);
        if(root.next == null){
            return root;
        }
        // 先记住 root 的next节点
        Node temp = root.next;
        // 递归 root 的next节点，并返回root的节点
        Node node = reverseList(root.next, (deap + 1));
        // 将 root 节点与链表断开连接
        root.next = null;
        // 让我们之前缓存的 root的下一个节点 指向 root节点，这样就实现了链表的反转
        temp.next = root;
        return node;
    }
    /**
     private Node reverseList(Node root, int deap){
        System.out.println("root ==> " + root);
        System.out.println("递归深度：" + deap);
        if(root.next == null){
            return root;
        }
        // 先记住 root 的next节点
        Node temp = root.next;
        System.out.println("缓存的当前节点的: temp ==> " + temp);
        // 递归 root 的next节点，并返回root的节点
        Node node = reverseList(root.next, (deap + 1));
        System.out.println("递归返回的节点: node ==> " + node);
        // 将 root 节点与链表断开连接
        root.next = null;
        // 让我们之前缓存的 root的下一个节点 指向 root节点，这样就实现了链表的反转
        temp.next = root;
        System.out.println("temp.next = root; 之后 temp ==>" + temp);
        return node;
    }
     */
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














