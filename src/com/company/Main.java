package com.company;

import Domain.Classes.die;

public class Main {

  public static void main(String[] args) {
    try{
      die testDie = new die (10);
      for(int i =0;i<20;i++){
        System.out.println("dice value " + testDie.roll());
      }
    }
    catch (Exception e){
      System.out.println(e.getMessage());
    }
  }
}
