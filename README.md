# Hittite_Script_Decoder
# HittiteTranslator

## Overview

**HittiteTranslator** is a Java application designed to translate English sentences into the Hittite language. It also provides explanations for each Hittite word, showing their English meanings.

## Components

### Dictionary

- **dictionary**: A `Map<String, String>` that maps English words and phrases to their Hittite equivalents.
- **reverseDictionary**: A `Map<String, String>` that maps Hittite words back to their English meanings.

### Static Initialization

Populates both dictionaries with predefined translations and phrases. Ensure that these dictionaries are populated with appropriate translations to handle the sentences effectively.

## Methods

### translateToHittite(String englishSentence)

**Purpose**: Translates an English sentence into Hittite.

**Process**:
1. **Split the Sentence**: Split the input sentence into individual words or phrases.
2. **Look Up Each Word**: Check the dictionary for translations of each word or phrase.
3. **Check for Phrases**: If a direct match is not found, check if longer phrases are present in the dictionary.
4. **Join Translations**: Combine the translated words or phrases into a single Hittite sentence.

**Example**:
```java
public String translateToHittite(String englishSentence) {
    String[] words = englishSentence.split(" ");
    StringBuilder hittiteSentence = new StringBuilder();
    
    for (String word : words) {
        String translated = dictionary.getOrDefault(word, null);
        if (translated == null) {
            // Handle longer phrases or unknown words
            translated = "Unknown"; // Placeholder for unknown words
        }
        hittiteSentence.append(translated).append(" ");
    }
    
    return hittiteSentence.toString().trim();
}

getMeaning(String hittiteWord)
Purpose: Retrieves the English meaning of a Hittite word.

Process:

Look Up the Word: Check the reverse dictionary for the English equivalent.
Return the Meaning: If found, return the English meaning; otherwise, return "Unknown".
Example:

java
Copy code
public String getMeaning(String hittiteWord) {
    return reverseDictionary.getOrDefault(hittiteWord, "Unknown");
}
translateAndExplain(String englishSentence)
Purpose: Translates an English sentence to Hittite and explains each Hittite word.

Process:

Translate the Sentence: Use translateToHittite() to get the Hittite translation.
Retrieve Meanings: For each Hittite word in the translation, use getMeaning() to find its English meaning.
Format the Explanation: Combine the Hittite words and their English meanings.
Example:

java
Copy code
public String translateAndExplain(String englishSentence) {
    String hittiteSentence = translateToHittite(englishSentence);
    String[] hittiteWords = hittiteSentence.split(" ");
    
    StringBuilder explanation = new StringBuilder();
    
    for (String hittiteWord : hittiteWords) {
        String meaning = getMeaning(hittiteWord);
        explanation.append(hittiteWord).append(" (").append(meaning).append(") ");
    }
    
    return explanation.toString().trim();
}
Main Method
Purpose: Facilitates user interaction.

Process:

Prompt for Input: Ask users to enter English sentences.
Translate and Explain: Use translateAndExplain() to process the input.
Continue or Exit: Repeat the process until the user types "exit".
Example:

java
Copy code
import java.util.Scanner;

public class HittiteTranslator {
    static {
        // Static initialization of dictionary and reverseDictionary
        // Populate dictionary and reverseDictionary with predefined values
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HittiteTranslator translator = new HittiteTranslator();
        
        while (true) {
            System.out.println("Enter an English sentence (type 'exit' to quit):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            String explanation = translator.translateAndExplain(input);
            System.out.println("Explanation:");
            System.out.println(explanation);
        }
        
        scanner.close();
    }
}
getMeaning(String hittiteWord)
Purpose: Retrieves the English meaning of a Hittite word.

Process:

Look Up the Word: Check the reverse dictionary for the English equivalent.
Return the Meaning: If found, return the English meaning; otherwise, return "Unknown".
Example:

java
Copy code
public String getMeaning(String hittiteWord) {
    return reverseDictionary.getOrDefault(hittiteWord, "Unknown");
}
translateAndExplain(String englishSentence)
Purpose: Translates an English sentence to Hittite and explains each Hittite word.

Process:

Translate the Sentence: Use translateToHittite() to get the Hittite translation.
Retrieve Meanings: For each Hittite word in the translation, use getMeaning() to find its English meaning.
Format the Explanation: Combine the Hittite words and their English meanings.
Example:

java
Copy code
public String translateAndExplain(String englishSentence) {
    String hittiteSentence = translateToHittite(englishSentence);
    String[] hittiteWords = hittiteSentence.split(" ");
    
    StringBuilder explanation = new StringBuilder();
    
    for (String hittiteWord : hittiteWords) {
        String meaning = getMeaning(hittiteWord);
        explanation.append(hittiteWord).append(" (").append(meaning).append(") ");
    }
    
    return explanation.toString().trim();
}
Main Method
Purpose: Facilitates user interaction.

Process:

Prompt for Input: Ask users to enter English sentences.
Translate and Explain: Use translateAndExplain() to process the input.
Continue or Exit: Repeat the process until the user types "exit".
Example:

java
Copy code
import java.util.Scanner;

public class HittiteTranslator {
    static {
        // Static initialization of dictionary and reverseDictionary
        // Populate dictionary and reverseDictionary with predefined values
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HittiteTranslator translator = new HittiteTranslator();
        
        while (true) {
            System.out.println("Enter an English sentence (type 'exit' to quit):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            String explanation = translator.translateAndExplain(input);
            System.out.println("Explanation:");
            System.out.println(explanation);
        }
        
        scanner.close();
    }
}
**getMeaning(String hittiteWord)**
Purpose: Retrieves the English meaning of a Hittite word.

Process:

Look Up the Word: Check the reverse dictionary for the English equivalent.
Return the Meaning: If found, return the English meaning; otherwise, return "Unknown".

public String getMeaning(String hittiteWord) {
    return reverseDictionary.getOrDefault(hittiteWord, "Unknown");
}

