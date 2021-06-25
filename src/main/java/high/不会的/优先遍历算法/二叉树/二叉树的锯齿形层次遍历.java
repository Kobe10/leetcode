package high.不会的.优先遍历算法.二叉树;

import java.util.*;

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
 * @date Created in 2021年04月05日 09:16
 * @since 1.0
 */
public class 二叉树的锯齿形层次遍历 {
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

    /**
     * 二叉树的层序遍历 升级版   锯齿形遍历
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 返回锯齿形层序遍历如下：
     * <p>
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 利用和层序遍历的思想类似，  再用一个层数的数字记录是奇数层还是偶数层   奇数层从左往右，偶数层从右往左
        // 因为有奇数偶数次序之分， 可以利用栈和queue来分别存储
        if (root == null) {
            return new ArrayList<>();
        }
        int level = 0;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            // 这里利用双端队列的特性，头尾都能插入值，这样可以解决奇数和偶数层情况下插入方向不一致的问题
            Deque<Integer> levelList = new LinkedList<>();
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                // 取头部  还是取尾部  奇数取头部，偶数取尾部
                TreeNode temp = queue.poll();
                if (temp == null)
                    continue;
                if (level % 2 == 0) {
                    levelList.offerFirst(temp.val);
                } else {
                    levelList.offerLast(temp.val);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(new ArrayList<>(levelList));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, null);
        TreeNode treeNode3 = new TreeNode(3, null, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        List<List<Integer>> result = zigzagLevelOrder(treeNode1);
        System.out.println(result.toString());
    }
}
