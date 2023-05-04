class Solution {
    public int[] startPoint(String[] park, String[] route) {
        int[] start = {0, 0};
        for (int i=0; i<park.length; i++) {
            String[] row = park[i].split("");
            for (int j=0; j<row.length; j++) {
                if (row[j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                    return start;
                }
            }
        }
        return start;
    }

    public int[] move(String[] park, int[] point, int originRow, int originCol) {
        try{
            if (park[point[0]].split("")[point[1]].equals("X")) {
                point[0] = originRow;
                point[1] = originCol;
            }
        } catch (IndexOutOfBoundsException e) {
            point[0] = originRow;
            point[1] = originCol;
            return point;
        }
        return point;
    }

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};
        int[] point = startPoint(park, routes);

        for (int i=0; i<routes.length; i++) {
            String[] command = routes[i].split(" ");
            String direction = command[0];
            int moves = Integer.parseInt(command[1]);
            int originRow = point[0];
            int originCol = point[1];
            if(direction.equals("E")) {
                for (int j=0; j<moves; j++) {
                    point[1] = point[1] + 1;
                    point = move(park, point, originRow, originCol);
                    if (point[0]==originRow && point[1]==originCol) break;
                }
            }
            else if(direction.equals("W")) {
                for (int j=0; j<moves; j++) {
                    point[1] = point[1] - 1;
                    point = move(park, point, originRow, originCol);
                    if (point[0]==originRow && point[1]==originCol) break;
                }
            }
            else if(direction.equals("N")) {
                for (int j=0; j<moves; j++) {
                    point[0] = point[0] - 1;
                    point = move(park, point, originRow, originCol);
                    if (point[0]==originRow && point[1]==originCol) break;
                }
            }
            else if(direction.equals("S")) {
                for (int j=0; j<moves; j++) {
                    point[0] = point[0] + 1;
                    point = move(park, point, originRow, originCol);
                    if (point[0]==originRow && point[1]==originCol) break;
                }
            }
        }
        answer[0] = point[0];
        answer[1] = point[1];
        return answer;
    }
}