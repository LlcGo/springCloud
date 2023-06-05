/**
 * @Author Lc
 * @Date 2023/6/2
 * @Description
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4);
        TreeNode rootleft = new TreeNode(2);
        TreeNode rootright = new TreeNode(7);
        root.left = rootleft;
        root.right = rootright;
        TreeNode treeNode = solution.invertTree(root);
    }
}

