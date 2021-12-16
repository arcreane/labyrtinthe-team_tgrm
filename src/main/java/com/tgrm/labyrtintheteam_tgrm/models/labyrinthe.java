package com.tgrm.labyrtintheteam_tgrm.models;
import java.util.*;

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

       List<MazeCell> path = generator(labyrinthe, height,width);

        for(int i = 0; i< path.size()-1;i++){
          int posX1 = path.get(i).getX();
          int posY1 = path.get(i).getY();
          int posX2 = path.get(i+1).getX();
          int posY2 = path.get(i+1).getY();

          if(posX1<posX2 && labyrinthe[posX1][posY1]==0){   //aller a droite et la case actuel est pleine
              labyrinthe[posX1][posY1]=1;  // on casse le mur de droite sur la case actuel
          }else  if(posX1<posX2 && labyrinthe[posX1][posY1]==2){  //aller a droite  et la case actuel a le bas casser
             labyrinthe[posX1][posY1]=3;  //casser le bas et droite de la case actuel
          }
          else if (posX1>posX2){  //aller a gauche
              labyrinthe[posX2][posY2] = 1;  // casser le mur de droite de la prochaine case
          }
          else  if(posY1<posY2 && labyrinthe[posX1][posY1]==0){
                labyrinthe[posX1][posY1]=2;
           }else  if(posY1<posY2 && labyrinthe[posX1][posY1]==1){
              labyrinthe[posX1][posY1]=3;
            }
            else if (posY1>posY2){
                labyrinthe[posX2][posY2] = 2;
            }


                    System.out.println(labyrinthe[posX1][posY1] + "  " + posX1 +"  "+ posY1);




        }

       System.out.println(path.toString());
       for (colonnes=0;colonnes<height;colonnes++) {
           for (lignes = 0; lignes < width; lignes++){
               System.out.print(labyrinthe[colonnes][lignes] + "  " );
           }
       } System.out.println("");

       for(lignes=0;lignes<width;lignes++){
           System.out.print(" ___");

       }
       System.out.println("");
       for (colonnes=0;colonnes<height;colonnes++) {
           System.out.print("|");

           for (lignes = 0; lignes < width; lignes++){
               if (labyrinthe[lignes][colonnes] == 0) {
                   System.out.print("   |");
               }else if (labyrinthe[lignes][colonnes] == 1 ) {
                   System.out.print("    ");
               }else  if(labyrinthe[lignes][colonnes] == 3){
                   System.out.print("    ");
               }else if(labyrinthe[lignes][colonnes] == 2){
                   System.out.print("   |");
               }
           }
           System.out.println("");
           System.out.print("|");
           for (lignes = 0; lignes < width; lignes++){
               if (labyrinthe[lignes][colonnes] == 0 ) {
                   System.out.print("___");
                   System.out.print("+");
               }else if (labyrinthe[lignes][colonnes] == 2){
                   System.out.print("   ");
                   System.out.print("+");
               }else if( labyrinthe[lignes][colonnes] == 1){
                   System.out.print("___");
                   System.out.print("+");
               }else if ( labyrinthe[lignes][colonnes] == 3){
                   System.out.print("   ");
                   System.out.print("+");
                }
           }
           System.out.println("");


     }
    }

     static List<MazeCell> generator(int [][]tab, int height, int width) {
         boolean fin = false;
         int posX = 0;
         int posY = 0;
         List<MazeCell> nextCell = new ArrayList();
         List<MazeCell> path = new ArrayList();
         List<MazeCell> voisins = new ArrayList<>();
         boolean [][] visited = new boolean[width][height];


         Map<Integer,Integer> xmap = new HashMap();
         Map<Integer,Integer> ymap = new HashMap();

         for(posX=0; posX<width-1;posX++){
             for (posY=0;posY<height-1;posY++){
                 visited[posX][posY]=false;
             }
         }
         posX=0;
         posY=0;
         visited[0][0] = true;
         path.add(new MazeCell(0,0));

        while (!fin) {
            nextCell.removeAll(nextCell);
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
            long  result =  Math.round((Math.random() * (taille-1)));

            posX = nextCell.get((int)result).getX();
            posY = nextCell.get((int)result).getY();
            visited[posX][posY] = true;
            path.add(new MazeCell(posX,posY));

          for (int y=0;y< voisins.size();y++) {
              System.out.println(nextCell.get((int)result));
              System.out.println(voisins.get(y));
             if(nextCell.get((int)result).equals(voisins.get(y))){
                 System.out.println(voisins.get(y) + "test");
                   voisins.remove(voisins.get(y));
               }
           }
            nextCell.remove((int)result);
            for(int i=0;i< nextCell.size();i++) {
                if(!voisins.contains(nextCell.get(i))) {
                    voisins.add(nextCell.get(i));
                }
            }

         }
         System.out.println(voisins);
        return path;

     }
}


