def main():
    N = int(input())
    i = 1
    ans = 0
    while i*i <= N:
        ans += 1
        i += 1
        
    print(ans)
        



if __name__ == "__main__":
    main()