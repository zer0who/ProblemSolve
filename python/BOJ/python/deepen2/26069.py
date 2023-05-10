import sys

def main ():
    N = int(sys.stdin.readline())
    dancing = {"ChongChong": 1}
    for _ in range(N):
        a, b = sys.stdin.readline().rstrip().split()
        if a in dancing or b in dancing:
            dancing[a] = 1
            dancing[b] = 1
    print(len(dancing))


if __name__ == "__main__":
    main()