import java.util.Stack;

public class Iterative_Treversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int index = 0;

    static Node generateTree(int[] arr ,int index) {   // 1,2,3,4,5,-1,-1,-1,-1,-1,6,-1,-1
        Node newNode = null;

        if(index < arr.length) {
            newNode = new Node(arr[index]);

            newNode.left = generateTree(arr, 2*index + 1);
            newNode.right = generateTree(arr, 2*index + 2);
        }

        return newNode;
    }

    public Node insertLevelOrder(int[] arr, int i)
    {
          Node root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new Node(arr[i]);
  
            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);
  
            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }

    static void iterativePreorder(Node root) {
        Stack<Node> s = new Stack<>();

        if(root != null)
        s.push(root);

        while(!s.isEmpty()) {           //           1
            Node a = s.peek();          //       2       3
            s.pop();                   //     4    5        6
            
            if(a.right != null)
            s.push(a.right);

            if(a.left != null)
            s.push(a.left);

            System.out.print(a.data + " ");
        }
        System.out.println();
    }

    static void iterativeinOrder(Node root) {      // 3 2 4 1 5 6
        Stack<Node> s = new Stack<>();

        if(root != null)
        s.push(root);

        while(!s.isEmpty()) {
            Node a = s.peek();

            if(a.left != null) {
                s.push(a.left);
                a.left = null;
            } else {
                System.out.print(a.data + " ");

                s.pop();

                if(a.right != null) 
                s.push(a.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        Node root = generateTree(a , index);

        iterativePreorder(root);  
        iterativeinOrder(root);  
    }
}