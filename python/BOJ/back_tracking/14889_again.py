def startLink(team_start):
    global diff

    if len(team_start) == N//2:
        team_link = [i for i in range(N)]   # team link 인덱스 생성
        start = 0
        link = 0
        for s in team_start:
            if s in team_link:
                team_link.remove(s)
        for i in range(len(team_start)):
            for j in range(i+1, len(team_start)):
                start += S[team_start[i]][team_start[j]] + S[team_start[j]][team_start[i]]
                link += S[team_link[i]][team_link[j]] + S[team_link[j]][team_link[i]]

        diff = min(diff, abs(start - link))
        return
        

    for i in range(N):
        if not team_start:
            team_start.append(i)
            startLink(team_start)
            team_start.pop()
        elif i not in team_start and i > team_start[-1]:
            team_start.append(i)
            startLink(team_start)
            team_start.pop()

def main():
    global N, S, diff
    N = int(input())
    S = []
    diff = 10000

    for _ in range(N):
        s = list(map(int, input().split()))
        S.append(s)
    startLink([])
    print(diff)


if __name__ == "__main__":
    main()