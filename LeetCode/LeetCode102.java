package LeetCode_Solution;

import binarytree.TreeNode;

/*
   LeetCode_102.二叉树层序遍历
 */
public class LeetCode102 {
    public static void main(String[] args) {
        /*
              1
             / \
            2    3
           / \  / \
          4  5  6  7

         */
        binarytree.TreeNode root = new binarytree.TreeNode(
                new binarytree.TreeNode(
                        new binarytree.TreeNode(4),
                        2,
                        new binarytree.TreeNode(5)
                ),
                1,
                new binarytree.TreeNode(
                        new binarytree.TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );
    }
}
