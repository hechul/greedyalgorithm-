import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class b1439 {
    // 0001100
    // 배열의 첫번째가 0 인지 확인하고 1이라면 카운트 + 1
    // 두번째 배열부터 전 배열이 0 이고 현재 배열이 1이라면 카운트 + 1
    public static int ARRAY(String S, String[] m){
        int count = 0;
        if(Objects.equals(m[0], "1")){
            count++;
        }
        for(int i=1; i<S.length(); i++){
            if(Objects.equals(m[i - 1], "0") && Objects.equals(m[i], "1")){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 연속된 하나 이상의 숫자를 집고 모두 뒤집기 가능
        // 뒤집는 것은 1을 0으로 0을 1로 바꾸는 것을 의미
        String S = bf.readLine();
        String[] m = new String[S.length()];

        for(int i = 0; i<S.length(); i++){
            m[i] = String.valueOf(S.charAt(i));
        }
        int countA = ARRAY(S, m);
        for(int i=0;i<S.length();i++){
            if(Objects.equals(m[i], "0")){
                m[i] = String.valueOf('1');
            }
            else{
                if(Objects.equals(m[i], "1")){
                    m[i] = String.valueOf('0');
                }
            }
        }
        int countB = ARRAY(S, m);

        bw.write(String.valueOf(Math.min(countA,countB)));
        bw.flush();
        bw.close();
        bf.close();
        // 전부 같게 만드려 하는거니
        // 0으로만 만드는 경우 1로만 만드는 경우를
        // 함수로 만들어서 1을 찾을땐 배열 전체를 뒤집어서
        // 0으로만 만드는 경우를 그대로 사용하면 코드가 짧아질 것 같음



        // 1로만 만드는 경우

    }

}
