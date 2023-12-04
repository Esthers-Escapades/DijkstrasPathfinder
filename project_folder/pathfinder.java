package project_folder;
import java.util.*;
//import java.util.LinkedList;
//import java.util.HashMap;
public class pathfinder{

    public static void main(String[] args){
        //create a graph
        HashMap<String, Map<String,Integer>> graph = new HashMap<>();

        //populate graph 
        HashMap<String, Integer> neighborsA = new HashMap<>();
            neighborsA.put("B",calculateDistance(23, 23, 3,24, 20,1));
            neighborsA.put("I",calculateDistance( 23,23,3,18,19,1));
            graph.put("A",neighborsA);


        HashMap<String, Integer> neighborsB = new HashMap<>();
            neighborsB.put("C",calculateDistance(24,20,1, 21,13,3));
            neighborsB.put("A",calculateDistance(24, 20, 1,23, 23,3));
            graph.put("B",neighborsB);

        HashMap<String, Integer> neighborsC = new HashMap<>();
            neighborsC.put("D",calculateDistance(21, 13, 3, 25, 11,1));
            neighborsC.put("B",calculateDistance(21, 13, 3, 24, 20,1));
            // neighborsD.put("",calculateDistance(0, 0, 0, 0, 0));
            graph.put("C",neighborsC);

        HashMap<String, Integer> neighborsD = new HashMap<>();
            neighborsD.put("C",calculateDistance(25, 11, 1,21, 13,3));
            // neighborsD.put("",calculateDistance(0, 0, 0, 0, 0,0));
            graph.put("D",neighborsD);

            HashMap<String, Integer> neighborsI = new HashMap<>();
            neighborsI.put("A",calculateDistance(18,19,1,23,23,3));
            graph.put("I",neighborsI);

//print out hashmap
for(String id : graph.keySet()){
    String key = id.toString();
    String value = graph.get(id).toString();
    System.out.println(key + ":" + value);
} 

dijkstra(graph, "A", "B");
/* 
        HashMap<String, Integer> neighborsE = new HashMap<>();
        neighborsE.put("",calculateDistance(0, 0, 0, 0, 0));
        neighborsE.put("",calculateDistance(0, 0, 0, 0, 0));
        neighborsE.put("",calculateDistance(0, 0, 0, 0, 0));
        neighborsE.put("",calculateDistance(0, 0, 0, 0, 0));
        graph.put("E",);

        HashMap<String, Integer> neighborsF = new HashMap<>();
        neighborsF.put("",calculateDistance(0, 0, 0, 0, 0));
        neighborsF.put("",calculateDistance(0, 0, 0, 0, 0));
        graph.put("F",);

        HashMap<String, Integer> neighborsG = new HashMap<>();
        neighborsG.put("",calculateDistance(0, 0, 0, 0, 0));
        graph.put("G",);

        HashMap<String, Integer> neighborsH = new HashMap<>();
        neighborsH.put("",calculateDistance(0, 0, 0, 0, 0));
        neighborsH.put("",calculateDistance(0, 0, 0, 0, 0));
        graph.put("H",);

        HashMap<String, Integer> neighborsJ = new HashMap<>();
        neighborsJ.put("",calculateDistance(0, 0, 0, 0, 0));
        neighborsJ.put("",calculateDistance(0, 0, 0, 0, 0));
        graph.put("J",);

        HashMap<String, Integer> neighborsK = new HashMap<>();
        neighborsK.put("",calculateDistance(0, 0, 0, 0, 0));
        neighborsK.put("",calculateDistance(0, 0, 0, 0, 0));
        neighborsK.put("",calculateDistance(0, 0, 0, 0, 0));
        graph.put("K",);

*/
      
    }

    // calculate distance from point A to point B

    public static Integer calculateDistance(int x1,int y1,int tt, int x2,int y2,int tt2){
        int distance = (int) Math.sqrt( ((y2-y1)*(y2-y1)) +  ((x2-x1)*(x2-x1)))   ;
        Integer time = (distance + tt + tt2) * 10;

        return time;

    }
    
    //Dijkstra's algorithm

    public static void dijkstra( HashMap<String, Map<String,Integer>> graph, String start, String end){
        System.out.println(getWeight(graph,start,end));
        
    }

    public static int getWeight(HashMap<String, Map<String,Integer>> graph,String s, String e){
//get key, then key within the value, then get thee value 
    //System.out.println(graph.get(s).get(e).toString());
    return graph.get(s).get(e);

    }





    
}