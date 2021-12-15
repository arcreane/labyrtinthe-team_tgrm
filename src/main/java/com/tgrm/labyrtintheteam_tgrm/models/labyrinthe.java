package com.tgrm.labyrtintheteam_tgrm.models;
import java.util.*;

import com.tgrm.labyrtintheteam_tgrm.models.MazeCell;

public class labyrinthe {


    public static void main(String[] args) {
        creerLabyrinthe(10,10);
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
         boolean [][] visited = new boolean[width][height];

         Map<Integer,Integer> xmap = new HashMap();
         Map<Integer,Integer> ymap = new HashMap();

         for(posX=0; posX<width-1;posX++){
             for (posY=0;posY<height-1;posY++){
                 visited[posX][posY]=false;
             }
         }

         posX=3;
         posY=3;

        while (fin == false) {
            xmap.put(0 , posX+1);
            xmap.put(width-1 , posX-1);
            ymap.put(0 , posY+1);
            ymap.put(height-1 , posY-1);
             if (posX == 0 || posX == width -1) {
                     if (visited[xmap.get(posX)][posY]==false){
                         nextCell.add(new MazeCell(xmap.get(posX),posY));
                 }
             }
             else{
                 for (int i=-1;i<=1;i+=2){
                     if (visited[posX+i][posY]==false) {
                         nextCell.add(new MazeCell(posX+i, posY));
                     }
                 }
             }
             if (posY == 0) {
                 if (visited[posX][posY+1]==false){
                     nextCell.add(new MazeCell(posX,posY+1));
                 }
             }
             else if (posY==height-1) {
                 if (visited[posX][posY-1]==false){
                     nextCell.add(new MazeCell(posX,posY-1));
                 }
             }
             else{
                 for (int i=-1;i<=1;i+=2){
                     if (visited[posX][posY+i]==false) {
                         nextCell.add(new MazeCell(posX, posY + i));
                     }
                 }
             }
            int taille = nextCell.size();
            long  result =  Math.round((Math.random() * taille-1));
            System.out.print(nextCell.get((int)result).getX());
            System.out.print("  ");
            System.out.println(nextCell.get((int)result).getY());
             break;
         }



    }
}


