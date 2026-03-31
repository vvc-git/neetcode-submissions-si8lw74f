class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        int[] res = new int[k];

        for (int num : nums) {

            frequency.put(num, frequency.getOrDefault(num, 0) + 1);

        }

        maxHeap.addAll(frequency.entrySet());

        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }

        return res;
        
    }
}
