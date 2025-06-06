import java.util.*;

class Solution {
    class DoubleEndedPQ {
        private final TreeMap<Integer, Integer> map;
        int size;

        public DoubleEndedPQ() {
            this.map = new TreeMap<>();
            this.size = 0;
        }

        public void add(int value) {
            map.put(value, map.getOrDefault(value, 0) + 1);
            size++;
        }

        public int removeMax() {
            int maxKey = map.lastKey();
            int cnt = map.get(maxKey);
            if (cnt == 1) {
                map.remove(maxKey);
            } else {
                map.put(maxKey, cnt - 1);
            }
            size--;
            return maxKey;
        }

        public int removeMin() {
            int minKey = map.firstKey();
            int cnt = map.get(minKey);
            if (cnt == 1) {
                map.remove(minKey);
            } else {
                map.put(minKey, cnt - 1);
            }
            size--;
            return minKey;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public int[] solution(String[] operations) {
        DoubleEndedPQ pq = new DoubleEndedPQ();
        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String cmd = parts[0];
            int val = Integer.parseInt(parts[1]);

            switch (cmd) {
                case "I" -> pq.add(val);
                case "D" -> {
                    if (pq.isEmpty())
                        continue;
                    if (val == 1) {
                        pq.removeMax();
                    } else if (val == -1) {
                        pq.removeMin();
                    }
                }
            }
        }
        int[] answer = new int[2];
        if (pq.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            if (pq.size >= 2) {
                answer[0] = pq.removeMax();
                answer[1] = pq.removeMin();
            } else {
                int value = pq.removeMax();
                answer[0] = value;
                answer[1] = value;
            }
        }

        return answer;
    }
}