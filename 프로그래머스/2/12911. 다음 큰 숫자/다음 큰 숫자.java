class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        while (true)
            if (Integer.bitCount(++n) == cnt) return n;
    }
}