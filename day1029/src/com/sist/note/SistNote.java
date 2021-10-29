package com.sist.note;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//�θ޴��� �������� �̺�Ʈó���� ���� ActionListener�������̽� ����
public class SistNote extends JFrame implements ActionListener{
	
	//�޸����� ������� ���Ͽ� �������� ������ �Է��Ҽ� �ִ� JTextArea�� �ɹ������� ����
	JTextArea jta;
	
	//������ �����̸��� ����� �����̸��� �����ϱ� ���� JFileChooser�� �ɹ������� ����
	JFileChooser jfc;
	
	String fileName = "�������";
	
	//�����ڿ��� JTextArea��ü ���� �� �����ӿ� ���
	public SistNote(){
		jta = new JTextArea();
		
		
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
		
		//�������� ũ�⸦ �����ϰ� �������� �����ֵ��� ����
		setSize(800,600);
		setVisible(true);
		setTitle(fileName);
		
		/*		
		jta.setText("�ȳ��ϼ���");
		try {
			Thread.sleep(3000);
		}catch (Exception e) {

		}
		jta.setText("");
		*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//���õ� �޴��� �ľ��ϱ� ���� ActionEvent�� getActionCommand �޼ҵ带 �̿��Ͽ� �޴��� "����"������
		String cmd = e.getActionCommand();
		
		//���õ� �޴��� ���� ������ ��ó���� �ϵ��� ��
		if(cmd.equals("������")) {
			jta.setText("");
			setTitle("�������");
		}else if(cmd.equals("����")) {
			try {
				//����޴��� ������ ��� �ִ� � ������ ������� �����ϱ� ���� ���̾�α� ���
				int re = jfc.showOpenDialog(this);
				
				//���̾�α׿��� ��Ұ� �ƴ� ���⸦ �������� ������ ������ �о���� ó��
				if(re == 0) {
					//������ �������� ��������
					File file = jfc.getSelectedFile();
					
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
		}else if(cmd.equals("����")) {
			//��� ������̸��� ������ ������ �����ϵ��� ���̾�α׸� ���
			//�Ű����� this�� �� ���̾�α׸� ������������� �������� ����
			//���� ������ SistNote�� ����� �ǹ̷� ��ü�ڽ��� �ǹ��ϴ� this ����
			//showSaveDialog���� ����/��� ���� ����
			//������ ������ 0�� ��ȯ, ��Ҹ� ������ 1�� ��ȯ
			//��ȯ�ϴ� ���� ������ ��� �� ���� ���� �� ���� ��ó���� �ٸ��� �� �� ����
			int re = jfc.showSaveDialog(this);
			
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
                
			}
		}
	}
}
