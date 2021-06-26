Double Hashing
    T is the input size
    insert O(T)
    update O(T)
    delete O(T)
    contains O(T)
    get O(T)
    address O(T)


Single Chaining with BST
    h is height of BST
    insert 
        finding index O(1) inserting element in BST in O(h)
    update
        finding index O(1), updating element in O(h)
    delete
        finding index O(1), deleting element in O(h)
    contains 
        O(h)
    get
        O(h)
    address
        O(h)

In large number of input BST has an best runtime of O(log n) while Double Hashing has a best runtime of O(1) for all operations
If we choose a large hash table size then then the double hashing will have a constant average access time similarly in single chaining approach most elements will get a unique index, so they too will have a constant access time. So at large hash table size both approaches give same constant running time.
