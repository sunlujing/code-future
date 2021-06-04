
/**
 * 给你一个链表，3-4-7-2-10-9-21-19
 * nlogn 排序；
 * merge 排序
 */
public class SortLinkList {


    public static Node sortLinkList(Node head){

        if(head == null) return null;
        if(head.next== null) return head;

        Node slowHead = head;
        Node fastHead = head;
        Node middle = head;
        while( fastHead!=null &&
                fastHead.next!=null){
            middle = slowHead;
            slowHead = slowHead.next;
            fastHead = fastHead.next.next;
        }
        //断开
        middle.next = null;

        head = sortLinkList(head);
        slowHead = sortLinkList(slowHead);

        return mergeSort(head,slowHead);

    }

    //3-4- 1-2

    public static Node mergeSort(Node head, Node h2){
        Node res = new Node(-1);
        Node newHead = res;

        while( head!=null && h2!=null){
              if(head.val > h2.val){
                  Node next = new Node(h2.val);
                  res.next = next;

                  h2 = h2.next;
                  res = next;

              }else{
                  Node next=new Node(head.val);
                  res.next = next;

                  head = head.next;
                  res = next;
              }

        }
        while(head!=null ){
            Node next = new Node(head.val);
            res.next = next;
            res = next;
            head = head.next;
        }
        while(h2!=null){
            Node next = new Node(h2.val);
            res.next = next;
            res = next;
            h2 = h2.next;
        }

        return newHead.next;
    }

    public static void main(String[]args){
        Node a = new Node(3);
        Node b = new Node(9);
        Node c = new Node(2);
        Node d = new Node(1);
        Node e = new Node(11);
        Node f = new Node(10);

        a.next= b; b.next =c; c.next =d; d.next=e; e.next=f;

        Node res = sortLinkList(a);
        while(res !=null){
            System.out.println(res.val);
            res= res.next;
        }
    }



    static class Node{
        int val;
        Node next;

        public Node (int val){
            this.val = val;
        }
    }

}
