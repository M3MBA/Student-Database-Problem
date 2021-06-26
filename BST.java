public class BST<K extends Comparable<K>, T>
{
    Node<K, T> root;
    int steps;

    public BST()
    {
        this.root = null;
        this.steps = 0;
    }

    private Node<K, T> getRoot()
    {
        return this.root;
    }

    public void traverseInOrder(Node<K, T> node)
    {
        if (node != null)
        {
            traverseInOrder(node.getLeft());
            System.out.println(node.getValue().toString());
            traverseInOrder(node.getRight());
        }
    }

    public void display()
    {
        this.traverseInOrder(this.getRoot());
    }


    private Node<K, T> insertRecursive(Node<K, T> current, K k, T s)
    {
        if (current == null)
        {
            //this.steps++;
            return new Node<K, T>(k, s);
        }
        if (k.compareTo(current.getKey()) == 0)
        {
            if (k.toString().compareTo(current.getKey().toString()) == 0)
            {
                this.steps = -1;
                return current;
            }
            else
            {
                this.steps++;
                current.setLeft(insertRecursive(current.getLeft(),k,s));
            }
        }
        if(k.compareTo(current.getKey()) < 0)
        {
            this.steps++;
            current.setLeft(insertRecursive(current.getLeft(),k, s));
        }
        else if (k.compareTo(current.getKey()) > 0)
        {
            this.steps++;
            current.setRight(insertRecursive(current.getRight(),k, s));
        }
        /*else
        {
            steps = -1;
            return current;
        }*/
        return current;
    }

    public int insert(K k, T s)
    {
        this.steps = 1;
        this.root = insertRecursive(this.root, k, s);
        return this.steps;
    }



    private Node<K, T> updateRecursive(Node<K, T> current, K key, T obj)
    {
        if (current == null)
        {
            steps = -1;
            return null;
        }
        if (key.compareTo(current.getKey()) == 0)
        {
            if (key.toString().compareTo(current.getKey().toString()) == 0)
            {
                return current;
            }
            else
            {
                steps++;
                return updateRecursive(current.getLeft(),key,obj);
            }
        }
        if (key.compareTo(current.getKey()) < 0)
        {
            steps++;
            return updateRecursive(current.getLeft(), key, obj);
        }
        else
        {
            steps++;
            return updateRecursive(current.getRight(), key, obj);
        }
    }

    public int update(K key, T obj)
    {
        this.steps = 1;
        Node<K, T> temp = updateRecursive(this.root, key, obj);
        if (temp != null)
            temp.setValue(key, obj);
        return this.steps;
    }

    


    private Node<K, T> deleteRecursive(Node<K, T> current, K key)
    {
        if (current == null)
        {
            steps = -1;
            return null;
        }
        if (key.compareTo(current.getKey()) == 0)
        {
            if (key.toString().compareTo(current.getKey().toString()) == 0)
            {
                if (current.getLeft() == null && current.getRight() == null)
                {
                    return null;
                }
                if (current.getRight() == null)
                {
                    this.steps++;
                    return current.getLeft();
                }
                if (current.getLeft() == null)
                {
                    this.steps++;
                    return current.getRight();
                }
                
                Node<K, T> n = minNode(current.getRight());
                current.setValue(n.getKey(), n.getValue());
                //System.out.println(steps + "key found with two nodes");
                this.steps++;
                current.setRight(deleteRecursive(current.getRight(), n.getKey()));
                return current;
            }
            else
            {
                this.steps++;
                current.setLeft(deleteRecursive(current.getLeft(),key));
                return current;
            }
        }

        else if (key.compareTo(current.getKey()) < 0)
        {
            this.steps++;
            //System.out.println(steps+"key less");
            current.setLeft(deleteRecursive(current.getLeft(),key));
            return current;
        }
        else if (key.compareTo(current.getKey()) > 0)
        {
            this.steps++;
            //System.out.println(steps+"key more");
            current.setRight(deleteRecursive(current.getRight(),key));
            return current;
        }
        return current;
    }

    private Node<K, T>  minNode(Node<K, T> n)
    {
        if (n.getLeft() == null)
            return n;
        else
        {
            //this.steps++;
            return minNode(n.getLeft());
        }
    }

    public int delete(K key)
    {
        this.steps = 1;
        this.root = deleteRecursive(this.root, key);
        return this.steps;
    }



    private boolean findRecursive(Node<K, T> current, K key)
    {
        if (current == null)
            return false;
        if (key.compareTo(current.getKey()) == 0)
        {
            if (key.toString().compareTo(current.getKey().toString()) == 0)
                return true;
            else
                return findRecursive(current.getLeft(), key);
        }
        if (key.compareTo(current.getKey()) < 0)
            return findRecursive(current.getLeft(), key);
        else
            return findRecursive(current.getRight(), key);
    }

    public boolean contains(K key)
    {
        return findRecursive(this.root, key);
    }



    private T getRecursive(Node<K, T> current, K key)
    {
        if (current == null)
            return null;
        if (key.compareTo(current.getKey()) == 0)
        {
            if (key.toString().compareTo(current.getKey().toString()) == 0)
                return current.getValue();
            else
                return getRecursive(current.getLeft(), key);
        }
        if (key.compareTo(current.getKey()) < 0)
            return getRecursive(current.getLeft(), key);
        else
            return getRecursive(current.getRight(), key);
    }

    public T get(K key) throws NotFoundException
    {
        if (getRecursive(this.getRoot(), key) == null)
            throw new NotFoundException();
        return getRecursive(this.getRoot(), key);
    }



    private String addressRecursive(Node<K, T> current, K key) throws NotFoundException
    {
        if (current == null)
            throw new NotFoundException();
        if (key.compareTo(current.getKey()) == 0)
        {
            if (key.toString().compareTo(current.getKey().toString()) == 0)
                return "";
            else
                return "L" + addressRecursive(current.getLeft(), key);
        }
        if (key.compareTo(current.getKey()) < 0)
            return "L" + addressRecursive(current.getLeft(), key);
        else
            return "R" + addressRecursive(current.getRight(), key);
    }

    public String address(K key) throws NotFoundException
    {
        try
        {
          return "-" + addressRecursive(this.getRoot(), key);
        }
        catch(NotFoundException e)
        {
            throw new NotFoundException(); 
        }
    }
}
