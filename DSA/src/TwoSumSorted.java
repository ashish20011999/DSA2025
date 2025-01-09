import java.util.ArrayList;
import java.util.List;

public class TwoSumSorted {
    public static void main(String[] args) {
        int[] nums = {10,20,30,40,50,60};
        int target = 70;
        System.out.println(twoSum(nums,target));
    }

    private static List<List<Integer>> twoSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]==target){
                result.add(List.of(nums[left],nums[right]));
                left++;
                right--;
            } else if (nums[left]+nums[right]>target) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }
}
