import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static class Node {
        char c;
        Map<Character, Node> children;
        boolean passed;

        public Node(char c) {
            this.c = c;
            this.children = new HashMap<>();
            this.passed = false;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().strip();
        }

        Map<String, Integer> cntMap = new HashMap<>();
        Node root = new Node('\0');

        for (String word : words) {
            cntMap.putIfAbsent(word, 0);
            cntMap.put(word, cntMap.get(word) + 1);

            if(cntMap.get(word) > 1) {
                System.out.println(word + cntMap.get(word));
                continue;
            }

            Node curr = root;
            StringBuilder sb = new StringBuilder();
            boolean flag = false;

            for (char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new Node(c));
                curr = curr.children.get(c);
                if(!flag) sb.append(c);

                if(!curr.passed){
                    curr.passed = true;
                    flag = true;
                }
            }

            System.out.println(sb.toString());
        }
    }

}