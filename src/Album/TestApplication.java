package Album;

import java.util.Scanner;

import Validations.Validations;

public class TestApplication {
	static int count = 0;
	static Scanner sc = new Scanner(System.in);
	static Validations vs = new Validations();

	public static void main(String[] args) {
		Album albums[] = new Album[30];
		createAlubums(albums);
		displayDetails(albums);
		int op;
		do {
			System.out.println(
					"\nchoose an option\n1.Get All Songs sang by an given artist\n2.Get most expensive album in which a given artist have worked"
							+ "\n3.For a given artist find in how many languages he/she has worked on"
							+ "\n4. Sort thr albums in ascending order of price, if price is same then sort by rating"
							+ "\n5.Sort all the albums in descending order of their name.\n6.exit\n");
			System.out.println("\nenter an option:");
			op = sc.nextInt();
			switch (op) {
			case 1:
				boolean result = getSongsByArtist(albums);
				if (result == false) {
					System.err.println("no artist is found");
				}
				break;
			case 2:
				boolean result2 = getExpensiveAlbumByArtist(albums);
				if (result2 == false) {
					System.out.println("no artist is found");
				}
				break;
			case 3:
				boolean result1 = getLanguagesByArtist(albums);
				if (result1 == false) {
					System.err.println("no artist is found");
				}
				break;
			case 4:
				Album sortedByPrice[] = getSortedAlbumsBasedOnPrice(albums);
				displayDetails(sortedByPrice);
				break;
			case 5:
				Album sortedByName[] = getSortedAlbumsBasedOnName(albums);
				displayDetails(sortedByName);
				break;
			case 6:
				break;
			default:
				System.out.println("invalid option:");
			}
		} while (op != 6);

	}

//get expensive albums by artist
	private static boolean getExpensiveAlbumByArtist(Album[] albums) {
		System.out.println("enter artist name:");
		String name = vs.validateString(sc.next());
		int flag = 0;
		int artistCount = 0;

		for (int i = 0; i < count; i++) {
			if (albums[i].songs.artist.getName().equalsIgnoreCase(name)) {
				flag = 1;
				artistCount++;

			}
		}
		
		Album artists[] = new Album[artistCount];
		int k=0;
		for (int i = 0; i < count; i++) {
			if (albums[i].songs.artist.getName().equalsIgnoreCase(name)) {
					// artists[i] = albums[i];
					Artist artist=new Artist(albums[i].songs.artist.getId(),albums[i].songs.artist.getName(),albums[i].songs.artist.getGender(),albums[i].songs.artist.getAge());
					Song song=new Song(albums[i].songs.getId(),albums[i].songs.getName(),artist,albums[i].songs.getLikes(),albums[i].songs.getLanguage());
					Album album=new Album(albums[i].getId(),albums[i].getName(),albums[i].getPrice(),song,albums[i].getRating());
					if(k<artistCount) {
					artists[k]=album;	
					k++;}				
			}
		}
	
		Album expensive = artists[0];
		for (int j = 0; j < artistCount; j++) {
			if (artists[j].getPrice() > expensive.getPrice()) {
				expensive = artists[j];
			}
		}

		System.out.println("Get most expensive album in which a given artist have worked");
		System.out.println("album id: " + expensive.getId() + ", album name:" + expensive.getName() + ", album price: "
				+ expensive.getPrice() + ",album rating: " + expensive.getRating());

		if (flag == 1) {
			return true;
		}
		return false;
	}

	// get sort the albums based on name descending order
	private static Album[] getSortedAlbumsBasedOnName(Album[] albums) {
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count - i - 1; j++) {
				if (albums[j].getName().compareToIgnoreCase(albums[j + 1].getName()) < 0) {
					Album temp = albums[j];
					albums[j] = albums[j + 1];
					albums[j + 1] = temp;
				}
			}
		}
		return albums;
	}

	// sorted albums based on rating
	private static Album[] getSortedAlbumsBasedOnRating(Album[] albums) {
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count - 1; j++) {
				if (albums[j].getRating() > albums[j + 1].getRating()) {
					Album temp = albums[j];
					albums[j] = albums[j + 1];
					albums[j + 1] = temp;
				}
			}
		}
		return albums;
	}

//sorted albums based on price
	private static Album[] getSortedAlbumsBasedOnPrice(Album[] albums) {
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count - 1; j++) {
				if (albums[j].getPrice() > albums[j + 1].getPrice()) {
					Album temp = albums[j];
					albums[j] = albums[j + 1];
					albums[j + 1] = temp;
				} else {
					getSortedAlbumsBasedOnRating(albums);
				}
			}
		}
		return albums;
	}

