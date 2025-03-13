class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (!isEnough(wallet, bill)) {
            int max = getMax(bill);
            bill[max] /= 2;
            answer++;
        }

        return answer;
    }

    public int getMax(int[] arr) {
        int a = arr[0];
        int b = arr[1];
        if (a > b) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean isEnough(int[] wallet, int[] bill) {
        int w = wallet[0];
        int l = wallet[1];
        int a = bill[0];
        int b = bill[1];

        if ((w >= b && l >= a) || (w >= a && l >= b)) {
            return true;
        } else {
            return false;
        }
    }
}