def main():
    num = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    answer = 0
    N, B = input().split()
    for i in reversed(range(len(N))):
        temp = num.index(N[i]) * (int(B)**i)
        answer += temp
    print(answer)
    # print(int(N, int(B)))
    

if __name__ == "__main__":
    main()