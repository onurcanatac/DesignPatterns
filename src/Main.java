public class Main {
    public static void main(String[] args) throws Exception {

        // I have used some fo the examples from the homework document

        // part 1 test

        System.out.println("---------------------");
        System.out.println("Part 1");
        System.out.println();

        // initializations

        Directory dir1 = new Directory("MyPC");
        Directory dir2 = new Directory("MyDocuments");
        Directory dir3 = new Directory("BilkentStuff");
        Directory dir4 = new Directory("FavoriteMusic");

        File file1 = new File("InternshipReport", "pdf", 10);
        File file2 = new File("setup", "exe", 5);
        File file3 = new File("ToDoList", "docx", 15);
        File file4 = new File("MetallicaTheUnforgiven", "mp3", 100);

        // add files to directories

        dir3.addElement(file1);
        dir3.addElement(file2);
        dir3.addElement(file3);

        dir4.addElement(file4);

        dir3.addElement(dir4);

        dir1.addElement(dir2);
        dir1.addElement(dir3);

        // print the result

        System.out.println(dir1.getInfo());

        // part 2 test

        System.out.println("---------------------");
        System.out.println("Part 2");
        System.out.println();

        System.out.println(new IndentationDecorator(dir1).getInfo());

        System.out.println();

        System.out.println(new TypeIndicationDecorator(dir1).getInfo());

        System.out.println();

        System.out.println(new TypeIndicationDecorator(new IndentationDecorator(dir1)).getInfo());

        // part 3 test

        // size based representation

        System.out.println("---------------------");
        System.out.println("Part 3");
        System.out.println();

        dir1.adjustMemoryRepresentation(true);
        System.out.println(dir1.applyMemoryRepresentation());

        System.out.println();

        dir1.adjustMemoryRepresentation(false);
        System.out.println(dir1.applyMemoryRepresentation());

        System.out.println();

    }
}
