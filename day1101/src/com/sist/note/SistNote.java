package com.sist.note;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//�θ޴��� �������� �̺�Ʈó���� ���� ActionListener�������̽� ����
public class SistNote extends JFrame implements ActionListener, KeyListener {
	
	//�޸����� ������� ���Ͽ� �������� ������ �Է��Ҽ� �ִ� JTextArea�� �ɹ������� ����
	JTextArea jta;
	
	//������ �����̸��� ����� �����̸��� �����ϱ� ���� JFileChooser�� �ɹ������� ����
	JFileChooser jfc;
	
	String fileName = "�������";
	
	//�̹� ���ϸ��� ���� ��� ����� �ʰ� �� ���Ͽ� �����ϵ��� �ϱ� ���� File��ü�� ��������� ����
	File file = null; // ���ص� �⺻�� null
	
	
	//�޸����� ���� ������ �ִ��� ���¸� �����ϱ� ���� ���� ����
	boolean isNew;
	
	//�����ڿ��� JTextArea��ü ���� �� �����ӿ� ���
	public SistNote(){
		jta = new JTextArea();
		
		//isNew�� �⺻���� false ����
		isNew = false;
		
		//JFileChooser ��ü�� ����
		jfc = new JFileChooser("c:/myData");
		
		//add(jta);
		//TextArea�� �ٷ� �����ӿ� ������ ȭ���� ��� ���ڵ��� ������ ����
		//��ũ���� �ڵ����� ������ִ� JScrollPane���� ���μ� �����ӿ� ���
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		
		//�޴� �����
		//�޴��� ��ü ����
		JMenuBar jmb = new JMenuBar();
		
		//�ָ޴� ����
		JMenu mn_file = new JMenu("����");
		
		//�θ޴� �����
		JMenuItem file_new = new JMenuItem("������"); 
		JMenuItem file_open = new JMenuItem("����"); 
		JMenuItem file_save = new JMenuItem("����"); 
		
		//�θ޴��� �ָ޴��� ���
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//�ָ޴� ������ �޴��ٿ� ���
		jmb.add(mn_file);
		
		//�����ӿ� �޴��� ����
		setJMenuBar(jmb); //this.setJMenuBar(jmb);�� ����
		
		//�θ޴� �޴��� �������� ���� �����ϵ��� �̺�Ʈ ���
		//�Ű����� �̺�Ʈó����簴ü�� �����ؾ��ϴµ� �� Ŭ����(SistNote) �ڽ��� ó���ϵ��� this ����
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		//TextArea�� Ű�̺�Ʈ�� ���
		jta.addKeyListener(this);
		
		//�������� ũ�⸦ �����ϰ� �������� �����ֵ��� ����
		setSize(800,600);
		setVisible(true);
		setTitle(fileName);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//���õ� �޴��� �ľ��ϱ� ���� ActionEvent�� getActionCommand �޼ҵ带 �̿��Ͽ� �޴��� "����"������
		String cmd = e.getActionCommand();
		
		//���õ� �޴��� ���� ������ ��ó���� �ϵ��� ��
		if(cmd.equals("������")) {
			
			if(isNew == true) {
				int re = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?");
				//System.out.println("re:"+ re);
				//re=0 : �����ϰ� ������ ó��
				//re=1 : ���� ���ϰ� ������ ó��
				//re=2 : ������ ���
				switch(re) {
				case 0:saveFile();
				case 1:
					jta.setText("");
					fileName = "�������";
					setTitle(fileName);
					isNew = false;
					file = null;
					break;
				case 2:return;
				}
			}else {
				jta.setText("");
				fileName = "�������";
				setTitle(fileName);
				isNew = false;
				file = null;
			}
			
			
			
		}else if(cmd.equals("����")) {
			try {
				//����޴��� ������ ��� �ִ� � ������ ������� �����ϱ� ���� ���̾�α� ���
				int re = jfc.showOpenDialog(this);
				
				//���̾�α׿��� ��Ұ� �ƴ� ���⸦ �������� ������ ������ �о���� ó��
				if(re == 0) {
					//������ �������� ��������
					//����� ������ ������� file�� ����
					file = jfc.getSelectedFile();
					
					//������ ������ ��ǻ�͸޸𸮷� �о���̱� ���� ��Ʈ�� ����
					FileReader fr = new FileReader(file);
					
					//������ ��� ������ ��� ���� ���ڿ� ���� �����
					//���Ϸκ��� �ѱ��ھ� �о�ͼ� �����ϱ� ���� �ʱ�ȭ
					String data = "";
					
					//���Ϸκ��� �ѱ��ھ� �б����� ���� �����
					int ch;
					
					//�ݺ����� �̿��Ͽ� ������ ���� �ƴҵ��� �ѱ��ھ� �о���̱�
					while(true) {
						//���Ϸκ��� �ѱ��ھ� �о����
						//���ڿ� �ش��ϴ� ������ ��ȯ
						//���� ���̻� �о���� ������ ���� ������ ���� �����ϸ� -1 ��ȯ
						ch = fr.read();
						
						//���Ϸκ��� ���̻� �о���� ������ ������ �ݺ��� Ż��
						if( ch == -1 ) {
							break;
						}
						
						//������ ���� �ƴ϶�� �о���� ������ ���ڸ� �ٽ� ���ڷ� ��ȯ�Ͽ� data�� ����
						data = data + (char)ch;
					}
					//������ ������ ��� �о���� ���� while�� Ż��
					//while�� Ż�������� ������ ��� ������ String ���� data�� ����� ����
					//data�� ������ TextArea�� ����
					jta.setText(data);
					
					//���ϻ�� �Ϸ� �� �ݱ�
                	fr.close();
					
					JOptionPane.showMessageDialog(this, "������ �о�Խ��ϴ�.");
					
					//�о�� ������ ������ ����ִ� File��ü�κ��� ���ϸ��� �̾� fileName�� ���
					//fileName = file.getName();   Ȯ���ڵ� ǥ�õ�
					fileName = file.getName();
					fileName = fileName.substring(0,fileName.indexOf("."));
					
					//���ϸ��� �������� ����ǥ���ٷ� ����
					setTitle(fileName);
				
				}
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
			
			isNew = false;
			
		}else if(cmd.equals("����")) {
			saveFile();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isNew = true;
	}
	
	public void saveFile() {
		//��� ������̸��� ������ ������ �����ϵ��� ���̾�α׸� ���
		//�Ű����� this�� �� ���̾�α׸� ������������� �������� ����
		//���� ������ SistNote�� ����� �ǹ̷� ��ü�ڽ��� �ǹ��ϴ� this ����
		//showSaveDialog���� ����/��� ���� ����
		//������ ������ 0�� ��ȯ, ��Ҹ� ������ 1�� ��ȯ
		//��ȯ�ϴ� ���� ������ ��� �� ���� ���� �� ���� ��ó���� �ٸ��� �� �� ����
		
		//������ ���ٸ� ������ �����ϱ� ���� ���̾�α׸� ���� �̹� ������ �ִٸ� �� �̸����� ����
		
		int re = 0;
		//�̹� �����̸��� �ִ� ���¿��� file�� null�� �ƴ� �����̸� ������ ������ ������ �����ؾ���
		//ó�� ������ �����ϸ� file�� null �� ���¿��� ������ ������ ������ �����ϴ� ���̾�α׿��� ��Ҹ�
		//������ �ʰ� ������ ���������� �����ϵ��� ó��
		//���ÿ� ó���ϱ� ���� re�� �⺻�� 0�� ����
		//�̹� ������ ������ ������ if�� ������ �ʾ� re�� �״�� 0����
		//������ ���� ���¸� if�� ������ ����� ���̾�α׿��� ��Ҹ� ������ re = 1�� ��, ����ó�� ����
		if(file == null) {
			re = jfc.showSaveDialog(this);
			if(re == 0) {
				file = jfc.getSelectedFile();
			}
		}
		
		//�����ϱ� ���̾�α׿� ������ �������� ���������� ���� ��ɾ���� �����ϵ��� ��
		if(re == 0) {
			//���̾�α׿��� ������ ���� ��������
            File file = jfc.getSelectedFile();
            
            //������ ���Ͽ� textArea�� ������ ������ ����ϱ� ���� ��Ʈ�� ����
            //���ڴ����� ����� ���� Writer�� �ļ��� FileWriter �̿�
            //����°� ���õ� ��� �����ڿ� �޼ҵ���� ���ܸ� ����
            //�� ���ܵ��� RuntimeException�� �ļյ��� �ƴϹǷ� �ݵ�� ����ó�� �ؾ���
            try {
            	FileWriter fw = new FileWriter(file);
            	
            	//textArea�� ���� �о�ͼ� ���Ϸ� ���
            	fw.write(jta.getText());
            	
            	//���ϻ�� �Ϸ� �� �ݱ�
            	fw.close();
            	
            	//����ڿ��� �˷��� ������ �ܼ��� �ƴ� ���̾�α׸� ���
            	JOptionPane.showMessageDialog(this, "������ �����Ͽ����ϴ�.");
            	
            	//������ ������ ������ ���� ��ü File file�� ���� �����̸��� ������ fileName�� ���
            	//fileName = file.getName();   Ȯ���ڵ� ǥ�õ�
				fileName = file.getName();
				fileName = fileName.substring(0,fileName.indexOf("."));
				
				//���ϸ��� �������� ����ǥ���ٷ� ����
				setTitle(fileName);
			
            }catch (Exception ex) {	//���ܺ����̸��� �̺�Ʈ�����̸��� �޶����
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
            
        	isNew = false;
		}
	
	}
}
