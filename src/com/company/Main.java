package com.company;

import Domain.Classes.system;
import Interface.DRTextInterface;
import Interface.DRInterface;


public class Main {

  public static void main(String[] args) {
    testDRWTextInterface();
  }

  public static void testDRWTextInterface(){
    DRTextInterface txtInterface = new DRTextInterface();
    txtInterface.run();
  }

  public static void testDRWGUI() {
    system syst = new system();
    DRInterface GUInterface = new DRInterface(syst);
  }
}
