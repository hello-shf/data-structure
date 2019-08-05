package queue;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/18 15:42
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args){

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
