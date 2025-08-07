import java.util.*;

class Solution {
    static int hitTime = 1;
    static int missTime = 5;

    class LRUCache extends LinkedHashMap<String, Integer> {
        int cacheSize;
        int totalTime = 0;

        public LRUCache(int size) {
            super(size, 1, true);
            this.cacheSize = size;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
            return size() > cacheSize; // 캐시 크기를 초과하면 가장 오래된 항목을 제거
        }

        @Override
        public Integer put(String key, Integer value) {
            if (containsKey(key)) {
                totalTime += hitTime; // 캐시 적중
            } else {
                totalTime += missTime; // 캐시 미스
            }
            return super.put(key, value);
        }

    }

    public int solution(int cacheSize, String[] cities) {
        LRUCache cache = new LRUCache(cacheSize);

        for (String city : cities) {
            String lower = city.toLowerCase();
            cache.put(lower, 1);
        }

        return cache.totalTime;
    }
}