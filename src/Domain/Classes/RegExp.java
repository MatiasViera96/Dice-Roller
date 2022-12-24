package Domain.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

class RegExp {
  /**
   * This class is used to generate validate data with regular expressions
   */

  // default method constructor

  /**
   * This reg exp is used to match a String that is formed by integers and commas. Does not match empty string.
   * An example of a string that matches is 1,2,3.
   */
  private static final String intInputTextData= "^\\d+(,\\d+)*?$";

  /**
   * RegExp list with all available regExp in this class. Used with matchStringInputData method
   * In case more regExp are added, they must be added to this list in order to matchStringInputData method to work
   * properly
   */
  private static final List<String> expressions = new ArrayList<String>(Arrays.asList(intInputTextData));

  /**
   * Matcher function for regExp. This method is case-insensitive for all regular expressions
   * @param data String data to match with regExp avalable for this project
   * @return data in case of match with a regExp or null in other cases
   */
  public String matchStringInputData(String data){
    for(String s : expressions){
      if (Pattern.matches(s,data.toLowerCase())) return data;
    }
    return null;
  }

}
