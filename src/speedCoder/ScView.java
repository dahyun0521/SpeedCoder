package speedCoder;

import javax.swing.*;
import java.awt.*;

public class ScView extends JFrame{

	JLabel text = new JLabel("text");
	JFrame frm = new JFrame("SpeedCoder");
	Font font = new Font("맑은 고딕", Font.BOLD, 30);
	
	
	ScView(){
		frm.setBounds(120, 120, 300, 300);
		frm.setLayout(new BorderLayout());
		frm.getContentPane().setBackground(Color.WHITE);
		
		text.setBounds(0, 0, 100, 100);
		
		// 가운데 정렬
		text.setHorizontalAlignment(JLabel.CENTER);
		
		// 폰트 서식 적용
		text.setFont(font);
		
		text.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		text.setBackground(Color.GREEN);
		
		frm.add(text);
		
		// 프레임 닫을 때 프로세스 종료
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //X버튼 누를시 종료
        frm.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ScView();

	}

}
