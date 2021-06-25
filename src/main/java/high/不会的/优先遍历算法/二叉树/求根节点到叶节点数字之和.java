package high.不会的.优先遍历算法.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @Desc
 * @date Created in 2021年04月05日 15:49
 * @since 1.0
 */
public class 求根节点到叶节点数字之和 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumNumbers(TreeNode root) {
        // 第一步 先是查询出所有的路径
        if (root == null) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        getVal(root, stack, result);
        int sum = 0;
        for (String list : result) {
            // 多个字符串的大数相加   或者这里可以尝试直接转换为Integer  然后累加
            sum+= Integer.parseInt(list);
        }

        return sum;
    }

    public void getVal(TreeNode root, Stack<String> stack, List<String> result) {
        if (root == null) {
            return;
        }
        stack.add(String.valueOf(root.val));
        // 判断当前节点是不是叶子节点
        if (root.left == null && root.right == null) {
            // 将栈转换为lis
            if (!stack.isEmpty()) {
                List<String> list = new ArrayList<>(stack);
                String temp = String.join("", list);
                result.add(temp);
                stack.pop();
            }
            return;
        } else {
            getVal(root.left, stack, result);
            getVal(root.right, stack, result);
        }
        stack.pop();
    }

    // 字符串大数相加

}
