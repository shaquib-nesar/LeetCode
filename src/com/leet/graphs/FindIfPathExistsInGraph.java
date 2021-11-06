package com.leet.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int start, int end) {

        var adjMap = getGraph(edges, n);

//        System.out.println(adjMap);
        boolean[] vis = new boolean[n];
        return dfs(adjMap, start, end, vis);

    }

    public boolean dfs(Map<Integer, List<Integer>> map, int curr, int target, boolean[] vis) {

        vis[curr] = true;

        if (curr == target) return true;

        if (map.get(curr) != null) {
            for (int i : map.get(curr)) {
                if (!vis[i] && dfs(map, i, target, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public Map<Integer, List<Integer>> getGraph(int[][] edges, int n) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (var i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (var edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }
}
