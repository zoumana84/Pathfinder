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
 * This class is used to
 * store adjacency nodes data
 * a[i][j] = 1 represent i directed from i to j
 * a[i][j] = 0 represent i was not directed from i to j
 * The variable matrix of two dimension array use to store adjacency
 * size store the size of matrix
 */

package lab2;
public class AdjacencyMatrix {
    private int matrix[][];

    private int size;

    /**
     * Constructor initialize matrix and size value
     * Parameter size define the size of a two dimension array
    */
    public AdjacencyMatrix(int size) {
        this.matrix = new int[size][size];
        this.size = size;
    }

    /**
     * add direction of node
     * Parameter from is where the direction start
     * Parameter to is where the direction heads to
     */
    public void addDirectionalEdge(int from, int to){
        matrix[from][to]=1;
    }
    /**
     * get direction of node
     * Parameter from direction start
     * Parameter to direction heads to
     */
    public int getDirectionalEdge(int from, int to){
        return matrix[from][to]; //return if node directed from node to to node then return 1 otherwise 0
    }

    /**
     * return gives the size of matrix
     */
    public int getSize(){
        return size;
    }

//    return the Adjacency matrix as string in printable format
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Size : "+size+"\n<-------------------------------------------->\n");
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                string.append(this.matrix[row][col]+ " ");
            }
            string.append("\n");
        }
        return string.append("<------------------------------------------>\n").toString();
    }
    
}
