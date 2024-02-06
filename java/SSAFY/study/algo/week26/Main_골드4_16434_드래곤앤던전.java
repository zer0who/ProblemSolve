package SSAFY.study.algo.week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드4_16434_드래곤앤던전 {

    static class Knight {
        int atk;    // 공격력
        int curLife;   // 체력
        int maxLife;    // 최대 체력

        public Knight (int atk, int curLife, int maxLife) {
            this.atk = atk;
            this.curLife = curLife;
            this.maxLife = maxLife;
        }
    }
    
    static class Room { // 방 정보
        int info;   // 1: 몬스터, 2: 생명력
        int atkValue;   // 공격력 관련 수치(몬스터일 경우 공격력, 포션일 경우 증가시켜 줄 용사의 공격력)
        int lifeValue;  // 생명력 관련 수치(몬스터일 경우 체력, 포션일 경우 증가시켜 줄 용사의 체력)

        public Room(int info, int atkValue, int lifeValue) {
            this.info = info;
            this.atkValue = atkValue;
            this.lifeValue = lifeValue;
        }
        
        public void changeKnight(Knight knight) {   // 방에 입장했을 때 쓰일 함수
            if (info == 1) knight.curLife -= atkValue;
            else {
                knight.atk += atkValue;
                knight.curLife += lifeValue;
                if (knight.curLife > knight.maxLife) knight.curLife = knight.maxLife;   //  최대 체력보다 많이 회복되면 최대 체력만큼만 회복으로 변경
            }
        }
    }
    
    static int N, initAtk;  // N: 방 개수, initAtk: 초기 공격력
    static Room[] rooms;
    
    public static void main(String[] args) throws IOException {
        init();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        initAtk = Integer.parseInt(st.nextToken());
        rooms = new Room[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int roomInfo = Integer.parseInt(st.nextToken());
            int roomAtkValue = Integer.parseInt(st.nextToken());
            int roomLifeValue = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(roomInfo, roomAtkValue, roomLifeValue);
        }
    }

}
