# Detecting and Removing a Loop in a Linked List

## Project Title
Efficient Cycle Detection in a Linked List Using Floyd’s Algorithm

## Course
Data Structures — COSC 251  
American University of Phnom Penh  
Professor: Visethboti Sin  
Group: Group 2

## Description
This project addresses the problem of **loop (cycle) detection** in singly linked lists using **Floyd’s Cycle Detection Algorithm**, also known as the **Tortoise and Hare** method. A loop occurs when a node's `next` pointer points back to a previous node, causing infinite traversal and memory issues.  
Our Java implementation not only **detects** such loops but also **removes** them safely.

## Features
- Detects if a cycle exists in a linked list  
- Removes the cycle if found  
- Handles large linked lists efficiently  
- Includes utility methods to create test cases  
- Prevents infinite printing with a safe output limit  

## How to Run the Program
1. Save the code file as:
```
DetectLoopInLinkedList.java
```
2. Compile the file:
```
javac DetectLoopInLinkedList.java
```
3. Run the program:
```
java DetectLoopInLinkedList
```

## Example
In the `main()` method:
```java
// Creates a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> ... -> 10
// Then creates a loop from node 10 back to node 4
list.createLoop(4);
```
The program will detect and remove the loop, then safely print the list:
```
Loop detected and removed.
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null
```

## Code Structure

| Method                | Description                                                   |
|-----------------------|---------------------------------------------------------------|
| `append(int data)`    | Adds a new node to the end of the list                        |
| `createLoop(int pos)` | Connects the last node to the node at given position          |
| `hasLoop()`           | Returns `true` if a loop exists, `false` otherwise            |
| `detectAndRemoveLoop()` | Detects and safely removes a loop if it exists              |
| `printList()`         | Prints the list (safe for looped structures)                  |

## References
- GeeksforGeeks - [Detect loop in a linked list](https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/)
