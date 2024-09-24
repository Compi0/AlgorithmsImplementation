/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosfinal177232;

/**
 *
 * @author 52444
 */

class Arboles {
    NodoArbol root;

    public Arboles() {
        root = null;
    }
    
    public static void main(String[] args) {
        Arboles T = new Arboles();
        T.treeInsert(new NodoArbol(9));
        T.treeInsert(new NodoArbol(5));
        T.treeInsert(new NodoArbol(15));
        T.treeInsert(new NodoArbol(0));
        
        T.inorderTreeWalk(T.root);
    }
    
    public void inorderTreeWalk(NodoArbol x) {
        if (x != null) {
            inorderTreeWalk(x.left);
            System.out.print(x.key + " ");
            inorderTreeWalk(x.right);
        }
    }

    public NodoArbol treeSearch(NodoArbol x, int k) {
        if (x == null || k == x.key)
            return x;
        if (k < x.key)
            return treeSearch(x.left, k);
        else
            return treeSearch(x.right, k);
    }

    public NodoArbol iterativeTreeSearch(NodoArbol x, int k) {
        while (x != null && k != x.key) {
            if (k < x.key)
                x = x.left;
            else
                x = x.right;
        }
        return x;
    }

    public NodoArbol treeMinimum(NodoArbol x) {
        while (x.left != null)
            x = x.left;
        return x;
    }
    
    public NodoArbol treeMinimumRecursive(NodoArbol x) {
    if (x.left != null) {
        return treeMinimumRecursive(x.left);
    }
    return x;
}

    public NodoArbol treeMaxmiumRecursive(NodoArbol x) {
    if (x.right != null) {
        return treeMinimumRecursive(x.right);
    }
    return x;
}
    public void PreOrder(NodoArbol x){
        if(x != null){
            System.out.println(x.key);
            PreOrder(x.left);
            PreOrder(x.right);
        }
    }
    
    public void PostOrder(NodoArbol x){
        if(x != null){
            
            PreOrder(x.left);
            PreOrder(x.right);
            System.out.println(x.key);
        }
    }

    public NodoArbol treeMaximum(NodoArbol x) {
        while (x.right != null)
            x = x.right;
        return x;
    }

    public NodoArbol treeSuccessor(NodoArbol x) {
        if (x.right != null)
            return treeMinimum(x.right);
        NodoArbol y = x.p;
        while (y != null && x == y.right) {
            x = y;
            y = y.p;
        }
        return y;
    }
    
    public NodoArbol treePredecessor(NodoArbol x) {
        if (x.left != null)
            return treeMaximum(x.left);
        NodoArbol y = x.p;
        while (y != null && x == y.left) {
            x = y;
            y = y.p;
        }
        return y;
    }

    public void treeInsert(NodoArbol z) {
        NodoArbol y = null;
        NodoArbol x = root;
        while (x != null) {
            y = x;
            if (z.key < x.key)
                x = x.left;
            else
                x = x.right;
        }
        z.p = y;
        if (y == null)
            root = z;
        else if (z.key < y.key)
            y.left = z;
        else
            y.right = z;
    }

    public void transplant(NodoArbol u, NodoArbol v) {
        if (u.p == null)
            root = v;
        else if (u == u.p.left)
            u.p.left = v;
        else
            u.p.right = v;
        if (v != null)
            v.p = u.p;
    }

    public void treeDelete(NodoArbol z) {
        if (z.left == null)
            transplant(z, z.right);
        else if (z.right == null)
            transplant(z, z.left);
        else {
            NodoArbol y = treeMinimum(z.right);
            if (y.p != z) {
                transplant(y, y.right);
                y.right = z.right;
                y.right.p = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.p = y;
        }
        
    }
    
    public void treeInsertRecursive(NodoArbol z) {
        root = treeInsertRecursiveHelper(root, null, z);
    }

    private NodoArbol treeInsertRecursiveHelper(NodoArbol current, NodoArbol parent, NodoArbol z) {
        if (current == null) {
            z.p = parent;
            return z;
        }
        if (z.key < current.key) {
            current.left = treeInsertRecursiveHelper(current.left, current, z);
        } else {
            current.right = treeInsertRecursiveHelper(current.right, current, z);
        }

        return current;
    }


}


