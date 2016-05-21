public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();
        for(int i : nums1) set.add(i);
        for(int i : nums2){
            if(set.contains(i)) intersect.add(i);
        }
        int[] res = new int[intersect.size()];
        int index = 0;
        for(int i : intersect){
            res[index++] = i;
        }
        return res;
    }
}