/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    TreeNode groot;

    public FindElements(TreeNode root) {
        if(root!=null && root.val==-1){
            root.val=0;                
        }
        solve1(root);   
        groot=root;  

        //printTree(groot); //Used for printing the new Tree
    }

    void printTree(TreeNode node){
        if(node==null){ 
            System.out.print(" null ");
            return;
        }

        System.out.print(" "+node.val);
        printTree(node.left);
        printTree(node.right);
    }



    void solve1(TreeNode node){
        if(node==null){
            return;
        }

        if(node.left !=null){
            node.left.val=2*node.val+1;                
        }
        if(node.right !=null){
            node.right.val=2*node.val+2;
        }

        solve1(node.left);
        solve1(node.right);

    }


    
    public boolean find(int target) {
        TreeNode node=new TreeNode();
        node=groot;
        return solve2(node, target);
    }

    boolean solve2(TreeNode node, int target){
        if(node==null){
            return false;
        }
        if(node.val==target){
            return true;
        }
        
        if(solve2(node.left, target) || solve2(node.right, target)) return true;

        return false;
    }  

  
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */