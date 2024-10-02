package structural;

interface MediaPlayer {
    void play(String audioType, String fileName);
}

class Mp3Player implements MediaPlayer {
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else {
            System.out.println("Invalid media type");
        }
    }
}

interface AdvancedMediaPlayer {
    void playMp4(String fileName);
}

class Mp4Player implements AdvancedMediaPlayer {
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

public class AdapterPattern {


	  
		public static void execute() {
	        MediaPlayer player = new Mp3Player();
	        player.play("mp3", "song.mp3");

	        MediaPlayer player2 = new MediaAdapter("mp4");
	        player2.play("mp4", "movie.mp4");
	    }
  
	

}
