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
public class AvlTreeWithArtist {
   SongNodeWithArtist root;
   
   
   
    // A utility function to get the height of the tree
	int height(SongNodeWithArtist N) {
		if (N == null)
			return 0;

		return N.height;
	}
        // A utility function to get maximum of two integers
	int max(int a, int b) {
		return (a > b) ? a : b;
	}
        // A utility function to right rotate subtree rooted with y
	// See the diagram given above.
	SongNodeWithArtist rightRotate(SongNodeWithArtist y) {
		SongNodeWithArtist x = y.left;
		SongNodeWithArtist T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}
        // A utility function to left rotate subtree rooted with x
	// See the diagram given above.
	SongNodeWithArtist leftRotate(SongNodeWithArtist x) {
		SongNodeWithArtist y = x.right;
		SongNodeWithArtist T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}
        // Get Balance factor of node N
	int getBalance(SongNodeWithArtist N) {
		if (N == null)
			return 0;

		return height(N.left) - height(N.right);
	}
        
        //UPDATE THİS PART UGUR!
        SongNodeWithArtist insert(SongNodeWithArtist node, SongNodeWithArtist newNode ) {

		/* 1. Perform the normal BST insertion */
		if (node == null)
			return (newNode);

		if (newNode.artist.compareTo(node.artist) < 0 ) 
			node.left = insert(node.left, newNode);
		else if (newNode.artist.compareTo(node.artist) > 0)
			node.right = insert(node.right, newNode);
		else // Duplicate keys not allowed
			return node;

		/* 2. Update height of this ancestor node */
		node.height = 1 + max(height(node.left), height(node.right));

		/* 3. Get the balance factor of this ancestor
			node to check whether this node became
			unbalanced */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balance > 1 && newNode.artist.compareTo(node.left.artist) < 0)
                    
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && newNode.artist.compareTo(node.right.artist) > 0)
			return leftRotate(node);
                            
		// Left Right Case
		if (balance > 1 && newNode.artist.compareTo(node.left.artist) > 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
                
		// Right Left Case
		if (balance < -1 && newNode.artist.compareTo(node.right.artist) < 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
                    
		/* return the (unchanged) node pointer */
		return node;
	}
        public SongNodeWithArtist search(SongNodeWithArtist focus, String name) {
            if(focus == null) {
                return focus;
            }
            if(name.compareTo(focus.artist) > 0) {
                return search(focus.right, name);
            }else if(name.compareTo(focus.artist) < 0) {
                return search(focus.left, name);
            }
            else {
                return focus;
            }
        }
        void preOrder(SongNodeWithArtist node) {
		if (node != null) {
			System.out.print(node.artist + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
         SongNodeWithArtist deleteNode(SongNodeWithArtist focus, int indexOfArray) {
        // STEP 1: PERFORM STANDARD BST DELETE 
        if (focus == null) {
            return focus;
        }
        // If the key to be deleted is smaller than 
        // the root's key, then it lies in left subtree 
        if (indexOfArray < focus.indexOfArray) {
            focus.left = deleteNode(focus.left, indexOfArray);
        } // If the key to be deleted is greater than the 
        // root's key, then it lies in right subtree 
        else if (indexOfArray > focus.indexOfArray) {
            focus.right = deleteNode(focus.right, indexOfArray);
        } // if key is same as root's key, then this is the node 
        // to be deleted 
        else {

            // node with only one child or no child 
            if ((focus.left == null) || (focus.right == null)) {
                SongNodeWithArtist temp = null;
                if (temp == focus.left) {
                    temp = focus.right;
                } else {
                    temp = focus.left;
                }

                // No child case 
                if (temp == null) {
                    temp = focus;
                    focus = null;
                } else // One child case 
                {
                    focus = temp; // Copy the contents of 
                }                                // the non-empty child 
            } else {

                // node with two children: Get the inorder 
                // successor (smallest in the right subtree) 
                SongNodeWithArtist temp = minValueNode(focus.right);

                // Copy the inorder successor's data to this node 
                focus.indexOfArray = temp.indexOfArray;
                focus.artist= temp.artist;

                // Delete the inorder successor 
                focus.right = deleteNode(focus.right, temp.indexOfArray);
            }
        }

        // If the tree had only one node then return 
        if (focus == null) {
            return focus;
        }

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE 
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether 
        // this node became unbalanced) 
        int balance = getBalance(focus);

        // If this node becomes unbalanced, then there are 4 cases 
        // Left Left Case 
        if (balance > 1 && getBalance(focus.left) >= 0) {
            return rotateMyLeft(focus);
        }

        // Left Right Case 
        if (balance > 1 && getBalance(focus.left) < 0) {
            focus.left = rotateMyRight(focus.left);
            return rotateMyLeft(focus);
        }

        // Right Right Case 
        if (balance < -1 && getBalance(focus.right) <= 0) {
            return rotateMyRight(focus);
        }

        // Right Left Case 
        if (balance < -1 && getBalance(focus.right) > 0) {
            focus.right = rotateMyLeft(focus.right);
            return rotateMyRight(focus);
        }

        return focus;
    }
        public SongNodeWithArtist rotateMyLeft(SongNodeWithArtist focus) {
        SongNodeWithArtist k = focus.left;
        focus.left = k.right;
        k.right = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }
         public SongNodeWithArtist rotateMyRight(SongNodeWithArtist focus) {
        SongNodeWithArtist k = focus.right;
        focus.right = k.left;
        k.left = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }
         public SongNodeWithArtist doubleRotateLeftSide(SongNodeWithArtist focus) {
        focus.left = rotateMyRight(focus.left);
        return rotateMyLeft(focus);
    }
         public SongNodeWithArtist doubleRotateRightSide(SongNodeWithArtist focus) {
        focus.right = rotateMyLeft(focus.right);
        return rotateMyRight(focus);
    }
         SongNodeWithArtist minValueNode(SongNodeWithArtist node) {
        SongNodeWithArtist current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
}
