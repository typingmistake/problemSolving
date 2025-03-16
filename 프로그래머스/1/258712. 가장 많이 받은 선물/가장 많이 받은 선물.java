import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> result = new HashMap<>();

        for (String friend : friends) {
            result.put(friend, 0);
        }

        HashMap<String, Integer> giftPoint = getGiftPoint(friends, gifts);
        HashMap<String, HashMap<String, Integer>> giftHistory = getGiftHistory(gifts, friends);

        for (String from : friends) {
            int fromPoint = giftPoint.get(from);
            for (String to : friends) {
                if (from.equals(to)) {
                    continue;
                }
                int fromCount = giftHistory.get(from).get(to);
                int toCount = giftHistory.get(to).get(from);
                int toPoint = giftPoint.get(to);
                String winner = null;

                if (fromCount != toCount) {
                    winner = fromCount > toCount ? from : to;
                } else if (fromPoint != toPoint) {
                    winner = fromPoint > toPoint ? from : to;
                }

                if (winner != null) {
                    result.put(winner, result.get(winner) + 1);
                }
            }

        }

        // 2로 나누는 이유는 선물을 주고 받는 경우가 2번씩 카운트 되기 때문
        return Collections.max(result.values()) / 2;

    }

    public static HashMap<String, HashMap<String, Integer>> getGiftHistory(String[] gifts, String[] friends) {
        HashMap<String, HashMap<String, Integer>> giftHistory = new HashMap<>();

        for (String from : friends) {
            giftHistory.put(from, new HashMap<>());
            for (String to : friends) {
                giftHistory.get(from).put(to, 0);
            }
        }

        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String from = split[0];
            String to = split[1];

            giftHistory.get(from).put(to, giftHistory.get(from).get(to) + 1);
        }

        return giftHistory;
    }

    public static HashMap<String, Integer> getGiftPoint(String[] friends, String[] gifts) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String friend : friends) {
            map.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String from = split[0];
            String to = split[1];

            if (map.containsKey(from)) {
                map.put(from, map.get(from) + 1);
            }

            if (map.containsKey(to)) {
                map.put(to, map.get(to) - 1);
            }
        }

        System.out.println(map);
        return map;
    }
}