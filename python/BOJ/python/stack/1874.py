def main():
    N = int(input())
    num_stack = [N-i for i in range(N)]
    num_string = [int(input()) for _ in range(N)]
    stack = []
    answer = []
    try:
        for i in range(len(num_string)):
            while True:
                if not stack:
                    stack.append(num_stack.pop())
                    answer.append("+")
                    continue
                if stack[-1] != num_string[i]:
                    stack.append(num_stack.pop())
                    answer.append("+")
                    continue
                stack.pop()
                answer.append("-")
                break
    except IndexError:
        print("NO")
        return
    for a in answer:
        print(a)

    

if __name__ == "__main__":
    main()