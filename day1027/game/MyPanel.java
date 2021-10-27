package com.sist.game;

import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;

//��,�̻���,���ּ��� ���ÿ� ������ �ִ� "�г�"Ŭ������ ����
//Ű���尡 �������� �̺�Ʈ�� ó���ϱ� ���� KeyListener�� ����
public class MyPanel extends JPanel implements KeyListener {
	
	//��,�̻���,���ּ��� �г��� ��������� ����
	Enermy enermy;
	SpaceShip spaceship;
	Missile missile;
	
	//�����ڿ� ��,�г��� �����ǰ� ���ÿ� ����
	public MyPanel() {
		super();
		this.addKeyListener(this);     //�г��� Ű���� �̺�Ʈ�� ���
		this.requestFocus();		   //�г��� Ű���� ��û�� ����       A
		setFocusable(true);			   //�гο� ��Ŀ���� ����           B
		//�г��� ȭ�鱸����� �� ���� Ű����κ��� �Է��� �޾Ƶ��̴� �뵵�� �ƴϱ� ������ 
		//Ű����κ��� �Է��� �޾Ƶ��̰� �Ϸ��� �гο� �ϴ� ��Ŀ���� �����ؾ� ��
		
		enermy = new Enermy("enermy.png");				//�̹������ϸ��� ������ �� ��ü ����
		spaceship = new SpaceShip("spaceship.png");		//�̹������ϸ��� ������ ���ּ� ��ü ����
		missile = new Missile("missile.png");			//�̹������ϸ��� ������ �̻��� ��ü ����
		
		//�г��� ��������� ��,�̻���,���ּ��� ���� ����������(���ÿ�,�����ϰ�) �����̱� ���� ��Ƽ������� ����
		//��,�̻���,���ּ��� ���ÿ�(�����ϰ�) �����̰� �ϴ� ����� �гο����� �ʿ�
		//�̷��� Ŭ������ Ŭ�����ȿ� ���� �� ���� - inner class
		class MyThread extends Thread{				//Thread�� ��ӹ޾� ��Ƽ������ ����
			public void run() {						//run�� �������̵��Ͽ� ���ÿ� �����ų ��ɾ�(��) �ۼ�
				while(true) {		//��� �ݺ��Ͽ� ��,�̻���,���ּ��� �����̵��� �ϱ� ���� while(true)�̿�
					enermy.update();		//���� �����̱� ���� ��ġ�� �����ϴ� �޼ҵ� ȣ��
					//spaceship.update(); 	//���ּ��� �����̱� ���� ��ġ�� �����ϴ� �޼ҵ� ȣ��
					//���ּ��� Ű���尡 ������ �������� �ѹ��� �ѹ� �����̵��� �Ǿ��ֱ� ������ ������ ȣ������ �ʾƵ� ��
					
					missile.update();		//�̻����� �����̱� ���� �̻����� ��ġ�� �����ϴ� �޼ҵ� ȣ��
					
					//���� �̻��Ͽ� �¾Ҵ��� �Ǻ��Ͽ� ���ִ� �޼ҵ� ȣ��
					enermy.crush(missile);
					
					repaint();				//��,�̻���,���ּ��� ����� ��ġ�� �ٽ� �׸��� ���� ��û
											//ȭ�鿡 �׷����� �׷��ִ� �޼ҵ�� paint(Component) �޼ҵ�
											//����ڰ� ���� paint(Component)�� ȣ���� �� ����
											// repaint�� ȣ���Ͽ� paint(Component)�� ���۽�ų �� ����
					
					
					try { Thread.sleep(50);
					}catch(InterruptedException e) {
						//handle exception
					}//end catch
				}//end while
			}//end run
		}//end MyThread
		
		//��,�̻���,���ּ��� ���� ���������� �����̰� ���� ��Ƽ������ ��ü MyThread ����
		Thread t = new MyThread();
		t.start();
	}
	//��,�̻���,���ּ��� ����� ��ġ�� �׷����� �ٽ� �׷���
	//�гο� �׷����� ǥ���ϱ� ���ؼ��� paint(Component)�� �������̵� ���� 
	//�̶� �Ű������� ���޹��� Graphics�� �׷����� ǥ���ϱ� ���� �ٿ��� �޼ҵ���� ����
	public void paint(Graphics g) {   
		super.paint(g);
		
		//�׷����� �׸��� ���� �׷��Ƚ��� g�� ��,���ּ�,�̻��Ͽ� �����Ͽ� �ٽ� ����� ��ġ�� �׸�
		enermy.draw(g);			
		spaceship.draw(g);
		missile.draw(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//�гο��� Ű���尡 �������� 
	@Override
	public void keyPressed(KeyEvent event) {
		spaceship.keyPressed(event);  //������ Ű�����̺�Ʈ�� ������ ���ּ����� ����
		
		missile.keyPressed(event, spaceship.x, spaceship.y);
		//������ Ű�����̺�Ʈ�� ������ ���ּ��� ��ġ�� �̻��Ͽ� ����
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
