import java.util.*;

public class ProblemE257BinaryTreePaths {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        dfs(root, new StringBuilder(), answer);
        return answer;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> answer) {
        if (node == null) return;
        int len = path.length();
        if (len > 0) path.append("->");
        path.append(node.val);
        if (node.left == null && node.right == null) {
            answer.add(path.toString());
        } else {
            dfs(node.left, path, answer);
            dfs(node.right, path, answer);
        }
        path.setLength(len);
    }
}
