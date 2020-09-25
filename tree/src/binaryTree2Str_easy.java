/**
 * @author yym
 * @date 2020/09/25
 * @title 606.根据二叉树创建字符串：你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。空节点则用一对
 *                                 空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号
 *                                 对。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 */
public class binaryTree2Str_easy {
    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }
}
