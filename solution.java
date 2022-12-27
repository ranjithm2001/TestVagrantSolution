import java.util.*;
class Solution {
    public static List<List<Double>> newspaperCombinations(double[] newspaperSum, double target) {
    Arrays.sort(newspaperSum);
    List<List<Double>> ans = new ArrayList<List<Double>>();
    List<Double> comb = new ArrayList<Double>();
    dfs(newspaperSum, 0, target, comb, ans);
    return ans;
}
    public static void dfs(double[] newspaperSum, int cur, double target, List<Double> comb, List<List<Double>> ans) {
    if (target == 0) {
        if (comb.size() >= 2)
        ans.add(new ArrayList(comb));
        return ;
    }
    if (target > 0) {
        if (comb.size() >= 2)
        ans.add(new ArrayList(comb));
    }
    for (int i = cur; i < newspaperSum.length; i++){
        comb.add(newspaperSum[i]);
        dfs(newspaperSum, i+1, target - newspaperSum[i], comb, ans);
        comb.remove(comb.size()-1);
    }
}
    public static void main(String[] args) {
        double[] newspaperSum = {10.5,18,20.5,26,34};
        double target = 35;
        List<List<Double>> res = newspaperCombinations(newspaperSum, target);
        for (List<Double> lst: res){
            for (Double val: lst){
                if (val == 10.5){
                    System.out.print("BM ");
                }else if(val == 18){
                    System.out.print("HT ");
                }else if (val == 20.5){
                    System.out.print("Hindu ");
                }else if(val == 26){
                    System.out.print("TOI ");
                }else if(val == 34){
                    System.out.print("ET ");
                }
            }
            System.out.println();
        }
    }
}
