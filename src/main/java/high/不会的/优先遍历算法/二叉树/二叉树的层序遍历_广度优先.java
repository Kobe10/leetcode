package high.不会的.优先遍历算法.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 * @date Created in 2021年03月31日 17:52
 * @since 1.0
 */
public class 二叉树的层序遍历_广度优先 {

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


    public List<List<Integer>> levelOrder(TreeNode root) {
        // 二叉树的层序遍历  广度优先算法
        // 每次都需要记住上一层的所有的树节点(用队列接住，优先队列)， 然后每次去遍历队列中的树节点，然后出队里，同事将当前节点的左右节点加入队列中
        // 队列是FIFO的，所以可以依次打印出来

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 记录每一层的数值
            List<Integer> level = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    level.add(temp.val);
                    if (temp.left != null)
                        queue.add(temp.left);
                    if (temp.right != null)
                        queue.add(temp.right);
                }


            }
            result.add(level);
        }
        return result;
    }
}
