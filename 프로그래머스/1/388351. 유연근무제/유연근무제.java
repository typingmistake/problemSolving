
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = n;

        for (int i = 0; i < n; i++) {
            int[] weekendDays = getWeekendDays(startday);
            int sat = weekendDays[0];
            int sun = weekendDays[1];

            int lateTime = getLateTime(schedules[i]);
            int[] timelog = timelogs[i];

            for (int d = 0; d < 7; d++) {
                if (d == sat || d == sun) {
                    continue;
                }

                if (timelog[d] > lateTime) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }

    // 며칠 후에 주말이 오는지 계산
    public int[] getWeekendDays(int startday) {
        int sat = (13 - startday) % 7;
        int sun = (14 - startday) % 7;

        return new int[] { sat, sun };
    }

    // 지각 시간 계산
    public int getLateTime(int schedule) {
        int res = schedule + 10;
        if (res % 100 >= 60) {
            res += 100;
            res -= 60;
        }
        return res;
    }
}
