package speedCoder;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class ScView extends JFrame{

	JLabel text = new JLabel("text");
	JFrame frm = new JFrame("SpeedCoder");
	Font font = new Font("맑은 고딕", Font.BOLD, 30);
	LineBorder lb = new LineBorder(Color.black, 1, false); 
	
	
	ScView(){
		frm.setBounds(120, 120, 700, 500);
		// frm.setLayout(new BorderLayout());
		frm.getContentPane().setBackground(Color.GRAY);
		
		text.setBounds(0, 0, 300, 300);
		// text.setBorder(lb);
		
		// 가운데 정렬
		text.setHorizontalAlignment(JLabel.CENTER);
		
		// 폰트 서식 적용
		text.setFont(font);
		
		// text.setOpaque(true);
		// text.setBackground(Color.GREEN);
		
		frm.add(text);
		
		// 프레임 닫을 때 프로세스 종료
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //X버튼 누를시 종료
        frm.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ScView();

	}

}
