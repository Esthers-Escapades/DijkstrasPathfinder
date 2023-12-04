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
            neighborsA.put("B",calculateDistance(23, 23, 3,24, 20));
            neighborsA.put("I",calculateDistance( 23,23,3,18,19));
            graph.put("A",neighborsA);


        HashMap<String, Integer> neighborsB = new HashMap<>();
            neighborsB.put("C",calculateDistance(24,20,1, 21,13));
            neighborsB.put("A",calculateDistance(24, 20, 1,23, 23));
            graph.put("B",neighborsB);

        HashMap<String, Integer> neighborsC = new HashMap<>();
            neighborsC.put("D",calculateDistance(21, 13, 3, 25, 11));
            neighborsC.put("B",calculateDistance(21, 13, 3, 24, 20));
            // neighborsD.put("",calculateDistance(0, 0, 0, 0, 0));
            graph.put("C",neighborsC);

        HashMap<String, Integer> neighborsD = new HashMap<>();
            neighborsD.put("C",calculateDistance(25, 11, 1,21, 13));
            // neighborsD.put("",calculateDistance(0, 0, 0, 0, 0));
            graph.put("D",neighborsD);

            HashMap<String, Integer> neighborsI = new HashMap<>();
            neighborsI.put("A",calculateDistance(18,19,1,23,23));
            graph.put("I",neighborsI);

//print out hashmap
for(String id : graph.keySet()){
    String key = id.toString();
    String value = graph.get(id).toString();
    System.out.println(key + ":" + value);
}
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

    public static Integer calculateDistance(int x1,int y1,int tt, int x2,int y2){
        int distance = (int) Math.sqrt( ((y2-y1)*(y2-y1)) +  ((x2-x1)*(x2-x1)))   ;
        Integer time = (distance + tt) * 10;

        return time;

    }
    
   
    //create graph of the map
    // public static ArrayList<ArrayList<Integer>> createGraph(int start){



    // }

    //method for adding edges to graph
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int start, int end ){

    }





    //represents a point on the map 
    class Location {
        //id represents the locatino id
        String id;
        LinkedList<Location> neighbors;

        public Location(String id){
            this.id = id;
            this.neighbors = new LinkedList<>();
        }

    }

    
}