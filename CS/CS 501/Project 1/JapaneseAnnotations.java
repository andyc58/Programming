import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class JapaneseAnnotations {

    public static String annotateSentence(String sentence, Scanner scnr){

        /*************************************************************************************************************************************************** 
        -   Based on the CJK standard, Kanji characters fall between the 4e00 - 9faf and also from 3400 - 4dbf unicode hex ranges. 
            I think these also match chinese characters not found in Japanese as well, which is ok for this program as well.
            https://en.wikipedia.org/wiki/CJK_Unified_Ideographs

        -   This post also discusses the rarity of each extension in the CJK standard. For this project, I include the common ones as well as the rarer types. 
            Other extensions are very archaic and I highly doubt a learner would ever encounter them in their study.
            https://stackoverflow.com/questions/1366068/whats-the-complete-range-for-chinese-characters-in-unicode
        ***************************************************************************************************************************************************/ 

        /* Initializes the regex pattern to check whether the character is a Kanji character or not
        Source: https://www.w3schools.com/java/java_regex.asp */ 
        Pattern kanjiPattern = Pattern.compile("[\\u4e00-\\u9faf]|[\\u3400-\\u4dbf]");

        String html = ""; // The result string
        String kanjiPart = ""; // Holds the Kanji sequences needed for annotation

        for (int i = 0; i < sentence.length(); i++){


            // Gets the character at each index in the string and converts the char value back to a string to prepare for matching
            // Source: https://www.javatpoint.com/java-string-valueof
            String character = String.valueOf(sentence.charAt(i)); 


            // These 2 lines determine whether the character is a Kanji character or not through the regex pattern defined above
            // Source: https://www.w3schools.com/java/java_regex.asp 
            Matcher kanjiCharacter = kanjiPattern.matcher(character);
            boolean kanji_found = kanjiCharacter.find();

            if (kanji_found){
                kanjiPart += character; // If the character is a Kanji character, add it to the kanji part string to build the sequence
            }
            
            else {
            
            /*  If the character is not a kanji character, the next step is to determine whether the Kanji part string is not empty. 
            This happens when a Kanji sequence is built. If true, then the ruby annotation is added after the user finished it for that sequence. 
            If it's not true, then continue onward. The non-kanji character will be added no matter what. */ 
                
                if (!kanjiPart.isEmpty()) { // Source: https://www.javatpoint.com/java-string-isempty
                    System.out.printf("Kana annotation for %s: ", kanjiPart);
                    String furigana = scnr.nextLine();
                    html += "<ruby>"+kanjiPart+"<rt>"+furigana+"</rt></ruby>";
                    kanjiPart = "";    
                }

                html += character; 
            }
        }
        
        /* Since we are looking for Kanji sequences, annotations will not prompt until the loop hits a non-Kanji character. But there may also be trailing Kanji, 
        causing the final sequence to never prompt. Hence, this check needs to happen again after the loop. 
        It wouldn't be a sentence in such cases, since Japanese sentences always end with a conjugated verb (ending written with Hiragana), 
        but still could be possible, especially when dealing with isolated nouns */

        if (!kanjiPart.isEmpty()) {
            System.out.printf("Kana annotation for %s: ", kanjiPart);
            String furigana = scnr.nextLine();
            html += "<ruby>"+kanjiPart+"<rt>"+furigana+"</rt></ruby>";
            kanjiPart = "";    
        }

        System.out.println("The ruby annotation is\n");
        return html;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean userDone = false; // Boolean indicates when a user is finished with annotating all their sentences (if there are multiple sentences)

        while(! userDone) {

            System.out.println("Enter the sentence\n");
            String sentence = scan.nextLine();
            System.out.println();

            System.out.println(annotateSentence(sentence, scan));
            System.out.print("\nAnnotate again? Y/N  ");
            String response = scan.nextLine();

            // Validate user input after annotation (User can enter y/n or yes/no and case doesn't matter)
            while (!response.toLowerCase().equals("y")  && !response.toLowerCase().equals("n") && 
                    !response.toLowerCase().equals("yes") && !response.toLowerCase().equals("no")){
                System.out.print("Invalid input. Annotate again? Y/N ");
                response = scan.nextLine();
            }


            if (response.toLowerCase().startsWith("n")){
                userDone = true;
            }
    
        }
        scan.close();

    }
}
