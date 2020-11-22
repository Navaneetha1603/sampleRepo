package Validations;

import java.util.Scanner;

public class Validations {
	static Scanner sc=new Scanner(System.in);
	// validate string
		public static String validateString(String s) {
			boolean isValid = true;
			while (isValid) {
				int count = 0;
				for (int i = 0; i < s.length(); i++) {
					// int ch = (int) (s.charAt(i));
					char ch = s.charAt(i);
					if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
						count++;
					}
				}
				if (count != s.length() || s.length() < 3) {
					System.out.println("invalid input:once again enter");
					s = sc.next();
				} else {
					isValid = false;
				}

			}
			return s;
		}

		// validate age
		public static int validateAge(int age) {
			boolean isValid = true;
			while (isValid) {
				if (age < 0 || age >= 120) {
					System.out.println("invalid input:\nit should between 1 to 120:once again enter:");
					age = sc.nextInt();
				} else {
					isValid = false;
				}
			}
			return age;
		}

//		validate gender
		public static char validateGender(char gender) {
			boolean isValid = true;
			while (isValid) {
				if (gender == 'F' || gender == 'M' || gender == 'f' || gender == 'm') {
					isValid = false;
				} else {
					System.out.println("invalid input\nit should be 'M' or 'F':once agin enter:");
					gender = sc.next().charAt(0);
				}
			}
			return gender;
		}
	//validate the integer
		// validate integer
		public static int validateInt(int number) {
			boolean isValid = true;
			while (isValid) {
				if (number <= 0) {
					System.out.println("invalid input:\nit should not contain negative numbers:once again enter:");
					number = sc.nextInt();
				} else {
					isValid = false;
				}
			}
			return number;
		}
//validate price
		public double validatePrice(double nextDouble) {
			boolean isValid = true;
			while (isValid) {
				if (nextDouble <= 0 || nextDouble>1000) {
					System.out.println("invalid input:\nit should not contain negative numbers:once again enter:");
					nextDouble = sc.nextDouble();
				} else {
					isValid = false;
				}
			}
			return nextDouble;
		}
//validate rating
		public double validateRating(double nextDouble) {
			boolean isValid = true;
			while (isValid) {
				if (nextDouble <= 0 || nextDouble>5) {
					System.out.println("invalid input:\nit should not contain negative numbers:once again enter:");
					nextDouble = sc.nextDouble();
				} else {
					isValid = false;
				}
			}
			return nextDouble;
		}
		//valiadate language
		
		public static String validateLanguage(String service) {
			String array[] = { "Telugu","English","Hindhi","Marati","Tamil","Kannada" };
			boolean isValid = true;
			while (isValid) {
				int found = 0;
				for (int i = 0; i < array.length; i++) {
					if (array[i].equalsIgnoreCase(service)) {
						found = 1;
					}
				}
				if (found == 0) {
					System.out.println("invalid input:it must be(telugu,hindhi,english,marati,tamil,kannada):once again enter");
					service = sc.next();
				} else {
					isValid = false;
				}
			}
			return service;
		}
}
