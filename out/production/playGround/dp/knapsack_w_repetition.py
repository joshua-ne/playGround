
# Recursive solution
T = dict()
def knapsack(w, v, u):
    if u not in T:
        T[u] = 0

        for i in range(len(w)):
            if w[i] <= u:
                T[u] = max(T[u], knapsack(w, v, u - w[i]) + v[i])

    return T[u]
print(knapsack(w=[6, 3, 4, 2], v=[30, 14, 16, 9], u=10))

# Iterative solution
def knapsack(W, w, v):
    T = [0] * (W + 1)
    for u in range(1, W + 1):
        for i in range(len(w)):
            if w[i] <= u:
                T[u] = max(T[u], T[u - w[i]] + v[i])
    return T[W]

print(knapsack(W=10, w=[6, 3, 4, 2], v=[30, 14, 16, 9]))


# Brute force solution
def knapsack(W, w, v, items):
    weight = sum(w[i] for i in items)
    value = sum(v[i] for i in items)

    for i in range(len(w)):
        if weight + w[i] <= W:
            value = max(value, knapsack(W, w, v, items + [i]))
    return value

print(knapsack(W=10, w=[6, 3, 4, 2], v=[30, 14, 16, 9], items=[]))