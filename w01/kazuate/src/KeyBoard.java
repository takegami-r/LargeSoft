package w01.kazuate.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//キーボード空の入出力を実装するテンプレートクラス
public class KeyBoard {
	//数字を入力する為のサブルーチン数字以外の入力や入力エラーをはじく
	public static int inputNumber() {
		int number;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			number = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.err.println("フォーマット例外です．もう一度．");
			number = inputNumber(); // 再起呼び出し
		} catch (IOException e) {
			System.err.println("入出力例外です．もう一度．");
			number = inputNumber(); // 再起呼び出し
		}

		return number;
	}

	//文字を入力する為のサブルーチン文字以外の入力や入力エラーをはじく
	public static String inputString() {
		String line;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch (IOException e) {
			System.err.println("エラー：入出力例外です．もう一度入力．");
			line = inputString();
		}

		return line;

	}

}