package Interface;

import Domain.Classes.system;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class DRTextInterface {

  private final system syst;
 public DRTextInterface(){
   this.syst = new system();
 }
  /**
   * This method runs the dice roll app on the terminal
   */
  public void run(){
    this.Menu();
  }

  /**
   * Main menu for dice roller app text interface
   */
  private void textMenu(){
    System.out.println("Welcome to dice roller text interface");
    System.out.println("Please select one of the following options");
    System.out.println("1- Roll die");
    System.out.println("2- Instructions");
    System.out.println("3- Exit");
  }

  /**
   * Error message for when the user selects the wrong menu option
   */
  private void errorMessage(){
    System.out.println("Please select one of the above options\n");
  }

  /**
   * This menu clears the screen inserting a 100 \n
   */
  private void clearScreen(){
    for(int i =0;i<100;i++){
      System.out.println();
    }
  }

  private void instructions (){
    this.clearScreen();
    System.out.println("This apps rolls dice of 4 ,6 ,8 ,10, 12 or 20 sides");
    System.out.println("you can roll 1 die or several dice");
    System.out.println("If you want to roll one die, for example a 6 side die. In terminal you write 6 when xxx message appears and 1 when yyy message appears");
    System.out.println("If you want roll roll several dice, for example 2d6 and 3d4. In terminal you write 6,4 when xxx message appears and 2,3 when yyy message appears");
    System.out.println("Remember that you must write the same amount of numbers when xxx and yyy messages appears");
    System.out.println("\nPress any key to return to main menu");
    try{
      System.in.read();
    }catch (Exception e){}
  }

  private void diceRoller(){
    try{
      System.out.print("Types of die to roll: ");
      int [] dieType = recibeInputData();
      System.out.print("\nAmount of die to roll: ");
      int [] dieAmount = recibeInputData();
      List<Integer>[] rolledValues = syst.rollDie(dieType,dieAmount);
      System.out.println("\nDice Rolled\n");
      for(int i =0; i<rolledValues.length; i++){
        System.out.print(dieAmount[i]+"d"+dieType[i] + " : "+rolledValues[i].get(0));
        if(rolledValues[i].size()>1) System.out.print(" (");
        for(int j = 1; j<rolledValues[i].size();j++){
          System.out.print(rolledValues[i].get(j));
          if (j!= rolledValues[i].size()-1) System.out.print(" + ");
        }
        if(rolledValues[i].size()>1) System.out.print(")");
        System.out.println("\n");
      }
    } catch (ExitExcepetion e){
      //returns to main menu
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }
  /**
   * Menu for dice roller app
   */
  private void Menu(){
    boolean exit = false;
    this.clearScreen();
    while (!exit){
      this.textMenu();
      Scanner inputData = new Scanner(System.in);
      String data = inputData.nextLine();
      try{
        int op = Integer.parseInt(data);
        if (op <0 || op > 3) this.errorMessage();
        else if (op == 1) this.diceRoller();
        else if (op == 2) {
          this.instructions();
          this.clearScreen();
        }
        else if (op == 3) exit = true;
      }catch (NumberFormatException n){
        this.clearScreen();
        this.errorMessage();
      }
    }

  }

  private int[] recibeInputData()throws ExitExcepetion,Exception{
    int [] ret;
    Scanner inputData = new Scanner(System.in);
    String data = inputData.nextLine();
    if (data.contains("exit")) throw new ExitExcepetion("exit");
    this.validateInputData(data);
    String [] splitedData = data.split(",");
    ret = new int[splitedData.length];
    for (int i =0; i<splitedData.length;i++){
      ret[i] = Integer.parseInt(splitedData[i]);
    }
    return ret;
  }

  private void validateInputData(String data) throws Exception{
    data = this.syst.verifyInputData(data);
    if (data == null) throw new Exception("Error: Data input must be \"exit\" or a number(s) separated by \",\"");
  }

  /**
   * class used to recibe the exit command in text interface
   */
  class ExitExcepetion extends Exception{
    public ExitExcepetion(String message){
      super(message);
    }
  }
}
