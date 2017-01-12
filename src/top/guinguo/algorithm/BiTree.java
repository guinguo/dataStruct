package top.guinguo.algorithm;

/**
 * Created by guin_guo on 2017/1/12.
 */
public class BiTree {
    private BiTNode root;

    public BiTree() {
    }

    public void setRoot(BiTNode root) {
        this.root = root;
    }

    public static void main(String[] args) {
        BiTree tree = new BiTree();
        BiTNode root = tree.BiTNode(10);
        tree.setRoot(root);
        tree.insert(root, 8);
        tree.insert(root,6);
        tree.insert(root,12);
        tree.insert(root,5);
        tree.insert(root,9);
//        System.out.println(tree.getRoot().data+","+tree.getRoot().right.data+","+tree.getRoot().left.data+","+tree.getRoot().left.left.data);
        tree.preOrderTraverse(root);
        System.out.println();
        tree.inOrdertraverse(root);
        System.out.println();
        tree.postOrdertraverse(root);
    }

    /**
     * Insert an node into the binary tree
     * @param root
     * @param data
     * @return
     */
    public boolean insert(BiTNode root, Integer data) {
        if (data == null) return false;
        if (root == null) return false;
        if (data < root.data) {
            if (root.left == null) {
                BiTNode node = new BiTNode(data);
                root.left = (node);
                return true;
            } else {
                return insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                BiTNode node = new BiTNode(data);
                root.right = (node);
                return true;
            } else {
                return insert(root.right, data);
            }
        }
    }

    /**
     * The preorder traverses the binary tree
     * @param root
     */
    public void preOrderTraverse(BiTNode root) {
        if (root.data != null)
            System.out.print(root.data + ",");
        if (root.left != null)
            preOrderTraverse(root.left);
        if (root.right != null)
            preOrderTraverse(root.right);
    }

    /**
     * Inorder traversal binary tree
     * @param root
     */
    public void inOrdertraverse(BiTNode root) {
        if (root.left != null)
            inOrdertraverse(root.left);
        if (root.data != null)
            System.out.print(root.data + ",");
        if (root.right != null)
            inOrdertraverse(root.right);
    }

    /**
     * Post-traversal of the binary tree
     * @param root
     */
    public void postOrdertraverse(BiTNode root) {
        if (root.left != null)
            postOrdertraverse(root.left);
        if (root.right != null)
            postOrdertraverse(root.right);
        if (root.data != null)
            System.out.print(root.data + ",");
    }

    /**
     * The preorder traverses the binary tree
     * Non-recursive implementation
     * @param root
     */
    public void preOrderTraverseNr(BiTNode root) {
        //TODO
    }

    /**
     * Inorder traversal binary tree
     * Non-recursive implementation
     * @param root
     */
    public void inOrdertraverseNr(BiTNode root) {
        //TODO
    }

    /**
     * Post-traversal of the binary tree
     * Non-recursive implementation
     * @param root
     */
    public void postOrdertraverseNr(BiTNode root) {
        //TODO
    }

    public BiTNode BiTNode(Integer data) {
        return new BiTNode(data);
    }

    class BiTNode{
        private Integer data;
        private BiTNode left;
        private BiTNode right;

        public BiTNode() {
            data = null;
            left = null;
            right= null;
        }

        public BiTNode(Integer data) {
            this.data = data;
            left = null;
            right= null;
        }

    }
}
