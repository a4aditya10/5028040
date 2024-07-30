# 1.Understand Sorting Algorithms
##	Explain different sorting algorithms (Bubble Sort, Insertion Sort, Quick Sort, Merge Sort)
- Bubble Sort: Bubble Sort repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. This process repeats until the list is sorted.
O(n²) average and worst case. Simple but inefficient for large datasets.
- Insertion Sort:Insertion Sort builds the sorted array one item at a time by comparing the current element with the already sorted elements and inserting it in the correct position.
O(n²) average and worst case, but O(n) best case when the array is almost sorted.
- Quick Sort:Quick Sort is a divide-and-conquer algorithm. It selects a 'pivot' element and partitions the array into two halves: elements less than the pivot go to the left, and elements greater than the pivot go to the right. It then recursively sorts the subarrays.
O(n log n) average case, but O(n²) worst case. Generally fast and widely used.
- Merge Sort:Merge Sort also uses a divide-and-conquer approach. It divides the array into two halves, recursively sorts them, and then merges the sorted halves. 
O(n log n) for all cases, stable and efficient for large datasets but requires extra space.

# 4.Analysis
### Compare the performance (time complexity) of Bubble Sort and Quick Sort.
- Bubble Sort: Inefficient for large datasets due to O(n²) time complexity.
- Quick Sort: Generally faster with O(n log n) average time complexity. It is more suitable for sorting large datasets, especially when the data is not uniformly distributed.
### Discuss why Quick Sort is generally preferred over Bubble Sort.
- Quick Sort is generally preferred over Bubble Sort due to its better average-case time complexity and efficiency in handling large and diverse datasets.