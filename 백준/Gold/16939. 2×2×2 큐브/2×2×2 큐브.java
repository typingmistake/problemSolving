import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] original = new int[24];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < 24; i++) {
            original[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < 6; i++) {
            for (int d = 0; d < 2; d++) {
                int[] arr = original.clone();

                if (i == 0) { // 윗면
                    int t1 = arr[4], t2 = arr[5];
                    if (d == 0) {
                        arr[4] = arr[16]; arr[5] = arr[17];
                        arr[16] = arr[21]; arr[17] = arr[20];
                        arr[21] = arr[12]; arr[20] = arr[13];
                        arr[12] = t1; arr[13] = t2;
                    } else {
                        arr[4] = arr[12]; arr[5] = arr[13];
                        arr[12] = arr[21]; arr[13] = arr[20];
                        arr[21] = arr[16]; arr[20] = arr[17];
                        arr[16] = t1; arr[17] = t2;
                    }
                } else if (i == 1) { // 앞면
                    int t1 = arr[2], t2 = arr[3];
                    if (d == 0) {
                        arr[2] = arr[15]; arr[3] = arr[13];
                        arr[15] = arr[9]; arr[13] = arr[8];
                        arr[9] = arr[16]; arr[8] = arr[18];
                        arr[16] = t1; arr[18] = t2;
                    } else {
                        arr[2] = arr[16]; arr[3] = arr[18];
                        arr[16] = arr[9]; arr[18] = arr[8];
                        arr[9] = arr[15]; arr[8] = arr[13];
                        arr[15] = t1; arr[13] = t2;
                    }
                } else if (i == 2) { // 아랫면
                    int t1 = arr[6], t2 = arr[7];
                    if (d == 0) {
                        arr[6] = arr[18]; arr[7] = arr[19];
                        arr[18] = arr[23]; arr[19] = arr[22];
                        arr[23] = arr[14]; arr[22] = arr[15];
                        arr[14] = t1; arr[15] = t2;
                    } else {
                        arr[6] = arr[14]; arr[7] = arr[15];
                        arr[14] = arr[23]; arr[15] = arr[22];
                        arr[23] = arr[18]; arr[22] = arr[19];
                        arr[18] = t1; arr[19] = t2;
                    }
                } else if (i == 3) { // 왼면
                    int t1 = arr[0], t2 = arr[2];
                    if (d == 0) {
                        arr[0] = arr[21]; arr[2] = arr[23];
                        arr[21] = arr[10]; arr[23] = arr[8];
                        arr[10] = arr[4]; arr[8] = arr[6];
                        arr[4] = t1; arr[6] = t2;
                    } else {
                        arr[0] = arr[4]; arr[2] = arr[6];
                        arr[4] = arr[10]; arr[6] = arr[8];
                        arr[10] = arr[21]; arr[8] = arr[23];
                        arr[21] = t1; arr[23] = t2;
                    }
                } else if (i == 4) { // 오른면
                    int t1 = arr[1], t2 = arr[3];
                    if (d == 0) {
                        arr[1] = arr[22]; arr[3] = arr[20];
                        arr[22] = arr[9]; arr[20] = arr[11];
                        arr[9] = arr[5]; arr[11] = arr[7];
                        arr[5] = t1; arr[7] = t2;
                    } else {
                        arr[1] = arr[5]; arr[3] = arr[7];
                        arr[5] = arr[9]; arr[7] = arr[11];
                        arr[9] = arr[22]; arr[11] = arr[20];
                        arr[22] = t1; arr[20] = t2;
                    }
                } else if (i == 5) { // 뒷면
                    int t1 = arr[0], t2 = arr[1];
                    if (d == 0) {
                        arr[0] = arr[17]; arr[1] = arr[19];
                        arr[17] = arr[11]; arr[19] = arr[10];
                        arr[11] = arr[12]; arr[10] = arr[14];
                        arr[12] = t1; arr[14] = t2;
                    } else {
                        arr[0] = arr[12]; arr[1] = arr[14];
                        arr[12] = arr[11]; arr[14] = arr[10];
                        arr[11] = arr[17]; arr[10] = arr[19];
                        arr[17] = t1; arr[19] = t2;
                    }
                }

                if (check(arr)) {
                    System.out.println("1");
                    return;
                }
            }
        }

        System.out.println("0");
    }

    public static boolean check(int[] arr) {
        for (int i = 0; i < 6; i++) {
            int n = arr[i * 4];
            for (int j = 1; j < 4; j++) {
                if (arr[i * 4 + j] != n) return false;
            }
        }
        return true;
    }
}