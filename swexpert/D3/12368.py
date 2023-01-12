T = int(input())
for t in range(1, T+1):
    A, B = map(int, input().split())
    if A + B >= 24:
        print("#{} {}".format(t, A+B-24))
    else:
        print("#{} {}".format(t, A+B))
