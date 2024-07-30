# 1.Understand Recursive Algorithms:

### Explain the concept of recursion and how it can simplify certain problems.
- Recursion is a method where a function calls itself to solve smaller instances of the same problem. It can simplify the implementation of complex problems but may lead to excessive computation and memory use if not properly managed.

# 4.Analysis 

### Discuss the time complexity of your recursive algorithm.
- The time complexity of the algorithm is O(n) , where n is the number of elements in the 'pastValues' array.

### Explain how to optimize the recursive solution to avoid excessive computation

- Memoization: Store results of expensive function calls and reuse them when the same inputs occur again.
- Iterative Approaches: Convert recursive algorithms to iterative ones to avoid the overhead of recursive calls and stack overflow issues.