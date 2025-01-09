import java.util.*;

public class TwoSumUnsorted {
    public static void main(String[] args) {
        int[] nums = {60,50,40,30,20,10};
        int target = 70;
        System.out.println(twoSum(nums,target));
    }

    private static List<List<Integer>> twoSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length-1;i++){
            Integer k = map.get(target - nums[i]);
            if(k !=null && k>i){
                if(nums[i]>target-nums[i]){
                    result.add(List.of(target-nums[i],nums[i]));
                } else {
                    result.add(List.of(nums[i],target-nums[i]));
                }
            }
        }

        return result;
    }
}
