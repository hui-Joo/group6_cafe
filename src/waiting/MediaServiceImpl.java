package waiting;

import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Window;

public class MediaServiceImpl implements MediaService {

	MediaPlayer mediaPlayer;
	MediaView mediaView;
	boolean endOfMedia;
	Controller cont = new Controller();

	ProgressBar progressBar;

	public void setControl(Parent root) {
		mediaView = (MediaView) root.lookup("#fxMediaView");
		progressBar = (ProgressBar) root.lookup("#progressBar");
	}

	public void setMedia(Parent root) {
		setControl(root);
		Media media = new Media(getClass().getResource("/media/coffee_mv.mp4").toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.setOnReady(new Runnable() {

			public void run() {

				mediaPlayer.currentTimeProperty().addListener((a, b, c) -> {
					double progress = mediaPlayer.getCurrentTime().toSeconds()
							/ mediaPlayer.getTotalDuration().toSeconds();
					progressBar.setProgress(progress);

				});
			}
			

			});
		
		mediaPlayer.setOnEndOfMedia(()->{
			cont.setNewStage();
			
		});

	}

	public void myPlay() {
		mediaPlayer.play();
	}
	
	public void myStop() {
		mediaPlayer.stop();
	}

}
