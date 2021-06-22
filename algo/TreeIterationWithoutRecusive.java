package com.leetcodeSubmit;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TreeIterationWithoutRecusive {


    public static void inOrder(Node root){
        Stack<Node> queues = new Stack<Node>();
        queues.push(root);
        Set<Node> visited = new HashSet<Node>();
        while(!queues.isEmpty()){
            Node current = queues.peek();
            if(!visited.contains(current)){
                visited.add(current);
                while(current.left!=null){
                    queues.push(current.left);
                    current = current.left;
                }
            }
            current= queues.pop();
            System.out.println(current.v);
            if(current.right !=null){
                queues.push(current.right);
            }
        }

    }

    public static void inOrderV2(Node root){
        Stack<Node> queues = new Stack<Node>();
        while(root !=null || !queues.isEmpty()){
            while(root!=null) {
                queues.push(root);
                root = root.left;
            }
            if(!queues.isEmpty()){
                root = queues.pop();
                System.out.println(root);
                root = root.right;
            }
        }

    }

    public static void preOrder(Node root){
        Stack<Node> queues = new Stack<Node>();
        while(root !=null || !queues.isEmpty()){
            while(root!=null) {
                System.out.println(root);
                queues.push(root);
                root = root.left;
            }
            if(!queues.isEmpty()){
                root = queues.pop();
                root = root.right;
            }
        }

    }


    public static void postOrder(Node root){
        Stack<Node> queues = new Stack<Node>();
        Stack<Integer> marks = new Stack<Integer>();
        //1, 标识 左子 树，2，标识右子树
        while(root !=null || !queues.isEmpty()){
            while(root!=null) {
                queues.push(root);
                marks.push(1);
                root = root.left;
            }
            while(!queues.isEmpty() && marks.peek() == 2){
                //右字数已经访问：
                marks.pop();
                System.out.println(queues.pop().v);

            }
            if(!queues.isEmpty() && marks.peek() == 1){
                marks.pop();
                marks.push(2);
                root = queues.peek();
                root = root.right;
            }
        }

    }

    public static void postOrderV2(Node root){
        Stack<Node> queues = new Stack<Node>();
        Node lastVisited = null;
        //1, 标识 左子 树，2，标识右子树
        while(root !=null || !queues.isEmpty()){
            while(root!=null) {
                queues.push(root);
                root = root.left;
            }
            if(!queues.isEmpty()){
                root = queues.peek();
                if(root.right == null ||root.right == lastVisited ){
                    System.out.println(queues.pop().v);
                    lastVisited = root;
                    root = null;
                }else{
                    root = root.right;

                }
            }
        }

    }



    public static void main(String[] args) {
        Node v15 = new Node(15);
        Node v7 = new Node(7);
        Node v20 = new Node(v15,v7,20);
        Node v9 = new Node(9);
        Node v3 = new Node(v9,v20,3);

//        inOrderV2(v3);
//        preOrder(v3);
        postOrderV2(v3);
    }

    /**
     *  *
     *  *     3
     *  *    / \
     *  *   9  20
     *  *     /  \
     *  *    15   7
     *  * 返回锯齿形层次遍历如下：
     */
    static class Node{

        Node left;
        Node right;
        int v;

        public Node(Node left, Node right, int v){
            this.left = left;
            this.right = right;
            this.v = v;
        }

        public Node(int v){
            this.v = v;
        }

        @Override
        public String toString() {
            return ""+v;
        }
    }
}
