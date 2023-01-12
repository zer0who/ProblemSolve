T = int(input())
for t in range(1, T+1):
    a, b = map(int, input().split())
    print("#{0} {1} {2}".format(t, a//b, a%b))