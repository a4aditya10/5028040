# 1.Understand Linked Lists:

### Explain the different types of linked lists (Singly Linked List, Doubly Linked List).

Singly Linked List

**Structure and Characteristics**:
- A Singly Linked List consists of a series of nodes where each node contains:
  - **Data**: The value or information stored in the node.
  - **Next Pointer**: A reference to the next node in the sequence.
- **Head**: The first node in the list.
- **Tail**: The last node, whose next pointer is `null` indicating the end of the list.

**Operations**:
- **Traversal**: Starts from the head and moves sequentially to the next node using the next pointers.
- **Insertion**:
  - At the beginning: O(1) time complexity, as it involves updating the head pointer.
  - At the end: O(n) time complexity, as it requires traversing the list to find the last node.
  - At a specific position: O(n) time complexity, due to the need to traverse the list.
- **Deletion**:
  - At the beginning: O(1) time complexity, as it involves updating the head pointer.
  - At the end: O(n) time complexity, as it requires finding the second-last node.
  - At a specific position: O(n) time complexity, due to the need to traverse the list.

**Advantages**:
- Dynamic size: Can grow or shrink as needed.
- Efficient insertion/deletion at the beginning.

**Disadvantages**:
- No backward traversal, making certain operations more complex.
- More memory usage due to storage of pointers.

Doubly Linked List

**Structure and Characteristics** :
- A Doubly Linked List consists of nodes where each node contains:
  - **Data**: The value or information stored in the node.
  - **Next Pointer**: A reference to the next node.
  - **Previous Pointer**: A reference to the previous node.
- **Head**: The first node in the list.
- **Tail**: The last node, where the next pointer is `null`.

**Operations**:
- **Traversal**: Can be done in both forward and backward directions using the next and previous pointers.
- **Insertion**:
  - At the beginning: O(1) time complexity, involves updating the head and the previous pointer of the old head.
  - At the end: O(1) time complexity, involves updating the tail and the next pointer of the old tail.
  - At a specific position: O(n) time complexity, involves finding the position by traversal.
- **Deletion**:
  - At the beginning: O(1) time complexity, involves updating the head and the previous pointer of the new head.
  - At the end: O(1) time complexity, involves updating the tail and the next pointer of the new tail.
  - At a specific position: O(n) time complexity, involves traversal to find the node to delete.

**Advantages**:
- Allows for bidirectional traversal.
- More flexible in insertion and deletion at both ends.

**Disadvantages**:
- Requires more memory to store two pointers per node.
- Slightly more complex to implement compared to singly linked lists.

# 4.Analysis:

### Analyze the time complexity of each operation.
- All operations(Addition , Deletion , Traversal and Searching) take O(n) time complexity in worst case . We have to start from the head of the list and move forward to perform any kind of operation.

### Discuss the advantages of linked lists over arrays for dynamic data.
- Dynamic Size: Can easily grow or shrink as needed without reallocating memory.
- Efficient Insertions/Deletions: Can efficiently insert or delete nodes without shifting elements, especially in doubly linked lists.