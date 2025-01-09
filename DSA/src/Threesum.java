import java.util.*;

public class Threesum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            //perform 2 sum here
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0) {
                        List<Integer> threeSomePair = new ArrayList<>();
                        threeSomePair.add(nums[i]);
                        threeSomePair.add(nums[j]);
                        threeSomePair.add(nums[k]);

                        Collections.sort(threeSomePair);
                        result.add(threeSomePair);
                    }
                }
            }
        }
        List<List<Integer>> finalResult = new ArrayList<>();
        result.forEach(pair -> finalResult.add(pair));
        return finalResult;
    }
}