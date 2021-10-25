package com.sist.exam06;

public class ProcessScoreTest {

	public class ProcessScore {  //Ŭ�����̸��� �ٸ��� ����
		public static double Score(double []arr) throws IllegalScore{
			double avg=0;
			int sum = 0;
			for(int i=0;i<arr.length;i++) {
				sum += arr[i];
			}
			avg = (double)sum/arr.length;
			
			if(avg<0) {
				throw new IllegalScore("������ ����� �����Դϴ�.");
			}
			return avg;
		}
	}
	
	public static void main(String[] args) {
		try {
			double []arr = {100,70,90,85};
			double avg = ProcessScore.Score(arr);
			System.out.println("���: "+avg);
		}catch(IllegalScore i) {
			System.out.println("���� �߻�"+ i.getMessage());
		}

	}

	


}
