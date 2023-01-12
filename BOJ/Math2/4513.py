while True:
    a, b, c = map(int, input().split())
    if a == 0 and b == 0 and c == 0:
        break
    t = [a, b, c]
    m = t.pop(t.index(max(t)))
    if m**2 == t[0]**2 + t[1]**2:
        print("right")
    else:
        print("wrong")