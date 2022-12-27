package Interface;

import Domain.Classes.system;

import Interface.RegExp;
import java.util.List;
import java.util.Scanner;

public class DRTextInterface {

  private static final system syst = new system();

  // Default constructor method
  /**
   * main method for DR text interface
    */
  public static void main(String[] args){
    Menu();
  }

  /**
   * Menu for dice roller app
   */
  private static void Menu(){
    boolean exit = false;
    clearScreen();
    System.out.println("Welcome to dice roller text interface");
    while (!exit){
      textMenu();
      Scanner inputData = new Scanner(System.in);
      String data = inputData.nextLine();
      try{
        clearScreen();
        int op = Integer.parseInt(data);
        if (op == 1) diceRoller();
        else if (op == 2) {
          instructions();
          clearScreen();
        }
        else if (op == 3) exit = true;
      }catch (NumberFormatException n){
        clearScreen();
      }
    }
  }

  /**
   * Main menu for dice roller app text interface
   */
  private static void textMenu(){
    System.out.println("Please select one of the following options");
    System.out.println("1- Roll die");
    System.out.println("2- Instructions");
    System.out.println("3- Exit");
    System.out.print("Option: ");
  }

  /**
   * This menu clears the screen inserting a 100 \n
   */
  private static void clearScreen(){
    for(int i =0;i<100;i++){
      System.out.println();
    }
  }

  private static void instructions (){
    clearScreen();
    System.out.println("This apps rolls dice of 4 ,6 ,8 ,10, 12 or 20 sides");
    System.out.println("you can roll 1 die or several dice");
    System.out.println("If you want to roll one die, for example a 6 side die. In terminal you write 6 when \"Types of die to roll\" message appears and 1 when \"Amount of die to roll\" message appears");
    System.out.println("If you want roll roll several dice, for example 2d6 and 3d4. In terminal you write 6,4 when \"Types of die to roll\" message appears and 2,3 when \"Amount of die to roll\" message appears");
    System.out.println("Remember that you must write the same amount of numbers when \"Types of die to roll\" and \"Amount of die to roll\" messages appears");
    System.out.print("\nPress any key to return to main menu");
    try{
      System.in.read();
    }catch (Exception e){}
  }

  private static void diceRoller(){
    try{
      System.out.print("Types of die to roll: ");
      int [] dieType = recibeInputData();
      validateDieSides(dieType);
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
      clearScreen();
      System.out.println(e.getMessage());
    }
  }


  private static int[] recibeInputData()throws ExitExcepetion,Exception{
    int [] ret;
    Scanner inputData = new Scanner(System.in);
    String data = inputData.nextLine();
    if (data.contains("exit")) throw new ExitExcepetion("exit");
    validateInputData(data);
    String [] splitedData = data.split(",");
    ret = new int[splitedData.length];
    for (int i =0; i<splitedData.length;i++){
      ret[i] = Integer.parseInt(splitedData[i]);
    }
    return ret;
  }

  private static void validateInputData(String data) throws Exception{
    RegExp regExp = new RegExp();
    data = regExp.matchStringInputData(data);
    if (data == null) throw new Exception("Error: Data input only accepts numbers separated by \",\"");
  }

  /**
   * This method is used to verify that the die (or dice) that the user selected are the ones the app allows
   * @param data int[] data array to be verified
   * @throws Exception throws an exception in case that any of the numbers chosen by the user are not allowed
   */
  private static void validateDieSides(int[] data) throws Exception{
    int [] validEntrys = {4,6,8,10,12,20};
    for(int i =0; i<data.length;i++){
      boolean found = false;
      for(int j = 0;j< validEntrys.length && !found;j++){
        if(data[i] == validEntrys[j]) found =true;
      }
      if(!found) throw new Exception("dieType values must be 4,6,10,12 or 20");
    }
  }

  /**
   * class used to recibe the exit command in text interface
   */
  static class ExitExcepetion extends Exception{
    public ExitExcepetion(String message){
      super(message);
    }
  }
}
