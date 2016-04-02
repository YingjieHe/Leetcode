public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        
        if(preorder == null || preorder.length <= 1) return true;
        
        Stack<Integer> st = new Stack<Integer>();
        st.push(preorder[0]);
        int min = Integer.MIN_VALUE;
        
        for(int i = 1; i < preorder.length; ++i){
            if(preorder[i] > st.peek()){
                while(!st.isEmpty() && preorder[i] > st.peek()){
                    min = st.pop();
                }
                st.push(preorder[i]);
            }
            else{
                if(preorder[i] < min) return false;
                st.push(preorder[i]);
            }
        }
        
        return true;
        
    }
}