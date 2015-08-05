package word_ladder;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        int n = beginWord.length();
        if(n < 1) return 0;

        Map<String, List<String>> map = new HashMap<>(n * (wordDict.size() + 2));
        addWordToMap(beginWord, map);
        for(String word : wordDict) addWordToMap(word, map);
        addWordToMap(endWord, map);

        Map<String, List<String>> graph = new HashMap<>();
        addWordToGraph(beginWord, graph, map);
        for(String word : wordDict) addWordToGraph(word, graph, map);
        addWordToGraph(endWord, graph, map);

        return getShortestPath(beginWord, endWord, graph);
    }

    private static void addWordToMap(String word, Map<String, List<String>> map) {
        int length = word.length();

        for(int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder(length);
            if(i > 0) sb.append(word.substring(0, i));
            sb.append('?');
            if(i < length - 1) sb.append(word.substring(i + 1, length));

            String key = sb.toString();
            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(word);
        }
    }

    private static void addWordToGraph(String s, Map<String, List<String>> graph, Map<String, List<String>> map) {
        int length = s.length();
        graph.putIfAbsent(s, new LinkedList<>());

        for(int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder(length);
            if(i > 0) sb.append(s.substring(0, i));
            sb.append('?');
            if(i < length - 1) sb.append(s.substring(i+1, length));

            String key = sb.toString();
            graph.putIfAbsent(key, new LinkedList<>());
            List<String> adjacentWords = map.get(key);
            if(adjacentWords != null) graph.get(s).addAll(adjacentWords);
        }

    }

    private int getShortestPath(String src, String dest, Map<String, List<String>> graph) {
        Map<String, Integer> paths = new HashMap<>();
        paths.put(src, 1);
        Deque<String> deque = new LinkedList<>();
        deque.addLast(src);

        while(!deque.isEmpty()) {
            String s = deque.removeFirst();
            int l = paths.get(s) + 1;

            List<String> adjacentWords = graph.get(s);
            if(adjacentWords == null) continue;
            for(String word : adjacentWords) {
                if(word.equals(dest)) return l;

                if(paths.containsKey(word)) continue;

                deque.addLast(word);
                paths.put(word, l);

            }
        }

        return paths.getOrDefault(dest, 0);
    }
}