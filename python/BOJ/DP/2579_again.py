def main():
    n = int(input())
    stairs = []
    for _ in range(n):
        stairs.append(int(input()))
    if n == 1:
        print(stairs[0])
        return
    elif n == 2:
        print(stairs[0] + stairs[1])
        return
    elif n == 3:
        print(max(stairs[0]+stairs[1], stairs[0]+stairs[2], stairs[1]+stairs[2]))
        return
    else:
        score = [0] * n
        score[0] = stairs[0]
        score[1] = score[0] + stairs[1]
        score[2] = max(stairs[0]+stairs[2], stairs[1]+stairs[2])
        for i in range(3, n):
            score[i] = max(stairs[i]+score[i-2], stairs[i]+stairs[i-1]+score[i-3])
        
        print(score[-1])
        
    
if __name__ == "__main__":
    main()