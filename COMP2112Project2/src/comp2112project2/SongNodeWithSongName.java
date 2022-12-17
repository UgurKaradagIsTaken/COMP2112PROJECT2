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
public class SongNodeWithSongName {
    String songName;
    static int count = -1;
    int indexOfArray;
    int height = 1;
    SongNodeWithSongName left;
    SongNodeWithSongName right;

    public SongNodeWithSongName(String songName) {
        SongNodeWithSongName.count++;
        this.indexOfArray = count;
        this.songName = songName;
        this.left = null;
        this.right = null;
    }
    
}
