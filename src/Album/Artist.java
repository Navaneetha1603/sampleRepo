package Album;

public class Artist {
	private int id;
	private String name;
	private char gender;
	private int age;
	public Artist(int id, String name, char gender, int age) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
