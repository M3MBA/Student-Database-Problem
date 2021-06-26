public class Test2
{
    public static void main(String[] args)
    {
        Student[] s = new Student[12];
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
        s[11] = new Student("Anurag", "Singla", "Udaigiri", "TT", "7.9");

        Pair<String, String>[] p = new Pair[12];
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
        p[11] = new Pair<>("Anurag", "Singla");
        BST<Pair<String, String>, Student> bt = new BST<>();
        System.out.println(p[11].toString());
        System.out.println();
        for (int i = 0; i < 12; i++)
            System.out.println(bt.insert(p[i], s[i]));
        System.out.println();
        System.out.println(bt.insert(p[5], s[5]));
        System.out.println();
        System.out.println(bt.delete(p[4]));
        //bt.display();
        System.out.println();
        for (int i = 0; i < 12; i++)
        {
            try {
                System.out.println(bt.address(p[i]));
            }
            catch (NotFoundException e) {
                System.out.println("E");
            }
        }
        System.out.println();
        System.out.println(bt.insert(p[2], s[2]));
    }
}

