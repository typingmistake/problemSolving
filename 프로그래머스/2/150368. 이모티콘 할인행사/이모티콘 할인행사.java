
class Solution {
    int[] answer;
    int[][] users;
    int[] emoticons;
    static int[] discounts = { 10, 20, 30, 40 };

    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        this.users = users;
        this.emoticons = emoticons;

        calc(0, new int[emoticons.length]);

        return answer;
    }

    public void calc(int idx, int[] path) {
        if (idx == emoticons.length) {
            int[] result = new int[2];

            for (int user[] : users) {
                int total = 0;
                for (int i = 0; i < emoticons.length; i++) {
                    if (path[i] >= user[0]) {
                        total += emoticons[i] * (100 - path[i]) / 100;
                    }
                }
                if (total >= user[1]) {
                    result[0]++;
                } else {
                    result[1] += total;
                }
            }

            if (result[0] > answer[0]) {
                answer[0] = result[0];
                answer[1] = result[1];
            } else if (result[0] == answer[0]) {
                answer[1] = Math.max(answer[1], result[1]);
            }
            return;
        }

        for (int i = 0; i < discounts.length; i++) {
            int[] temp = path.clone();
            temp[idx] = discounts[i];
            calc(idx + 1, temp);
        }
    }
}