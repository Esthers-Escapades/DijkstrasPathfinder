package project_folder;
import java.util.*;

public class pathfinder{


    public static void main(String[] args){
        //ask user for start and end location
        System.out.println("Pick a starting location from A - J");
        Scanner input = new Scanner(System.in);

        String start = input.next().toUpperCase().trim();

        System.out.println("Pick an end location from A - B");
        String end = input.next().toUpperCase().trim();

        //set number of locations
        int L = 10;
    

        //Populate Adjacency List
   HashMap<String, ArrayList<Node>>  al = new HashMap<>();
        
        //populate graph 
        ArrayList<Node> neighborsA = new ArrayList<>();
            neighborsA.add(new Node("B",calculateDistance(23, 23, 3,24, 20,1,0)));
            neighborsA.add(new Node("I",calculateDistance(23,23,3,18,19,1,2)));
            al.put("A",neighborsA);


        ArrayList<Node> neighborsB = new ArrayList<>();
            neighborsB.add(new Node("C",calculateDistance(24,20,1, 21,13,3,2)));
            neighborsB.add( new Node("A",calculateDistance(24, 20, 1,23, 23,3,1)));
            al.put("B",neighborsB);

        ArrayList<Node> neighborsC = new ArrayList<>();
            neighborsC.add(new Node("D",calculateDistance(21, 13, 3, 25, 11,1,3)));
            neighborsC.add(new Node("B",calculateDistance(21, 13, 3, 24, 20,1,0)));
            neighborsC.add(new Node("E",calculateDistance(21, 13, 3, 20, 7,3,0)));
            al.put("C",neighborsC);

        ArrayList<Node> neighborsD = new ArrayList<>();
            neighborsD.add(new Node("C",calculateDistance(25, 11, 1,21, 13,3,2)));
            neighborsD.add(new Node("E",calculateDistance(25, 11, 1, 20, 7,3,0)));
            al.put("D",neighborsD);

        ArrayList<Node> neighborsE = new ArrayList<>();
            neighborsE.add(new Node("C",calculateDistance(20,7,3,21,13,3,2)));
            neighborsE.add(new Node("D",calculateDistance(20,7,3,25,11,1,3)));
            neighborsE.add(new Node("F",calculateDistance(20,7,3,20,4,0,0)));
            neighborsE.add(new Node("H",calculateDistance(20,7,3,15,11,0,4)));
            al.put("E",neighborsE);

        ArrayList<Node> neighborsF = new ArrayList<>();
            neighborsF.add(new Node("E",calculateDistance(20,4,0,20,7,3,0)));
            neighborsF.add(new Node("G",calculateDistance(20,4,0,24,2,2,1)));
            al.put("F",neighborsF);

        ArrayList<Node> neighborsG = new ArrayList<>();
            neighborsG.add(new Node("F",calculateDistance(24,2,2,20,4,0,0)));
            al.put("G",neighborsG);

        ArrayList<Node> neighborsH = new ArrayList<>();
            neighborsH.add(new Node("E",calculateDistance(15,11,0,20,7,3,0)));
            neighborsH.add(new Node("I",calculateDistance(15,11,0,18,19,1,2)));
            al.put("H",neighborsH);

        ArrayList<Node> neighborsI = new ArrayList<>();
            neighborsI.add(new Node("A",calculateDistance(18,19,1,23,23,3,1)));
            neighborsI.add(new Node("H",calculateDistance(18,19,1,15,11,0,4)));
            neighborsI.add(new Node("J",calculateDistance(18,19,1,19,24,1,0)));
            al.put("I",neighborsI);

        ArrayList<Node> neighborsJ = new ArrayList<>();
            neighborsJ.add(new Node("I",calculateDistance(19,24,1,18,19,1,2)));
            al.put("J",neighborsJ);

//TESTING: print out hashmap
/*for (Map.Entry<String, ArrayList<Node>> entry : al.entrySet()) {
    String key = entry.getKey();
    ArrayList<Node> value = entry.getValue();

    System.out.println("Key: " + key);
    
    // Print each Node in the ArrayList
    for (Node node : value) {
        System.out.println("  Node ID: " + node.getId() + ", Duration: " + node.getDuration());
    }
}*/
    // run dijkstra's 
       System.out.println( dijkstra(al,start,end,L));
        
      
    }

    // calculate distance from point A to point B

    public static Integer calculateDistance(int x1,int y1,int tt, int x2,int y2,int tt2,int me){
        int distance = (int) Math.sqrt( ((y2-y1)*(y2-y1)) +  ((x2-x1)*(x2-x1)))   ;
        Integer time = (distance + tt + tt2) * 10;

        return time;

    }
    
    //Dijkstra's algorithm

    public static String dijkstra(HashMap<String,ArrayList<Node>> graph, String start, String end, int L){
        

        Map<String, Integer> duration = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(L, new Node());

        
        //create empty lists visited and unvisited to keep track of nodes
            ArrayList<String> unvisited = new ArrayList<>();
            ArrayList<String> visited = new ArrayList<>();
        

        //set duration to all locations to infinity
            for (String id : graph.keySet()) {
                duration.put(id, Integer.MAX_VALUE);
                unvisited.add(id);
    }

        //set starting node as 0
        pq.add(new Node(start,0));
        duration.replace(start,0);


        int finalDistance = 0;

        while(!pq.isEmpty()){
            //remove top element
            Node currNode = pq.poll();
           // Testing print statement
            //System.out.println(currNode);
          
            //if we've already gotten the shortest then skip
            if(visited.contains(currNode.getId())) continue;

            
            visited.add(currNode.getId());
            unvisited.remove(currNode.getId());

            //update neighbor travel duration
            for(Node neighbor : graph.get(currNode.getId())){
             //   System.out.println("Node " + currNode.getId() + " has neighbor: " + neighbor );
                if(duration.containsKey(neighbor.getId())){
                    int newDuration = duration.get(currNode.getId()) + neighbor.getDuration();

                    if(newDuration < duration.get(neighbor.getId())){
                        duration.replace(neighbor.getId(), newDuration);
                        pq.add(new Node(neighbor.getId(), newDuration));
                     }
                }

            }
        }

        finalDistance = duration.get(end);

        String returnMessage = "The distance from " + start + " to " + end + " is " + finalDistance;
        return returnMessage; 
    }
    

 


}