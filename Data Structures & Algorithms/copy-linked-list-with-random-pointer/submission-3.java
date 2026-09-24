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
        map.put(null, null);
        map.put(head, new Node(head.val));
        Node temp = head;
        Node ret = map.get(head);
        
        while (temp != null) {
            if (!map.containsKey(temp)) {
                map.put(temp, new Node(temp.val));
            }
            if (!map.containsKey(temp.next)) {
                map.put(temp.next, new Node(temp.next.val));
            }
            if (!map.containsKey(temp.random)) {
                map.put(temp.random, new Node(temp.random.val));
            }
            ret.next = map.get(temp.next);
            ret.random = map.get(temp.random);
            ret = ret.next;
            temp = temp.next;
        }
        return map.get(head);
    }
}
