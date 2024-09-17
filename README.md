# Hittite_Script_Decoder

## Overview

**HittiteTranslator** is a Java application designed to translate English sentences into the Hittite language. It also provides explanations for each Hittite word, showing their English meanings.

## Components

### Dictionary

- **dictionary**: Maps English words and phrases to Hittite equivalents.
- **reverseDictionary**: Maps Hittite words back to their English meanings.

### Static Initialization

Populates both dictionaries with predefined translations and phrases.

## Methods

### translateToHittite(String englishSentence)

**Purpose**: Translates an English sentence into Hittite.

**Process**:
1. Splits the sentence into words or phrases.
2. Looks up each in the dictionary.
3. Checks for longer phrases if direct matches are not found.
4. Joins translated words into a single Hittite sentence.

### getMeaning(String hittiteWord)

**Purpose**: Retrieves the English meaning of a Hittite word.

**Process**:
1. Looks up the word in the reverse dictionary.
2. Returns its English equivalent, or "Unknown" if not found.

### translateAndExplain(String englishSentence)

**Purpose**: Translates an English sentence to Hittite and explains each Hittite word.

**Process**:
1. Translates the sentence.
2. Retrieves and formats the English meanings of each Hittite word.

## Main Method

**Purpose**: Facilitates user interaction.

**Process**:
1. Prompts users to enter English sentences.
2. Translates and explains the sentences.
3. Continues until the user types "exit".

## Usage Example

**Input**:



**Processing**:

**Translation**:
- hello → salu
- how are you → ka tu sa?

**Combined Translation**: salu ka tu sa?

**Explanation**:
- salu (hello)
- ka (how)
- tu (you)
- sa (are)

**Result**: salu (hello) ka (how) tu (you) sa (are)

## Running the Program

1. **Compile** the program using:
   ```bash
   javac HittiteTranslator.java

