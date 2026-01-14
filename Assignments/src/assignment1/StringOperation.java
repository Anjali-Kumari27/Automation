package assignment1;
/*
1. String
A String is "immutable," which is a fancy word for "cannot be changed." Once you create a String, Java doesn't let you edit it. If you try to change it (like adding a word), Java actually creates a brand new String in the computer's memory. This is fine for small tasks, but if you change a word 1,000 times, it can make the computer a bit slow.

2. StringBuffer
StringBuffer is like a "writable" String. You can add, delete, or change characters without creating a new object every time. It is "Thread-Safe," which means it is very safe to use if many parts of a big program are working at the same time. However, this extra safety makes it a little bit slower than its younger brother, StringBuilder.

3. StringBuilder
StringBuilder is just like StringBuffer—you can change the text as much as you want. The only difference is that it is not "Thread-Safe." Because it doesn't worry about that extra safety, it is the fastest way to handle text when you are doing a lot of editing in a simple program.
*/

public class StringOperation {
    public static void main(String[] args) {
        // Our main string to test with
        String text = "  Hello Students! Java is fun  ";

        // 1. Basic checks
        System.out.println("Length: " + text.length()); // Counts every letter and space
        System.out.println("Is Empty: " + text.isEmpty()); // Checks if it has nothing inside
        System.out.println("Letter at index 8: " + text.charAt(8)); // Gets one letter

        // 2. Comparing strings
        String other = "hello students! java is fun";
        System.out.println("Is exactly same: " + text.equals(other)); // False because of spaces/caps
        System.out.println("Compare result: " + text.compareTo(other)); // Gives a number (0 means same)

        // 3. Searching inside
        System.out.println("Contains 'Java': " + text.contains("Java")); 
        System.out.println("First index of 'a': " + text.indexOf("a")); 
        System.out.println("Last index of 'a': " + text.lastIndexOf("a"));

        // 4. Checking Start and End
        System.out.println("Starts with '  Hello': " + text.startsWith("  Hello"));
        System.out.println("Ends with 'fun  ': " + text.endsWith("fun  "));
        System.out.println("Matches a pattern: " + text.matches(".*Java.*")); // Using regex

        // 5. Editing (creates new strings)
        String small = text.toLowerCase();
        System.out.println("Lowercase: " + small);
        
        String clean = text.trim(); // Removes spaces from front and back
        System.out.println("Trimmed: '" + clean + "'");

        String sub = clean.substring(0, 5); // Just takes "Hello"
        System.out.println("Part of string: " + sub);

        String fixed = clean.replace("fun", "awesome");
        System.out.println("Replaced: " + fixed);

        // 6. Splitting and Joining
        String[] words = clean.split(" "); // Cuts the sentence into an array of words
        System.out.println("First word after split: " + words[0]);

        String joined = String.join("-", "Java", "is", "cool"); // Glues them with -
        System.out.println("Joined: " + joined);

        // 7. Converting values
        int number = 100;
        String fromNum = String.valueOf(number); // Turns a number into a String
        System.out.println("Converted Number: " + fromNum);

        // toString() is usually used to represent an object as text
        System.out.println("ToString result: " + text.toString());
    }
}