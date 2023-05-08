# def padSequence(N: int, pad: list) -> int: # top-down
#     if N <= 3:
#         pad[N] = 1

#     if pad[N] != None:
#         return pad[N]
    
#     pad[N] = padSequence(N-3, pad) + padSequence(N-2, pad)

#     return pad[N]

def padSequence(N: int, pad: list) -> int:  #bottom-up
    pad[0] = 1
    pad[1] = 1
    pad[2] = 1
    pad[3] = 1
    for i in range(4, N+1):
        pad[i] = pad[i-3] + pad[i-2]
    
    return pad[N]


def main():
    T = int(input())
    for _ in range(T):
        N = int(input())
        pad = [None] * 101
        ans = padSequence(N, pad)
        print(ans)
        
if __name__ == "__main__":
    main()