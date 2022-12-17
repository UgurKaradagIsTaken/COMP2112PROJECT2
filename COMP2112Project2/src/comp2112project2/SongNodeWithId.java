/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp2112project2;

/**
 *
 * @author apple
 */
public class SongNodeWithId {
    int id;
    static int count = -1;
     int indexOfArray;
    int height = 1;
    SongNodeWithId left;
    SongNodeWithId right;
    
    public SongNodeWithId() {
        SongNodeWithId.count++;
        this.id = count;
        this.indexOfArray = count;
        this.left = null;
        this.right = null;
    }
    
}
