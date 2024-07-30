# 1.Understand Array Representation:

### Explain how arrays are represented in memory and their advantages
- Arrays are contiguous blocks of memory where elements are stored sequentially. 
- The main advantage is constant-time access to elements using their index. 

# 4.Analysis:

### Analyze the time complexity of each operation (add, search, traverse, delete).
- add operation takes O(1) i.e, constant time
- search operation takes O(n) in the worst case , where n is the number of employees present in the array.
- traverse operation takes O(n) in the worst case.
- delete operation takes O(n) in the worst case which occurs when the last element is needed to be removed from the array.


### Discuss the limitations of arrays and when to use them.
- Limitations: Fixed size, inefficient insertion and deletion operations if the array needs to be resized or elements need to be shifted.
- When to Use Arrays:
Arrays are suitable when the number of elements is known in advance and infrequent insertion and deletion are required. They are not ideal for dynamic data where frequent resizing or insertion/deletion at arbitrary positions is needed.