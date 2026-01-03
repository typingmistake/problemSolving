import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> pairs;
    static List<Integer> list;
    static String exp;
    static Set<String> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pairs = new HashMap<>();
        list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        exp = br.readLine().trim();
        results = new HashSet<>();

        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);

            if(c == '('){
                stack.push(i);
                list.add(i);
            } else if(c == ')'){
                pairs.put(stack.pop(), i);
            }
        }

        solve(0, new boolean[exp.length()]);

        List<String> sorted = new ArrayList<>(results);
        sorted.sort(String::compareTo);

        for(String res : sorted){
            System.out.println(res);
        }
    }

    public static void solve(int depth, boolean[] removed){
        if(depth == list.size()){
            add(removed);
            return;
        }

        int openIdx = list.get(depth);
        int closeIdx = pairs.get(openIdx);

        // 괄호 제거
        removed[openIdx] = true;
        removed[closeIdx] = true;
        solve(depth+1, removed);
        removed[openIdx] = false;
        removed[closeIdx] = false;

        // 괄호 유지
        solve(depth+1, removed);
    }

    public static void add(boolean[] removed){
        StringBuilder sb = new StringBuilder();
        boolean anyRemoved = false;

        for(int i = 0; i < exp.length(); i++){
            if(removed[i]){
                anyRemoved = true;
                continue;
            }
            sb.append(exp.charAt(i));
        }

        if(anyRemoved){
            results.add(sb.toString());
        }
    }
}