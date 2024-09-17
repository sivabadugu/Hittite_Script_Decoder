# Hittite_Script_Decoder



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

