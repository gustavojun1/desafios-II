import java.util.Scanner;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Sol {
    static void addNode(TreeNode root, int value) {
        if(root == null) return;
        if(value > root.val) {
            if(root.right == null) {
                root.right = new TreeNode(value);
                return;
            } else {
                addNode(root.right, value);
            }
        } else {
            if(root.left == null) {
                root.left = new TreeNode(value);
                return;
            } else {
                addNode(root.left, value);
            }
        }
    }
    static TreeNode buildTree(ArrayList<Integer> seq) {
        TreeNode root = new TreeNode(seq.get(0));
        for (int i = 1; i < seq.size(); i++) {
            addNode(root, seq.get(i));
        }
        return root;
    }
    static int verifyTreeHeight(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = verifyTreeHeight(root.left);
        int rightHeight  = verifyTreeHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static void printTree(TreeNode root) {
        if(root == null) return;
        printTree(root.left);
        System.out.println(root.val + " ");
        printTree(root.right);
    }

    static void reorder(ArrayList<Integer> seq, int pivot) {
        // TODO
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int case_num = 1;
        while(true) {
            int N = sc.nextInt();
            int H = sc.nextInt();
            if(N == 0 && H == 0) break;
            int[] nodes = new int[N];
            for (int i = 0; i < N; i++) {
                nodes[i] = i+1;
            }
            int pivot = N - 1;
            while(true) {
                ArrayList<Integer> seq = new ArrayList<Integer>();
                for (int i = 1; i <= N; i++) {
                    seq.add(i);
                }
                System.out.println("seq: " + seq);
                TreeNode root = buildTree(seq);
                int treeHeight = verifyTreeHeight(root);
                if(treeHeight <= H) {
                    System.out.print("Case " + case_num + ": ");
                    for (int i = 0; i < seq.size(); i++) {
                        System.out.print(seq.get(i));
                        if(i == seq.size() - 1)
                            System.out.println();
                        else
                            System.out.print(" ");
                    }
                    break;
                } else {
                    reorder(seq, pivot);
                    break; // tirar quando fizer o reorder, deixei só para não entrar em loop infinito
                }
            }
            case_num++;
        }
    }
}