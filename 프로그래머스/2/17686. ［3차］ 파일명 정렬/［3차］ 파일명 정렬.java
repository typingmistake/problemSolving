import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        int N = files.length;
        String[][] meta = new String[N][3]; // 파일의 HEAD, NUMBER, 인덱스

        for(int i = 0; i < N; i++){
            String file = files[i];
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            int idx = 0;

            while(idx < file.length() && !Character.isDigit(file.charAt(idx))){
                head.append(file.charAt(idx++));
            }
            while(idx < file.length() && Character.isDigit(file.charAt(idx))){
                number.append(file.charAt(idx++));
            }
            meta[i] = new String[]{head.toString().toLowerCase(), number.toString(), String.valueOf(i)};
        }

        Arrays.sort(meta, (a, b) -> {
            if(a[0].equals(b[0])){
                int numA = Integer.parseInt(a[1]);
                int numB = Integer.parseInt(b[1]);
                if(numA == numB)
                    return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
                return numA - numB;
            }
            return a[0].compareTo(b[0]);
        });

        String[] ans = new String[N];
        for(int i = 0; i < N; i++){
            int idx = Integer.parseInt(meta[i][2]);
            ans[i] = files[idx];
        }

        return ans;
    }
}