# datastructures
Collection of some must know data structures

# Asymptotic Notations

Big Oh : upper bound
f(n) = n2 + 2n + 3
=> f(n) <= n2 + 2n2 + 3n2 <= 6n2 [C.F(n)]
=> **O(n2)**

Big Omega : lower bound
f(n) = n2 + 2n + 3
=> f(n) >= n2 [C.F(n)]
=> **Ω(n2)**

Big Theta : upper as well as lower bound
f(n) = n2 + 2n + 3
=> n2 <= f(n) <= 6n2 [C.F(n)]
=> **Θ(n2)**

* Big Omega tells us the lower bound of the runtime of a function, and Big O tells us the upper bound. Often times, they are different and we can’t put a guarantee on the runtime - it will vary between the two bounds and the inputs. But what happens when they’re the same? Then we can give a theta (Θ) bound - our function will run in that time, no matter what input we give it. In general, we always want to give a theta bound if possible because it is the most accurate and tightest bound. If we can’t give a theta bound, the next best thing is the tightest O bound possible.

# Stack
* lifo => last in first out

# Queue
* fifo => first in first out
* Priority queue is an abstract data type which is like a regular queue or stack data structure, but where additionally each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority.

# Set
* a collection which doesn't allow duplicates 

# Map
* a key value collection
* keys are unique

# Heap
* Min-Heap has every parent smaller than it's children. Hence the smallest element is always the root.
* Max-Heap has every parent larger than it's children. Hence the largest element is always the root.

# TREES

# BST
* Can get skewed if elements are inserted in sorted order

# AVL
* Self balancing BST. As soon as a node is unbalanced(difference between height of left sub-tree and right sub-tree is greater than 1), the nodes balance themselves.
* If the left child's left child is the unbalanced one, LL rotation is performed.
* If the right child's right child is the unbalanced one, RR rotation is performed.
* If the left child's right child is the unbalanced one, LR rotation is performed. First right rotation is performed on the left child, then left rotation is performed on the node.
* If the right child's left child is the unbalanced one, RL rotation is performed. First left rotation is performed on the right child, then right rotation is performed on the node.

# Red Black Tree
* Each node is either red or black.
* The root is always black.
* All leaves (NIL) are black.
* If a node is red, then both its children are black.
* Every path from a given node to any of its descendant NIL nodes contains the same number of black nodes.
* If an operation results in 2 consecutive red nodes, then, if uncle is red, perform color flip; if uncle is black, perform rotation.

* AVL is better at searching(because it is more strictly balanced).
* Red Black is better at insertion and removal(because it is less strictly balanced, so less rotations on average).

# B Tree
* Self-balancing tree data structure that maintains sorted data and allows searches, sequential access, insertions, and deletions in logarithmic time.
* The B-tree is a generalization of a binary search tree in that a node can have more than two children.
* It is well suited for storage systems that read and write relatively large blocks of data, such as discs. It is commonly used in databases and file systems.

# 2-3 and 2-3-4 Trees
* 2–3 tree is a tree data structure, where every node with children (internal node) has either two children (2-node) and one data element or three children (3-nodes) and two data elements.
* 2–3–4 tree (also called a 2–4 tree) is a self-balancing data structure. The numbers mean a tree where every node with children (internal node) has either two, three, or four child nodes:
* 2-node has one data element, and if internal has two child nodes;
* 3-node has two data elements, and if internal has three child nodes;
* 4-node has three data elements, and if internal has four child nodes;

# B+ Tree
* In the B+ tree, copies of the keys are stored in the internal nodes; the keys and records are stored in leaves; in addition, a leaf node may include a pointer to the next leaf node to speed sequential access.

# B* Tree
* The B* tree balances more neighboring internal nodes to keep the internal nodes more densely packed.
* As the most costly part of operation of inserting the node in B-tree is splitting the node, B*-trees are created to postpone splitting operation as long as they can.[3] To maintain this, instead of immediately splitting up a node when it gets full, its keys are shared with a node next to it. This spill operation is less costly to do than split, because it requires only shifting the keys between existing nodes, not allocating memory for a new one.

