import java.util.*;


//maxDepth using recursion(topdown and bottomup) and iteration (use stack) and bfs (use queue). 
class MaxDepth {

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode (int x) {val = x;}
	}

	static class Pair {
		TreeNode node;
		int level;
		Pair(TreeNode node, int level) {this.node = node; this.level = level;}
	}

	static int maxDepth_topdown(TreeNode root) {
		int[] res = new int[1];
		maxDepth_topdown_helper(root, 0, res);
		return res[0];
	}
	static void maxDepth_topdown_helper(TreeNode root, int curLevel, int[] res) {
		if (root == null) {res[0] = Math.max(res[0], curLevel); return;}
		maxDepth_topdown_helper(root.left, curLevel + 1, res);
		maxDepth_topdown_helper(root.right, curLevel + 1, res);
	}

	static int maxDepth_bottomup(TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth_bottomup(root.left), maxDepth_bottomup(root.right)) + 1;
	}

	static int maxDepth_iteration(TreeNode root) {
		int depth = 0; 
		Deque<Pair> stack = new ArrayDeque<>();
		stack.push(new Pair(root, 0));

		while(!stack.isEmpty()) {
			Pair curPair = stack.pop();
			TreeNode curNode = curPair.node;
			int curLevel = curPair.level;
			
			if (curNode == null ) {
				depth = Math.max(depth, curLevel);
			} // if (curNode == null) do this? similar to updating res only at null nodes as in topdown method?
			else {
				stack.push(new Pair(curNode.right, curLevel + 1));
				stack.push(new Pair(curNode.left, curLevel + 1));
			}
		}
		return depth;
	}

	static int maxDepth_bfs(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new ArrayDeque<>();
		int depth = 0; 
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			depth++;
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.remove();
				if (cur.left != null) queue.add(cur.left);
				if (cur.right != null) queue.add(cur.right);
			}
		}
		return depth;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		Jren.p("recursive topdown: " + maxDepth_topdown(root));
		Jren.p("recursive bottomup: " + maxDepth_bottomup(root));
		Jren.p("iteration: " + maxDepth_iteration(root));
		Jren.p("BFS: " + maxDepth_bfs(root));
	}

}
