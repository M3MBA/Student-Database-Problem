public class HashTest
{
    private static int getHash(Pair<String,String> key, int i, int s)
    {
        return ((int) (Hash.djb2(key.toString(), s) + (i * Hash.sdbm(key.toString(), s))) % s);
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String query;

        while ((query = br.readLine()) != null)
        {
            String st = query.split(" ");
        }
    }
}

