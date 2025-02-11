package System;

import java.util.*;

public class Cheak_reservation extends Save {
	int k;
	
	public Cheak_reservation() {

	}

	public static String d_grade(int s_num) {
		String grade;

		if (s_num >= 0 && s_num <= 29) {
			grade = "V";
		} else if (s_num >= 30 && s_num <= 59) {
			grade = "S";
		} else if (s_num >= 60 && s_num <= 89) {
			grade = "A";
		} else if (s_num >= 90 && s_num <= 120) {
			grade = "B";
		} else {
			grade = "?";
		}

		return grade;
	}

	public static int d_num(String grade, int s_num) {
		int num;

		if (grade.equals("V")) {
			num = s_num + 1;
		} else if (grade.equals("S")) {
			num = s_num - 29;
		} else if (grade.equals("A")) {
			num = s_num - 59;
		} else if (grade.equals("B")) {
			num = s_num - 89;
		} else {
			num = 0;
		}

		return num;
	}

	private void reCheak_num() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("잘못된 예매 번호 또는 비밀번호 입니다. ");
		System.out.println("예약 번호를 다시 입력하세요 : ");
		String r_num = scanner.next();
		System.out.println("비밀번호를 다시 입력하세요 : ");
		String pw = scanner.next();


		Cheak(r_num, pw);
	}

	private void reCheak_name() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("잘못된 입력 입니다. ");
		System.out.println("이름을 다시 입력하세요 : ");
		String name = scanner.next();
		System.out.println("전화번호를 다시 입력하세요 : ");
		String p_num = scanner.next();
		System.out.println("비밀번호를 다시 입력하세요 : ");
		String pw = scanner.next();

		Cheak(name, p_num, pw);
	}

	public static int get_i(String r_num) {
		Save saves = new Save();
		for (int k = 0; k < 39; k++) {
			for (int i = 0; i < 120; i++) {
				if (saves.get_save(k, i)[2].equals(r_num)) {
					return i;
				}
			}
		}
		return 0;
	}

	void Cheak(String name, String p_num, String pw) {
		Save saves = new Save();
		Boolean a = false;

		for (int k = 0; k < 39; k++) {
			for (int i = 0; i < 120; i++) {
				if (saves.get_save(k, i)[1].equals(name) && saves.get_save(k, i)[3].equals(p_num) && saves.get_save(k, i)[4].equals(pw)) {
					System.out.println(name + " 고객님의 예매 좌석은 : " + "12월 " + k + "일, " + d_grade(i) + "("
							+ d_num(d_grade(i), i) + " 번) 좌석 입니다.");
					this.k = k;
					a = true;
				}
			}
		}
		if (a == false) {
			reCheak_name();
		}
	}

	void Cheak(String r_num, String pw) {
		Save saves = new Save();
		Boolean a = false;

		for (int k = 0; k < 39; k++) {

			for (int i = 0; i < 120; i++) {
				if (saves.get_save(k, i)[2].equals(r_num) && saves.get_save(k, i)[4].equals(pw)) {
					System.out.println(saves.get_save(k, i)[1] + " 고객님의 예약 좌석은 : " + "12월 " + k + "일, " + d_grade(i)
							+ "(" + d_num(d_grade(i), i) + " 번) 좌석 입니다.");
					this.k = k;
					a = true;
				}
			}
		}
		if (a == false) {
			reCheak_num();
		}
	}

	public static void initialize(int k, int i, String g) {
		saves[k][i][0] = g;
		saves[k][i][1] = "빈자리";
		saves[k][i][2] = "공란";
		saves[k][i][3] = "공란";
		saves[k][i][4] = " ";
	}
}
