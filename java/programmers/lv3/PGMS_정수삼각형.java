package programmers.lv3;

public class PGMS_정수삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;
        if (triangle.length == 1) answer = triangle[0][0];
        else if (triangle.length == 2) answer = triangle[0][0] + Math.max(triangle[1][0], triangle[1][1]);
        else answer = findMaxSum(triangle);

        return answer;
    }

    int findMaxSum(int[][] triangle) {
        int answer = -1;
        int h = triangle.length;    // 삼각형의 높이
        int[][] dpArr = new int[h+1][h];
        dpArr[0][0] = triangle[0][0];
        dpArr[1][0] = dpArr[0][0] + triangle[1][0];
        dpArr[1][1] = dpArr[0][0] + triangle[1][1];
        // List<List<Integer>> dpList = new ArrayList<>();
        // for (int i = 0; i < triangle.length; i++) dpList.add(new ArrayList<>());
        // dpList.get(0).add(triangle[0][0]);
        // dpList.get(1).add(dpList.get(0).get(0) + triangle[1][0]);
        // dpList.get(1).add(dpList.get(0).get(0) + triangle[1][1]);

        int innerH; // 삼각형 내부 길이
        for (int i = 2; i < h; i++) {
            innerH = triangle[i].length;
            for (int j = 0; j < innerH; j++) {
                int plusNumber;

                if (j == 0) plusNumber = dpArr[i-1][0];
                else if (j == innerH-1) plusNumber = dpArr[i-1][j-1];
                else plusNumber = Math.max(dpArr[i-1][j-1], dpArr[i-1][j]);

                dpArr[i][j] = plusNumber + triangle[i][j];
                if (i == h-1 && answer < dpArr[i][j]) answer = dpArr[i][j];
            }
        }

//         for (int i = 2; i < triangle.length; i++) {
//             for (int j = 0; j < triangle[i].length; j++) {  // 삼각형 내의 원소들에 대해 수행
//                 int plusNumber;
//                 if (j == 0) plusNumber = dpList.get(i-1).get(0);
//                 else if (j == triangle[i].length-1) {
//                     plusNumber = dpList.get(i-1).get(j-1);
//                 }
//                 else plusNumber = Math.max(dpList.get(i-1).get(j-1), dpList.get(i-1).get(j));

//                 dpList.get(i).add(plusNumber + triangle[i][j]);

//                 if (i == triangle.length-1 && answer < dpList.get(i).get(j)) answer = dpList.get(i).get(j);
//             }
//         }

        return answer;
    }

}
