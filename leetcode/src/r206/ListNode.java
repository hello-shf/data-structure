package r206;

/**
 * 描述：leetcode - 206 链表反转
 *
 * @Author shf
 * @Date 2019/7/24 14:09
 * @Version V1.0
 **/

public class ListNode {
    int val;
    public ListNode next;
    ListNode(int x) {
        this.val = x;
    }
    public ListNode(int[] arr){

        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1 ; i < arr.length ; i ++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

class Solution {
    /**
     * 链表反转 - 递归
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode temp = head.next;
        ListNode node = reverseList(head.next);
        head.next = null;
        temp.next = head;
        return node;
    }

    /**
     * 链表反转 - 循环
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head){
        ListNode preHead = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = preHead;
            preHead = head;
            head = temp;
        }
        return preHead;
    }
    // 1->2->3->4-null          return:
    //    2->3->4-null
    //       3->4-null                  4-null
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
//        ListNode newList = reverseList(listNode);
        ListNode newList = reverseList1(listNode);
        System.out.println(newList);

    }
}
