class Solution {
    public int longestConsecutive(int[] nums) {

       Set<Integer> values = new HashSet<>();
       int result = 0;
        for (int num : nums) {   
            values.add(num);
        }

        for (int num : nums) {
            if (!values.contains(num - 1)) {
                // We can start to create a sequence
                int curr = num; int streak = 0;
                while (values.contains(curr)) {
                    curr++;
                    streak++;
                }
                result = Math.max(result, streak);
            }
        }
        return result;

    }
}
