package high.不会的.优先遍历算法.二叉树;

import java.util.*;
import java.util.stream.Collectors;

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
 * @date Created in 2021年04月05日 09:14
 * @since 1.0
 */
public class 二叉树的所有路径 {
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

    // 二叉树的所有路径，这是典型的深度优先遍历，这里认为最佳采用中序遍历
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<String> stack = new Stack<>();
        getVal(root, result, stack);
        return result;
    }

    public static void getVal(TreeNode root, List<String> result, Stack<String> stack) {
        if (root == null) {
            // 这里就相当于走完一条路径了 把当前路径拼接起来，然后保存
            return;
        }
        // 当前节点入栈
        stack.add(String.valueOf(root.val));
        // 如果当前节点是叶子节点   末尾追加
        if (root.left == null && root.right == null) {
            if (!stack.isEmpty()) {
                List<String> temp = new ArrayList<>(stack);
                result.add(String.join("->", temp));
            }
            // 追加完之后将当前节点出栈
            stack.pop();
            return;
        } else {
            getVal(root.left, result, stack);
            getVal(root.right, result, stack);
        }
        // 当当前节点的左右子节点都遍历完毕，将当前节点出栈
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        List<String> result = binaryTreePaths(treeNode1);
        System.out.println(result.toString());
    }
}
