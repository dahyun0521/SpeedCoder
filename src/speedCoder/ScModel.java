package speedCoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ScModel {
	public static String fileString() {
		FileInputStream fileInputStream = null;
		StringBuilder sb = new StringBuilder();
		try{
			fileInputStream = new FileInputStream("jtextfield/"+1+".txt");
			int i = 0;
			while ((i = fileInputStream.read()) != -1) {
//				System.out.print((char) i);
				sb.append((char) i);
			}
		}catch(
		FileNotFoundException e)
		{
			System.err.println("파일을 찾을 수 없습니다: " + e.getMessage());
		}catch(
		IOException e)
		{
			System.err.println("파일 읽기 오류: " + e.getMessage());
		}finally
		{
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					System.err.println("파일 닫기 오류: " + e.getMessage());
				}
			}
		}
		return sb.toString();
	}
}