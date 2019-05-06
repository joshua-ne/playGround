
import java.util.*;

public class LC2 {
    public TreeNode bstToGst(TreeNode root) {
        List<TreeNode> nodes = getAllNodesInorder(root);
        Collections.reverse(nodes);
        int curSum = 0;
        for (TreeNode n : nodes) {
            curSum += n.val;
            n.val = curSum;
        }
        return root;

    }

    List<TreeNode> getAllNodesInorder(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;

        res.addAll(getAllNodesInorder(root.left));
        res.add(root);
        res.addAll(getAllNodesInorder(root.right));
        return res;
    }














	public static void main(String[] args) {
		
	}

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
