import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int R = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);
        char[][] board = new char[R][C];

        for(int i = 0; i < R; i++){
            String row = br.readLine().strip();
            board[i] = row.toCharArray();
        }

        String[] result = find(board, R, C);

        Arrays.sort(result); // 사전순 정렬

        System.out.println(result[0]);
    }

    public static String[] find(char[][] board, int R, int C){
        List<String> result = new ArrayList<>();

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                // 세로 낱말 찾기
                if(i==0 || board[i-1][j] == '#'){
                    String word = "";
                    for(int k = i; k < R; k++){
                        if(board[k][j] == '#') break;
                        word += board[k][j];
                    }
                    if(word.length() >= 2) result.add(word);
                }

                // 가로 단어 찾기
                if(j==0 || board[i][j-1] == '#'){
                    String word = "";
                    for(int k = j; k < C; k++){
                        if(board[i][k] == '#') break;
                        word += board[i][k];
                    }
                    if(word.length() >= 2) result.add(word);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}