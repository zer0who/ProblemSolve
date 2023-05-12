import sys

def main():
    N = int(sys.stdin.readline().rstrip())
    stack = []
    for _ in range(N):
        command = sys.stdin.readline().rstrip()
        if command[:4] == "push":
            command, num = command.split(" ")
            stack.append(num)
            
        elif command == "top":
            if stack:
                print(stack[-1])
                continue
            print(-1)
            
        elif command == "size":
            print(len(stack))

        elif command == "pop":
            if stack:
                print(stack.pop())
                continue
            print(-1)

        elif command == "empty":
            if stack:
                print(0)
                continue
            print(1)
        

if __name__ == "__main__":
    main()