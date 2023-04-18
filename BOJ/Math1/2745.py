def main():
    num = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    answer = 0
    N, B = input().split()
    for i in range(len(N)):
        temp = num.index(N[i]) * (int(B)**(len(N)-i-1))
        answer += temp
    print(answer)
    # print(int(N, int(B)))
    

if __name__ == "__main__":
    main()