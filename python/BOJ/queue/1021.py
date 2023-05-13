from collections import deque

def main():
    N, M = map(int, input().split())
    draw = list(map(int, input().split()))
    numbers = deque([i+1 for i in range(N)])
    answer = 0
    for i in range(M):
        draw_num = draw[0]
        count = 0
        while True:
            if numbers[0] == draw_num:
                numbers.popleft()
                draw.pop(0)
                break
            if numbers.index(draw_num) <= len(numbers)//2:
                numbers.append(numbers.popleft())
                count += 1
            else:
                numbers.appendleft(numbers.pop())
                count += 1
        answer += count
    
    print(answer)



if __name__ == "__main__":
    main()