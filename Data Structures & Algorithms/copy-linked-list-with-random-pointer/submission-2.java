/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head==null){
            return null;
        }

        Node copyHead = new Node(head.val);
        Node temp = head;
        Node copyTemp = copyHead;

        while(temp!=null) {
            // Copy
            copyTemp.val=temp.val;
            
            temp=temp.next;
            if(temp!=null){
                copyTemp.next = new Node(-1);
                copyTemp = copyTemp.next;
            }
        }

        temp = head;
        copyTemp = copyHead;

        while(temp!=null){
            if(temp.random==null){
                copyTemp.random = null;
            }
            else{
                Node newTemp = head;
                Node copyNewTemp = copyHead;
                while(temp.random != newTemp){

                    newTemp = newTemp.next;
                    copyNewTemp = copyNewTemp.next;

                }

                copyTemp.random = copyNewTemp;
            }

            temp=temp.next;
            copyTemp=copyTemp.next;
        }

        System.out.println(copyHead.next);

        return copyHead;
        
        
    }
}
