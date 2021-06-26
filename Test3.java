public class Test3
{
    @SuppressWarnings({"rawtypes","unchecked"})
    public static void main(String[] args)
    {
        Student[] s = new Student[11];
        s[0] = new Student("Ram", "Singh", "Nilgiri", "CS", "6.5");
        s[1] = new Student("Lallan", "Singh", "Nilgiri", "CE", "6.0");
        s[2] = new Student("Shyam", "Singh", "Satpura", "EE", "8.2");
        s[3] = new Student("Anurag", "Singh", "Kumaon", "TT", "7.3");
        s[4] = new Student("Navneet", "Singh", "Nilgiri", "PH", "5.7");
        s[5] = new Student("Tejas", "Singh", "Aravali", "BB", "5.9");
        s[6] = new Student("Shina", "Singh", "Himadri", "MT", "7.3");
        s[7] = new Student("Aadish", "Singh", "Girnar", "TT", "8.7");
        s[8] = new Student("Atharva", "Singh", "Kara", "EE", "7.7");
        s[9] = new Student("Astitva", "Singh", "Jwala", "ME", "6.4");
        s[10] = new Student("Avruty", "Singh", "Kailash", "CS", "8.0");
        Student stu = new Student("Astitva", "Singh", "Kumaon", "CS", "5.9");

        Pair<String, String>[] p = new Pair[11];
        p[0] = new Pair<>("Ram", "Singh");
        p[1] = new Pair<>("Lallan", "Singh");
        p[2] = new Pair<>("Shyam", "Singh");
        p[3] = new Pair<>("Anurag", "Singh");
        p[4] = new Pair<>("Navneet", "Singh");
        p[5] = new Pair<>("Tejas", "Singh");
        p[6] = new Pair<>("Shina", "Singh");
        p[7] = new Pair<>("Aadish", "Singh");
        p[8] = new Pair<>("Atharva", "Singh");
        p[9] = new Pair<>("Astitva", "Singh");
        p[10] = new Pair<>("Avruty", "Singh");
        Pair<String, String> key = new Pair<>("Abhinav", "Singh");

        DoubleHashing<Pair<String, String>, Student> dhtable = new DoubleHashing<>(11);

        

        for (int i = 0; i < 11; i++)
        {
            System.out.println(Hash.djb2(p[i].toString(), 13));
        }
        System.out.println();
        for (int i = 0; i < 11; i++)
        {
            System.out.println(dhtable.insert(p[i], s[i]));
        }
        System.out.println();
        System.out.println(dhtable.count());
        System.out.println();
        //System.out.println(dhtable.delete(p[1]));
        System.out.println();
        dhtable.display();
        System.out.println();
        //dhtable.flags();
        //System.out.println(dhtable.delete(p[2]));
        System.out.println();
        System.out.println(dhtable.contains(p[7]));
        System.out.println();
        //System.out.println(dhtable.update(p[9], stu));
        dhtable.display();
        System.out.println();
        try
        {
            System.out.println(dhtable.address(p[5]));
        }
        catch(NotFoundException e)
        {
            System.out.println("E");
        }
        System.out.println(dhtable.insert(p[6], s[6]));
    }
}
