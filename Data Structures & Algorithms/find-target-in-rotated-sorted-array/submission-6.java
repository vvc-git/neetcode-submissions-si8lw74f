class Solution {
    int[] nums;

    // Return the index of minimum value
    public int findMin() {
        int begin = 0;
        int end = nums.length - 1;
        
        while (begin < end) {
            int middle = (end + begin) / 2;

            if (nums[middle] > nums[end]) {
                begin = middle + 1;
                continue;
            }

            if (nums[middle] <= nums[end]) {
                end = middle;
            }

        }
        return begin; // or end since they should be equal;

    }

    public int binarySearch(int begin, int end, int target) {

        while (begin <= end) {
            int middle = (end + begin) / 2;

            if (nums[middle] == target) {
                return middle;                
            }

            if (nums[middle] < target) {
                begin = middle + 1;
                continue;
            }

            if (nums[middle] > target) {
                end = middle - 1;
            }

        }
        return -1;
    }


    public int search(int[] nums, int target) {
        this.nums = nums;
        int min = findMin();
        System.out.println(min);
        int begin, end;


        // Left sorted portion
        if (min == 0) {
            begin = 0;
            end = nums.length - 1;
        } else if (target >= nums[0] && target <= nums[min -1]) {
            begin = 0;
            end = min -1;
        } else {
            // target >= nums[min] && target < nums.length
            begin = min;
            end = nums.length - 1;
        }

        return binarySearch(begin, end, target);
    }
}
