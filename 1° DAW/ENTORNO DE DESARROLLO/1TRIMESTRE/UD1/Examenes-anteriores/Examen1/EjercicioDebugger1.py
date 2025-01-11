def max(n1, n2):
    if n2 < n1:
        return n2
    elif n1 < n2:
        return n1
    else:
        return n2

print(max(100, 50))