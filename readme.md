# Step to run the code:
    1. Edit the file path in the main class.
    2. Run the program

# Steps to solve the problem
    1. Read the files line by line to manage the size.
    2. Check the last word in the list and the current word to make sure words in a single list are the same 
        size.
    3. Run the anagram method on list of the same words

## Anagram solution
    1. Pick each word in the list using a loop.
    2. Calculate the number of occurence of each letter in the word.
    3. Save the occurence in a Hashmap and using the letter as the key and the frequency as the value.
    4. This is then save as a key in another Hashmap and a list is created to add the the word being considered if it does not exit before.
    5. This process is repeated until the list is emptied.

# Big O
    Where N is the number of words in the list and L is the characters
    We have O(NL) as the upperbound

# Reason for the data structure chosen
Hashmap is chosen to take advantage of the face that similar content generate similar hash which help
prevents duplicates.