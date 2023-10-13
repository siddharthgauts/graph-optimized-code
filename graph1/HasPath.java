package graphs;
import java.util.*;

public class HasPath {

    static class Edge{

        int src;
        int dest;
        int  wt;

        // constructor
        public Edge(int s,  int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
        
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,5));
    
    }
     public static boolean hasPath(ArrayList<Edge> [] graph, int src, int dest, boolean vis[]){
        if(src==dest){ // agar koi current(src) mil jaata hai dest se tou true return kar do
            return true;
        }
        vis[src]=true;
        for(int  i =0; i<graph[src].size(); i++){        // src ==curr                     
               Edge e = graph[src].get(i);
            // e.des= neightbour
            // !vis[e.dest] = jo visited naahi hain uspar jao our fir wha se recursively visit karo
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }     
        }
        //agar mera sourse dest nahi hai our kisey neighbour se bhi waha tak nahi pahuch shakti to return kar do false;
        return false;
     }

    public static void main(String args[]){
        int V=7;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
       System.out.println(hasPath(graph, 0, 5, new boolean[V]));
    }
}
