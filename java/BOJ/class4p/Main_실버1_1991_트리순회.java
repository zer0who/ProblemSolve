package BOJ.class4p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실버1_1991_트리순회 {

    static class Node {
        String v;
        Node left;
        Node right;

        public Node(String v) {
            this.v = v;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "[ " + this.v + ", left: " + this.left + ", right: " + this.right + " ]";
        }
    }

    static class BinaryTree {
        Node root;

        public BinaryTree(Node root) {
            this.root = root;
        }

        public void addNode(Node parent, String parentValue, Node left, Node right) { // 자식 노드를 추가하는 함수, 항상 root노드부터 시작하여
            if (parent.v.equals(parentValue)) {   // 루트 노드에 자식을 넣는 경우
                if (!left.v.equals(".")) parent.left = left;
                if (!right.v.equals(".")) parent.right = right;
            } else {    // 루트 노드 이외에 자식을 넣을 경우
                if (parent.left != null) addNode(parent.left, parentValue, left, right);
                if (parent.right != null) addNode(parent.right, parentValue, left, right);
            }
        }

        public void printPre(Node parent) {    // 전위 순회
            if (parent == null) return;
            System.out.print(parent.v);
            printPre(parent.left);
            printPre(parent.right);
        }

        public void printIn(Node parent) { // 중위 순회
            if (parent == null) return;
            printIn(parent.left);
            System.out.print(parent.v);
            printIn(parent.right);
        }

        public void printPost(Node parent) {   // 후위 순회
            if (parent == null) return;
            printPost(parent.left);
            printPost(parent.right);
            System.out.print(parent.v);
        }

        @Override
        public String toString() {
            return this.root.toString();
        }

    }

    public static void main(String[] args) throws IOException {
        Node root = new Node("A");
        BinaryTree bt = init(root);
        bt.printPre(root);
        System.out.println("");
        bt.printIn(root);
        System.out.println("");
        bt.printPost(root);
    }

    static BinaryTree init(Node root) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BinaryTree bt = new BinaryTree(root);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            bt.addNode(root, parent, new Node(left), new Node(right));
        }

        return bt;
    }

}
