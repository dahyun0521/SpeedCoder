package speedCoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileRead {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        Scanner sc = new Scanner(System.in);
        try {
            fileInputStream = new FileInputStream("1.txt");
            int i = 0;
            while ((i = fileInputStream.read()) != -1) {
                System.out.print((char) i);
                
            }
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.err.println("파일 닫기 오류: " + e.getMessage());
                }
            }
        }
        try {
            fileInputStream = new FileInputStream(1 +".txt");
            System.out.println((int)(Math.random()*10 + 1));
            int i = 0;
            int prev = -1;
            while ((i = fileInputStream.read()) != -1) {
                System.out.print(i);
                String s = sc.nextLine();
                if((char) i == s.charAt(0)) {
                	System.out.println("참");
                }else {
                	System.out.println("거짓");
                }
                prev = i;
            }
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.err.println("파일 닫기 오류: " + e.getMessage());
                }
            }
        }
    }
}