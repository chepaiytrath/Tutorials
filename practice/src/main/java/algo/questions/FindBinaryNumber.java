package algo.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindBinaryNumber {
    private static char getCharacter(int m, int k, int n){
        String str = Integer.toBinaryString(m);
        for(int i = 0; i < n; i++){
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < str.length(); j++){
                builder.append(str.charAt(j) == '0' ? "01" : "10");
            }
            str = builder.toString();
        }
        return str.charAt(k);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < testCases; ++i) {
            String[] strArray = br.readLine().trim().split("\\s+");
            int m = Integer.parseInt(strArray[0]);
            int k = Integer.parseInt(strArray[1]);
            int n = Integer.parseInt(strArray[2]);
            System.out.println(getCharacter(m,k,n));
        }
    }
}
