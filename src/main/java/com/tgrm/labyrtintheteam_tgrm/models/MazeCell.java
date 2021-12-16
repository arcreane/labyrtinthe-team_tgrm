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

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String toString() {
        return super.toString();
    }
}
