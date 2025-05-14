import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int n = cards.length;
        int pass = 0;
        Set<Integer> initSet = new HashSet<>();
        
        for (int i = 0; i < n / 3; i++) {
            int card = cards[i];
            if (initSet.contains(n + 1 - card)) {
                pass++;
                initSet.remove(n + 1 - card);
            } else {
                initSet.add(card);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        
        for (int i = n / 3; i < n; i += 2) {
            if (i + 1 < n && cards[i] + cards[i + 1] == n + 1 && coin >= 2) {
                coin -= 2;
                pass++;
            } else {
                for (int j = i; j < Math.min(i + 2, n); j++) {
                    int card = cards[j];
                    
                    if (initSet.contains(n + 1 - card) && coin >= 1) {
                        pass++;
                        coin--;
                        initSet.remove(n + 1 - card);
                    } else {
                        if (set.contains(n + 1 - card) && coin >= 2) {
                            cnt++;
                            set.remove(n + 1 - card);
                        } else {
                            set.add(card);
                        }
                    }
                }
            }
            
            if (pass > 0) {
                pass--;
            } else if (cnt > 0 && coin >= 2) {
                cnt--;
                coin -= 2;
            } else {
                break;
            }
            
            answer++;
        }
        
        return answer;
    }
}