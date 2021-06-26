public class Node<K, T>
{
    Node<K, T> left, right;
    T data;
    K key;

    public Node(K k, T d)
    {
        this.left = null;
        this.right = null;
        this.data = d;
        this.key = k;
    }

    public Node<K, T> getLeft()
    {
        return this.left;
    }

    public Node<K, T> getRight()
    {
        return this.right;
    }

    public void setLeft(Node<K, T> l)
    {
        this.left = l;
    }

    public void setRight(Node<K, T> r)
    {
       this.right = r;
    }

    public T getValue()
    {
        return this.data;
    }

    public K getKey()
    {
        return this.key;
    }

    public void setValue(K k, T d)
    {
        this.key = k;
        this.data = d;
    }

}
