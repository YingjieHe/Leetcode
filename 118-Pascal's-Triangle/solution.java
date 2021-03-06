public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows <= 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < numRows; i++){
            list.add(0, 1);
            for(int j = 1; j < list.size() - 1; j++){
                list.set(j, list.get(j) + list.get(j + 1));
            }
            res.add(new ArrayList<Integer>(list));
        }
        return res;
    }
}