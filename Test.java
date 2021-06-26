public class Test
{
    @SuppressWarnings({"rawtypes","unchecked"})
    public static void main(String[] args)
    {
        Student s1 = new Student("Ram", "Singh", "Nilgiri", "CS", "6.5");
        Student s2 = new Student("Lallan", "Singh", "Nilgiri", "CE", "6.0");
        Student s3 = new Student("Shyam", "Singh", "Satpura", "EE", "8.2");
        Student s4 = new Student("Anurag", "Singh", "Kumaon", "TT", "7.3");
        Student s5 = new Student("Navneet", "Singh", "Nilgiri", "PH", "5.7");
        Student s6 = new Student("Tejas", "Singh", "Aravali", "BB", "5.9");
        Student s7 = new Student("Shina", "Singh", "Himadri", "MT", "7.3");
        Student s8 = new Student("Aadish", "Singh", "Girnar", "TT", "8.7");
        Student s9 = new Student("Atharva", "Singh", "Kara", "EE", "7.7");
        Student s10 = new Student("Astitva", "Singh", "Jwala", "ME", "6.4");
        Student s11 = new Student("Avruty", "Singh", "Kailash", "CS", "8.0");
        Student s12 = new Student("Anurag","Singla","Udaigiri","TT","7.2");
        Pair<String,String> p1 = new Pair<>("Ram", "Singh");
        Pair<String,String> p2 = new Pair<>("Lallan", "Singh");
        Pair<String,String> p3 = new Pair<>("Shyam", "Singh");
        Pair<String,String> p4 = new Pair<>("Anurag", "Singh");
        Pair<String,String> p5 = new Pair<>("Navneet", "Singh");
        Pair<String,String> p6 = new Pair<>("Tejas", "Singh");
        Pair<String,String> p7 = new Pair<>("Shina", "Singh");
        Pair<String,String> p8 = new Pair<>("Aadish", "Singh");
        Pair<String,String> p9 = new Pair<>("Atharva", "Singh");
        Pair<String,String> p10 = new Pair<>("Astitva", "Singh");
        Pair<String,String> p11 = new Pair<>("Avruty", "Singh");
        Pair<String, String> p12 = new Pair<>("Anurag", "Singla");
        SCBST<Pair<String, String>, Student> bt = new SCBST(15);
        System.out.println(bt.insert(p1, s1));
        System.out.println(bt.insert(p2, s2));
        System.out.println(bt.insert(p3, s3));
        System.out.println(bt.insert(p4, s4));
        System.out.println(bt.insert(p5, s5));
        System.out.println(bt.insert(p6, s6));
        System.out.println(bt.insert(p7, s7));
        System.out.println(bt.insert(p8, s8));
        System.out.println(bt.insert(p9, s9));
        System.out.println(bt.insert(p10, s10));
        System.out.println(bt.insert(p11, s11));
        System.out.println(bt.insert(p12, s12));
        System.out.println();
        System.out.println(bt.insert(p10, s10));
        //System.out.println(bt.delete(p4));
        //bt.display();
        System.out.println();
        try
        {
            System.out.println(bt.address(p1));
            System.out.println(bt.address(p2));    
            System.out.println(bt.address(p3));
            System.out.println(bt.address(p4));
            System.out.println(bt.address(p5));
            System.out.println(bt.address(p6));
            System.out.println(bt.address(p7));
            System.out.println(bt.address(p8));
            System.out.println(bt.address(p9));
            System.out.println(bt.address(p10));
            System.out.println(bt.address(p11));
            System.out.println(bt.address(p12));
        }
        catch (NotFoundException e)
        {
            System.out.println("E");
        }
        //System.out.println(bt.delete(p9));
        //System.out.println(bt.delete(p5));
        /*System.out.println();
        System.out.println(bt.contains(p9));
        System.out.println(bt.contains(p2));
        System.out.println();
        //bt.display();
        System.out.println();
        try
        {
            System.out.println(bt.get(p5).toString());
        }
        catch(NotFoundException e)
        {
            System.out.println("E");
        }

        //System.out.println(bt.address(p11));

        //Generic<Pair<String,String>> gen = new Generic<>();
        /**System.out.println(gen.fname(p1));
        System.out.println(bt.delete(p2));
        System.out.println();
        System.out.println(bt.insert(s7));
        bt.display();
        System.out.println();
        System.out.println(bt.count());*/
    }
}
