package high.不会的.优先遍历算法.二叉树;

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
 * @date Created in 2021年04月04日 21:35
 * @since 1.0
 */
public class 二叉树的最大深度 {
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


    public int maxDepth(TreeNode root) {
        // 这里因为是找最大深度， 所以也是需要递归遍历到最左节点和最右节点   也是一次深度优先遍历(前序遍历)
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            // 获取当前节点的最大深度  深度都是0开始  然后+1
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
