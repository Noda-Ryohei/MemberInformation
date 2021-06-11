package jp.co.aforce.trial;

public class Empty {

	public static void main(String[] args) {
		
		String empty = "1";
		int num =0;
//		int num1;
		try {
			num = Integer.parseInt(empty);
		} catch (NumberFormatException e) {
			System.out.println("\" " + empty+ " \"" + "は、parseIntできません。");
		}
		
		System.out.println(empty + "→" + num);
		
//		System.out.println(num1);
	}
}

//parseIntの実験
//全角数字は変換できる。
//空値はエラーを吐く。
//{}の外で宣言すれば、{}の外でも使える。