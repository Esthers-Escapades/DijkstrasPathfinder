package project_folder;
import java.util.Comparator;
public class Node implements Comparator<Node>{
    private String id;
    private Integer duration;

    public Node(){}
    
    public Node(String id, Integer duration){
        this.id = id;
        this.duration = duration;
    }

    public String getId(){
        return id;
    }

    
    public Integer getDuration(){
        return duration;
    }

@Override public int compare(Node node1, Node node2){
    if(node1.duration < node2.duration){
        return -1;
    }
    if(node1.duration > node2.duration){

    }
    return 0;
}

//for printing out node

public String toString(){
    return "ID: " + this.id + "\nDuration: " + this.duration;
}

}
