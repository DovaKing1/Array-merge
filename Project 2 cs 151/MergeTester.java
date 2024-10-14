import java.util.NoSuchElementException;

/**
 * Testing methods for the ArrayMerge class.
 * @author William Kreahling
 * @author Scott Barlowe
 * @author Katie Brodhead
 * @version Modified January 2024
 */
public class MergeTester {
    private int passes;
    private int failures;

    /**
     * Constructor to initalize passes and failures.
     */
    public MergeTester() {
        passes = 0;
        failures = 0;
    }
    /**
     * Getter method for number of tests passed
     *
     * @return the number of tests passed.
     */
    public int getPasses() {
        return passes;
    }

    /**
     * Getter method for number of failures
     *
     * @return the number of failures.
     */
    public int getFailures() {
        return failures;
    }

    /**
     * A helper method that increments the pass/fail counters and prints an appropriate message based on the value of
     * the specified condition.
     *
     * @param condition A condition for which to test.  If the condition is true, the test passed; otherwise, it
     * fails.
     * @param message A message to print indicating the context for the test.
     */
    public void test(boolean condition, String message, String messageOne, String messageTwo) {
        System.out.println("*** " + message + " ***");
        if (condition) {
            System.out.println("PASSED: EXPECTED --> " + messageOne);
            System.out.println("        ACTUAL   --> " + messageTwo);
            System.out.println();
            passes = passes + 1;
        } else {
            System.out.println("FAILED: EXPECTED --> " + messageOne);
            System.out.println("        ACTUAL   --> " + messageTwo);
            System.out.println();
            failures = failures + 1;
        }
    }
    /**
     * A helper method that increments the pass/fail counters and prints an appropriate message based on the value of
     * the specified condition.
     *
     * @param condition A condition for which to test.  If the condition is true, the test passed; otherwise, it
     * fails.
     * @param messageOne A message to print indicating the expected output
     * @param messageTwo A message to print indicating the actual output
     */
    public void test(boolean condition, String messageOne, String messageTwo) {
        if (condition) {
            System.out.println("PASSED: EXPECTED --> " + messageOne);
            System.out.println("        ACTUAL   --> " + messageTwo);
            System.out.println();
            passes = passes + 1;
        } else {
            System.out.println("FAILED: EXPECTED --> " + messageOne);
            System.out.println("        ACTUAL   --> " + messageTwo);
            System.out.println();
            failures = failures + 1;
        }
    }
    /**
     * A helper method that increments the pass/fail counters and prints an appropriate message based on the value of
     * the specified condition.
     *
     * @param condition A condition for which to test.  If the condition is true, the test passed; otherwise, it
     * fails.
     * @param message A message to print indicating the context for the test.
     */
    public void test(boolean condition, String message) {
        if (condition) {
            System.out.println("PASSED: " + message);
            passes = passes + 1;
        } else {
            System.out.println("FAILED: " + message);
            failures = failures + 1;
        }
    }

    public void testConstruction() {
        System.out.println("\nTesting Constructor");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        ArrayMerge<?> s = new ArrayMerge<>();

        test(s.getCapacity() == 10, "Default constructor, capacity", "10", "" + s.getCapacity());

        test(s.size() == 0, "size","0", "" + s.size());

        test(s.toString().equals("<>"), "toString", "<>",  s.toString());

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++      New ArrayMerge(27); insert 0 elements     ++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        ArrayMerge<?> s2 = new ArrayMerge<>(27);

        test(s2.getCapacity() == 27, "new ArrayMerge(27)", "27", "" + s2.getCapacity());
        test(s2.size() == 0, "size", "0", "" + s2.size());

        test(s2.toString().equals("<>"), "toString",  "<>", "" + s2.toString());

        test(s.equals(s2), "Two empty sequences are equal: " + s.equals(s2));

        ArrayMerge<String> candy = new ArrayMerge<String>();
        candy.add("Butterfinger");
        candy.add("Snickers");
        candy.add("Kit Kat");
        candy.add("Three Muskateers");

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++ New ArrayMerge candy with 4; insert 4 elements ++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

        ArrayMerge<String> s3 = new ArrayMerge<>(candy);

        test(s3.getCapacity() == 10, "new ArrayMerge(candy)", "10", "" + s3.getCapacity());
        test(s3.size() == 4, "size", "4", "" + s3.size());
        test(s3.toString().equals("<Butterfinger, Snickers, Kit Kat, Three Muskateers>"),
             "toString", "<Butterfinger, Snickers, Kit Kat, Three Muskateers>", "" + s3.toString());

    }

