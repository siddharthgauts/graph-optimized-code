package graphs;
//15 lines
import java.util.*;
public class DetectCyclesUnDirected {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src=s;
            this.dest=d;

        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));        
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static boolean detectCycles(ArrayList<Edge> [] graph){
        boolean vis[]= new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(detectCyclesUtil(graph, vis, i, -1)){
                    return true;
                    // cyle exit in one of the part
                }
            }
        }
        return false;
    }

    public static boolean detectCyclesUtil(ArrayList<Edge>[] graph, boolean  vis[], int curr, int par){
        vis[curr]= true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e= graph[curr].get(i);
            //case 3
            if(!vis[e.dest]){                                      //agar mera neighbour unvisted hain our usko vist karne ke baad detectcyleutil ture de deta hai iska mtlb cyle exit karta hai
                if( detectCyclesUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            } 
            //case 1
             else  if(vis[e.dest] && e.dest!=par){ // 2 vist karega 1 ko fir 0 ko fir wo dekgega 0 uska parent bhi  nahi hai our visted bhi hai tou wo 1 ko true return kar deega  our 1 0 ko ture retunr kar dega so final output true hoga 
                return true;
             }
             // case 2--> d0 nothing --> continue
        }
        return false;
    }

    public static void main(String args[]){

        /*
        
           0-----3
          /|     |
         / |     |
        1  |     4
         \ |
          \|
           2

         */

         int V = 5;
         ArrayList<Edge> graph[] = new ArrayList[V];
         createGraph(graph);

         System.out.println(detectCycles(graph));


    }
}
