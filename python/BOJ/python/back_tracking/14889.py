def startLink(num_people: int, start_team: list, stat: list) -> int:
    global min_diff

    if len(start_team) == num_people // 2:
        start_stat = 0
        link_stat = 0
        link_team = []
        for i in range(num_people):
            if i not in start_team:
                link_team.append(i)
        
        for i in range(len(start_team)):
            for j in range(i+1, len(start_team)):
                start_stat += stat[start_team[i]][start_team[j]] + stat[start_team[j]][start_team[i]]
                link_stat += stat[link_team[i]][link_team[j]] + stat[link_team[j]][link_team[i]]

        min_diff = min(min_diff, abs(start_stat - link_stat))
        return

    else:
        for i in range(num_people):
            if len(start_team) == 0:
                start_team.append(i)
                startLink(num_people, start_team, stat)
                start_team.pop()
            elif i not in start_team and i > start_team[-1]:
                start_team.append(i)
                startLink(num_people, start_team, stat)
                start_team.pop()


def main():
    N = int(input())
    S = []
    for _ in range(N):
        S.append([*map(int, input().split())])
    start_team = []
    global min_diff
    min_diff = 100
    startLink(N, start_team, S)
    print(min_diff)


if __name__ == "__main__":
    main()