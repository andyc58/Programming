/*************************************
 * WordScramble.java
 * Scrambles a given word
 * @author Tammy Pirmann
 * @version 20210407
 *******************************/
public class WordScramble {
  
  private String solution; // Let input solution = "Andy"

  //constructor
  public WordScramble() {
    solution = "NA";  
  }
  //Setter
  public void setSolution(String str){
    solution = str.toUpperCase(); // ANDY
  }
  //Scrambles the solution String
  public String scramble(String str){
    setSolution(str);  // solution = "ANDY"
    String mix = "";
    int a = solution.indexOf("A");  // 0
    if (a >= 0) {  // true
      mix = solution.substring(a).concat(solution.substring(0,a)); // ANDY
    }
    int e = mix.indexOf("E"); // -1
    if (e >= 0) { // false
      mix = mix.substring(e).concat(mix.substring(0,e));
    }
    int i = mix.indexOf("I"); // -1
    if (i >= 0) { // false
      mix = mix.substring(i).concat(mix.substring(0,i));
    }
    int oh = mix.indexOf("O"); // -1
    if (oh >= 0) { // false
      mix = mix.substring(oh).concat(mix.substring(0,oh));
    }
    int u = mix.indexOf("U"); // -1
    if (u >= 0) { // false
      mix = mix.substring(u).concat(mix.substring(0,u));
    }
    //reverse it in case it still looks like the original word
    return reverse(mix);    // YDNA
  }

  //helper method to reverse the scrambled string
  private String reverse(String str){
    //base case
    if (str.isEmpty()){
      return str;
    }
    //Recursive call
    return reverse(str.substring(1)) + str.charAt(0);
  }
}