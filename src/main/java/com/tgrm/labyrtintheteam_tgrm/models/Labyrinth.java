package com.tgrm.labyrtintheteam_tgrm.models;
import java.util.*;

public class Labyrinth {


    public static void main(String[] args) {

        // Create a labyrinth of size 10x10

        createLabyrinth(5,5);
        System.out.println("Countdown !\n");
        labCountDown(30,60);
        System.out.println("\033[H\033[2J");
        System.out.println("Time's up !\n");
    }

   static public void createLabyrinth(int width, int height) {

        // Create a new table of size width x height

          int[][] labyrinth = new int[width][height];

          // Initialize columns and rows
          int columns;
          int rows;


          // Create a grid that will contain the labyrinth

       for (columns=0;columns<height-1;columns++){
           for(rows=0;rows<width-1;rows++) {
               labyrinth[columns][rows]=0;
           }
       }

       // Create our pathList that will contains our paths

       List<MazeCell> pathlist = generator(width,height);

        // Do a loop to get every of our cells ( X and Y ) and the following ones

        for(int i = 0; i< pathlist.size()-1;i++){
          int posX1 = pathlist.get(i).getX();
          int posY1 = pathlist.get(i).getY();
          int posX2 = pathlist.get(i+1).getX();
          int posY2 = pathlist.get(i+1).getY();

          // Make a comparison between the two cells and make some decisions

            // If the first cell is on the left of the second cell

          if(posX1<posX2 && labyrinth[posX1][posY1]==0){

              // Index that will give us the opportunity to break the wall on the right of the one we choose

              labyrinth[posX1][posY1]=1;

              // If the first cell is on the left of the second cell and that he has already an ID different of 0 :

          }else  if(posX1<posX2 && labyrinth[posX1][posY1]==1){

              // Index that will give us the opportunity to break the wall on the bottom and on the right of the one we choose
             labyrinth[posX1][posY1]=3;
          }

          // If the first cell is on the right of the second cell

          else if (posX1>posX2){

              // Index that will give us the opportunity to break the wall on the right of the one after the one we choose

              labyrinth[posX2][posY2] = 1;
          }

          // If the first cell is on the top of the second cell

          else  if(posY1<posY2 && labyrinth[posX1][posY1]==0){

              // Index that will give us the opportunity to break the wall on the bottom of the one we choose

                labyrinth[posX1][posY1]=2;
            // If the first cell is on the top of the second cell and that he has already an ID different of 0 :
           }else  if(posY1<posY2 && labyrinth[posX1][posY1]==2){

              // Index that will give us the opportunity to break the wall on the bottom of the one we choose

              labyrinth[posX1][posY1]=3;
            }

          // If the first cell is on the bottom of the second cell
            else if (posY1>posY2){

              // Index that will give us the opportunity to break the wall on the bottom of the one after the one we choose

                labyrinth[posX2][posY2] = 2;
            }


        }

        //----------------------------------------------------------------------------------------------------------------------//
        // Print the labyrinth
        //----------------------------------------------------------------------------------------------------------------------//

       // Loop that will go through all rows of our grid

       for(rows=0;rows<width;rows++){

           // Print the first row of our grid that will represent the top of the labyrinth

           System.out.print(" ___");

       }

       // Print the end of the first row by adding a new line
       System.out.println("");

       // Loop that will go through all columns of our grid
       for (columns=0;columns<height;columns++) {

           // Print the first column of our grid that will represent the left of the labyrinth

           System.out.print("|");


           // Loop that will go through all rows of our grid
           for (rows = 0; rows < width; rows++){

               // If the ID we selected for our cell is 0, we will print a space and a right wall

               if (labyrinth[rows][columns] == 0) {
                   System.out.print("   |");

               // If the ID we selected for our cell is 1, we will print a space and no side walls

               }else if (labyrinth[rows][columns] == 1 ) {
                   System.out.print("    ");

               // If the ID we selected for our cell is 3, we will print a space and no side walls

               }else  if(labyrinth[rows][columns] == 3){
                   System.out.print("    ");

               // If the ID we selected for our cell is 2, we will print a space and a right wall
               }else if(labyrinth[rows][columns] == 2){
                   System.out.print("   |");
               }
           }

           // Print the end of the column by adding a new line

           System.out.println("");
           System.out.print("|");

           // Loop that will go through all rows of our grid

           for (rows = 0; rows < width; rows++){

               // If the ID we selected for our cell is 0, we will print a space and a bottom wall (and a plus that will represent the link between cells
               if (labyrinth[rows][columns] == 0 ) {
                   System.out.print("___");
                   System.out.print("+");

               // If the ID we selected for our cell is 1, we will print a space and a bottom wall (and a plus that will represent the link between cells)
               }else if( labyrinth[rows][columns] == 1){
                   System.out.print("___");
                   System.out.print("+");

               // If the ID we selected for our cell is 2, we will print a space and no bottom wall (and a plus that will represent the link between cells)
               }else if (labyrinth[rows][columns] == 2){
                   System.out.print("   ");
                   System.out.print("+");

               // If the ID we selected for our cell is 3, we will print a space and no bottom wall (and a plus that will represent the link between cells)
               }else if ( labyrinth[rows][columns] == 3){
                   System.out.print("   ");
                   System.out.print("+");
                }
           }

           // Print the end of the column by adding a new line
           System.out.println("");


            }
        }

