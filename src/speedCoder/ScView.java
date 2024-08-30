package speedCoder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



public class ScView extends JFrame {
	
	JFrame frm = new JFrame("SpeedCoder");
	Container contentPane = getContentPane();
	JPanel panel1 = new JPanel();
	
	JLabel text = new JLabel(ScModel.fileString()); // 보여줄 코드
	JTextField textField = new JTextField(); // 입력창
	Font font = new Font("맑은 고딕", Font.BOLD, 12);
	LineBorder lb = new LineBorder(Color.black, 1, false);

	ScView(){
		frm.setSize(1200, 1000);
		contentPane.setBackground(Color.WHITE);
		// 컨텐트팬 add
		frm.add(contentPane);
		panel1.setLayout(new GridBagLayout());
		contentPane.add(panel1);
		
		// 화면창 가운데정렬
		Dimension frameSize = frm.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frm.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height)/2);
		
		getStr();
		
		// text : 문자열이 맞는지 확인
		text.setFont(font);
//		panel1.add(text);
		
		// 프레임 닫을 때 프로세스 종료
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //X버튼 누를시 종료
        frm.setVisible(true);
	}
	
	public void getStr() {
		panel1.removeAll();
		String originStr = ScModel.fileString();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		for(int i = 0; i < originStr.length(); i++) {
			if(originStr.charAt(i) == '\r') {
				gbc.gridx = 0;
				gbc.gridy++;
			}
			gbc.gridx++;
			panel1.add(new ScLabel(String.valueOf(originStr.charAt(i))), gbc);
			System.out.println((int)originStr.charAt(i));
			
		}
	}
	
	public class ScPanel extends JPanel{
		
		ScPanel(){
			
		}
		
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
		ScLabel(String s){
			setOpaque(true);
			setBackground(Color.ORANGE);
			setFont(font);
			setText(s);
			Border border = getBorder();
			Border margin = new EmptyBorder(2,2,2,2);
			setBorder(new CompoundBorder(border, margin));
		}
	}
	public static void main(String[] args) {
		new ScView();

	}
}
