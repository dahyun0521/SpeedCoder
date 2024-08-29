package speedCoder;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ScView extends JFrame {
	
	JFrame frm = new JFrame("SpeedCoder");
	Container contentPane = getContentPane();
	JPanel panel1 = new JPanel();
	JLabel text = new JLabel(ScModel.fileString()); // 보여줄 코드
	JTextField textField = new JTextField(); // 입력창
	Font font = new Font("맑은 고딕", Font.BOLD, 18);
	LineBorder lb = new LineBorder(Color.black, 1, false);

	ScView(){
		frm.setSize(1200, 1000);
		contentPane.setBackground(Color.WHITE);
		// 컨텐트팬 add
		frm.add(contentPane);
		contentPane.add(panel1);
		
		// 화면창 가운데정렬
		Dimension frameSize = frm.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frm.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height)/2);
		
		// textField : 입력창
		
		toString();
		
		// text : 문자열이 맞는지 확인
		text.setFont(font);
		panel1.add(text);
		
		// 프레임 닫을 때 프로세스 종료
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //X버튼 누를시 종료
        frm.setVisible(true);
	}
	
	public String toString() {
		String str = ScModel.fileString();
		for(int i = 0; i < str.length()-1; i++) {
			ScPanel panel = new ScPanel();
			if(str.charAt(i) == 13 && str.charAt(i+1) == 10) {
				
				add(panel);
			}
			
		}
		
		return "1";
	}
	
	public class ScPanel extends JPanel{
		
		ScPanel(){
			
		}
		public class TureScLabel extends JLabel{
			
			TureScLabel(){
				setFont(font);
			}
		}
		public class FalseScLabel extends JLabel{
			
			FalseScLabel(){
				setOpaque(true);
				setBackground(Color.RED);
				setFont(font);
			}
		}
		public class ScLabel extends JLabel{
			
			ScLabel(){
				setOpaque(true);
				setBackground(Color.ORANGE);
				setFont(font);
			}
		}
	}
	public static void main(String[] args) {
		new ScView();

	}
}
