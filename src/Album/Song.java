package Album;

public class Song {
	private int id;
	private String name;
	Artist artist;
	private String likes;
	private String language;
	public Song(int id, String name, Artist artist, String likes, String language) {
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.likes = likes;
		this.language = language;
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
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", likes=" + likes + ", language="
				+ language + "]";
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
