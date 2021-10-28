package com.sist.draw05;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//JMenuItem�� �������� MyFrameŬ���� �ڽ��� �̺�Ʈó�� ����ڰ� �ǵ��� �ϱ����� ActionListener�������̽� ����
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;

	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		//�޴��� ����
		JMenuBar jmb =  new JMenuBar();
		
		//�ָ޴� ���� ����
		JMenu mn_file = new JMenu("����");
		
		//�θ޴� ������,����,���� ����
		JMenuItem file_new = new JMenuItem("������");
		
		JMenuItem file_open = new JMenuItem("����");
		
		JMenuItem file_save = new JMenuItem("����");
		
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//�ָ޴��� �޴��ٿ� ���
		jmb.add(mn_file);
		
		//�޴��ٸ� �����ӿ� ����
		setJMenuBar(jmb);
		
		//������ JMenuItem�� ���� �̺�Ʈ�� ���
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		setSize(600,400);
		setVisible(true);
		setTitle("���׸���");
		
	}
	
	//������ JMenuItem ������ actionPerformed�޼ҵ� ����
	@Override
	public void actionPerformed(ActionEvent e) {
	//JMenuItem �� � �޴��� ���������� �ľ��ϱ� ���� �Ű����� ActionEvent�� getActionCommand()�̿�
		String cmd = e.getActionCommand();
		//System.out.println(cmd + "��(��) ������");
		
		if(cmd.equals("����")) {
			try {
				//���� ȭ�鿡 �׷��� ��� ������ ���Ϸ� ����("c:/myData/data.pan")
				//���� ȭ�鿡 �׷��� ��� ������ ������ LinePanel ��ü�� lp�� list�� ���������
				//list��ü�� ��°�� ���Ϸ� ����ϱ� ���� ObjectOutputStream �̿�
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/data.pan"));
				
				//LinePanel ��ü�� �ɹ������� list�� ���Ϸ� ���
				oos.writeObject(lp.list);
				
				oos.close();
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
			
		}else if(cmd.equals("����")) {
			//"c:/myData/data.pan" ������ ������ �о� LinePanel ��ü�� lp�� list�� ����
			//ȭ���� �ٽ� �׸��� ���� LinePanel ��ü�� lp�� repaint�� ȣ��
			try {
				//��ü������ ������ ������ �о���̱� ���� ObjectInputStream ��ü ����
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/data.pan"));
				
				//���Ϸ� �����͸� �о�鿩 LinePanel ��ü�� lp�� list�� ���
				lp.list = (ArrayList<GraphicInfo>)ois.readObject();
				
				//������ ������ �о�ͼ� list�� ��� �׷����� ������ŭ �ٽ� �׷��ֱ� ���� repaint ȣ��
				lp.repaint();
				
				//���� �ݱ�
				ois.close();
				
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
			
		}else if(cmd.equals("������")) {
			System.out.println("�������� ó��");
		}
	}
}
















