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
public class AvlTreeWithId {
     SongNodeWithId root;

    
     
     
     
     
     // A utility function to get the height of the tree
	int height(SongNodeWithId N) {
		if (N == null)
			return 0;

		return N.height;
	}
        // A utility function to get maximum of two integers
	int max(int a, int b) {
		return (a > b) ? a : b;
	}
        public SongNodeWithId rotateMyLeft(SongNodeWithId focus) {
        SongNodeWithId k = focus.left;
        focus.left = k.right;
        k.right = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }
         public SongNodeWithId rotateMyRight(SongNodeWithId focus) {
        SongNodeWithId k = focus.right;
        focus.right = k.left;
        k.left = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }
         public SongNodeWithId doubleRotateLeftSide(SongNodeWithId focus) {
        focus.left = rotateMyRight(focus.left);
        return rotateMyLeft(focus);
    }
         public SongNodeWithId doubleRotateRightSide(SongNodeWithId focus) {
        focus.right = rotateMyLeft(focus.right);
        return rotateMyRight(focus);
    }
        // A utility function to right rotate subtree rooted with y
	// See the diagram given above.
	SongNodeWithId rightRotate(SongNodeWithId y) {
		SongNodeWithId x = y.left;
		SongNodeWithId T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}
        SongNodeWithId minValueNode(SongNodeWithId node) {
        SongNodeWithId current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
        // A utility function to left rotate subtree rooted with x
	// See the diagram given above.
	SongNodeWithId leftRotate(SongNodeWithId x) {
		SongNodeWithId y = x.right;
		SongNodeWithId T2 = y.left;

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
	int getBalance(SongNodeWithId N) {
		if (N == null)
			return 0;

		return height(N.left) - height(N.right);
	}
        
        SongNodeWithId insert(SongNodeWithId node, SongNodeWithId newNode) {

		/* 1. Perform the normal BST insertion */
		if (node == null)
			return (newNode);

		if (newNode.id < node.id) {
			node.left = insert(node.left, newNode);
                }
		else if (newNode.id > node.id) {
			node.right = insert(node.right, newNode);
                }
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
		if (balance > 1 && newNode.id < node.id)  {
			return rightRotate(node);
                }
		// Right Right Case
		if (balance < -1 && newNode.id > node.right.id) {
			return leftRotate(node);
                }
		// Left Right Case
		if (balance > 1 && newNode.id> node.left.id) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && newNode.id< node.right.id) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
                
	}
        //Kontrol et
        public SongNodeWithId search(SongNodeWithId focus, int id) {
            if(focus == null) {
                return focus;
            }
            if(focus.id < id) {
                return search(focus.right, id);
            }else if(focus.id > id) {
                return search(focus.left, id);
            }else {
                return focus;
            }
           
        }
        void preOrder(SongNodeWithId node) {
		if (node != null) {
			System.out.print(node.id + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
        void preOrderWithinTheRange(SongNodeWithId node, int min, int max) {
		if (node != null) {
                    if( min <= node.id && node.id <= max) {
                        System.out.println(node.id + " ");
                    }
			preOrderWithinTheRange(node.left,  min,  max);
			preOrderWithinTheRange(node.right,min, max);
		}
	}
        //DELETE VE MINVALUE FONKSİYONLARINA CALIS ACIL
           SongNodeWithId deleteNode(SongNodeWithId focus, int id) {
        // STEP 1: PERFORM STANDARD BST DELETE 
        if (focus == null) {
            return focus;
        }
        // If the key to be deleted is smaller than 
        // the root's key, then it lies in left subtree 
        if (id < focus.id) {
            focus.left = deleteNode(focus.left, id);
        } // If the key to be deleted is greater than the 
        // root's key, then it lies in right subtree 
        else if (id > focus.id) {
            focus.right = deleteNode(focus.right, id);
        } // if key is same as root's key, then this is the node 
        // to be deleted 
        else {

            // node with only one child or no child 
            if ((focus.left == null) || (focus.right == null)) {
                SongNodeWithId temp = null;
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
                SongNodeWithId temp = minValueNode(focus.right);

                // Copy the inorder successor's data to this node 
                focus.id = temp.id;
                focus.indexOfArray = temp.indexOfArray;

                // Delete the inorder successor 
                focus.right = deleteNode(focus.right, temp.id);
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
           

 }
