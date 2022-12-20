package test;

/**
 * This class is used to do tests for the dice roller app
 */
class MainTest {
  /**
   * A simple main method which executes unitary test for dice roller app
   * @param args
   */
  public static void mainTest(String[] args){
    executeDieTests();
  }

  /**
   * A simple test method for test the die class
   */
  private static void executeDieTests(){
    dieTest test = new dieTest();
    test.test(4);
    test.test(6);
    test.test(10);
    test.test(12);
    test.test(20);
  }

}
