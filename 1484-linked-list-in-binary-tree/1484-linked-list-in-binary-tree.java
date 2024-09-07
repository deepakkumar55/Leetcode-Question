class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return helper(head , root);
    }
    boolean helper(ListNode curr , TreeNode node){

        if(node==null) return false;
        return check_path(curr,node) || helper(curr,node.left) || helper(curr,node.right);
    }
    boolean check_path(ListNode curr,TreeNode node){
       if(curr==null) return true;
       if(node==null) return false;
       if(curr.val!=node.val) return false;
       return check_path(curr.next,node.right)||check_path(curr.next,node.left);
    }
}