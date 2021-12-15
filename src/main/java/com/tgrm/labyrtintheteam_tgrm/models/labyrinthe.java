package com.tgrm.labyrtintheteam_tgrm.models;

public class labyrinthe {

    public static void main(String[] args) {
        creerLabyrinthe(10,10);
    }

   static  public void creerLabyrinthe(int width, int height) {

          int[][] labyrinthe = new int[width][height];
          int colonnes;
          int lignes;


       for (colonnes=0;colonnes<height-1;colonnes++){
           for(lignes=0;lignes<width-1;lignes++) {
               labyrinthe[colonnes][lignes]=0;
           }
       }

      // labyrinthe[0][0]=1;


       for (colonnes=0;colonnes<height-1;colonnes++){
           for(lignes=0;lignes<width-1;lignes++) {
               System.out.println(colonnes + " " +lignes + " = " + labyrinthe[colonnes][lignes] );
           }
       }

       for(lignes=0;lignes<width;lignes++){
           System.out.print(" __");
       }
       System.out.println("");
       for (colonnes=0;colonnes<height;colonnes++) {
           System.out.print("|");
           for (lignes = 0; lignes < width; lignes++)
               if (labyrinthe[colonnes][lignes] == 0) {
                   System.out.print("__");
                   System.out.print("|");

               } /*else if (labyrinthe[colonnes][lignes] == 1) {
                   System.out.print("|");
               }*/
               System.out.println("");
           }



     }
}
