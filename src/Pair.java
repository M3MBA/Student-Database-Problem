public class Pair<A,B> implements Comparable<Pair<A, B>>
{
    A first;
    B last;

    public Pair(A f, B l)
    {
        this.first = f;
        this.last = l;
    }

    public String getFirst()
    {
        return String.valueOf(this.first);
    }

    public String getLast()
    {
        return String.valueOf(this.last);
    }

    public String toString()
    {
        return String.valueOf(this.first) + String.valueOf(this.last);
    }

    public int compareTo(Pair<A, B> key)
    {
        return this.getFirst().compareTo(key.getFirst());
    }
}