//get number of languages by given artist
	private static boolean getLanguagesByArtist(Album[] albums) {
		System.out.println("enter artist name:");
		String name = vs.validateString(sc.next());
		int flag = 0;
		int languageCount = 0;
		for (int i = 0; i < count; i++) {
			if (albums[i].songs.artist.getName().equalsIgnoreCase(name)) {
				flag = 1;
				/*
				 * System.out.println(" song language: "+ albums[i].songs.getLanguage() +
				 * " artist name: " + albums[i].songs.artist.getName() + " artist age: ");
				 */
				languageCount++;
			}
		}
		System.out.println("languages count:" + languageCount);
		String languages[] = new String[languageCount];
		for (int i = 0; i < languageCount; i++) {
			if (albums[i].songs.artist.getName().equalsIgnoreCase(name)) {
				flag = 1;
				languages[i] = albums[i].songs.getLanguage();
				System.out.println(languages[i]);
			}
		}
		/*
		 * int j; for (int i = 0; i < languages.length; i++) { for (j = 0; j <
		 * languages.length; j++) { if (languages[i].equals(languages[j]) && i != j) {
		 * break; } if (j == languages.length) { System.out.println(languages[i]); } } }
		 */
		if (flag == 1) {
			return true;
		}
		return false;
	}

	// get songs details by artist
	private static boolean getSongsByArtist(Album[] albums) {
		System.out.println("enter artist name:");
		String name = vs.validateString(sc.next());
		int flag = 0;
		for (int i = 0; i < count; i++) {
			if (albums[i].songs.artist.getName().equalsIgnoreCase(name)) {
				flag = 1;
				System.out.println("\nsong id: " + albums[i].songs.getId() + " =song name: " + albums[i].songs.getName()
						+ "=song likes: " + albums[i].songs.getLikes() + " =song language: "
						+ albums[i].songs.getLanguage() + "\nArtistId: " + albums[i].songs.artist.getId()
						+ " =artist name: " + albums[i].songs.artist.getName() + " =artist age: "
						+ albums[i].songs.artist.getAge() + "=artist gender:  " + albums[i].songs.artist.getGender());
			}
		}
		if (flag == 1) {
			return true;
		}

		return false;
	}

	// display details of the album
	public static void displayDetails(Album[] albums) {
		for (int i = 0; i < count; i++) {
			System.out.println("*******ALBUM*****" + (i + 1));
			System.out.println("album id: " + albums[i].getId() + ", album name:" + albums[i].getName()
					+ ", album price: " + albums[i].getPrice() + ",album rating: " + albums[i].getRating()
					+ "\nsong id: " + albums[i].songs.getId() + " ,song name:" + albums[i].songs.getName()
					+ ",song likes: " + albums[i].songs.getLikes() + " ,song language: " + albums[i].songs.getLanguage()
					+ "\nArtistId: " + albums[i].songs.artist.getId() + " ,artist name: "
					+ albums[i].songs.artist.getName() + " ,artist age:" + albums[i].songs.artist.getAge()
					+ ",artist gender: " + albums[i].songs.artist.getGender());
		}
	}

	// create albumns
	private static void createAlubums(Album[] albums) {
		System.out.println("enter number of albums");
		int number = vs.validateInt(sc.nextInt());

		for (int i = 0; i < number; i++) {
			System.out.println("albums:******" + (i + 1));
			System.out.println("enter album id:");
			int id = vs.validateInt(sc.nextInt());
			int uniqueId = 0;
			if (i > 0) {
				uniqueId = getUniqueId(id, albums, i);
			} else {
				uniqueId = id;
			}
			System.out.println("enter name of album");
			String name = vs.validateString(sc.next());
			System.out.println("enter price of album");
			double price = vs.validatePrice(sc.nextDouble());
			// songs creation
			System.out.println("enter number of songs");
			int number1 = vs.validateInt(sc.nextInt());
			for (int j = 0; j < number1; j++) {
				Song songs[] = new Song[number1];
				System.out.println("enter song id:");
				int sid = vs.validateInt(sc.nextInt());
				System.out.println("enter name of song");
				String sName = vs.validateString(sc.next());
				// artist details
				System.out.println("enter artist id:");
				int aid = vs.validateInt(sc.nextInt());
				System.out.println("enter name of artist");
				String aName = vs.validateString(sc.next());
				System.out.println("enter gender of artist");
				char aGender = vs.validateGender(sc.next().charAt(0));
				System.out.println("enter artist age:");
				int age = vs.validateAge(sc.nextInt());
				Artist artist = new Artist(aid, aName, aGender, age);
				// continuation of songs details
				System.out.println("enter likes of songs");
				String likes = vs.validateString(sc.next());
				System.out.println("enter langauge of song");
				String language = vs.validateLanguage(sc.next());
				// create song object
				Song song = new Song(sid, sName, artist, likes, language);
				System.out.println("enter rating of album");
				double rating = vs.validateRating(sc.nextDouble());
				Album album = new Album(uniqueId, name, price, song, rating);
				// System.out.println(album);
				albums[count] = album;
				count++;
			}
		}
	}

	// get unique id
	private static int getUniqueId(int id, Album[] albums, int i) {
		boolean isValid = true;
		while (isValid) {
			int flag = 0;
			for (int j = 0; j < i; j++) {
				if (albums[j].getId() == id) {
					flag = 1;
				}
				if (flag == 1) {
					System.out.println("album id is already exist:once again enter:");
					id = sc.nextInt();
				} else {
					isValid = false;
				}
			}
		}
		return id;
	}
}
