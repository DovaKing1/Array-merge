import java.lang.reflect.Method;

/**
 * @author Elijah McCray
 * @author Anna Sloan
 */

public class MergeTesterDriver {

    /**
     * Runs the tests for the MergeTester class.
     * 
     * This method creates an instance of MergeTester, executes various test methods,
     * and prints the results of the tests.
     */
    public void runTests(){
        MergeTester mergeTester = new MergeTester();

        System.out.println("==================================================================");
        System.out.println("Testing class ArrayMergeTester");
        System.out.println("==================================================================");
        
        mergeTester.testConstruction();
        mergeTester.testAdd();
        mergeTester.testAdd();
        mergeTester.testRemove();
        mergeTester.testContains();
        mergeTester.testEquals();
        mergeTester.testPreconditions();
        mergeTester.testRetainAll();
        mergeTester.testMergeUnmerge();

        int testsAttempted = mergeTester.getPasses() + mergeTester.getFailures();

        System.out.print("Tests executed:\t" + testsAttempted + "\nSuccessful:\t" +
             mergeTester.getPasses() +  "\nUnsuccessful:\t" + mergeTester.getFailures());
        //Prints how many tests were attempted and how many were passed/failed.
    }

/**
 * This method creates an instance of MergeTesterDriver, invokes the runTests() method,
 * and initiates the execution of tests for the MergeTester class.
 * 
 * @param args
 */
    public static void main(String args[]){
        MergeTesterDriver driver = new MergeTesterDriver();
        driver.runTests();
    }


}
