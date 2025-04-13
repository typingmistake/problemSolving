class Solution {
    public long solution(int[] sequence) {
        long[] seq1 = new long[sequence.length];
        long[] seq2 = new long[sequence.length];
        int mul = 1;

        for (int i = 0; i < sequence.length; i++) {
            mul *= -1;
            seq1[i] = sequence[i] * mul;
            seq2[i] = -sequence[i] * mul;
        }

        return Math.max(findMax(seq1), findMax(seq2));
    }

    public long findMax(long[] seq) {
        long curr = seq[0];
        long res = seq[0];

        for (int i = 1; i < seq.length; i++) {
            curr = Math.max(curr + seq[i], seq[i]);
            res = Math.max(res, curr);
        }

        return res;
    }
}