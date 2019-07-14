import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DFS {
    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge( 0, 1);
        graph.addEdge( 0, 4);
        graph.addEdge( 1, 2);
        graph.addEdge( 1, 3);
        graph.addEdge( 1, 4);
        graph.addEdge( 2, 3);
        graph.addEdge( 3, 4);

        int[] visited = new int[V];
        dfs(visited,0,graph);
        bfs(graph);
    }

    public static void dfs(int[] visited,int src,Graph graph){
        if(visited[src]==1){
            return;
        }
        visited[src]= 1;
        System.out.println("visited = " + src);
        for(int i=0;i<graph.adArray[src].size();i++){
            dfs(visited,graph.adArray[src].get(i),graph);
        }
    }

    public static void bfs(Graph g){
        System.out.println("BFS");
        int[] visited = new int[g.adArray.length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(g.adArray[0].get(0));
        visited[g.adArray[0].get(0)]=1;
        while (!queue.isEmpty())
        {
            int poped = queue.remove();
            visited[poped]=1;
            System.out.println("visited = " + poped);
            for(int i=0;i<g.adArray[poped].size();i++){
                int curr = g.adArray[poped].get(i);
                if(visited[curr]==0){
                    visited[curr]=1;
                    queue.add(curr);
                }
            }
        }
    }
}

class Graph {
    int v;
    ArrayList<Integer>[]  adArray;

    Graph(int v) {
        this.v=v;
        adArray = new ArrayList[v];
        for(int i=0;i<v;i++){
            adArray[i] = new ArrayList<>();
        }
    }

    void addEdge(int src,int dest){
        this.adArray[src].add(dest);
        this.adArray[dest].add(src);
    }
}

