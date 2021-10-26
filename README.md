# FLCD

    * Identifiers *
        A sequence of letters and digits, such that the first characters are letters and last characters are digits.

            - identifier = letter | letter{letter}{digit}
            letter = "a" | "b" | ... | "z" | "A" | "B" | ... | "Z"
            digit = "0" | "1" |...| "9"

        * Constants *
            1. boolean = "0" | "1"
            - 0 = false; 1 = true -

            2. integer = ["+"|"-"]ndigit{"0"|ndigit}
                ndigit = "1" |...| "9"
            - a sequence of digits that can start with +/- and first digit can't be 0 -

            3. character = letter|digit|space
                letter = "a" | "b" | ... | "z" | "A" | "B" | ... | "Z"
                digit = "0" | "1" |...| "9"
                space = " "
            - a leter, a digit or a space -

            4. string - character{character}
            - a sequence of characters -

    * Symbol Table *
        I have implemented the symbol table using an alphabetically binary search tree [BST] in Java.

        * Functions *
        add:
            - add a new node with a given value to the BST.
            - return the key of the node with the given value if the value is already in the BST.
        
        getKey:
            - returns the key of the node with the given value, going through the BST values.
        
        getNewNode:
            - returns a new node with the given value
            (generates a new key value for a new node).
        
        toString:
            - inorder traversal of a binary search tree.