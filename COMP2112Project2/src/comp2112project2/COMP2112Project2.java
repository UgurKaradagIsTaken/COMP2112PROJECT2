
package comp2112project2;

import java.util.Scanner;

public class COMP2112Project2 {
 
    
    
    
        
        
        
        
        
    public static void main(String[] args) {
        AvlTreeWithId tree1 = new AvlTreeWithId();
        AvlTreeWithSongName tree2 = new AvlTreeWithSongName();
        AvlTreeWithArtist tree3 = new AvlTreeWithArtist();
        
        Scanner scanner = new Scanner(System.in);
        
        
        //Create the array in here
        Song[] songArray = new Song[5];
        
        
    
        //Create the objects in here
        Song s1 = new Song("a", "b", 0, "Rock", 2);
        Song s2 = new Song("c", "d", 1, "Pop", 4);
        Song s3 = new Song("e", "f", 2, "Edm", 6);
        Song s4 = new Song("g", "h", 3, "Phonk", 8);
        Song s5 = new Song("j", "k", 4, "Pop", 10);
        //Add the objects into the array
        
        songArray[0] = s1;
        songArray[1] = s2;
        songArray[2] = s3;
        songArray[3] = s4;
        songArray[4] = s5;
        
        SongNodeWithId idSong1 = new SongNodeWithId();
        SongNodeWithId idSong2 = new SongNodeWithId();
        SongNodeWithId idSong3 = new SongNodeWithId();
        SongNodeWithId idSong4 = new SongNodeWithId();
        SongNodeWithId idSong5 = new SongNodeWithId();
        
        
        tree1.root = tree1.insert(tree1.root, idSong1);
	tree1.root = tree1.insert(tree1.root, idSong2);
	tree1.root = tree1.insert(tree1.root, idSong3);
	tree1.root = tree1.insert(tree1.root, idSong4);
	tree1.root = tree1.insert(tree1.root, idSong5);
		
       
        
        
        SongNodeWithSongName songName1 = new SongNodeWithSongName("a");
        SongNodeWithSongName songName2 = new SongNodeWithSongName("c");
        SongNodeWithSongName songName3 = new SongNodeWithSongName("e");
        SongNodeWithSongName songName4 = new SongNodeWithSongName("g");
        SongNodeWithSongName songName5 = new SongNodeWithSongName("j");
        
       
        tree2.root = tree2.insert(tree2.root, songName1);
        tree2.root = tree2.insert(tree2.root, songName2);
        tree2.root = tree2.insert(tree2.root, songName3);
        tree2.root = tree2.insert(tree2.root, songName4);
        tree2.root = tree2.insert(tree2.root, songName5);
        
       
        
        
        SongNodeWithArtist artist1 = new SongNodeWithArtist("b");
        SongNodeWithArtist artist2 = new SongNodeWithArtist("d");
        SongNodeWithArtist artist3 = new SongNodeWithArtist("f");
        SongNodeWithArtist artist4 = new SongNodeWithArtist("h");
        SongNodeWithArtist artist5 = new SongNodeWithArtist("k");
        
        tree3.root = tree3.insert(tree3.root, artist1);
        tree3.root = tree3.insert(tree3.root, artist2);
        tree3.root = tree3.insert(tree3.root, artist3);
        tree3.root = tree3.insert(tree3.root, artist4);
        tree3.root = tree3.insert(tree3.root, artist5);
            
        
            int index = tree3.search(tree3.root, "k").indexOfArray;
            System.out.println(songArray[index]);
            
             
             
             
             
             
             
        /*
        System.out.println("Welcome");
        int operation = scanner.nextInt();
        while(true) {
        switch (operation) {
            case 1:
                System.out.println("Enter the id you want to search : ");
                int id = scanner.nextInt();
                int indexArray = tree1.search(tree1.root, id).indexOfArray;
                System.out.println(songArray[indexArray].toString());
                break;
            case 2:
                
                System.out.println("Enter the id you want to delete : ");
                int id2 = scanner.nextInt();
                int indexArray2 = tree1.search(tree1.root, id2).indexOfArray;
                tree1.deleteNode(tree1.root, id2);
                tree1.preOrder(tree1.root);
                break;
        }
        }
        */
       
        
        
        
    }
}
