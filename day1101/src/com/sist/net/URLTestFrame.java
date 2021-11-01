package com.sist.net;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.awt.BorderLayout;

public class URLTestFrame extends JFrame implements ActionListener{

	//url�� �Է¹ޱ� ���� �ؽ�Ʈ�ʵ带 �ɹ������� �����
	JTextField jtf;
	
	//url�� ������ ������ �ܾ�ͼ� ����ϱ� ���� textArea�� �ɹ������� �����
	JTextArea jta;
	
	public URLTestFrame() {
		//�ɹ����� TextField�� TextArea��ü�� ����
		jtf = new JTextField(50); //������� �ص��ǰ� ���ص� ��.���ϸ� �۰� �������
		jta = new JTextArea();
		
		//�о���⸦ �����ų ��ư ����
		JButton btn = new JButton("�о����");
		
		//TextField�� ��ư�� ������� �гλ���
		JPanel p = new JPanel();
		
		//�гο� TextFiled�� ��ư ���
		p.add(jtf);
		p.add(btn);
		
		//TextArea�� ���α� ���� ��ũ������ ����
		JScrollPane jsp = new JScrollPane(jta);
		
		//TextFiled�� ��ư�� ��� �ִ� �г��� �������� ���ʿ� ���
		add(p, BorderLayout.NORTH);
		
		//TextArea�� ���ΰ� �ִ� ��ũ������ ������ ����� ���
		add(jsp, BorderLayout.CENTER);
		
		//�������� ũ�� ����
		setSize(800,600);
		
		//�������� ȭ�鿡 ���̵��� ����
		setVisible(true);
		
		//��ư�� �̺�Ʈ ���
		btn.addActionListener(this);
		
		
	}
	
	public static void main(String[] args) {
		new URLTestFrame();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			//����ڰ� �Է��� ���ͳ��ּҸ� �о�ͼ� ��ü ����
			URL url = new URL(jtf.getText());
			
			//������ ������ �о���� ���� ��Ʈ�� ����
			InputStream is =  url.openStream();
			
			//�Ѳ����� �о���� byte���� �迭�� �����
			byte []data = new byte[100];
			
			//��Ʈ���� ���� �о�� ���ڿ��� �� ��Ƴ��� ������ �����
			String str = "";
			
			//��Ʈ���� ���� �ƴҶ����� 100����Ʈ�� �о����
			while( is.read(data) != -1 ) {
				
				//�о���� byte�迭�� �����͸� ���ڿ��� ����� ����
				str += new String(data,"utf-8");
				
				//�迭�� �ٽ� �о���̱� ���� ������ ����
				//�׷��� ������ �ǳ��� �̻��� �����Ⱑ ��µ� �� ����
				//byte���� �迭 data�� ��� 0���� �ʱ�ȭ
				//���� 0�̿��� �ڹٴ� int�� ����ϱ� ������ byte���� ����ȯ��
				Arrays.fill(data, (byte)0);
			}
			
			//��ü������ ���ڿ� ������ TextArea�� ���
			jta.setText(str);
			
			//��Ʈ�� �ݱ�
			is.close();
			
		}catch (Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
		
	}

}
