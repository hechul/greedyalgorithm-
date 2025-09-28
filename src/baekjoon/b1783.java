import java.io.*;

public class b1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" "); // 가로 세로 입력받기
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int run = 1;
        int f = 1;
        boolean T = false;
        // while 문으로 false 를 반환할 때 까지 이걸 반복하면 된다.
        if(N<2){ //N이 2보다 작으면 위로 이동 불가능
            bw.write(String.valueOf(run));
            bw.flush();
            br.close();
            bw.close();
        }
        else if(N == 2){ // N이 2라면 1,4의 조건 불만족
            // 오른쪽으로 몇번 이동가능한지만 체크 하면 된다.
            // 한번당 2칸씩 이동 f + 2씩 해서 같아질경우랑
            // -1일 경우에 그만 두게 하면 된다.
            // 처음에 2칸씩 이동
            run = (M + 1) / 2;

            // 최대 4칸이라는 상한선을 적용합니다.
            if (run > 4) {
                run = 4;
            }

            bw.write(String.valueOf(run));
            bw.flush();
            br.close();
            bw.close();
        }
        else { // N이 3이상일때
            // f가 7이상을 만족할때의 경우
            if (M >= f + 6) {     //한번씩 사용해서 4번 이동이 가능하다면
                f = f + 6;
                run = run + 4; // 4번 이동이 가능한 것이므로 + 4
                T = true;
            }
            // f는 지금 있는 x 좌표의 위치
            // y좌표는 N이 3보다 크기 때문에 고려할 필요 없음
            // x 좌표 M - f가 1인경우 3을 더해야하고
            // x 좌표 M - f가 2인경우에는 6을 더할 수 있음
            // x 좌표 M - f가 3인 경우에는 9를 더할 수 있다.
            // 4번 이동하면 그 뒤엔 자유롭게 이동가능
            // 4번 이동하지 못한다면 그 뒤엔 run이 최대 4일 수 밖에 없다.

            //4번 이동이 가능 했을때 나머지 자유
            if(T){
                run = run + (M-f);
                bw.write(String.valueOf(run));
                bw.flush();
                br.close();
                bw.close();
            }
            // 4번 이동을 못했을때 나머지는 최대 3번 이동가능
            else{
                run = run + (M-f);
                if(run > 4) run = 4;
                bw.write(String.valueOf(run));
                bw.flush();
                br.close();
                bw.close();
            }
        }
        // 4번 이동을 여러번 반복 했거나 한번 반복 했거나
        // y축의 위치를 똑같이 0 이고 x축의 위치만
        // 오른쪽으로 몇칸인지 확인하면 된다.
        // 오른쪽으로 몇칸 갔는지 확인
        // 확인이 되었으므로 4개의 이동중에 최대로 이동할 수 있는 방법들을 구하기
        // 갈 수 있는 방법이 오른쪽으로 6칸 이하
        // y축은 0 이기 때문에 위로갈 수 있는지 확인


        // N x M 크기 체스판의 가장 왼쪽아래 칸에서 시작
        // 움직일 수 있는 조건
        // 1. 2칸 위, 1칸 오른쪽
        // 2. 1칸 위, 2칸 오른쪽
        // 3. 1칸 아래, 2칸 오른쪽
        // 4. 2칸 아래, 1칸 오른쪽
        // 방문한 칸의 수를 최대로 하려고함
        // 이동 횟수가 4번보다 적지 않다면,
        // 이동방법을 모두 한번씩 사용해야함
        // 이동 횟수가 4번보다 적은경우에 이동 방법에 제약이없다.

        // 이동 횟수가 최대가 되려면 일단 계속해서 이동 횟수가
        // 4번째마다 모든 이동 4개를 만족해야함


        // 우선 1,2,3,4 를 한번씩 할 수 있는지 없는지 확인
        // 할 수 있다면 진행하고 한번 더 할 수있는지 확인
        // 할 수 없다면 1,2,3,4 조합중에 가장 멀리 이동할 수 있는
        // 조합을 찾는다.
    }
}
