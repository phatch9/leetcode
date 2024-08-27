package med;
/* Given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

*/

package med;


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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode headNode = new ListNode();
        ListNode currentNode = headNode;
        int carryOver = 0;
        while  (list1 != null || list2 != null || carryOver != 0)
        {
            int val1 =0, val2 = 0;
            if (list1 != null) val1 = list1.val;
            if (list2 != null) val2 = list2.val;
            int sum = val1 + val2 + carryOver;

        // Adding carryOver 
        carryOver = sum/10;
        currentNode.next = new ListNode(sum %10);
        // Assign nodes
        currentNode = currentNode.next;
        if(list1 != null) list1= list1.next;
        if(list2 != null) list2= list2.next;
        }
    return headNode.next;
    }
}