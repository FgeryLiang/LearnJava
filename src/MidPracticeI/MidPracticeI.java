package MidPracticeI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * <pre>
 * �m���D1
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
 �Шϥ�for�j��A�m�ߦL�X�H�U�Ϯ�
   
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
 * 1. �������ͤ@�հ}�C�A�̭��\�񥿾�� 0~5
 * 2. ���ͤ@�ӥؼе��סA�üƵ��׬O 1~9 ����
 * 3. �Q�βĤ@�հ}�C�A�H����Ӥ����ۥ[�A�|����ؼе��סA�æL�X��Ӱ}�C��m
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
					System.out.println("�ؼл�: " + tarInt + ", �i��զX" + row + "�� [��" + i + "��(" + arrayInt[i] + "), ��" + j
							+ "��(" + arrayInt[j] + ") ]");
				}
			}
		}
	}
}

/**
 * <pre>
 * �ǥ͸��
 * �Ǹ�  �m�W
 * S1    �p��
 * S2    �p��
 * S3    �p��
 * 
 * ���Z���
 * �Ǹ�  �ƾ�  �^��  ���
 * S1     80   100    87
 * S2     99    94    78
 * S3     55    79    77
 * 
 * �Хηs�W�ǥͻP���Z���O(Class)
 * �]�w�C��ǥ͸�ƥH�γ]�w�U�즨�Z��ƫ�
 * 
 * 1.�����ڥξǸ��d�߾ǥͦU�쪺���Z
 * 2.�C��ǥͪ��������Z
 * 3.�U�쪺�������Z
 * 4.�C��̰�����
 * 5.�C��̧C����
 * </pre>
 */
class mi_3 {

	Map<Integer, StudentInfo> studentMap = new LinkedHashMap<Integer, StudentInfo>();
	Map<Integer, StudentGrade> gradeMap = new LinkedHashMap<Integer, StudentGrade>();
	int stdCount = 0;

	public void exec() {
		init();
		System.out.println("1.�����ڥξǸ��d�߾ǥͦU�쪺���Z");
		eveyGrade();
		System.out.println();
		System.out.println("2.�C��ǥͪ��������Z");
		avgGrade();
		System.out.println();
		System.out.println("3.�U�쪺�������Z");
		avgGradeByPara();
		System.out.println();
		System.out.println("4.�C��̰�����");
		getHighestGrade();
		System.out.println();
		System.out.println("5.�C��̧C����");
		getLowestGrade();
		System.out.println();
	}

	public void init() {
		newStudent("S1", "�p��", 80, 100, 87);
		newStudent("S2", "�p��", 99, 94, 78);
		newStudent("S3", "�p��", 55, 79, 77);
	}

	public void newStudent(String id, String name, int math, int eng, int chn) {
		stdCount++;
		studentMap.put(stdCount, new StudentInfo(id, name));
		gradeMap.put(stdCount, new StudentGrade(id, math, eng, chn));
	}

	public void eveyGrade() {
		for (int sKey : studentMap.keySet()) {
			System.out.println("�Ǹ�:" + studentMap.get(sKey).getId() + ", " + "�m�W:" + studentMap.get(sKey).getName()
					+ ", " + "�ƾ�:" + gradeMap.get(sKey).getMath() + ", " + "�^��:" + gradeMap.get(sKey).getEng() + ", "
					+ "���:" + gradeMap.get(sKey).getChn());
		}
	}

	public void avgGrade() {
		for (int sKey : studentMap.keySet()) {
			System.out.println("�Ǹ�:" + studentMap.get(sKey).getId() + ", " + "�m�W:" + studentMap.get(sKey).getName()
					+ ", " + "�������Z:"
					+ (float) (Math.round(
							((gradeMap.get(sKey).getMath() + gradeMap.get(sKey).getEng() + gradeMap.get(sKey).getChn())
									/ 3.0) * 100.0)
							/ 100.0));
		}
	}

	public void avgGradeByPara() {

		String[] gradeName = { "�ƾ�", "�^��", "���" };
		int[] gradeValues = { 0, 0, 0 };
		for (int sKey : studentMap.keySet()) {
			gradeValues[0] += gradeMap.get(sKey).getMath();
			gradeValues[1] += gradeMap.get(sKey).getEng();
			gradeValues[2] += gradeMap.get(sKey).getChn();
		}

		for (int i = 0; i < gradeValues.length; i++) {
			System.out.println(gradeName[i] + "����:" + (Math.round((gradeValues[i] / 3.0) * 100.0) / 100.0));
		}
	}

	public void getHighestGrade() {
		
		String[] gradeName = { "�ƾ�", "�^��", "���" };
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
			System.out.println(gradeName[i] + "�̰���:" + tarGrade[i]);
		}
	}

	public void getLowestGrade() {
		String[] gradeName = { "�ƾ�", "�^��", "���" };
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
			System.out.println(gradeName[i] + "�̧C��:" + tarGrade[i]);
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
