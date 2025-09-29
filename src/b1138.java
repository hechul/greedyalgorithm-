import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class b1138 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());          // 몇명이 설 것인가.
        String[] People = br.readLine().split(" "); // 사람들의 왼쪽에 키가 큰사람이 몇명인지 입력받기
        String[] Location = new String[N];
        int C = 1;  // 값 삽입을 위한 변수 처음에는 1 갈수록 +1씩 할 예정
        int count = 0; // 빈칸의 수를 세기 위함
        // N명의 사람들은 매일 아침 한 줄로 줄을 선다.
        // 오민식의 지시대로 선다.
        // 오민식은 사람들의 줄 서는 위치를 기록해놓는다.
        // 아침에 자기가 기록해 놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다
        // 사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다.
        // N명의 사람 키는 1부터 N까지 모두 다름
        // 4명의 사람이 있으면 1 2 3 4 키의 사람이 존재
        // 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명 있었는지 주어진다.



        // 왼쪽의 비워둬야할 칸의 갯수가 몇개인지로 위치를 찾는다.
        // 4
        // 2 1 1 0 이라면
        // 1은  * * 1 * 위치에 오게되고
        // 2는 왼쪽에 빈칸이 하나여야 하므로 * 2 1 * 이 되고
        // 3은 왼쪽에 빈칸이 하나여야 하므로 * 2 1 3 이 된다.

        // 현재는 * * 1 * 인 상태
        for(int i = 0; i<N; i++){ // 1~4까지 위치를 찾는다.
            count = 0;
            for(int j=0;j<N;j++){ // 빈칸의 갯수를 구하기 위한 반복문
                // 인덱스 0에서 인덱스 4까지의 빈칸의 수를 구한다.
                // 구하는 도중 빈칸의 수가 People[i]  와 일치하다면
                // Location[j+1] 인곳에 값을 삽입한다.

                if(Location[j] == null){  // 해당 배열에 빈칸이 존재하는가
                    if(String.valueOf(count).equals(People[i])){
                        Location[j] = String.valueOf(C);
                        C++;
                        break;
                    }
                    count++;              // 존재한다면 카운트 + 1
                }

                // People => 2 1 1 0
                // j = 1
                // 배열의 빈칸의 수를 따져 보다가 People[i]와 count이 같다면
                // Location[count+1]의 위치에 C 값이 존재하여야 함

            }

        }
        for(int i = 0; i<N;i ++){
            bw.write(Location[i] + " ");
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
