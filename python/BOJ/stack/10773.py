def main():
    K = int(input())
    stack = []
    for _ in range(K):
        num = int(input())
        if num == 0:
            stack.pop()
            continue
        stack.append(num)
    
    print(sum(stack))

if __name__ == "__main__":
    main()