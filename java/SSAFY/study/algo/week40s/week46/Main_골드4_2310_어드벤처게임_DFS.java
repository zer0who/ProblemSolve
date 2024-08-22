package SSAFY.study.algo.week40s.week46;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_골드4_2310_어드벤처게임_DFS {

    static class Player {   // 어드벤처 게임을 진행하는 플레이어
        int room;   // 현재 위치한 방의 번호
        int gold;   // 현재 소지한 돈의 양

        public Player(int room, int gold) {
            this.room = room;
            this.gold = gold;
        }

        @Override
        public String toString() { return this.room + " " + this.gold; }
    }

    static class Room {
        int roomNo; // 방의 번호
        String type;  // E: 빈 방, L: 레프리콘, T: 트롤
        int gold;    // L일 경우 채워주는 돈의 양, T일 경우 방에 입장할 때 필요한 돈의 양
        List<Integer> to;   // 갈 수 있는 방의 번호

        public Room(int roomNo, String type, int gold, List<Integer> to) {
            this.roomNo = roomNo;
            this.type = type;
            this.gold = gold;
            this.to = to;
        }

        @Override
        public String toString() { return this.roomNo + " " + this.type + " " + this.gold + " " + this.to; }
    }

    static int N;   // 방 개수
    static List<Room> roomList;
    static boolean isPossible;  // N번 방에 도착했는 지 여부 판단하는 플래그

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            init(br);
            int[] isVisited = new int[N+1];
            Arrays.fill(isVisited, -1);
            isVisited[1] = 0;
            dfs(new Player(1, 0), isVisited);
            if (isPossible) sb.append("Yes").append("\n");
            else sb.append("No").append("\n");
        }
        System.out.println(sb);
    }

    static void init(BufferedReader br) throws IOException {
        StringTokenizer st;
        roomList = new ArrayList<>();
        roomList.add(new Room(0, "N", 0, new ArrayList<>()));   // 0번 방은 없으니까 인덱스 헷갈리지 않게 미리 하나 추가해둠
        String type;
        int gold;
        List<Integer> to;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            type = st.nextToken();
            gold = Integer.parseInt(st.nextToken());
            to = new ArrayList<>();
            int toRoomNo;
            while (true) {
                toRoomNo = Integer.parseInt(st.nextToken());
                if (toRoomNo == 0) break;
                if (toRoomNo != i) to.add(toRoomNo);    // 자기 자신으로 향하는 간선은 의미가 없으므로 중복 방지하기 위해 미리 빼버리기
            }
            roomList.add(new Room(i, type, gold, to));
        }
        isPossible = false;
    }

    static void dfs(Player nowPlayer, int[] isVisited) {
        if (isPossible) return;
        if (nowPlayer.room == N) {
            isPossible = true;
            return;
        }

        Room nowRoom = roomList.get(nowPlayer.room);
        List<Integer> nextRoomList = nowRoom.to;
        Room nextRoom;
        for (int i = 0; i < nextRoomList.size(); i++) {
            nextRoom = roomList.get(nextRoomList.get(i));
            int nextRoomNo = nextRoom.roomNo;
            int nextGold = nowPlayer.gold;
            switch (nextRoom.type) {
                case "E":
                    break;
                case "L":
                    if (nextRoom.gold > nowPlayer.gold) nextGold = nextRoom.gold;
                    break;
                case "T":
                    if (nextRoom.gold > nowPlayer.gold) continue;
                    else nextGold -= nextRoom.gold;
                    break;
            }
            if (isVisited[nextRoomNo] != -1 && isVisited[nextRoomNo] >= nextGold) continue;   // 이전보다 돈을 더 적게 가지고 있는데 다시 돌아가는 거라면 다시 반복할 필요가 없는 경우임
            isVisited[nextRoomNo] = nextGold;
            dfs(new Player(nextRoomNo, nextGold), isVisited);
            isVisited[nextRoomNo] = nowPlayer.gold;
        }
    }

}
