import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class b1965 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        String N = br.readLine();
        String[] Cage = br.readLine().split(" ");
        int[] C = new int[Integer.parseInt(N)];
        for (int i=0; i<Integer.parseInt(N); i++) C[i] = 1;
        // 정육면체 모양의 상자가 일렬로 늘어서 있다.
        // 상자마다 크기가 주어져 있다.
        // 앞에 있는 상자의 크기가 뒤에 있는 상자의 크기보다 작으면
        // 앞에 있는 상자를 뒤에 있는 상자에 넣을 수 있음
        // ex) 15237
        // 1 2 3 7
        // 마트료시카 형식으로 가장 많은 숫자를 포함하게 해라.
        // 1->2->3->5->6
        // 저장 한 값을 배열에서 배제
        // 그렇게 갯수를 센다.
        // 2 4 1 3
        // 만약 이 상자가 가장 앞의 상자라면 몇개를 포함할 수 있는가?
        // 1 6 2 5 7 3 5 6   - Cage
        // 1 1 1 1 1 1 1 1   - C
        // 1 2 2 3 3 3 4 5   - C
        // 지금 배열의 수 보다 작은 수 중에 가장 큰 수에 해당하는
        // Cage의 C를 더한다.
        for(int i=1;i<Integer.parseInt(N);i++){
            for(int j = 0; j<i;j++){// 1 0 2 0 2 1
                // 6보다 1이 크다면
                // C[j] 의 값을 리스트에 저장
                // 리스트안의 값 중에서 가장 큰 값을
                // 다시 C[i] 에 저장
                if(Integer.parseInt(Cage[i]) > Integer.parseInt(Cage[j])) {
                    list.add(C[j]);
                }
            }
            if(!list.isEmpty()) {
                C[i] += Collections.max(list);
                list.clear();
            }
        }
        Arrays.sort(C);
        int maxvalue = C[C.length - 1];
        bw.write(String.valueOf(maxvalue));
        bw.flush();
        bw.close();
        br.close();
    }
}

