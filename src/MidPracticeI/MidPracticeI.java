package MidPracticeI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * <pre>
 * 練習題1
 * </pre>
 */
public class MidPracticeI {
	public static void main(String[] args) {
		new mi_1().exec(10);
		System.out.println("-----------");
		new mi_2().exec(5);
		System.out.println("-----------");
		new mi_3().exec();
	}
}

/**
 * <pre>
 請使用for迴圈，練習印出以下圖案
   
   *       *
    *     *
     *   *
      * *
       *
      * *
     *   *
    *     *
   *       *
 * </pre>
 */
class mi_1 {
	public void exec(int size) {

		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size; j++) {
				if (i != 0) {
					if ((j == i && j <= 5) || (j > 5 && j == 9 - i + 1)) {
						System.out.print("*");
					} else if ((i > 5 && j == 9 - i + 1) || (j == i && i > 5)) {//
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
}

/**
 * <pre>
 * 1. 首先產生一組陣列，裡面擺放正整數 0~5
 * 2. 產生一個目標答案，亂數答案是 1~9 之間
 * 3. 利用第一組陣列，隨機兩個元素相加，會等於目標答案，並印出兩個陣列位置
 * </pre>
 */
class mi_2 {

	public void exec(int size) {
		int row = 0;
		int arrayInt[] = { 0, 1, 2, 3, 4, 5 };
		int tarInt = (int) ((Math.random() * (9 - 1 + 1)) + 1);
		for (int i = 0; i < arrayInt.length; i++) {
			for (int j = 0; j < arrayInt.length; j++) {
				if (tarInt == (arrayInt[i] + arrayInt[j])) {
					row++;
					System.out.println("目標價: " + tarInt + ", 可能組合" + row + "為 [第" + i + "位(" + arrayInt[i] + "), 第" + j
							+ "位(" + arrayInt[j] + ") ]");
				}
			}
		}
	}
}

/**
 * <pre>
 * 學生資料
 * 學號  姓名
 * S1    小天
 * S2    小忍
 * S3    小玉
 * 
 * 成績資料
 * 學號  數學  英文  國文
 * S1     80   100    87
 * S2     99    94    78
 * S3     55    79    77
 * 
 * 請用新增學生與成績類別(Class)
 * 設定每位學生資料以及設定各科成績資料後
 * 
 * 1.請幫我用學號查詢學生各科的成績
 * 2.每位學生的平均成績
 * 3.各科的平均成績
 * 4.每科最高分數
 * 5.每科最低分數
 * </pre>
 */
class mi_3 {

	Map<Integer, StudentInfo> studentMap = new LinkedHashMap<Integer, StudentInfo>();
	Map<Integer, StudentGrade> gradeMap = new LinkedHashMap<Integer, StudentGrade>();
	int stdCount = 0;

	public void exec() {
		init();
		System.out.println("1.請幫我用學號查詢學生各科的成績");
		eveyGrade();
		System.out.println();
		System.out.println("2.每位學生的平均成績");
		avgGrade();
		System.out.println();
		System.out.println("3.各科的平均成績");
		avgGradeByPara();
		System.out.println();
		System.out.println("4.每科最高分數");
		getHighestGrade();
		System.out.println();
		System.out.println("5.每科最低分數");
		getLowestGrade();
		System.out.println();
	}

	public void init() {
		newStudent("S1", "小天", 80, 100, 87);
		newStudent("S2", "小忍", 99, 94, 78);
		newStudent("S3", "小玉", 55, 79, 77);
	}

	public void newStudent(String id, String name, int math, int eng, int chn) {
		stdCount++;
		studentMap.put(stdCount, new StudentInfo(id, name));
		gradeMap.put(stdCount, new StudentGrade(id, math, eng, chn));
	}

	public void eveyGrade() {
		for (int sKey : studentMap.keySet()) {
			System.out.println("學號:" + studentMap.get(sKey).getId() + ", " + "姓名:" + studentMap.get(sKey).getName()
					+ ", " + "數學:" + gradeMap.get(sKey).getMath() + ", " + "英文:" + gradeMap.get(sKey).getEng() + ", "
					+ "國文:" + gradeMap.get(sKey).getChn());
		}
	}

	public void avgGrade() {
		for (int sKey : studentMap.keySet()) {
			System.out.println("學號:" + studentMap.get(sKey).getId() + ", " + "姓名:" + studentMap.get(sKey).getName()
					+ ", " + "平均成績:"
					+ (float) (Math.round(
							((gradeMap.get(sKey).getMath() + gradeMap.get(sKey).getEng() + gradeMap.get(sKey).getChn())
									/ 3.0) * 100.0)
							/ 100.0));
		}
	}

	public void avgGradeByPara() {

		String[] gradeName = { "數學", "英文", "國文" };
		int[] gradeValues = { 0, 0, 0 };
		for (int sKey : studentMap.keySet()) {
			gradeValues[0] += gradeMap.get(sKey).getMath();
			gradeValues[1] += gradeMap.get(sKey).getEng();
			gradeValues[2] += gradeMap.get(sKey).getChn();
		}

		for (int i = 0; i < gradeValues.length; i++) {
			System.out.println(gradeName[i] + "平均:" + (Math.round((gradeValues[i] / 3.0) * 100.0) / 100.0));
		}
	}

	public void getHighestGrade() {
		
		String[] gradeName = { "數學", "英文", "國文" };
		int[] tarGrade = { 0, 0, 0 };
		for (int sKey : studentMap.keySet()) {
			if ( tarGrade[0] < gradeMap.get(sKey).getMath() ) {
				tarGrade[0] = gradeMap.get(sKey).getMath();
			}
			if ( tarGrade[1] < gradeMap.get(sKey).getEng() ) {
				tarGrade[1] = gradeMap.get(sKey).getEng();
			}
			if ( tarGrade[2] < gradeMap.get(sKey).getChn() ) {
				tarGrade[2] = gradeMap.get(sKey).getChn();
			}
		}
		
		for (int i = 0; i < tarGrade.length; i++) {
			System.out.println(gradeName[i] + "最高分:" + tarGrade[i]);
		}
	}

	public void getLowestGrade() {
		String[] gradeName = { "數學", "英文", "國文" };
		int[] tarGrade = { 999, 999, 999 };
		for (int sKey : studentMap.keySet()) {
			if ( tarGrade[0] > gradeMap.get(sKey).getMath() ) {
				tarGrade[0] = gradeMap.get(sKey).getMath();
			}
			if ( tarGrade[1] > gradeMap.get(sKey).getEng() ) {
				tarGrade[1] = gradeMap.get(sKey).getEng();
			}
			if ( tarGrade[2] > gradeMap.get(sKey).getChn() ) {
				tarGrade[2] = gradeMap.get(sKey).getChn();
			}
		}
		
		for (int i = 0; i < tarGrade.length; i++) {
			System.out.println(gradeName[i] + "最低分:" + tarGrade[i]);
		}
	}
}

class StudentInfo {
	String id, name;

	public StudentInfo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class StudentGrade {
	String id;
	int math, eng, chn;

	public StudentGrade(String id, int math, int eng, int chn) {
		super();
		this.id = id;
		this.math = math;
		this.eng = eng;
		this.chn = chn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getChn() {
		return chn;
	}

	public void setChn(int chn) {
		this.chn = chn;
	}

}
