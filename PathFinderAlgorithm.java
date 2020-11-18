
package lab2;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gagnon
 */

/**
* This class is used to find all possible non-looping paths from all nodes
* available in the provided adjacency matrix
*/
public class PathFinderAlgorithm {
     
     private  boolean visitedNode[];
     private  AdjacencyMatrix matrix;

    /**
     * The printAllPath method use to find all path and print them using member method findPath
     * based on parameter adjacencyMatrix provided to find all paths
    */
    public void printAllPath(AdjacencyMatrix adjacencyMatrix){
        matrix = adjacencyMatrix; // Assign provided adjacencyMatrix to local matrix variable of AdjacencyMatrix class
        System.out.println("Here are all possible non-looping paths between all possible pairs of nodes");
        for (int from=0; from < matrix.getSize(); from++){ // run a loop for starting node of path up to matrix size
            visitedNode = new boolean[matrix.getSize()]; // track visited node
            List<Integer> pathList = new ArrayList<>(); // store the path node
            pathList.add(from); // add starting node in path List
            findPath(from, pathList, 1);
        }
    }

    /**
     * The findPath method use DFS path finding algorithm to find and print the path starting from the value provided from
     * parameter from which is the node start point or check for next directed node that is present.
     * Parameter pathList is a list that collects all the node in the path
     * Parameter index is the current index of the list
     */
    private void findPath(int from, List<Integer> pathList, int index){
        boolean isEndVertex = true;
        // check the from node contain other node directed from from node to other node and also check whether it is visited or not
        for(int row=0;row< matrix.getSize();row++){
            if(matrix.getDirectionalEdge(from,row)==1 && (!visitedNode[row]|| pathList.get(0)==row)){
                isEndVertex = false; // from node is not the last vertex of path if it has another node directed from from node and not visited or equal to starting node
                break;
            }
        }
        // if from is last vertex or is visited previously then print path list and return
        if(isEndVertex || visitedNode[from]){
            if(index==1){ // if from node has no path then print No path found
                System.out.println("No path found for node "+pathList.get(0));
                return;
            }
            System.out.println(pathList); // print path for all nodes
            return;
        }
        visitedNode[from] = true; // make from node visited
        for (int to=0 ; to<matrix.getSize(); to++) {
            
            // if another node directed from from node and not visited or equal to starting node
            if ((pathList.get(0) == to || !visitedNode[to]) && matrix.getDirectionalEdge(from,to)==1) {
                pathList.add(to); // add next node to path list
                index ++; // increase index
                findPath(to,pathList,index); // call findPath recursive method with current list , new from , and index of list
                pathList.remove(--index); // remove last added element of list i.e. to node
            }
        }
        visitedNode[from] = false; // make from node not visited
    }
    
}
