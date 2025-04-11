class Solution {
    public int solution(String[] board) {
        // O는 X와 같거나 1개만 더 많아야 한다.
        if (checkCount(board) == false) {
            return 0;
        }

        int rowCount = 0;
        int columnCount = 0;
        boolean xWin = false;
        boolean oWin = false;

        for (int i = 0; i < 3; i++) {
            // 가로줄 완성
            if (board[i].charAt(0) == 'X' && board[i].charAt(1) == 'X' && board[i].charAt(2) == 'X') {
                rowCount++;
                xWin = true;
            }

            // 세로줄 완성
            if (board[i].charAt(0) == 'O' && board[i].charAt(1) == 'O' && board[i].charAt(2) == 'O') {
                rowCount++;
                oWin = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X') {
                columnCount++;
                xWin = true;
            }
            if (board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O') {
                columnCount++;
                oWin = true;
            }
        }

        if (board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X') {
            xWin = true;
        }
        if (board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O') {
            oWin = true;
        }

        if (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X') {
            xWin = true;
        }
        if (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O') {
            oWin = true;
        }

        // 여러 줄이 이겼다면 불가능하다.
        if (rowCount > 1 || columnCount > 1) {
            return 0;
        }

        // X가 이겼을 때는 X와 O의 개수가 같아야 함
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'X') {
                    xCount++;
                } else if (board[i].charAt(j) == 'O') {
                    oCount++;
                }
            }
        }

        // X와 O의 개수가 2개 이상이면 불가능하다.
        if (rowCount > 1 || columnCount > 1) {
            return 0;
        }

        // X가 이겼는데 O가 더 많거나, O가 이겼는데 O가 X보다 1개 더 많지 않으면 불가능
        if (xWin && xCount != oCount) {
            return 0;
        }
        if (oWin && oCount != xCount + 1) {
            return 0;
        }

        return 1;
    }

    public static boolean checkCount(String[] board) {
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'X') {
                    xCount++;
                } else if (board[i].charAt(j) == 'O') {
                    oCount++;
                }
            }
        }
        if (xCount == oCount || oCount == xCount + 1) {
            return true;
        }
        return false;
    }
}