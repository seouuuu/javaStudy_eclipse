package com.sist.exam06;

public class ProcessScoreTest {

	public class ProcessScore {  //클래스이름과 다르게 생성
		public static double Score(double []arr) throws IllegalScore{
			double avg=0;
			int sum = 0;
			for(int i=0;i<arr.length;i++) {
				sum += arr[i];
			}
			avg = (double)sum/arr.length;
			
			if(avg<0) {
				throw new IllegalScore("성적의 평균이 음수입니다.");
			}
			return avg;
		}
	}
	
	public static void main(String[] args) {
		try {
			double []arr = {100,70,90,85};
			double avg = ProcessScore.Score(arr);
			System.out.println("평균: "+avg);
		}catch(IllegalScore i) {
			System.out.println("예외 발생"+ i.getMessage());
		}

	}

	


}
