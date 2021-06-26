public class Item<K, T>
{
    K key;
    T data;

    public Item(K k, T d)
    {
        this.key = k;
        this.data = d;
    }

    public K getKey()
    {
        return this.key;
    }

    public T getValue()
    {
        return this.data;
    }

    public void setValue(K k, T d)
    {
        this.key = k;
        this.data = d;
    }
}
