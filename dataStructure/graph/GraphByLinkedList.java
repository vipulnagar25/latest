package dataStructure.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphByLinkedList {
    private List<Integer>[] adj;
    private int V;
    private int E;

    public GraphByLinkedList(int V) {
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v1, int v2) {
        adj[v1].add(v2);
        adj[v2].add(v1);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices, ").append(E).append(" edges ").append("\n");
        for (int i = 0; i < V; i++) {
            sb.append(i).append(":   ");
            for (int w : adj[i]) {
                sb.append(w).append("          ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfsGraph(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + "--->");
            for (int w : adj[u]) {
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }

        }

    }

    public void dfsGraph(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        visited[s] = true;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            System.out.print(u + "--->");
            for (int w : adj[u]) {
                if (!visited[w]) {
                    visited[w] = true;
                    stack.push(w);
                }
            }
        }

    }

    // Check if graph has a cycle
    public boolean hasCycle() {
        boolean[] visited = new boolean[V];
        // Check every node (for disconnected graph)
        for (int node = 0; node < V; node++) {
            if (!visited[node]) {
                if (dfs(node, -1, visited)) {
                    return true; // cycle found
                }
            }
        }
        return false; // no cycle
    }

    // DFS helper
    private boolean dfs(int current, int parent, boolean[] visited) {
        visited[current] = true;

        for (int neighbor : adj[current]) {

            // If not visited → go deeper
            if (!visited[neighbor]) {
                if (dfs(neighbor, current, visited)) {
                    return true;
                }
            }
            // If visited and not parent → cycle
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
    public boolean hasCycleBFS() {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, visited)) {
                    return true; // cycle found
                }
            }
        }
        return false;
    }

    private boolean bfs(int start, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();

        // {node, parent}
        queue.add(new int[]{start, -1});
        visited[start] = true;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int nei : adj[node]) {

                if (!visited[nei]) {
                    visited[nei] = true;
                    queue.add(new int[]{nei, node});
                }

                // visited and not parent → cycle
                else if (nei != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    static void main() {
        GraphByLinkedList g = new GraphByLinkedList(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println(g);
        g.bfsGraph(0);
        System.out.println();
        g.dfsGraph(0);
        System.out.println();
        System.out.println(g.hasCycle());
    }


}
