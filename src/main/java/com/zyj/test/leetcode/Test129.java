package com.zyj.test.leetcode;

/**
 * @author zhongyj
 * @since 2021-04-17 11:52
 */
public class Test129 {
    public static void main(String[] args) {

    }
    public int sumNumbers(TreeNode root) {
        int result = 0;
        result = dfs(root, result);
        return result;
    }

    public int dfs(TreeNode root, int result) {
        if (root.left == null && root.right == null) {
            return result + root.val;
        }
        result += result * 10 + root.val;
        int left = dfs(root.left, result);
        int right = dfs(root.right, result);
        return left + right;
    }

    private static class TreeNode {
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
}
