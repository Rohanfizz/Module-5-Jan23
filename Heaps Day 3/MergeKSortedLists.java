/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public class Helper{
        ListNode node;
        int val;
        Helper(ListNode node,int val){
            this.node = node;
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Helper> pq = new PriorityQueue<>((a,b)->{
            return a.val - b.val;
        });

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for(int i = 0;i<lists.length;i++){
            if(lists[i] != null) pq.add(new Helper(lists[i],lists[i].val));
        }

        while(pq.size()>0){
            Helper top = pq.remove();
            ListNode currentNode = top.node;
            temp.next = currentNode;
            temp = temp.next;
            if(currentNode.next != null){
                pq.add(new Helper(currentNode.next,currentNode.next.val));
            }
        }
        return dummy.next;
    }
}