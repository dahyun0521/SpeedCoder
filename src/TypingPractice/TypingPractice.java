package TypingPractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TypingPractice extends JFrame {
   public static String FileString() {
        FileInputStream fileInputStream = null;
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        try {
            fileInputStream = new FileInputStream("1.txt");
            int i = 0;
            while ((i = fileInputStream.read()) != -1) {
                System.out.print((char)i);
                sb.append((char)i);
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
        return sb.toString();
   }
   
    private JLabel displayLabel; // 텍스트를 표시할 레이블
    private JTextField inputField; // 사용자 입력을 받을 텍스트 필드
    private String textToType = FileString(); // 타자 연습용 텍스트

    // 생성자
    public TypingPractice() {
       
        // 프레임 설정
        setTitle("타자 연습 프로그램"); // 프레임 제목 설정
        setSize(500, 200); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 종료
        setLayout(new BorderLayout()); // 레이아웃 매니저 설정

        // 텍스트를 표시할 레이블 초기화 및 설정
        displayLabel = new JLabel();
        displayLabel.setFont(new Font("휴먼엑스포", Font.PLAIN, 24)); // 폰트 설정
        updateDisplayLabel(textToType); // 초기 텍스트 설정

        // 입력 필드 초기화 및 설정
        inputField = new JTextField();
        inputField.setFont(new Font("휴먼엑스포", Font.PLAIN, 24)); // 폰트 설정
        inputField.addKeyListener(new KeyAdapter() {
            // 키가 눌릴 때마다 호출되는 메소드
            @Override
            public void keyReleased(KeyEvent e) {
                handleTyping(); // 입력 처리 메소드 호출
            }
        });

        // 컴포넌트 레이아웃 설정
        add(displayLabel, BorderLayout.CENTER); // 중앙에 레이블 추가
        add(inputField, BorderLayout.SOUTH); // 하단에 입력 필드 추가
    }

    // 사용자의 입력을 처리하고 화면에 표시할 텍스트 업데이트
    private void handleTyping() {
        String inputText = inputField.getText(); // 입력 필드의 텍스트 가져오기
        String formattedText = formatText(textToType, inputText); // 포맷된 텍스트 생성
        updateDisplayLabel(formattedText); // 레이블 업데이트
    }

    // 레이블의 텍스트를 업데이트 (HTML 형식으로 설정)
    private void updateDisplayLabel(String text) {
        displayLabel.setText("<html>" + text + "</html>"); // HTML 형식으로 텍스트 설정
    }

    // 원본 텍스트와 입력된 텍스트를 비교하여 틀린 문자만 빨갛게 표시
    private String formatText(String originalText, String typedText) {
        StringBuilder formattedText = new StringBuilder(); // 포맷된 텍스트를 저장할 StringBuilder

        int minLength = Math.min(originalText.length(), typedText.length()); // 비교할 최소 길이

        // 원본 텍스트와 입력된 텍스트를 문자 단위로 비교
        for (int i = 0; i < minLength; i++) {
            if (originalText.charAt(i) == typedText.charAt(i)) {
                formattedText.append(originalText.charAt(i)); // 문자가 일치하면 그대로 추가
            } else {
                // 문자가 틀리면 빨갛게 표시
                formattedText.append("<font color='red'>").append(originalText.charAt(i)).append("</font>");
            }
        }

        // 원본 텍스트의 나머지 부분 추가
        if (originalText.length() > minLength) {
            formattedText.append(originalText.substring(minLength));
        }

        // 입력된 텍스트의 나머지 부분 추가 (틀린 부분 강조)
        if (typedText.length() > minLength) {
            formattedText.append("<font color='red'>").append(typedText.substring(minLength)).append("</font>");
        }

        return formattedText.toString(); // 포맷된 텍스트 반환
    }

    // 프로그램 시작점
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TypingPractice frame = new TypingPractice(); // TypingPractice 객체 생성
            frame.setVisible(true); // 프레임을 화면에 표시
        });
    }
}