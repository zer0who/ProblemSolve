T = int(input())
for t in range(1, T+1):
    a, b = map(int, input().split())
    if a > b:
        print("#{0} >".format(t))
    elif a == b:
        print("#{0} =".format(t))
    else:
        print("#{0} <".format(t))