/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null){
            return res;
        }
        
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        Stack<Integer> arr = new Stack<Integer>();
        int currCount = 1;
        int nextCount = 0;
        int lineCount = 0;
        while(qu.size() > 0){
            TreeNode curr = qu.poll();
            arr.push(curr.val);
            currCount--;
            
            if (curr.left != null){
                qu.add(curr.left);
                nextCount++;
            }
            
            if (curr.right != null){
                qu.add(curr.right);
                nextCount++;
            }
            
            if (currCount == 0){
                currCount = nextCount;
                nextCount = 0;
                lineCount++;
                if (lineCount%2 == 1){
                    res.add(new ArrayList<Integer>(arr));
                }
                else{
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    while(arr.size() > 0){
                        temp.add(arr.pop());
                    }
                    res.add(temp);
                }
                arr.clear();
            }
        }
        return res;
    }
}