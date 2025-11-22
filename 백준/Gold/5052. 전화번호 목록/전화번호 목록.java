import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static class Node {
        char c;
        Map<Character, Node> children;
        boolean isEnd;

        public Node(char c) {
            this.c = c;
            this.children = new HashMap<>();
            this.isEnd = false;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] words = new String[N];

            for (int i = 0; i < N; i++) {
                words[i] = br.readLine().strip();
            }

            Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length())); // 길이 오름차순
            boolean result = true;
            Node root = new Node('\0');

            for (String word : words) {
                Node curr = root;

                for (char c : word.toCharArray()) {
                    curr.children.putIfAbsent(c, new Node(c));
                    curr = curr.children.get(c);

                    if (curr.isEnd) result = false;
                }

                curr.isEnd = true; // 단어의 끝 표시
            }

            System.out.println(result ? "YES" : "NO");
        }

    }
}