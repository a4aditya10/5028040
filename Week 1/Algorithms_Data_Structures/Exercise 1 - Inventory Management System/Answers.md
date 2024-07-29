# 1.Understand the Problem:

## Explain why data structures and algorithms are essential in handling large inventories.
- Data structures and algorithms are crucial for efficiently storing, retrieving, and managing large amounts of data. 
- In an inventory management system, they help in organizing the products, managing stock levels, and ensuring quick access to information. 
- Efficient algorithms ensure that operations like searching for a product, updating stock, or calculating total inventory value are performed quickly, even as the number of products grows.

## Discuss the types of data structures suitable for this problem.
- ArrayList: Good for storing a list of products with fast access by index, but insertion and deletion can be slow if the array needs to be resized.
- HashMap: Ideal for quick access, insertion, and deletion based on a unique key (e.g., productId). It provides average O(1) time complexity for these operations.


# 4.Analysis:

## Analyze the time complexity of each operation (add, update, delete) in your chosen data structure
- Add Operation: In a HashMap, the average time complexity is O(1). In an ArrayList, adding at the end is O(1), but adding at a specific index is O(n) due to the need to shift elements.
- Update Operation: O(1) in a HashMap if the key is known; O(n) in an ArrayList if searching by productId.
- Delete Operation: O(1) in a HashMap; O(n) in an ArrayList if searching by productId.

## Discuss how you can optimize these operations
- Use a HashMap for quick lookups, additions, and deletions by productId.
- Use an ArrayList for scenarios where the order of products needs to be maintained and fast iteration is required.