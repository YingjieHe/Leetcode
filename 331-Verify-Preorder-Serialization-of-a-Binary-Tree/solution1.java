public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0) return true;
        String[] nodes = preorder.split(",");
        int diff = 1;
        for(String node : nodes) {
            if(--diff < 0) return false;
            if(!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}