import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class Main {
    static class DoubleEndedPQ {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().strip());

        while (T-- > 0) {
            solve(br, bw);
            bw.newLine();
        }

        bw.flush();
    }

    public static void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        DoubleEndedPQ pq = new DoubleEndedPQ();
        int k = Integer.parseInt(br.readLine().strip());

        String[] operations = new String[k];
        for (int i = 0; i < k; i++) {
            operations[i] = br.readLine().strip();
        }

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String cmd = parts[0];
            int val = Integer.parseInt(parts[1]);

            switch (cmd) {
                case "I":
                    pq.add(val);
                    break;
                case "D":
                    if (!pq.isEmpty()) {
                        if (val == 1) {
                            pq.removeMax();
                        } else {
                            pq.removeMin();
                        }
                    }
                    break;
            }
        }

        if (pq.isEmpty()) {
            bw.write("EMPTY");
        } else {
            int max = pq.removeMax();
            if (pq.isEmpty()) {
                bw.write(max + " " + max);
            } else {
                bw.write(max + " " + pq.removeMin());
            }
        }
    }
}