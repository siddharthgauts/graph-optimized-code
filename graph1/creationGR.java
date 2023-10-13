package graphs;
import  java.util.*;

public class creationGR {

    static class Edge{ //information store karne keliye Edges

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
    
    public static void main(String args[]){

//         (5)
//     0----------1
//             /    \ 
//       (1) /       \(3)   
//         /          \
//        2  --------- 3
//        |     (1)
//    (2) |
//        |
//        |
//        4


    int V= 5;
    // int arr[]= new arr[V];
    //ArrayList of graph
    ArrayList<Edge>[] graph = new ArrayList[V];// null--> Empty  arrayList

    for(int i=  0; i<V; i++){
        graph[i]= new ArrayList<>(); //i waale vertex  pe jaa raha hu our waha ek new AL create kar raha hu
    }

    // 0 -vertex
    graph[0].add(new Edge(0,1,5));

    //1 vertex
    graph[1].add(new Edge(1,0,5));
    graph[1].add(new Edge(1,2,1));
    graph[1].add(new Edge(1,3,3));

    //2 vertex
    graph[2].add(new Edge(2,1,1));
    graph[2].add(new Edge(2, 3,1));
    graph[2].add(new Edge(2,4,2));


    //3 vertex
    graph[3].add(new Edge(3,1,3));
    graph[3].add(new Edge(3,2,1));

    //4 vertex
    graph[4].add(new Edge(4,2,2));

    //information of Edge 1
    for(int i=0; i<graph[1].size(); i++){
        //Edge me source, destination, weight hnoga
        Edge e= graph[1].get(i); // arraylist of edge nikaungal fir Edge jo khud ek AL hai uske ith index par jaakr value fetch karunga
        System.out.println(e.src+" " + e.dest+" " + e.wt);// Edge 1 from src  to dest  and their weight will be printed
    }
    }
}
