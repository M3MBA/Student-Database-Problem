public class SCBST<K extends Comparable<K>, T> implements MyHashTable_<K, T>
{
    BST<K, T>[] bt;
    K key;
    T data;
    int size;
    int index;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public SCBST(int n)
    {
        this.size = n;
        this.index = -1;
        bt = new BST[this.size]; 
        this.key = null;
        this.data = null;
        for (int i = 0; i < n; i++)
            bt[i] = new BST<K, T>();
    }

    public int insert(K key, T obj)
    {
        String pair = key.toString();
        index = (int) Hash.djb2(pair, size);
        return bt[index].insert(key, obj);
    }

    public int update(K key, T obj)
    {
        String pair = key.toString();
        index = (int) Hash.djb2(pair, size);
        return bt[index].update(key, obj);
    }

    public int delete(K key)
    {
        index = (int) Hash.djb2(key.toString(), size);
        return bt[index].delete(key);
    }

    public boolean contains(K key)
    {
        index = (int) Hash.djb2(key.toString(), size);
        return bt[index].contains(key);
    }

    public T get(K key) throws NotFoundException
    {
        try
        {
            index = (int) Hash.djb2(key.toString(), size);
            return bt[index].get(key);
        }
        catch(NotFoundException e) 
        {
            throw new NotFoundException();
        }
    }

    public String address(K key) throws NotFoundException
    {
        try
        {
            index = (int) Hash.djb2(key.toString(), size);
            return String.valueOf(index) + bt[index].address(key);
        }
        catch(NotFoundException e)
        {
            throw new NotFoundException();
        }
    }
}
