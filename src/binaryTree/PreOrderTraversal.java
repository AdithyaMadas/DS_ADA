package binaryTree;

import java.util.ArrayList;

public class PreOrderTraversal {

     static class Node{
     int data;
     Node left,right;
     Node(int d){
         data=d;
         left=right=null;
     }
 }

    static ArrayList<Integer> preorder(Node root) {
        return getPreOrder(new ArrayList<Integer>(), root);
    }

    private static ArrayList<Integer> getPreOrder(ArrayList<Integer> arrayList, Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        arrayList.add(node.data);
        getPreOrder(arrayList, node.left);
        getPreOrder(arrayList, node.right);
        return arrayList;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(4);
        node.left.left = new Node(4);
        node.left.right = new Node(2);
        System.out.println(preorder(node));

    }
}
