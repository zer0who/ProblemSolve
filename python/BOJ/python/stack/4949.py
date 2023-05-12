import sys

def main():
    while True:
        stack = []
        string = sys.stdin.readline().rstrip()
        if string == ".":
            break
        try:
            for i in range(len(string)):
                if string[i] == "(" or string[i] == "[":
                    stack.append(string[i])
                
                if string[i] == ")":
                    if stack[-1] != "(":
                        stack.append(string[i])
                        continue
                    stack.pop()
                elif string[i] == "]":
                    if stack[-1] != "[":
                        stack.append(string[i])
                        continue
                    stack.pop()
            if len(stack) == 0:
                print("yes")
                continue
            print("no")
        except IndexError:
            print("no")
            continue

if __name__ == "__main__":
    main()