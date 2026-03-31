class MedianFinder {
    // smallest Values
    PriorityQueue<Integer> smallHeap = new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer> largeHeap = new PriorityQueue<>();

    public MedianFinder() {
    }
    
    public void addNum(int num) {
        smallHeap.add(num);

        if (smallHeap.size() - largeHeap.size() > 1 || 
            !largeHeap.isEmpty() 
            && smallHeap.peek() > largeHeap.peek()
        ) {
            int val = smallHeap.poll();
            largeHeap.add(val);
        }

        if (largeHeap.size() - smallHeap.size() > 1) {
            int val = largeHeap.poll();
            smallHeap.add(val);
        }
    }
       
    
    public double findMedian() {        
        if (largeHeap.size() == smallHeap.size()) {
            return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
        }

        return  (largeHeap.size() > smallHeap.size()) ? (double) largeHeap.peek() : (double) smallHeap.peek();

    }
}
