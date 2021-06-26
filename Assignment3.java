import java.io.*;
public class Assignment3
{
    public static void print(boolean t)
    {
        if (t)
            System.out.println("T");
        else
            System.out.println("F");
    }
    public static void print(int s)
    {
        if (s == -1)
            System.out.println("E");
        else
            System.out.println(s);
    }
    public static void doubleHashing(int size, String file)
    {
        DoubleHashing<Pair<String, String>, Student> dhtable = new DoubleHashing<>(size);
        Student stud;
        Pair<String, String> key;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String query;
            while ((query = br.readLine()) != null)
            {
                String[] input = query.split(" ");
                key = new Pair<String, String>(input[1], input[2]);

                switch(input[0])
                {
                    case "insert":
                        stud = new Student(input[1], input[2], input[3], input[4], input[5]);
                        print(dhtable.insert(key, stud));
                        break;
                    case "update":
                        stud = new Student(input[1], input[2], input[3], input[4], input[5]);
                        print(dhtable.update(key, stud));
                        break;
                    case "delete":
                        print(dhtable.delete(key));
                        break;
                    case "contains":
                        print(dhtable.contains(key));
                        break;
                    case "get":
                        try {
                            System.out.println(dhtable.get(key).toString());
                        }
                        catch(NotFoundException e) {
                            System.out.println("E");
                        }
                        finally {
                            break;
                        }
                    case "address":
                        try {
                            System.out.println(dhtable.address(key));
                        }
                        catch(NotFoundException e) {
                            System.out.println("E");
                        }
                        finally {
                            break;
                        }
                    default:
                        System.out.println();
                }
            }
        }
        catch(IOException e){}
    }


    public static void singleChainingBST(int size, String file)
    {
        SCBST<Pair<String, String>, Student> sctable = new SCBST<>(size);
        Student stud;
        Pair<String, String> key;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String query;
            while ((query = br.readLine()) != null)
            {
                String[] input = query.split(" ");
                key = new Pair<String, String>(input[1], input[2]);

                switch(input[0])
                {
                    case "insert":
                        stud = new Student(input[1], input[2], input[3], input[4], input[5]);
                        print(sctable.insert(key, stud));
                        break;
                    case "update":
                        stud = new Student(input[1], input[2], input[3], input[4], input[5]);
                        print(sctable.update(key, stud));
                        break;
                    case "delete":
                        print(sctable.delete(key));
                        break;
                    case "contains":
                        print(sctable.contains(key));
                        break;
                    case "get":
                        try {
                            System.out.println(sctable.get(key).toString());
                        }
                        catch(NotFoundException e) {
                            System.out.println("E");
                        }
                        finally {
                            break;
                        }
                    case "address":
                        try {
                            System.out.println(sctable.address(key));
                        }
                        catch(NotFoundException e) {
                            System.out.println("E");
                        }
                        finally {
                            break;
                        }
                    default:
                        System.out.println();
                }
            }
        }
        catch(IOException e) {}
    }


    public static void main(String[] args)
    {
        switch(args[1])
        {
            case "DH":
                doubleHashing(Integer.valueOf(args[0]), args[2]);
                break;
            case "SCBST":
                singleChainingBST(Integer.valueOf(args[0]), args[2]);
                break;
            default:
                System.out.println("Incorrect arguments");
        }
    }
}
