import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class TrieNode{
        Map<String, TrieNode> children;
        String word;

        TrieNode(){
            children = new HashMap<>();
        }

        void append(String[] words, int idx){
            this.word = words[idx++];
            if(idx == words.length) return;
            String nextWord = words[idx];

            if(!children.containsKey(nextWord)){
                children.put(nextWord, new TrieNode());
            }

            children.get(nextWord).append(words, idx);
        }

        void dfs(int depth){
            List<String> keys = new ArrayList<>(children.keySet());
            Collections.sort(keys); // 사전순 정렬

            for(String key : keys){
                if(depth >= 0) System.out.println("--".repeat(depth) + key);
                children.get(key).dfs(depth + 1);
            }
        }
    }

    static class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        void add(String str){
            String[] words = str.split(" ");
            root.append(words, 0);
        }
        void dfs(){
            root.dfs(0);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());

        Trie trie = new Trie();

        for(int i = 0; i < N; i++){
            String line = sc.readLine();
            trie.add(line);
        }

        trie.dfs();
    }
}