package Album;

public class Album {
	private int id;
	private String name;
	private double price;
	Song songs;
	private double rating;
	public Album(int id, String name, double price, Song songs, double rating) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.songs = songs;
		this.rating = rating;
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
	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", price=" + price + ", songs=" + songs + ", rating=" + rating
				+ "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Song getSongs() {
		return songs;
	}
	public void setSongs(Song songs) {
		this.songs = songs;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
