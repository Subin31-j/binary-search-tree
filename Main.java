package advanced.binarySearch;


public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order: ");
        tree.inOrder();
        System.out.println("Pre-order: ");
        tree.preOrder();
        System.out.println("Post-order: ");
        tree.postOrder();

        System.out.println("Search 20: " + tree.search(20));
        System.out.println("Search 50: " + tree.search(50));

        System.out.println("Delete 20!");
        tree.delete(20);
        System.out.println("Post-order after deleted 20");
        tree.preOrder();
    }
}
