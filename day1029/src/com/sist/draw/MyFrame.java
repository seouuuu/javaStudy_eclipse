package com.sist.draw;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.Color;

//JMenuItem�� �������� MyFrameŬ���� �ڽ��� �̺�Ʈó�� ����ڰ� �ǵ��� �ϱ����� ActionListener�������̽� ����
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;
	
	//������ ���ϸ�� ����� ���ϸ��� ������ JFileChooser�� �ɹ������� ����
	JFileChooser jfc;
	
	//������ �����ϱ� ���� ���̾�α� JColorChooser�� �ɹ������� ����
	JColorChooser jcc;
	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		//JFileChooser ��ü ����
		jfc = new JFileChooser("c:/myData");
		
		//JColorChooser ��ü�� ����
		jcc = new JColorChooser();
		
		//�޴��� ����
		JMenuBar jmb =  new JMenuBar();
		
		//�ָ޴� ����,�׸��⵵��,�׸������ ����
		JMenu mn_file = new JMenu("����");
		JMenu mn_draw = new JMenu("�׸��⵵��");
		JMenu mn_color = new JMenu("�׸������");
		
		//�ָ޴� ������ �θ޴� ������,����,���� ����
		JMenuItem file_new = new JMenuItem("������");
		JMenuItem file_open = new JMenuItem("����");
		JMenuItem file_save = new JMenuItem("����");
		
		//�θ޴����� �ָ޴��� ���
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//�ָ޴� �׸��⵵���� ��� �θ޴� ��,�簢��,�� ����
		JMenuItem draw_line = new JMenuItem("��");
		JMenuItem draw_rect = new JMenuItem("�簢��");
		JMenuItem draw_oval = new JMenuItem("��");
		
		//�θ޴����� �׸��⵵�� �ָ޴��� ���
		mn_draw.add(draw_line);
		mn_draw.add(draw_rect);
		mn_draw.add(draw_oval);

		//�ָ޴� �׸�������� �θ޴�
		JMenuItem color_red = new JMenuItem("����");
		JMenuItem color_blue = new JMenuItem("�Ķ�");
		JMenuItem color_green = new JMenuItem("�ʷ�");
		JMenuItem color_other = new JMenuItem("��Ÿ");
		
		//�θ޴����� �׸������ �ָ޴��� ���
		mn_color.add(color_red);
		mn_color.add(color_blue);
		mn_color.add(color_green);
		mn_color.add(color_other);
		
		//�ָ޴��� �޴��ٿ� ���
		jmb.add(mn_file);
		jmb.add(mn_draw);
		jmb.add(mn_color);
		
		//�޴��ٸ� �����ӿ� ����
		setJMenuBar(jmb);
		
		//������ JMenuItem�� ���� �̺�Ʈ�� ���
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		draw_line.addActionListener(this);
		draw_rect.addActionListener(this);
		draw_oval.addActionListener(this);
		
		color_red.addActionListener(this);
		color_blue.addActionListener(this);
		color_green.addActionListener(this);
		color_other.addActionListener(this);
		
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
				System.out.println("���� ����");
				
				//��� ��̸����� �������� �����ϵ��� JFileChooser ���̾�α׸� ���
				int re = jfc.showSaveDialog(this);
				
				//�����ϱ� ���̾�α׿��� ����,��Ҹ� ���� �� ����
				//������ ������ 0�� ��ȯ
				if(re == 0) {
					
					//���̾�α׿��� ������ ���� ��������
					File file = jfc.getSelectedFile();
					
					//list��ü�� ��°�� ���Ϸ� ����ϱ� ���� ObjectOutputStream �̿�
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
					
					//LinePanel ��ü�� �ɹ������� list�� ���Ϸ� ���
					oos.writeObject(lp.list);
					oos.close();
				}
				
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
			
		}else if(cmd.equals("����")) {
			
			//������ ������ �о� LinePanel ��ü�� lp�� list�� ����
			//ȭ���� �ٽ� �׸��� ���� LinePanel ��ü�� lp�� repaint�� ȣ��
			try {
				System.out.println("���� ����");
				
				int re = jfc.showOpenDialog(this);
				
				if(re == 0) {
					File file = jfc.getSelectedFile();
					
					//��ü������ ������ ������ �о���̱� ���� ObjectInputStream ��ü ����
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					
					//���Ϸ� �����͸� �о�鿩 LinePanel ��ü�� lp�� list�� ���
					lp.list = (ArrayList<GraphicInfo>)ois.readObject();
					
					//������ ������ �о�ͼ� list�� ��� �׷����� ������ŭ �ٽ� �׷��ֱ� ���� repaint ȣ��
					lp.repaint();
					
					//���� �ݱ�
					ois.close();
				}
				
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
			
		}else if(cmd.equals("������")) {
			
			try {
				
				//����ڰ� �׸� �׷����� ����ִ� ����Ʈ �����
				lp.list.clear();
				//�׷����� �׸��� �ǳ��� �ٽ� �׸���
				lp.repaint();
				
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
			
		}else if(cmd.equals("��")) {		 //�׸��⵵�� �޴��� ���� ó��
			lp.drawType =0;
		}else if(cmd.equals("�簢��")) {
			lp.drawType =1;
		}else if(cmd.equals("��")) {
			lp.drawType =2;
		}else if(cmd.equals("����")){		 //�׸������ �޴��� ���� ó��
			lp.drawColor = Color.red;    //�빮�ڰ���
		}else if(cmd.equals("�Ķ�")){
			lp.drawColor = Color.blue;
		}else if(cmd.equals("�ʷ�")){
			lp.drawColor = Color.green;
		}else if(cmd.equals("��Ÿ")){
			//�ٸ������� �����Ҽ� �ְ� JColorChooser ���̾�α׸� ���
			Color color = jcc.showDialog(this, "�׸������", Color.red);
			if(color != null) {
				lp.drawColor = color;
			}
		}
	}
}

