package com.tgrm.labyrtintheteam_tgrm.models;

public class MazeCell {

    int x;
    int y;

    MazeCell(int x, int y){
       this.x = x;
       this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
