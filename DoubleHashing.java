public class DoubleHashing<K extends Comparable<K>, T> implements MyHashTable_<K, T>
{
    Item<K, T>[] table;
    int[] flag;
    int size;
    int index;
    int steps;
    int count;
    int t;

    @SuppressWarnings({"unchecked","rawtypes"})
    public DoubleHashing(int n)
    {
        this.size = n;
        this.table = new Item[this.size];
        this.flag = new int[this.size];
        for (int i = 0; i < this.size; i++)
        {
            this.table[i] = null;
            this.flag[i] = 0;
        }
        this.index = 0;
        this.steps = 0;
        this.count = 0;
        this.t = 0;
    }

    public int count()
    {
        return this.count;
    }

    private int getHash(K key, int i)
    {
        int h1 = (int) Hash.djb2(key.toString(),this.size);
        int h2 = (int) Hash.sdbm(key.toString(), this.size);
        return ((h1 + (i * h2)) % size);
    }

    public int insert(K key, T obj)
    {
        if (this.count() >= size)
            return -1;
        steps = 0;
        index = getHash(key, steps);
        while (table[index] != null)
        {
            if (table[index].getKey().toString().compareTo(key.toString()) == 0)
                return -1;
            steps+=1;
            index = getHash(key, steps);
        }
        table[index] = new Item<K, T>(key, obj);
        flag[index] = 2;
        count++;
        return (steps + 1);
    }

    public int update(K key, T obj)
    {
        t = 0;
        steps = 0;
        index = getHash(key, steps);

        while (t < size)
        {
            if (flag[index] == 2)
            {
                if (table[index].getKey().toString().compareTo(key.toString()) == 0)
                {
                    table[index] = new Item<K, T>(key, obj);
                    //System.out.println("not null equal");
                    return (steps + 1);
                }
                else
                {
                    steps+=1;
                    index = getHash(key, steps);
                    //System.out.println("not null not equal");
                }
            }
            else if (flag[index] == 1)
            {
                steps+=1;
                index = getHash(key, steps);
                //System.out.println("null prev occupies");
            }
            else
            {
                //System.out.println("null always");
                return -1;
            }
            t++;
        }
        return -1;
    }


    public int delete(K key)
    {
        t = 0;
        steps = 0;
        index = getHash(key, steps);
        while (t < size)
        {
            if (flag[index] == 2)
            {
                if (table[index].getKey().toString().compareTo(key.toString()) == 0)
                {
                    table[index] = null;
                    flag[index] = 1;
                    count--;
                    //System.out.println("not null equal");
                    return (steps + 1);
                }
                else
                {
                    steps+=1;
                    index = getHash(key, steps);
                    //System.out.println("not null not equal");
                }
            }
            else if (flag[index] == 1)
            {
                steps+=1;
                index = getHash(key, steps);
                //System.out.println("null prev occupied");
            }
            else
            {
                //System.out.println("null always");
                return -1;
            }
            t++;
        }
        return -1;
    }

    public void display()
    {
        for (int i = 0; i < this.table.length; i++)
            if (this.table[i] != null)
                System.out.println(i + " " + this.table[i].getValue().toString());
    }


    public boolean contains(K key)
    {
        t = 0;
        steps = 0;
        index = getHash(key,steps);
        while (t < size)
        {
            if (flag[index] == 2)
            {
                if (table[index].getKey().toString().compareTo(key.toString()) == 0)
                {
                    //System.out.println("not null equal");
                    return true;
                }
                else
                {
                    steps+=1;
                    index = getHash(key, steps);
                    //System.out.println("not null not equal");
                }
            }
            else if (flag[index] == 1)
            {
                steps+=1;
                index = getHash(key, steps);
                //System.out.println("null prev occupied");
            }
            else
            {
                //System.out.println("null always");
                return false;
            }
            t++;
        }
        return false;
    }
    



    public T get(K key) throws NotFoundException
    {
        t = 0;
        steps = 0;
        index = getHash(key,steps);

        while(t < size)
        {
            if (flag[index] == 2)
            {
                if (table[index].getKey().toString().compareTo(key.toString()) == 0)
                {
                    //System.out.println("not null equal");
                    return table[index].getValue();
                }
                else
                {
                    steps+=1;
                    index = getHash(key, steps);
                    //System.out.println("not null not equal");
                }
            }
            else if (flag[index] == 1)
            {
                steps+=1;
                index = getHash(key, steps);
                //System.out.println("null prev occupied");
            }
            else
            {
                //System.out.println("null always");
                throw new NotFoundException();
            }
            t++;
        }
        throw new NotFoundException();
    }


    public String address(K key) throws NotFoundException
    {
        t = 0;
        steps = 0;
        index = getHash(key, steps);

        while(t < size)
        {
            if (flag[index] == 2)
            {
                if (table[index].getKey().toString().compareTo(key.toString()) == 0)
                {
                    //System.out.println("not null equal");
                    return String.valueOf(index);
                }
                else
                {
                    steps+=1;
                    index = getHash(key, steps);
                    //System.out.println("not null not equal");
                }
            }
            else if (flag[index] == 1)
            {
                steps+=1;
                index = getHash(key, steps);
                //System.out.println("null prev occupied");
            }
            else
            {
                //System.out.println("null always");
                throw new NotFoundException();
            }
            t++;
        }
        throw new NotFoundException();
    }
}
