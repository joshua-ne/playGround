# Recursive algorithm

T = dict()

def matrix_mult(m, i, j):
    if (i, j) not in T:
        if j == i + 1:
            T[i, j] = 0
        else:
            T[i, j] = float("inf")
            for k in range(i + 1, j):
                T[i, j] = min(T[i, j], matrix_mult(m, i, k) + matrix_mult(m, k, j) + m[i] * m[j] * m[k])

    return T[i, j]

print(matrix_mult(m=[50, 20, 1, 10, 100], i=0, j=4))



# Iterative algorithm

def matrix_mult(m):
    n = len(m) - 1
    T = [[float("inf")] * (n + 1) for _ in range(n + 1)]

    for i in range(n):
        T[i][i + 1] = 0

    for s in range(2, n + 1):
        for i in range(n - s + 1):
            j = i + s
            for k in range(i + 1, j):
                T[i][j] = min(T[i][j], T[i][k] + T[k][j] + m[i] * m[j] * m[k])

    return T[0][n]

print(matrix_mult(m=[50, 20, 1, 10, 100]))