import sys

def main():
    T = int(input())
    for _ in range(T):
        stack = []
        line = sys.stdin.readline().rstrip()
        try:
            for i in range(len(line)):
                if line[i] == "(":
                    stack.append(line[i])
                else:
                    stack.pop()
        except IndexError:
            print("NO")
            continue
        
        if len(stack) == 0:
            print("YES")
            continue
        print("NO")

if __name__ == "__main__":
    main()