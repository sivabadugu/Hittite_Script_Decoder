import java.util.*;

public class HittiteTranslator {
    // Dictionary to map English words and phrases to Hittite
    private static final Map<String, String> dictionary = new HashMap<>();
    // Reverse dictionary to map Hittite words back to their English equivalents
    private static final Map<String, String> reverseDictionary = new HashMap<>();
    
    static {
        // Populate the dictionary with English to Hittite word translations
        dictionary.put("cat", "luha");
        dictionary.put("dog", "kurun");
        dictionary.put("house", "patu");
        dictionary.put("run", "huwi");
        dictionary.put("eat", "miyu");
        dictionary.put("hello", "salu");
        dictionary.put("goodbye", "miru");
        dictionary.put("friend", "waztu");
        dictionary.put("I", "ni");
        dictionary.put("you", "tu");
        dictionary.put("he", "hu");
        dictionary.put("she", "sha");
        dictionary.put("we", "mi");
        dictionary.put("they", "ra");
        dictionary.put("am", "sa");
        dictionary.put("are", "du");
        dictionary.put("is", "hu");
        dictionary.put("was", "sa");
        dictionary.put("were", "du");
        dictionary.put("will", "ka");
        dictionary.put("do", "pa");
        dictionary.put("make", "ta");

        // Add common phrases to the dictionary
        dictionary.put("good morning", "piwa luha");
        dictionary.put("how are you", "ka tu sa?");
        dictionary.put("I am fine", "ni sa towa");
        dictionary.put("thank you", "toza ni");
        dictionary.put("see you later", "wa tu miru");

        // Create a reverse dictionary for translating Hittite words to English
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            reverseDictionary.put(entry.getValue(), entry.getKey());
        }
    }

    // Translates an English sentence into Hittite
    public static String translateToHittite(String englishSentence) {
        // Split the input sentence into words or phrases using spaces
        String[] wordsOrPhrases = englishSentence.split("\\s+");

        // List to hold the translated Hittite words or phrases
        List<String> hittiteWords = new ArrayList<>();
        
        for (String wordOrPhrase : wordsOrPhrases) {
            // Normalize the word or phrase to lowercase for case-insensitive matching
            String lowerWordOrPhrase = wordOrPhrase.toLowerCase().trim();

            // Look up the translation from English to Hittite
            String hittiteWord = dictionary.get(lowerWordOrPhrase);
            
            // If no direct match is found, check if it's part of any longer phrase
            if (hittiteWord == null) {
                hittiteWord = dictionary.entrySet().stream()
                    .filter(entry -> lowerWordOrPhrase.contains(entry.getKey()))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse(null);
            }
            
            // If no translation is found, keep the original word or phrase
            if (hittiteWord == null) {
                hittiteWord = lowerWordOrPhrase;
            }
            
            // Add the translated word or phrase to the list
            hittiteWords.add(hittiteWord);
        }

        // Join the list of Hittite words into a single string separated by spaces
        return String.join(" ", hittiteWords);
    }

    // Retrieves the English meaning of a Hittite word
    public static String getMeaning(String hittiteWord) {
        // Look up the Hittite word in the reverse dictionary and return its English equivalent
        return reverseDictionary.getOrDefault(hittiteWord, "Unknown");
    }

    // Translates an English sentence to Hittite and provides meanings for each Hittite word
    public static String translateAndExplain(String englishSentence) {
        // Translate the sentence from English to Hittite
        String hittiteSentence = translateToHittite(englishSentence);
        
        // Split the translated Hittite sentence into individual words
        String[] hittiteWords = hittiteSentence.split(" ");
        
        // List to hold the Hittite words with their English meanings
        List<String> explanations = new ArrayList<>();
        
        for (String hittiteWord : hittiteWords) {
            // Get the English meaning of the Hittite word
            String meaning = getMeaning(hittiteWord);
            // Format the Hittite word with its English meaning and add it to the explanations list
            explanations.add(hittiteWord + " (" + meaning + ")");
        }
        
        // Join the list of Hittite words with explanations into a single string separated by spaces
        return String.join(" ", explanations);
    }

    // Main method for user interaction with the translator
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        
        // Display a welcome message and instructions
        System.out.println("Welcome to Ancient Hittite Translator!");
        System.out.println("Enter English sentences to translate (type 'exit' to quit):");

        // Loop to continuously read and process user input
        while (true) {
            // Read the user input
            String input = scanner.nextLine();

            // Exit the loop if the user types 'exit'
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Translate and explain the input sentence
            String hittiteExplanation = translateAndExplain(input);
            
            // Output the translated Hittite sentence with explanations
            System.out.println("Hittite Translation and Meanings: " + hittiteExplanation);
        }

        // Close the Scanner to release resources
        scanner.close();
        
        // Display a goodbye message
        System.out.println("Goodbye!");
    }
}
