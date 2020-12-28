import java.util.Stack;

/**
 * @author yym
 * @date 2020/12/28
 * @title 20. 有效的括号：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。有效字符串需满足：
 *                       左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。注意空字符串可被认为是有效字符串。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 栈
 */

public class valid_parentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && (!stack.isEmpty()) && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == ']' && (!stack.isEmpty()) && stack.peek() == '[') {
                stack.pop();
            } else if (s.charAt(i) == '}' && (!stack.isEmpty()) && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
