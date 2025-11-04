import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> colorCnt = new HashMap<>(); // 카드 색, 개수
        Map<Character, Integer> colorMaxNum = new HashMap<>(); // 카드 색, 가장 큰 숫자
        Map<Integer, Integer> numberCnt = new HashMap<>(); // 카드 숫자, 개수

        for(int i = 0; i < 5; i++){
            String[] input = br.readLine().split(" ");
            char color = input[0].charAt(0);
            int number = Integer.parseInt(input[1]);

            colorCnt.put(color, colorCnt.getOrDefault(color, 0) + 1);
            colorMaxNum.put(color, Math.max(colorMaxNum.getOrDefault(color, 0), number));
            numberCnt.put(number, numberCnt.getOrDefault(number, 0) + 1);
        }

        List<Integer> numbers = new ArrayList<>(numberCnt.keySet());
        Collections.sort(numbers);

        boolean isConsecutive = true; // 숫자가 연속적인지 여부
        if(numbers.size() == 5){
            for(int i = 1; i < numbers.size(); i++){
                if(numbers.get(i) != numbers.get(i - 1) + 1){
                    isConsecutive = false;
                    break;
                }
            }
        } else {
            isConsecutive = false;
        }

        int maxColorCount = -1; // 가장 많이 나온 색 개수
        char maxColor = ' '; // 가장 많이 나온 색
        for(Map.Entry<Character, Integer> entry : colorCnt.entrySet()){
            int count = entry.getValue();
            if(count > maxColorCount) {
                maxColorCount = count;
                maxColor = entry.getKey();
            }
        }

        int maxNumberCount = -1; // 가장 많이 나온 숫자 개수
        int maxNumber = -1; // 가장 많이 나온 숫자
        for(Map.Entry<Integer, Integer> entry : numberCnt.entrySet()){
            int count = entry.getValue();
            if(count > maxNumberCount) {
                maxNumberCount = count;
                maxNumber = entry.getKey();
            }
        }

        // 1
        if(maxColorCount == 5 && isConsecutive) {
            System.out.println(900 + colorMaxNum.get(maxColor));
            return;
        }

        // 2
        if(maxNumberCount == 4) {
            System.out.println(800 + maxNumber);
            return;
        }

        // 3
        if(maxNumberCount == 3 && numberCnt.size() == 2) {
            int result = 700;
            for(Map.Entry<Integer, Integer> entry : numberCnt.entrySet()){
                int num = entry.getKey();
                if(num == maxNumber){
                    result += num * 10;
                } else {
                    result += num;
                }
            }
            System.out.println(result);
            return;
        }

        // 4
        if(maxColorCount == 5) {
            System.out.println(600 + colorMaxNum.get(maxColor));
            return;
        }

        // 5
        if(isConsecutive) {
            System.out.println(500 + Collections.max(colorMaxNum.values()));
            return;
        }

        // 6
        if(maxNumberCount == 3) {
            System.out.println(400 + maxNumber);
            return;
        }

        // 7
        if(maxNumberCount == 2 && numberCnt.size() == 3) {
            int min = Integer.MAX_VALUE;
            int max = -1;

            for(Map.Entry<Integer, Integer> entry : numberCnt.entrySet()){
                if(entry.getValue() == 2){
                    int num = entry.getKey();
                    min = Math.min(min, num);
                    max = Math.max(max, num);
                }
            }

            System.out.println(300 + max * 10 + min);
            return;
        }

        // 8
        if(maxNumberCount == 2) {
            System.out.println(200 + maxNumber);
            return;
        }

        // 9
        System.out.println(100 + Collections.max(colorMaxNum.values()));
    }
}