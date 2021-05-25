package online.cx.javabasic.leetcode.day.may;

import online.cx.javabasic.leetcode.utils.TreeNode;

/**
 * @author Cao Xin
 * @since 2021/5/17
 */
public class LeetCode17 {

    // x 的信息
    int x;
    TreeNode xParent;
    int xDepth;
    boolean xFound = false;

    // y 的信息
    int y;
    TreeNode yParent;
    int yDepth;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {return;}
        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        } else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }
        if (xFound && yFound) {
            return;
        }

        dfs(node.left, depth+1, node);
        if (xFound && yFound) {
            return;
        }
        dfs(node.right, depth+1, node);
    }

}
