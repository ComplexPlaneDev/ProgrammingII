# Sparse Matrix Implementation Exam

The goal of this exercise is to develop a sparse square matrix implementation and its determinant calculus.

As a bonus task, the exercise also requires computing the matrix's in-place transpose and verifying that the determinant value remains unchanged.

## Requirements

1. **The determinant and transpose algorithms must be independent of the specific sparse matrix implementation chosen**. This means your determinant and transpose operations must work with any sparse matrix implementation, **regardless of how many implementations you develop**.

2. You **may use only the following Java types**:
 - int / Integer
 - double / Double
 - boolean / Boolean
 - char / Character
 - enum
 - String
 - your custom classes (and packages, if needed).

3. **No Java libraries of any kind are allowed**, except for the I/O support required to read the input file and the Math library.

4. **Java Generics are not allowed**.

5. The exercise solution **must contain at least one sparse matrix implementation and the determinant algorithm**.

6. The minimum valid output must contain the value of the computed determinant and, in the case of the transpose implementation, the value of the computed transpose determinant, verifying that they're equal. Any additional output on console is allowed but it won't be evaluated for the exam outcome.

A solution valid for the post-oral verification fulfills all points above, and the implementation **must print the correct value of the determinant**. Once the value is printed, no further operation is required, the program terminates without exceptions or crashes.

### Optional task requirements

- In case the transpose matrix algorithm is provided, **the transpose operation must occur in place, no clone operations are allowed**. This means you cannot create a new matrix structure to copy the values into. You may insert, delete, or swap nodes within the existing structure, but the result must be stored in the original data structure. This is a strict requirement for the transpose task, otherwise it won't be taken into account for evaluation.

- The value of the transpose determinant must be printed on screen so that it can be checked against the source matrix's determinant.

- A nice-to-have feature is a single linked list implementation for both Coordinate-List and Row-Wise-List data structures (see below).

## Provided input

The matrix must be read from a text file called `matrix.txt`, provided with this document. The file format follows this structure:
   - First line: `dimension dimension` (e.g., `5 5` for a 5x5 matrix)
   - Subsequent lines: `row column value` (1-indexed, e.g., `2 3 1.5`)
   - File contains only non-zero items

## Theory

### What is a Sparse Matrix?

A sparse matrix is a matrix in which most of the elements are zero. Storing and operating on such matrices using conventional dense matrix representations is inefficient because:

- **Memory waste**: Most storage space is occupied by zeros.
- **Computational overhead**: Operations iterate through all elements, including zeros.
- **I/O inefficiency**: Reading and writing large numbers of zero values is unnecessary.

Sparse matrix representations aim to store only the non-zero elements along with their positions, significantly reducing both memory usage and computational complexity for operations.

---

### Available sparse matrix implementations

#### 1. Coordinate List Structure

The Coordinate List representation organizes non-zero elements using a single linked list.

**How it works:**
- The whole matrix is represented by a linked list.
- Each node in the list contains: row index, column index, value, and a pointer to the next element.

---

#### 2. Row-Wise Linked List Structure

The Row-Wise representation organizes non-zero elements using linked lists, where each row maintains its own list of non-zero elements.

**How it works:**
- Each row is represented by a linked list.
- Each node in the list contains: column index, value, and a pointer to the next element.
- Rows without non-zero elements are represented as null or empty lists.
- A 2D structure (array of linked lists) organizes the data by row.

---

#### 3. QuadTree-Based Sparse Matrix

The QuadTree representation uses a hierarchical compressed tree structure to divide the matrix into quadrants, with non-zero elements acting as the leaves of the tree.

**How it works:**
- The matrix is recursively divided into four quadrants: northwest, northeast, southwest, southeast.
- Each node represents a sub-region of the matrix, containing its region-center coordinates, a value (if it's a leaf), and references to sub-nodes for each quadrant.
- Leaves contain the non-zero value at the specific (i, j) coordinates corresponding to that leaf's position in the tree.

---

### Laplace's Determinant Algorithm

Laplace's method is a recursive algorithm for computing the determinant of a square matrix.

**The Algorithm:**

For a matrix A of size n×n:

1. **Base Cases:**
   - If n = 1: det(A) = a₁₁
   - If n = 2: det(A) = a₁₁·a₂₂ - a₁₂·a₂₁

2. **Recursive Step (for n > 2):**
   Choose any row or column (typically the first row for simplicity):
   ```
   det(A) = Σ((-1)^(1+j) × a₁ⱼ × det(M₁ⱼ))
   ```
   where:
   - `j` ranges from 1 to n (columns in the chosen row)
   - `M₁ⱼ` is the minor matrix obtained by removing row 1 and column j
   - `(-1)^(1+j)` provides the alternating sign pattern

**The Sign Pattern:**
The alternating signs follow this pattern when expanding along the first row:
```
+ - + - + ...
```

**Key Concepts:**

- **Minor (Mᵢⱼ)**: The submatrix obtained by deleting row `i` and column `j`
- **Cofactor (Cᵢⱼ)**: (-1)^(i+j) × det(Mᵢⱼ)
- **Determinant**: Sum of products of elements in a row/column with their cofactors

---

### In-Place Transpose Calculation

Matrix transpose is the operation of swapping rows and columns. For a matrix A, the transpose Aᵀ has elements where:
```
Aᵀ[i][j] = A[j][i]
```

**In-Place Transpose:**

The challenge is to perform this operation without allocating a new matrix. This requires carefully adding/removing/swapping elements within the existing structure.