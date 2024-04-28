package solutions;

import java.util.PriorityQueue;

public class CookiesProblem {
    public Integer solve(int requiredSweetness , int[] cookies) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int cookie : cookies) {
            queue.add(cookie);
        }

        int operationsCount = 0;
        int leastSweetness = queue.peek();

        while (leastSweetness < requiredSweetness) {
            if (queue.size() <= 1) {
                return -1;
            }
            int leastSweetnessCookie = queue.poll();
            int secondLeastSweetnessCookie = queue.poll();

            queue.add(leastSweetnessCookie + (2 * secondLeastSweetnessCookie));
            leastSweetness = queue.peek();
            operationsCount++;
        }

        return operationsCount;
    }
}
