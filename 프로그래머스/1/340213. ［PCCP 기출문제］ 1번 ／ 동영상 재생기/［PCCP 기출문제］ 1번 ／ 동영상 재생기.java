class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        pos = skip(pos, op_start, op_end);

        for (String command : commands) {
            if (command.equals("next")) {
                pos = next(video_len, pos);
            } else {
                pos = prev(pos);
            }

            pos = skip(pos, op_start, op_end);
        }

        return pos;
    }

    public String next(String video_len, String pos) {
        int[] res = add(pos, "00:10");

        pos = String.format("%02d:%02d", res[0], res[1]);

        if (compare(video_len, pos) == -1) {
            return video_len;
        }

        return pos;
    }

    public String prev(String pos) {
        int[] res = sub(pos, "00:10");

        return String.format("%02d:%02d", res[0], res[1]);
    }

    public String skip(String pos, String op_start, String op_end) {
        if (compare(pos, op_start) == 1 && compare(op_end, pos) == 1) {
            return op_end;
        }
        return pos;
    }

    public int[] add(String time1, String time2) {
        String[] parts1 = time1.split(":");
        String[] parts2 = time2.split(":");
        int min1 = Integer.parseInt(parts1[0]);
        int sec1 = Integer.parseInt(parts1[1]);
        int min2 = Integer.parseInt(parts2[0]);
        int sec2 = Integer.parseInt(parts2[1]);

        int min = min1 + min2;
        int sec = sec1 + sec2;

        if (sec >= 60) {
            min++;
            sec -= 60;
        }

        return new int[] { min, sec };

    }

    public int[] sub(String time1, String time2) {
        String[] parts1 = time1.split(":");
        String[] parts2 = time2.split(":");
        int min1 = Integer.parseInt(parts1[0]);
        int sec1 = Integer.parseInt(parts1[1]);
        int min2 = Integer.parseInt(parts2[0]);
        int sec2 = Integer.parseInt(parts2[1]);

        int min = min1 - min2;
        int sec = sec1 - sec2;

        if (sec < 0) {
            min--;
            sec += 60;
        }

        if (min < 0) {
            min = 0;
            sec = 0;
        }

        return new int[] { min, sec };
    }

    // time1 >= time2: 1
    // time1 < time2: -1
    public int compare(String time1, String time2) {
        int min1 = Integer.parseInt(time1.split(":")[0]);
        int sec1 = Integer.parseInt(time1.split(":")[1]);
        int min2 = Integer.parseInt(time2.split(":")[0]);
        int sec2 = Integer.parseInt(time2.split(":")[1]);

        if (min1 > min2) {
            return 1;
        } else if (min1 < min2) {
            return -1;
        } else {
            if (sec1 >= sec2) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
