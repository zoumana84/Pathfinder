/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Gagnon
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            Scanner console = new Scanner(System.in);
            System.out.println("Enter File name: ");
            String fileName = console.nextLine();// read file name
            File fileCheck = new File(fileName); // create file object to check and read file
            if(fileCheck.exists()) { // check if file exits or not
                Scanner file = new Scanner(fileCheck); // open file and read adjacency matrix from file
                while (file.hasNext()) { // loop all data read from file
                    int size = file.nextInt();// get word as integer from file
                    AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(size);// create object of adjacency matrix of given size
                    for (int row = 0; row < size; row++) {
                        for (int col = 0; col < size; col++) {
                            if (file.nextInt() == 1) {
                                adjacencyMatrix.addDirectionalEdge(row, col); // add to adjacency matrix as directional edge if matrix value is 1
                            }
                        }
                    }
                    System.out.println("Adjacency Matrix: \n" + adjacencyMatrix);// print adjacency matrix
                    new PathFinderAlgorithm().printAllPath(adjacencyMatrix); // print all non-looping path of all nodes
                    System.out.println("<------------------------------------------>");
                }
                file.close(); // close open file
            }else {
                System.out.println(fileName+" file not found"); // print this if input file name file not found
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
    

