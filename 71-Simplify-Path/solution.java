public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "";
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        Stack<String> s = new Stack<>();
        for(String dir : path.split("/")) {
            if(dir.equals("..") && !s.isEmpty()) s.pop();
            else if(!skip.contains(dir)) s.push(dir);
        }
        String res = "";
        for(String dir : s) {
            res += "/" + dir;
        }
        return res.length() == 0? "/" : res;
    }
}