package high.不会的.优先遍历算法.二叉树;

import org.springframework.util.CollectionUtils;

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
 * @date Created in 2021年04月05日 09:06
 * @since 1.0
 */
public class 二叉树的路径和 {

    public class TreeNode {
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

    // 因为是求路劲和等于某个数，  所以最优解法是深度遍历， 直接使用前序遍历，然后每次都需要判断当前总值是否大于目标值
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<List<Integer>> all = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        getVal(root, targetSum, stack, all);


        // 遍历
        for (List<Integer> list : all) {
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            if (sum == targetSum) {
                return true;
            }
        }
        return false;
    }

    public void getVal(TreeNode root, int targetSum, Stack<Integer> stack, List<List<Integer>> all) {
        if (root == null) {
            return;
        }
        stack.add(root.val);
        // 判断当前节点是不是叶子节点
        if (root.left == null && root.right == null) {
            // 记录当前叶子节点的值
            if (!stack.isEmpty()) {
                List<Integer> list = new ArrayList<>(stack);
                all.add(list);
                stack.pop();
            }
            return;
        } else {
            getVal(root.left, targetSum, stack, all);
            getVal(root.right, targetSum, stack, all);
        }
        stack.pop();
    }
}
