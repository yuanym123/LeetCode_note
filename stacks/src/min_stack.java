import java.util.Stack;

/**
 * @author yym
 * @date 2020/12/28
 * @title 155. 最小栈：设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *                     push(x) —— 将元素 x 推入栈中。
 *                     pop() —— 删除栈顶的元素。
 *                     top() —— 获取栈顶元素。
 *                     getMin() —— 检索栈中的最小元素。
 * @complexity
 * @key 栈
 */
public class min_stack {
    Stack<Integer> num;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public min_stack() {
        num = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        num.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else if (min.peek() < x) {
            min.push(min.peek());
        } else {
            min.push(x);
        }
    }

    public void pop() {
        num.pop();
        min.pop();
    }

    public int top() {
        if (num.isEmpty()) {
            return -1;
        }
        return num.peek();
    }

    public int getMin() {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peek();
    }
}
