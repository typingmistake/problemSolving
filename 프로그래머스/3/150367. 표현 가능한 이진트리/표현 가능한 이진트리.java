class Solution {
    static int idx;

    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            long number = numbers[i];
            String bin = toBiary(number);
            answer[i] = isValid(bin) ? 1 : 0;
        }
        return answer;
    }

    public String toBiary(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }

    public boolean isValid(String s) {
        int len = s.length() + 1;
        int x = 1;

        // len <= 2^h를 만족하는 최소 h 찾기
        while (x < len) {
            x *= 2;
        }

        // 길이가 안맞으면 0으로 채우기
        while (s.length() < x - 1) {
            s = "0" + s;
        }

        idx = 0;
        int[] tree = new int[x];
        tree[0] = 1;
        preOrder(tree, 1, s); // 이진트리 업데이트

        for (int i = 1; i < tree.length; i++) {
            if (tree[i] == 0) {
                continue;
            }

            int parent = i / 2;
            // 자식 노드가 1이면 부모 노드도 1이어야 함
            if (tree[parent] == 0) {
                return false;
            }
        }

        return true;
    }

    public void preOrder(int[] tree, int i, String s) {
        if (i >= tree.length) {
            return;
        }
        preOrder(tree, i * 2, s);
        tree[i] = s.charAt(idx++) == '1' ? 1 : 0;
        preOrder(tree, i * 2 + 1, s);
    }
}