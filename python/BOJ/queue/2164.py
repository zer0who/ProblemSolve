from collections import deque

def main():
    list = reversed([i+1 for i in range(int(input()))])
    queue = deque(list)
    while len(queue) != 1:
        queue.pop()
        queue.appendleft(queue.pop())
    
    print(queue[0])
    

if __name__ == "__main__":
    main()