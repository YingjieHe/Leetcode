public class Vector2D {
    private List<List<Integer>> vec2d;
    private int index1 = 0;
    private int index2 = 0;
    private int max_row = 0;
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        max_row = vec2d.size();
        while (index1 < max_row && vec2d.get(index1).size() == 0){
            index1++;
        }
    }

    public int next() {
        return vec2d.get(index1).get(index2++);
    }

    public boolean hasNext() {
        if (index1 >= max_row) return false;
        if (index2 < vec2d.get(index1).size()) return true;
        while (++index1 < max_row){
            if (vec2d.get(index1).size() > 0){
                index2 = 0;
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
 
  