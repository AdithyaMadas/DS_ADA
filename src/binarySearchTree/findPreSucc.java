package binarySearchTree;

public class findPreSucc {
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    class Res{
        Node pre = null;
        Node succ = null;
    }

    public void findPreSuc(Node root, Res p, Res s, int key) {
        if (root == null) {
            return;
        }
        if (root.data < key) {
            p.pre = root;
            findPreSuc(root.right, p, s, key);
        } else if (root.data > key) {
            s.succ = root;
            findPreSuc(root.left, p, s, key);
        } else {
            if (root.left != null) {
                Node tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                p.pre = tmp;
            }
            if (root.right != null) {
                Node tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                s.succ = tmp;
            }
        }
    }

    public static void main(String[] args) {

    }
}
