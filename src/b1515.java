import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class b1515 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] Number = br.readLine().split(""); // 다솜이가 지우고 이어붙인 수
        int count = 1;
        String Strcount;
        int i = 0;
        boolean Max = false;
        // 세준 : 1부터 N까지 모든 수를 차례대로 공백없이 한줄에 다 씀
        // ex) 12345678---
        // 다솜 : 세준이가 쓴 수에서 마음에 드는 몇 개의 숫자를 지움
        // 남은 수를 이어 붙일 때 N의 최솟값을 구하자.
        // 원래는 1부터 1씩 증가하는 배열이었다.
        // 배열을 하나 만들어서 매번 그 배열에 십의 자리면 십의 자리와 일의자리로 나누도록 설계
        // 10부터는 십의자리와  일의 자리를구분
        // 100부터는 백 십 일 구분
        // 1000부터는 천 백 십 일 구분
        while(!Max){
            Strcount = String.valueOf(count); // 1부터 시작
            for (char c : Strcount.toCharArray()) { // count에 해당하는 값 c에 삽입
                if (i == Number.length) { break; }
                // Number[i] 와 c가 같은지 확인
                // 같다면 i+1
                // count가 10이라면 1과 0 두번 확인 100 이라면 1과 0 0 세번 확인
                if(Objects.equals(Number[i], String.valueOf(c))){
                    i++;
                }
            }
            // 같든 다르든 count의 값 증가
            if(i == Number.length){
                Max = true;
                bw.write(String.valueOf(count));
                bw.flush();
                br.close();
                bw.close();
            }
            count++;
        }

    }
}