    public void testAdd() {
        System.out.println("\nTesting add()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++          New ArrayMerge()               ++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        ArrayMerge<Double> s = new ArrayMerge<>();
        s.add(Double.valueOf(1.1));

        test(s.toString().equals("<1.1>"), "add(1.1)", "<1.1>", s.toString());
        test(s.getCapacity() == 10, "capacity", "10", "" + s.getCapacity());
        test(s.size() == 1, "size", "1", "" + s.size());

        s.add(Double.valueOf(2.2));
        test(s.toString().equals("<1.1, 2.2>"), "add(2.2)", "<1.1, 2.2>", s.toString());
        test(s.getCapacity() == 10, "capacity", "10", "" + s.getCapacity());
        test(s.size() == 2, "size", "2", "" + s.size());

        s.add(Double.valueOf(7.3));
        test(s.toString().equals("<1.1, 2.2, 7.3>"), 
                                 "add(3.3)", "<1.1, 2.2, 7.3>", s.toString());

        test(s.getCapacity() == 10, "capacity", "10", "" + s.getCapacity());
        test(s.size() == 3, "size", "3", "" + s.size());

        s.add(Double.valueOf(4.4));
        test(s.toString().equals("<1.1, 2.2, 7.3, 4.4>"),
             "add(4.4)", "<1.1, 2.2, 7.3, 4.4>", s.toString());

        test(s.getCapacity() == 10, "capacity", "10", "" + s.getCapacity());
        test(s.size() == 4, "size", "4", "" + s.size());

        s.add(Double.valueOf(5.5));
        test(s.toString().equals("<1.1, 2.2, 7.3, 4.4, 5.5>"),
             "add(5.5)", "<1.1, 2.2, 7.3, 4.4, 5.5>", s.toString());

        s.add(Double.valueOf(6.6));
        test(s.toString().equals("<1.1, 2.2, 7.3, 4.4, 5.5, 6.6>"),
               "add(6.6)", "<1.1, 2.2, 7.3, 4.4, 5.5, 6.6>", s.toString());

        s.add(Double.valueOf(7.7));
        s.add(Double.valueOf(8.8));
        s.add(Double.valueOf(9.9));
        s.add(Double.valueOf(1.2));
        test(s.toString().equals("<1.1, 2.2, 7.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 1.2>"),
             "add 4 more", "<1.1, 2.2, 7.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 1.2>", s.toString());

        test(s.getCapacity() == 10, "capacity", "10", "" + s.getCapacity());
        test(s.size() == 10, "size", "10", "" + s.size());


        s.add(Double.valueOf(2.3));
        test(s.toString().equals("<1.1, 2.2, 7.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 1.2, 2.3>"),
             "add 2.3", "<1.1, 2.2, 7.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 1.2, 2.3>", s.toString());
        test(s.getCapacity() == 20, "capacity", "20", "" + s.getCapacity());
        test(s.size() == 11, "size", "11", "" + s.size());
    }

    public void testRemove() {
        System.out.println("\nTesting Remove()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++           New ArrayMerge()              ++");
        System.out.println("++           add eight strings              ++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

        ArrayMerge<String> s = new ArrayMerge<>();
        s.add("one");
        s.add("two");
        s.add("three");
        s.add("four");
        s.add("five");
        s.add("six");
        s.add("seven");
        s.add("eight");

        s.remove("six");
        test(s.toString().equals("<one, two, three, four, five, seven, eight>"),
             "Removing \"six\"; toString", "<one, two, three, four, five, seven, eight>",
             s.toString());
        test(s.getCapacity() == 10, "10" , "" + s.getCapacity());
        test(s.size() == 7, "size", "7", "" + s.size());

        s.remove("three");
        test(s.toString().equals("<one, two, four, five, seven, eight>"),
             "Removing \"three\"; toString", "<one, two, four, five, seven, eight>",
             s.toString());
        test(s.getCapacity() == 10, "capacity", "10", "" + s.getCapacity());
        test(s.size() == 6, "size", "6", "" + s.size());

        s.remove("one");
        test(s.toString().equals("<two, four, five, seven, eight>"),
             "Removing \"one\"; toString", "<two, four, five, seven, eight>:",
             s.toString());
        test(s.getCapacity() == 10, "capacity", "10", "" + s.getCapacity());
        test(s.size() == 5, "size", "5", "" + s.size());

        s.remove("one");
        test(s.toString().equals("<two, four, five, seven, eight>"),
             "Invalid remove; toString", "<two, four, five, seven, eight>", s.toString());
        test(s.getCapacity() == 10, "capacity", "10", "" + s.getCapacity());
        test(s.size() == 5, "size", "5", "" + s.size());

    }

    public void testContains() {
        System.out.println("\nTesting Contains() / ContainsAll()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++            new ArrayMerge()             ++");
        System.out.println("++            insert Novel objects          ++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

        ArrayMerge<Novel> s1 = new ArrayMerge<>();

        s1.add(new Novel("Wuthering Heights", "Emily Bronte", "Fiction", 1847));
        s1.add(new Novel("Bourne Identity",   "Robert Ludlam", "Fiction", 1980));
        s1.add(new Novel("The Philosopher's Stone", "J.K. Rowling", "Young Adult", 2001));
        s1.add(new Novel("The Call of Cthulu", "H.P. Lovecraft", "Short Story", 1928));

        test(s1.toString().equals("<Wuthering Heights : Emily Bronte : Fiction : 1847., " +
                                  "Bourne Identity : Robert Ludlam : Fiction : 1980., " + 
                                  "The Philosopher's Stone : J.K. Rowling : Young Adult : 2001.,"
                                  + " The Call of Cthulu : H.P. Lovecraft : Short Story : 1928.>"),
             "s1.toString()", 
             "<Wuthering Heights : Emily Bronte : Fiction : 1847.," + 
             " Bourne Identity : Robert Ludlam : Fiction : 1980.," + 
             " The Philosopher's Stone : J.K. Rowling : Young Adult : 2001.," + 
             " The Call of Cthulu : H.P. Lovecraft : Short Story : 1928.>", s1.toString());

        test(s1.size() == 4, "s1's", "4", "" + s1.size());
        test(s1.getCapacity() == 10, "s1's capacity", "10", "" + s1.getCapacity());

        test(s1.contains(
        new Novel("The Philosopher's Stone", "J.K. Rowling", "Young Adult", 2001)) == true,
                  "call contains; (book is in set)","" +
                  s1.contains(new Novel("The Philosopher's Stone", "J.K. Rowling", "Young Adult", 
                                        2001)));
        test(s1.getCapacity() == 10, "s1's capacity", "10", "" + s1.getCapacity());

        ArrayMerge<Character> s3 = new ArrayMerge<>();
        s3.add('S');
        s3.add('t');
        s3.add('a');
        s3.add('R');
        s3.add(' ');
        s3.add('w');
        s3.add('A');
        s3.add('r');
        s3.add('s');
        s3.add('!');

        ArrayMerge<Character> all = new ArrayMerge<>();
        all.add('R');
        all.add('a');
        all.add('w');
        all.add('r');
        all.add('!');


        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++       Items contained in Merge           ++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        test(s3.containsAll(all),
             "containsAll(" + all.toString() + ") in " + s3.toString(), "true", 
             "" + s3.containsAll(all));

        all.clear();
        all.add('s');
        all.add('t');
        all.add('a');
        all.add('r');
        test(s3.containsAll(all),
             "containsAll(" + all.toString() + ") in " + s3.toString(), "true",  
             "" + s3.containsAll(all));
        all.clear();
        all.add('S');
        all.add('T');
        all.add('A');
        all.add('R');
        test(!s3.containsAll(all),
             "containsAll(" + all.toString() + ") in " + s3.toString(), "false", 
             "" + s3.containsAll(all));

    }

    public void testEquals() {
        System.out.println("\nTesting equals()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        ArrayMerge<Double> s1 = new ArrayMerge<>();
        ArrayMerge<Double> s2 = new ArrayMerge<>();
        ArrayMerge<Double> s3 = new ArrayMerge<>();
        ArrayMerge<Double> s4 = new ArrayMerge<>();
        ArrayMerge<Double> s5 = new ArrayMerge<>();
        s3.add(1.1);
        s4.add(1.1);
        s5.add(1.1);
        s5.add(2.2);
       


        test(s1.equals(s1), "Empty sequence equal to itself", "true", "" + s1.equals(s1));
        test(s1.equals(s2), "Empty sequence equal to an empty sequence", "true", "" + s1.equals(s2));
        test(!s1.equals(s3), "Empty sequence equal to a non-empty one", "false", 
             "" + s1.equals(s3));
        test(s3.equals(s4),
             "Two equal, non-empty sequences", "true", "" + s3.equals(s4));
        test(!s3.equals(s5),
             "Two non-empty, non-equal sequences", "false", "" + s3.equals(s5));

        ArrayMerge<Double> s6 = new ArrayMerge<>(27);
        s6.add(1.1);
        test(s6.equals(s4),
               "Two non-empty, equal sequences (w/ different capacities)", "true", 
               "" + s6.equals(s4));


    }

    public void testPreconditions() {
        System.out.println("\nTesting preconditions");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        try {
            ArrayMerge<?> s = new ArrayMerge<>();
            s.add(null);
            test(false, "add(null) should throw a IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "add(null) should throw a IAE: " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "add(null) should throw a IAE, got: " + ex.getMessage());
            ex.printStackTrace();
        }
        try {
            ArrayMerge<Double> s = new ArrayMerge<>();
            s.add(1.1);
            s.contains(null);
            test(false, "contains(null) should throw a IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "contains(null) should throw a IAE: " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "contains(null) should throw a IAE, got: " + ex.getMessage());
            ex.printStackTrace();
        }

        try {
            ArrayMerge<?> s = new ArrayMerge<>(null);
            test(false, "creating an ArrayMerge with null as input should throw an IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "creating an ArrayMerge with null as input should throw an IAE:\n"
                 + "        " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "constructor with null input should throw a IAE, got:\n"
                 + "        " + ex.getMessage());
            ex.printStackTrace();
        }
        try {
            ArrayMerge<Double> s = new ArrayMerge<>();
            s.add(1.1);
            s.add(2.2);
            s.containsAll(null);
            test(false, "containsAll(null) should throw a IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "containsAll(null) should throw a IAE: " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "containsAll(null) should throw a IAE, got: " + ex.getMessage());
            ex.printStackTrace();
        }
        try {
            ArrayMerge<Double> s = new ArrayMerge<>();
            s.add(1.1);
            s.add(2.2);
            s.get(4);
            // Modifications to below messages -  SAB, 10/2018
            test(false, "get(invalid index) should throw a NSEE");
        } catch (NoSuchElementException ex) {
            test(true, "get(invalid index) should throw a NSEE: " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "get(invalid index) should throw a NSEE, got: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public void testRetainAll() {
        System.out.println("\nTesting retainAll()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        ArrayMerge<String> s1 = new ArrayMerge<>();

        s1.add("Lion");
        s1.add("Bear");
        s1.add("Tiger");
        s1.add("Frog");
        s1.add("Pea");

        ArrayMerge<String> s2 = new ArrayMerge<>();
        s2.add("Frog");
        s2.add("Princess");
        s2.add("Pea");
        s2.add("Dragon");
        s2.add("Charming");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++ s1 = <Lion, Bear, Tiger, Frog, Pea>          ++");
        System.out.println("++ s2 = <Frog, Princess, Pea, Dragon, Charming> ++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();

        s1.retainAll(s2);
        test(s1.toString().equals("<Frog, Pea>"),
             "s1.retainAll(s2); s1.toString()", "<Frog, Pea>", s1.toString());
        test(s1.size() == 2, "s1's size", "2", "" + s1.size());
        test(s1.getCapacity() == 10, "s1's capacity", "10", "" + s1.getCapacity());

        s1.add("Charming");
        s1.add("Tiger");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++ s1 = <Frog, Pea, Charming, Tiger>            ++");
        System.out.println("++ s2 = <Frog, Princess, Pea, Dragon, Charming> ++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        s2.retainAll(s1);
        test(s2.toString().equals("<Frog, Pea, Charming>"),
             "s2.retainAll(s1); s2.toString()", "<Frog, Pea, Charming>", s2.toString());
        test(s2.size() == 3, "s2's size", "3", "" + s2.size());
        test(s2.getCapacity() == 10, "s2's capacity", "10", "" + s2.getCapacity());

        ArrayMerge<String> s3 = new ArrayMerge<String>(s1);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++ s3 = <Frog, Pea, Charming, Tiger>            ++");
        System.out.println("++ s2 = <Frog, Pea, Charming>                   ++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        s2.retainAll(s3);
        test(s2.toString().equals("<Frog, Pea, Charming>"),
             "s2.retainAll(s3); s2.toSTring()", "<Frog, Pea, Charming>", s2.toString());
        test(s2.size() == 3, "s2's size", "3", "" + s2.size());
        test(s2.getCapacity() == 10, "s2's capacity", "10", "" + s2.getCapacity());
    }
    
    public void testMergeUnmerge() {
        System.out.println("\nTesting merge() and unMerge");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        ArrayMerge<String> s1 = new ArrayMerge<>();
        s1.add("Banana");
        s1.add("Apple");
        s1.add("Pear");
        s1.add("Orange");
        s1.add("Strawberry");

        ArrayMerge<String> s2 = new ArrayMerge<>();
        s2.add("Cabbage");
        s2.add("Carrot");
        s2.add("Pea");
        s2.add("Broccoli");

        ArrayMerge<String> s3 = new ArrayMerge<>(s1);

        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++ s1 = <Banana, Apple, Pear, Orange, Strawberry>     ++");
        System.out.println("++ s2 = <Cabbage, Carrot, Pea, Broccoli>              ++");
        System.out.println("++ Merge offset 2                                     ++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        
        s1.merge(s2, 2);

        String correctString = "<Banana, Apple, Cabbage, Carrot, Pear, " + 
                         "Orange, Pea, Broccoli, Strawberry>";

        test(s1.toString().equals(correctString), "s1 merged with s2", correctString, 
                          s1.toString());
        test(s1.size() == 9, "s1's size", "9", "" + s1.size());
        test(s1.getCapacity() == 10, "s1's capacity", "10", "" + s1.getCapacity());


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                            "++++++++++++++++++++++++++++++");
        System.out.println("++ s1 = " + correctString + "              ++");
        System.out.println("++ s1 = <Banana, Apple, Pear, Orange, Strawberry>                 " +                  
                           "                            ++");
        System.out.println("++ UnMerge offset 2                                                " +
                           "                            ++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                            "++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println("s1 is " + s1);
        s1.unMerge(2);
        System.out.println("s1 is " + s1);

        //correctString = "<Banana, Cabbage, Pear, Pea, Strawberry>";
        correctString = "<Banana, Apple, Pear, Orange, Strawberry>";

        test(s1.toString().equals(correctString), "s1 unMerged", correctString, 
                          s1.toString());
        test(s1.size() == 5, "s1's size", "5", "" + s1.size());
        test(s1.getCapacity() == 5, "s1's capacity", "5", "" + s1.getCapacity());
      
      
        s1 = new ArrayMerge<>();
        s1.add("Banana");
        s1.add("Apple");
        s1.add("Pear");
        s1.add("Orange");
        s1.add("Strawberry");
        
        s2 = new ArrayMerge<>();
        s2.add("Cabbage");
        s2.add("Carrot");
        s2.add("Pea");
        s2.add("Broccoli");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++ s1 = <Banana, Apple, Pear, Orange, Strawberry>     ++");
        System.out.println("++ s2 = <Cabbage, Carrot, Pea, Broccoli>              ++");
        System.out.println("++ Merge offset 3                                     ++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();

        s1.merge(s2, 3);

        correctString = "<Banana, Apple, Pear, Cabbage, Carrot, Pea, Orange, Strawberry, Broccoli>";

        test(s1.toString().equals(correctString), "s1 merged with s2", correctString, s1.toString());
        test(s1.size() == 9, "s1's size", "9", "" + s1.size());
        test(s1.getCapacity() == 10, "s1's capacity", "10", "" + s1.getCapacity());
       
    }
}
