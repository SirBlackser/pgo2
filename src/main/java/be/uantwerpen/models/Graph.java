package be.uantwerpen.models;

import java.util.ArrayList;

/**
 * Created by Revilo on 01/03/2017.
 */
public class Graph {
    private int id;
    private ArrayList<Integer> upData = new ArrayList<Integer>();
    private ArrayList<Integer> downData = new ArrayList<Integer>();

    public Graph () {
        this.id = 0;
    }
    public Graph(int id, int upData, int downData)
    {
        this.id = id;
        this.upData.add(upData);
        this.downData.add(downData);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getUpData() {
        return upData;
    }

    public void setUpData(ArrayList<Integer> upData) {
        this.upData = upData;
    }

    public ArrayList<Integer> getDownData() {
        return downData;
    }

    public void setDownData(ArrayList<Integer> downData) {
        this.downData = downData;
    }

    public void addUpdata (int id, int updata){
        this.upData.add(id, updata);
    }

    public void addDowndata (int id, int downdata){
        this.downData.add(id, downdata);
    }



}
