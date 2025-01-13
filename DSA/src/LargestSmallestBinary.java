public class LargestSmallestBinary {
    public static void main(String[] args) {
        int[] nums = {10, 20, 3, 50, 7, 1, 100, -5};
        int start = 0;
        int end = nums.length - 1;

        int smallest = Smallest(nums, start, end);
        System.out.println("Smallest element: " + smallest);

        int largest = Largest(nums,start,end);
        System.out.println("largest element: " + largest);
    }

    private static int Smallest(int[] nums, int start, int end) {
        // Base case: if the subarray has only one element
        if (start == end) {
            return nums[start];
        }

        // Calculate the middle index correctly
        int mid = start + (end - start) / 2;

        // Recursive calls without creating new subarrays
        int leftSmallest = Smallest(nums, start, mid);
        int rightSmallest = Smallest(nums, mid + 1, end);

        // Return the smaller of the two
        return Math.min(leftSmallest, rightSmallest);
    }

    private static int Largest(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        int mid = start+(end-start)/2;
        int leftLargest = Largest(nums, start,mid);
        int rightLargest = Largest(nums, mid+1,end);
        return Math.max(leftLargest,rightLargest);
    }
}
