# 1 1 2 2 2 8
pieces = input().split()
needs = [1, 1, 2, 2, 2, 8]
for i in range(len(pieces)):
    print(str(needs[i] - int(pieces[i])), end = ' ')