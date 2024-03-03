import java.util.*;

public class Vingere {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		//type cast for ascii conversion
		final int KEY_BASE = (int) 'a'; 
		//user input
		System.out.print("Enter ciphertext: ");
		String cipher = scan.nextLine();
		System.out.print("Enter key: ");
		String key = scan.nextLine();

		//core loop
		int i = 0;
		String plainText = "";
		while (i < cipher.length()) {
			char cipherLetter = cipher.charAt(i);
			char keyLetter = key.charAt(i % key.length());
			int cipherNum = ((int) cipherLetter) - KEY_BASE;
			int keyNum = ((int) keyLetter) - KEY_BASE;
			int newNum =  (26 + (cipherNum - keyNum)) % 26 + KEY_BASE;
			char plainLetter = (char) newNum;
			String addLetter = Character.toString(plainLetter);
			plainText += addLetter;
			i++;
		}
		
		System.out.println(plainText);

	}
}
