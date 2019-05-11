
# Recursive solution
T = dict()

def knapsack(w, v, u, i):
    if (u, i) not in T:
        if i == 0:
            T[u, i] = 0
        else:
            T[u, i] = knapsack(w, v, u, i - 1)
            if u >= w[i - 1]:
                T[u, i] = max(T[u, i], knapsack(w, v, u - w[i - 1], i - 1) + v[i - 1])

    return T[u, i]


print(knapsack(w=[6, 3, 4, 2], v=[30, 14, 16, 9], u=10, i=4))

# Iterative solution
def knapsack(W, w, v):
    T = [[None] * (len(w) + 1) for _ in range(W + 1)]

    for u in range(W + 1):
        T[u][0] = 0

    for i in range(1, len(w) + 1):
        for u in range(W + 1):
            T[u][i] = T[u][i - 1]
            if u >= w[i - 1]:
                T[u][i] = max(T[u][i], T[u - w[i - 1]][i - 1] + v[i - 1])

    return T[W][len(w)]


print(knapsack(W=10, w=[6, 3, 4, 2], v=[30, 14, 16, 9]))


# Brute force solution
def knapsack(W, w, v, items, last):
    weight = sum(w[i] for i in items)

    if last == len(w) - 1:
        return sum(v[i] for i in items)

    value = knapsack(W, w, v, items, last + 1)
    if weight + w[last + 1] <= W:
        value = max(value, knapsack(W, w, v, items + [last + 1], last + 1))

    return value

print(knapsack(W=10, w=[6, 3, 4, 2], v=[30, 14, 16, 9], items=[], last=-1))