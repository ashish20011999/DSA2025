import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Threesum1 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<size;i++){
            map.put(nums[i],i);
        }

        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                Integer k = map.get(-(nums[i] + nums[j]));
                if (k != null && k > j) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                }
            }
        }

        List<List<Integer>> finalResult = new ArrayList<>();
        result.forEach(list -> finalResult.add(list) );

        return finalResult;
    }
}