package com.tgrm.labyrtintheteam_tgrm.models;
import java.util.*;

public class labyrinthe {


    public static void main(String[] args) {
        creerLabyrinthe(3,3);
    }

   static public void creerLabyrinthe(int width, int height) {

          int[][] labyrinthe = new int[width][height];
          int colonnes=0;
          int lignes=0;


       for (colonnes=0;colonnes<height-1;colonnes++){
           for(lignes=0;lignes<width-1;lignes++) {
               labyrinthe[colonnes][lignes]=0;
           }
       }

      //labyrinthe[5][2]=1;
        generator(labyrinthe, height,width);

     /*  for (colonnes=0;colonnes<height-1;colonnes++){
           for(lignes=0;lignes<width-1;lignes++) {
               System.out.println(colonnes + " " +lignes + " = " + labyrinthe[colonnes][lignes] );
           }
       }*/

       for(lignes=0;lignes<width;lignes++){
           System.out.print(" ____");

       }
       System.out.println("");
       for (colonnes=0;colonnes<height;colonnes++) {
           System.out.print("|");

           for (lignes = 0; lignes < width; lignes++){
               if (labyrinthe[colonnes][lignes] == 0) {
                   System.out.print("    |");
               }else if (labyrinthe[colonnes][lignes] == 1) {
                   System.out.print(" X  |");
               }
           }
           System.out.println("");
           System.out.print("|");
           for (lignes = 0; lignes < width; lignes++){
               if (labyrinthe[colonnes][lignes] == 0 || labyrinthe[colonnes][lignes] == 1) {
                   System.out.print("____");
                   System.out.print("|");
               }
           }

               System.out.println("");
           }
     }

     static void generator(int [][]tab, int height, int width) {
         boolean fin = false;
         int posX = 0;
         int posY = 0;
         List<MazeCell> nextCell = new ArrayList();
         List<MazeCell> path = new ArrayList();
         boolean [][] visited = new boolean[width][height];


         Map<Integer,Integer> xmap = new HashMap();
         Map<Integer,Integer> ymap = new HashMap();

         for(posX=0; posX<width-1;posX++){
             for (posY=0;posY<height-1;posY++){
                 visited[posX][posY]=false;
             }
         }



        while (!fin) {
            boolean voisinX = false;
            boolean voisinY = false;
            xmap.put(0 , posX+1);
            xmap.put(width-1 , posX-1);
            ymap.put(0 , posY+1);
            ymap.put(height-1 , posY-1);
             if (posX == 0 || posX == width -1) {
                     if (!visited[xmap.get(posX)][posY]){
                         nextCell.add(new MazeCell(xmap.get(posX),posY));
                         voisinX  = true;
                 }
             }
             else{
                 for (int i=-1;i<=1;i+=2){
                     if (!visited[posX + i][posY]) {
                         nextCell.add(new MazeCell(posX+i, posY));
                         voisinX = true;
                     }
                 }
             }
             if (posY == 0) {
                 if (!visited[posX][posY + 1]){
                     nextCell.add(new MazeCell(posX,posY+1));
                     voisinY = true;
                 }
             }
             else if (posY==height-1) {
                 if (!visited[posX][posY - 1]){
                     nextCell.add(new MazeCell(posX,posY-1));
                     voisinY = true;
                 }
             }
             else{
                 for (int i=-1;i<=1;i+=2){
                     if (!visited[posX][posY + i]) {
                         nextCell.add(new MazeCell(posX, posY + i));
                         voisinY = true;
                     }
                 }
             }

            if (!voisinX && !voisinY){
                fin = true;
                break;
            }

            int taille = nextCell.size();
            long  result =  Math.round((Math.random() * taille-1));

            posX = nextCell.get((int)result).getX();
            posY = nextCell.get((int)result).getY();

            path.add(new MazeCell(posX,posY));
            System.out.println(path);


         }



     }
}


