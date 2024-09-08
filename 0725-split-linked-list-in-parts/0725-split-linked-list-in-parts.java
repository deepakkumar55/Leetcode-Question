class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = getSize(head);
        int[] arr = getArray(size, k);

        ListNode[] ans = new ListNode[k];
        ListNode newNode = head;
        for(int i=0;i<k;i++) {

            ans[i] = newNode;

            int nodeCount = arr[i];
            ListNode prevNode = null;
            ListNode currNode = newNode;
            while(nodeCount > 0) {
                prevNode = currNode;
                currNode = currNode.next;
                nodeCount--;
            }

            newNode = currNode;
            if(prevNode != null) {
                prevNode.next = null;
            }
        }

        return ans;
    }

    private int getSize(ListNode head) {
        ListNode currNode = head;
        int size = 0;
        while (currNode != null) {
            currNode = currNode.next;
            size++;
        }
        return size;
    }

    private int[] getArray(int size, int k) {
        int[] arr = new int[k];
        int parts = size/k;
        int extraParts = size%k;

        for(int i=0;i<k;i++) {
            arr[i] = parts;
            if(extraParts>0) {
                arr[i] = arr[i] + 1;
                extraParts--;
            }
        }
        return arr;
    }
}