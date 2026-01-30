package advanced.binarySearch;

public class BinarySearchTree {
    TreeNode root;

    // Insert the value to right or left
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if(root.data < value) {
            root.left = insertRec(root.left, value);
        } else if (root.data > value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

//    Search the value
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode root, int value) {
        if (root == null) return false;
        if (root.data == value) return true;

        if(root.data < value) {
           return searchRec(root.left, value);
        }
        return searchRec(root.right, value);
    }

//    Delete a value
    public void delete(int value) {
        root = deleteRec(root, value);
    }
    private TreeNode deleteRec(TreeNode root, int value) {
        if (root == null) return null;

        if (value < root.data) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.data) {
            root.right = deleteRec(root.right, value);
        } else {
//            case 1
            if(root.left== null  && root.right == null) {
                return null;
            }
//            case 2
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
//            case 3
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }
    private int minValue(TreeNode root) {
            int min = root.data;
            while (root.left != null) {
                min = root.left.data;
                root = root.left;
            }
            return min;
    }
//    In-order
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data + " ");
            inOrderRec(root.right);
        }
    }
//    Pre-order
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }
    private void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.println(root.data + " ");
            inOrderRec(root.left);
            inOrderRec(root.right);
        }
    }
//    Post-order
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }
    private void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.left);
            System.out.println(root.data + " ");
        }
    }
}