        //----------------------------------------------------------------------------------------------------------------------//
        // Generate the labyrinth
        //----------------------------------------------------------------------------------------------------------------------//


     static List<MazeCell> generator(int height, int width) {

        // Initialize our variables //

         // Initialize our End of our labyrinth
         boolean endLab = false;
         /*boolean cellVoid = false;*/

         // Initialize our position in the labyrinth

         int posX;
         int posY;

         // Initialize List that will contain every useful cells of our labyrinth //

         // Initialize the next cell of the one we are in
         List<MazeCell> nextCell = new ArrayList();

         // Initialize the list that will contain all the paths of our labyrinth
         List<MazeCell> pathList = new ArrayList();

         // Initialize the list that will contain all the neighbours of our cells
         List<MazeCell> neighbours = new ArrayList<>();

        //List<List<MazeCell>> pathList = new ArrayList();


         // Initialize the boolean tha will save if our cell was visited or not
         boolean [][] visited = new boolean[width][height];


         // Create a new map that will contain our labyrinth
         Map<Integer,Integer> xmap = new HashMap();
         Map<Integer,Integer> ymap = new HashMap();

         // Initialize the list that will contain all the cells of our labyrinth
         for(posX=0; posX<width-1;posX++){
             for (posY=0;posY<height-1;posY++){
                 visited[posX][posY]=false;
             }
         }

         // Initialize our first position to 0, 0
         posX=0;
         posY=0;

         // Make our first cell visited

         visited[0][0] = true;

         // Initialize our first cell
         pathList.add(new MazeCell(0,0));

         // Go through all the columns of our labyrinth
         for (int cols=0;cols<height;cols++){

             // Go through all the rows of our labyrinth
             for(int raw = 0;raw<width;raw++ ){

                 // While at least one cell is not visited
                 while(!visited[cols][raw]){

                    // If we are not at the end of our labyrinth
                     while (!endLab) {

                         // Remove every nextCell from our nextCell list
                         nextCell.removeAll(nextCell);


                         // Make booleans to check if there is a neighbour on our sides
                         boolean neighbourX = false;
                         boolean neighbourY = false;

                         // Stock the position of the current cell and the previous one into the HashMap
                         xmap.put(0, posX + 1);
                         xmap.put(width - 1, posX - 1);
                         ymap.put(0, posY + 1);
                         ymap.put(height - 1, posY - 1);

                         // If we are at the beginning or at the end of our row

                         if (posX == 0 || posX == width - 1) {

                             // And if this cell is not visited
                             if (!visited[xmap.get(posX)][posY]) {

                                 // Add it to our nextCell list

                                 nextCell.add(new MazeCell(xmap.get(posX), posY));

                                 // And make the neighbour of our current cell visited

                                 neighbourX = true;
                             }
                         // If we are not in the beginning or at the end of our row
                         } else {
                            // Make a loop to check every of his neighbours
                             for (int i = -1; i <= 1; i += 2) {

                                 // Check the left and the right side of our current cell

                                 if (!visited[posX + i][posY]) {

                                     // Add it to our nextCell list

                                     nextCell.add(new MazeCell(posX + i, posY));

                                     // And make the neighbour existing of our current cell visited

                                     neighbourX = true;
                                 }
                             }
                         }

                         // If we are at the beginning or at the end of our column

                         if (posY == 0) {

                             // And if this next cell is not visited

                             if (!visited[posX][posY + 1]) {

                                // Add it to our nextCell list

                                 nextCell.add(new MazeCell(posX, posY + 1));

                                 // And make the neighbour existing of our current cell visited

                                 neighbourY = true;

                             }
                         } else if (posY == height - 1) {

                             // And if this next cell is not visited

                             if (!visited[posX][posY - 1]) {

                                 // Add it to our nextCell list

                                 nextCell.add(new MazeCell(posX, posY - 1));

                                 // And make the neighbour existing of our current cell visited

                                 neighbourY = true;
                             }
                         } else {

                             // Make a loop to check every of his neighbours

                             for (int i = -1; i <= 1; i += 2) {

                                 // Check the top and the bottom side of our current cell

                                 if (!visited[posX][posY + i]) {

                                     // Add it to our nextCell list

                                     nextCell.add(new MazeCell(posX, posY + i));

                                     // And make the neighbour existing of our current cell visited

                                     neighbourY = true;
                                 }
                             }
                         }

                         // If we didn't have found any neighbour
                         if (!neighbourX && !neighbourY) {

                             // Set the end of this maze (or at least of this path)

                             endLab = true;

                             // Leave the while

                             break;
                         }


                         // Int the size of our nextCell list

                         int size = nextCell.size();

                         // Create a random to chose a random neighbour (and so the direction of our next move)

                         long result = Math.round((Math.random() * (size - 1)));


                         // Initialize posX and posY to generate others paths

                         posX = nextCell.get((int) result).getX();
                         posY = nextCell.get((int) result).getY();
                         visited[posX][posY] = true;

                         // Add the current path to our path list

                         pathList.add(new MazeCell(posX, posY));


                         // Remove the current cell from our nextCell list

                         nextCell.remove((int) result);

                         // Go through our nextCells list
                         for (int i = 0; i < nextCell.size(); i++) {

                             // If the current cell isn't already visited
                             if (!neighbours.contains(nextCell.get(i))) {

                                 // Add it to our neighbours list

                                 neighbours.add(nextCell.get(i));
                             }
                         }

      /*    for (int y=0;y< neighbours.size();y++) {
              System.out.println(nextCell.get((int)result));
              System.out.println(neighbours.get(y));
             if(nextCell.get((int)result).equals(neighbours.get(y))){
                 System.out.println(neighbours.get(y) + "test");
                   neighbours.remove(neighbours.get(y));
               }
           }
                   */

                     }

                     // Go through our neighbours list
                     for(int l=0; l<neighbours.size();l++){

                         // If the current cell isn't already visited

                         if(!visited[neighbours.get(l).getX()][neighbours.get(l).getY()]){

                             // Change our posX to the next cell's X
                             posX = neighbours.get(l).getX();
                             // Change our posY to the next cell's Y
                             posY = neighbours.get(l).getY();
                             // Disable the end of this path
                             endLab = false;
                             // Add our new path Start to visited
                             visited[posX][posY]=true;
                             // Add the current path to our path list
                             pathList.add(new MazeCell(posX,posY));

                         }
                     }

                  //   pathList.add(path);

               }
           }
       }

      /* if (cellVoid){
           generator(height,width,x,y);

       }*/

         // Return our path list
         return pathList;


     }

     // Method to generate a Countdown to resolve the maze (if it's functional of course)

    public static void labCountDown(int chars, int seconds) {

        //  Make our characters appear every 1/30 of our total time

        int SecsPerChar = seconds * 1000 / (chars + 1);

        // Initialize our counter that will go up to the total time
        int CountingUp = 0;

        // Initialize our counter that will represent our time in seconds
        int timeInS = seconds * 1000;

        // Int the number of characters that are already displayed

        int nbDisplayed = 0;


        // Wihile our counter is less than our total time
        while (CountingUp < timeInS) {


            try {

                // Wait 1 portion of our char of our total time

                Thread.sleep(SecsPerChar);

                // Initialize our TimeBar
                String TimeBar = String.format("|%s%s|\r", "#".repeat(nbDisplayed), " ".repeat(chars - nbDisplayed));

                // Print our TimeBar

                System.out.write(TimeBar.getBytes());

            } catch (Exception ex) {

                // If there is an error print it, else do nothing

                System.out.println(ex);
            }
                // Increment our counter
            CountingUp += SecsPerChar;
            nbDisplayed++;
        }
    }
}


