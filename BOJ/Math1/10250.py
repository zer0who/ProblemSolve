T = int(input())
for i in range(T):
    H, W, N = map(int, input().split())
    room = 0
    if N%H == 0:
        room = H*100 +(N//H)
    else:
        room = (N%H)*100 + (N//H+1)
    print(room)