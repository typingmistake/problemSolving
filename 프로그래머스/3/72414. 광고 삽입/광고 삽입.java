import java.util.PriorityQueue;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int startTime = -1;
        String[] playParts = play_time.split(":");
        String[] advParts = adv_time.split(":");
        int playSec = toSeconds(playParts);
        int advSec = toSeconds(advParts);

        int MAX_TIME = 100*60*60;
        long[] dp = new long[MAX_TIME];

        for (String log : logs) {
            String[] timeParts = log.split("-");
            int start = toSeconds(timeParts[0].split(":"));
            int end = toSeconds(timeParts[1].split(":"));

            dp[start] += 1;
            dp[end] -= 1;
        }

        long currUsers = 0; // 현재 시청자 수
        long sum = 0; // 누적합

        for(int i = 0; i < advSec; i++){
            currUsers += dp[i]; // 누적 사용자 추가
            dp[i] = currUsers; // 현재 시간 사용자 수
            sum += currUsers;
        }

        int answer = 0;
        long maxSum = sum;

        for(int i = advSec; i < MAX_TIME; i++){
            currUsers += dp[i];
            dp[i] = currUsers;
            sum += currUsers;
            sum -= dp[i - advSec];

            if(maxSum < sum){
                answer = i-advSec+1;
                maxSum = sum;
            }
        }

        return toTimeString(answer);
    }

    static int toSeconds(String[] timeParts) {
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    static String toTimeString(int seconds) {
        int hours = seconds / 3600;
        seconds %= 3600;
        int minutes = seconds / 60;
        seconds %= 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}