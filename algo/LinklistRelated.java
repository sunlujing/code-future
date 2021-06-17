package com.leetcode;

public class LinklistRelated {

    /**  111 22 3 4 5
     *   1<-2,  3->4
     * @param root
     * @return
     */
    public static Node reverse(Node root){
        if(root == null || root.next == null) return root;

        Node cureentHead = root;
        Node next = null;
        Node newHead = null;

        while(cureentHead !=null){
            next = cureentHead.next;
            cureentHead.next = newHead;
            newHead = cureentHead;
            cureentHead = next;
        }
        return newHead;

    }

    /**
     *  11 22 33 4 5 : 4-5;
     *  递归的实现，找到 第一个 不用删除的节点，
     *  对接上，然后找下一个；
     * @param root
     * @return
     */
    public static Node removeDuplicatedElement(Node root){
        Node cur = root;
        Node head = new Node(-1);
        Node Res = head;
        Node next;

        while(cur!=null){
            //
            next = cur.next;
            if(next!=null && cur.val==next.val) {
                //有重复
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                cur = next;
            }else{
                //没重复
                head.next = cur;
                head = cur;
                cur = next;

            }

        }

        return Res.next;

    }

    public static Node keepOneDuplicated(Node root){
        Node cur = root;
        Node head = new Node(-1);
        Node Res = head;
        Node next;

        while(cur!=null){
            //
            next = cur.next;
            head.next = cur;
            head = cur;
            if(next!=null && cur.val==next.val) {
                //有重复
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
            }
            cur = next;
        }

        return Res.next;
    }

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     *
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * 1,3,2,5, 2,  3
     *
     * 1,2 ,2,5,3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static Node partition(Node root,int k){
        Node head = new Node(-1);
        Node Res = head;
        Node cur = root;
        Node tail = root;

        while(tail.next !=null) tail = tail.next;
        Node tailIter =tail;

        while(cur!=null && cur!=tail){
            if(cur.val >= k){
                //移动到尾部；
                Node temp = cur.next;

                tailIter.next = cur;
                tailIter = cur;
                cur.next = null;

                cur = temp;
            }else{
                head.next = cur;
                head =cur;
                cur = cur.next;
            }
        }
        return Res.next;

    }

    public static Node reverseMid(Node root, int s, int e){
        Node preStart = null;
        Node endNext =null;
        Node startToReverse = root;
        Node endToReverse = root;
        Node curHead =root;
        int i =1;
        while(root !=null){
            if(i == s-1){ preStart = root;}
            if(i== s){startToReverse = root;}
            if(i== e){endToReverse = root;}
            root = root.next;
        }
        endNext = endToReverse.next;

        //revese 的时候记录 记录tail 就行；
        return curHead;

    }


    public static void main(String[]args){
        Node head = new Node(2);
        Node v1 = new Node(1);

        Node v2 = new Node(3);
        Node v3 = new Node(2);
        Node v4 = new Node(5);

        head.next = v1; v1.next = v2; v2.next = v3; v3.next = v4;

        //Node h = reverse(head);
        Node h = partition(head,3);


        while(h !=null){
            System.out.println(h.val);
            h=h.next;
        }

    }




    static class Node{

        public int val;
        public Node next;
        public Node(int v){
            this.val = v;
        }
    }
}
