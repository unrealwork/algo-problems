package com.leetcode

import com.leetcode.helping.TreeNode

class FlattenTree {
  def flatten(root: TreeNode): Unit = {
    def iter(root: TreeNode, res: TreeNode): TreeNode = {
      if (root == null) {
        res
      } else {
        val pre = iter(root.left, iter(root.right, res))
        root.right = pre
        root.left = null
        root
      }
    }

    iter(root, null)
  }

}
