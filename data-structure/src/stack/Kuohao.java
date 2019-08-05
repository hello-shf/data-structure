package stack;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/18 15:04
 * @Version V1.0
 **/
public class Kuohao {

    public boolean isValid(String ss){
        Stack<Character> stack = new ArrayStack<>();
        for(char c : ss.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if(topChar == '(' && c != ')'){
                    return false;
                } else if(topChar == '[' && c != ']'){
                    return false;
                } else if (topChar == '{' && c != '}'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println((new Kuohao()).isValid("()[]{}"));
        System.out.println((new Kuohao()).isValid("([)]"));
    }
}
