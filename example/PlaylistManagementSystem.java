// Song Class
class Song {
    private String title;

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// Iterator Interface
interface Iterator {
    boolean hasNext();
    Song next();
}

// Playlist Class
class Playlist {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public Iterator getIterator() {
        return new PlaylistIterator();
    }

    private class PlaylistIterator implements Iterator {
        private int index = 0;

        public boolean hasNext() {
            return index < songs.size();
        }

        public Song next() {
            if (this.hasNext()) {
                return songs.get(index++);
            }
            return null;
        }
    }
}

// Main Class
public class PlaylistManagementSystem {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong(new Song("Song 1"));
        playlist.addSong(new Song("Song 2"));

        Iterator iterator = playlist.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }
    }
}
