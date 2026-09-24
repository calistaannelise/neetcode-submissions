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
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        map.put(null, null);

        temp = head;
        Node ret = map.get(head);
        Node curr = ret;
        while (temp != null) {
            curr.random = map.get(temp.random);
            curr.next = map.get(temp.next);
            temp = temp.next;
            curr = curr.next;
        }
        return ret;
    }
}
