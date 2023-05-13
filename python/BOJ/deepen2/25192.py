import sys

def main():
    N = int(sys.stdin.readline())
    ans = 0
    chatted_user = {}
    for _ in range(N):
        string = sys.stdin.readline().rstrip()
        if string == "ENTER":
            chatted_user = {}
            continue
        if string in chatted_user:
            continue
        chatted_user[string] = 1
        ans += 1
    
    print(ans)

if __name__ == "__main__":
    main()