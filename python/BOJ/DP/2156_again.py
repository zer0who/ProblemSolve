def main():
    n = int(input())
    wines = []
    for _ in range(n):
        wines.append(int(input()))
    if n == 1:
        print(wines[0])
        return
    elif n == 2:
        print(wines[0] + wines[1])
        return
    elif n == 3:
        print(max(wines[0]+wines[1], wines[0]+wines[2], wines[1]+wines[2]))
        return
    
    max_liter = [0 for i in range(n)]
    max_liter[0] = wines[0]
    max_liter[1] = wines[0] + wines[1]
    max_liter[2] = max(wines[0]+wines[1], wines[0]+wines[2], wines[1]+wines[2])
    for i in range(3, n):
        max_liter[i] = max(max_liter[i-1], max(max_liter[i-2]+wines[i], max_liter[i-3]+wines[i-1]+wines[i]))
    print(max(max_liter))
    return
    

if __name__ == "__main__":
    main()