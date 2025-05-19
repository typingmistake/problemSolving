import java.util.*;

class Solution {

    List<String> ans = new ArrayList<>();

    class Cell {
        String s = ""; // 초기값은 빈 문자열
        Cell parent = this; // 초기값은 자기 자신

        Cell find() {
            // 경로 압축
            if (this != parent)
                this.parent = parent.find();
            return this.parent;
        }

        void set(String s) {
            this.parent.s = s;
        }

        boolean isEmpty() {
            return this.parent.s.isEmpty();
        }
    }

    public String[] solution(String[] commands) {
        Cell[][] table = new Cell[50][50];

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                table[i][j] = new Cell();
            }
        }

        for (String command : commands) {
            func(command, table);
        }

        return ans.toArray(String[]::new);
    }

    public void func(String command, Cell[][] table) {
        StringTokenizer st = new StringTokenizer(command);
        String cmd = st.nextToken();

        switch (cmd) {
            case "UPDATE" -> {
                if (st.countTokens() == 3) {
                    int r = Integer.parseInt(st.nextToken()) - 1;
                    int c = Integer.parseInt(st.nextToken()) - 1;
                    String s = st.nextToken();
                    table[r][c].find().set(s);

                } else {
                    String s1 = st.nextToken();
                    String s2 = st.nextToken();
                    for (int r = 0; r < 50; r++) {
                        for (int c = 0; c < 50; c++) {
                            if (table[r][c].find().s.equals(s1)) {
                                table[r][c].parent.set(s2);
                            }
                        }
                    }
                }
            }

            case "MERGE" -> {
                int r1 = Integer.parseInt(st.nextToken()) - 1;
                int c1 = Integer.parseInt(st.nextToken()) - 1;
                int r2 = Integer.parseInt(st.nextToken()) - 1;
                int c2 = Integer.parseInt(st.nextToken()) - 1;

                Cell cell1 = table[r1][c1].find();
                Cell cell2 = table[r2][c2].find();
                if (cell1.isEmpty()) {
                    cell1.parent = cell2;
                } else {
                    cell2.parent = cell1;
                }
            }

            case "UNMERGE" -> {
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                Cell cell = table[r][c].find();
                String s = cell.s;

                for (int i = 0; i < 50; i++) {
                    for (int j = 0; j < 50; j++) {
                        if (table[i][j].find() == cell) {
                            table[i][j] = new Cell();
                        }
                    }
                }

                table[r][c].set(s);
            }

            case "PRINT" -> {
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                Cell cell = table[r][c].find();

                if (cell.isEmpty()) {
                    ans.add("EMPTY");
                } else {
                    ans.add(cell.s);
                }
            }

        }
    }
}