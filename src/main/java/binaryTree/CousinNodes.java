package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CousinNodes {

    private static Node prev;
    private static Node parentA, parentB;
    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.right = new Node(50);
        System.out.println(isCousins(root, 40, 50));
    }
    public static boolean isCousins(Node root, int a, int b) {
        // your code here
        // This function should return true if x and y are cousins, else return false

        prev = null;
        getParent(root, a, b, null);
        if ( parentA == parentB ) {
            System.out.println("yes");
            return false;
        }
        int levelA = getDepth(root, a);
        int levelB = getDepth(root, b);
        return levelA == levelB;
    }
    private static int getDepth(Node root, int key ) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {

            int size = queue.size();
            for ( int i=0; i<size; i++ ) {

                Node curr = queue.poll();
                if ( curr.data == key )
                    return level;

                if ( curr.left != null )
                    queue.add(curr.left);

                if ( curr.right != null )
                    queue.add(curr.right);
            }
            level++;
        }
        return -1;
    }
    private static void getParent(Node root, int a, int b, Node prev) {

        if ( root == null )
            return ;

        if ( root.data == a )
            parentA = prev;

        if ( root.data == b )
            parentB = prev;

        getParent(root.left, a, b, root);
        getParent(root.right, a, b, root);
    }
}
