package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 和leetcode 102 基本是一样的，思路是完全一样的。
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * ### 遍历树，用非递归的方式
 */
public class TreeIteration {


    public static List<List<Node>> iterateTree(Node root){
        Queue<Node> qs = new LinkedBlockingQueue<Node>();
        List<List<Node>> res = new ArrayList<List<Node>>();
        List<Node> oneLevel = new ArrayList<Node>();

        qs.add(root);
        qs.add(new Node(-1));
        while(!qs.isEmpty()){
            Node current = qs.poll();
            if(current.v != -1){
                //current level not end
                oneLevel.add(current);
                if(current.left !=null)
                    qs.add(current.left);
                if(current.right !=null)
                    qs.add(current.right);

                qs.add(new Node(-1));
            }else{
                //end the level
                if(oneLevel.size() > 0)
                    res.add(oneLevel);
                oneLevel = new ArrayList<Node>();
            }
        }
        return res;
    }



    public static List<List<Node>> rescurise(Node node){
        List<List<Node>> res = new ArrayList<List<Node>>();
        bfs(node, 0, res );
        return res;
    }

    public static void bfs(Node node, int depth, List<List<Node>> res ) {
        if(node==null) return;
        if(res.size() <=depth){
            List<Node> level = new ArrayList<Node>();
            res.add(level);
        }
        res.get(depth).add(node);
        bfs(node.left, depth+1, res);
        bfs(node.right, depth+1, res);

    }

    public static void main(String[] args) {
        Node v15 = new Node(15);
        Node v7 = new Node(7);
        Node v20 = new Node(v15,v7,20);
        Node v9 = new Node(9);
        Node v3 = new Node(v9,v20,3);

        List<List<Node>> res = rescurise(v3);
        System.out.println(res);
    }


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




