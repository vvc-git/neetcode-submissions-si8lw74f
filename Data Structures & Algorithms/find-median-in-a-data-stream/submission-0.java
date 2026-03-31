class MedianFinder {
    List<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {
        nums.add(num);
    }
    
    public double findMedian() {
       
        if (nums.size() == 1)
            return nums.get(0);

        Collections.sort(nums);
        System.out.println(nums);
        int divideByTwo = nums.size() / 2;
        System.out.println(divideByTwo);
        // if it is even
        if (nums.size() % 2 == 0) {
            double val1 = nums.get(divideByTwo - 1);
            double val2 = nums.get((divideByTwo));
            double median = (val1 + val2) / 2;
            System.out.printf("val1 : %s, val2: %s, median: %s\n", val1, val2, median);
            return median;
        }
        // if it is odd
        return nums.get(divideByTwo);

    }
}
