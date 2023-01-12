package Base;

import java.util.Random;

import com.github.javafaker.Faker;

public class Javautils {
	public static Faker faker;

	public static String getRandomString(int n) {

		String Mystring = "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			int index = (int) (Mystring.length() * Math.random());
			sb.append(Mystring.charAt(index));
		}

		return sb.toString();
	}

	public static String getRandominterger(int n) {

		String Myinteger = "0123456789";
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			int index = (int) (Myinteger.length() * Math.random());
			sb.append(Myinteger.charAt(index));
		}

		return sb.toString();
	}

	public static String randomNumGenerator() {
		Random random = new Random();
		int randomNumber = random.nextInt(9000000);
		String id = Integer.toString(randomNumber);
		return id;

	}

//	public static String newemail() {
//		String newemail = faker.name().lastName();
//		String email1 = newemail + Javautils.randomNumGenerator() + "@gmail.com";
//		return email1;
//	}

	public static String newemail() {
		String newemail = faker.internet().emailAddress();
		String email1 = newemail;
		return email1;
	}

	public static String fakerName() {
		faker = new Faker();
		String firstName = faker.name().firstName()+Javautils.getRandomString(3);
		return firstName;
	}
	public static String fakerPhone() {
		faker = new Faker();
		String firstName = faker.phoneNumber().cellPhone();
		return firstName;
	}

}
