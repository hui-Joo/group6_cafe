package main;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaServiceImpl {

	private MediaPlayer mediaPlay;
	private MediaView mediaView;
	private Button btnPlay;
	private Button btnPause;
	private Button btnStop;
	private boolean endOfmedia;
	
	private Label labelTime;
	private Slider sliderVolume;
	private ProgressBar progressBar;
	private ProgressIndicator progressIndicator;
	public void volumeController() {
		mediaPlay.setVolume(sliderVolume.getValue() / 100.0);
	}
	private void seVontroller (Parent root) {
		mediaView = (MediaView) root.lookup("#fxMediaView");
		btnPlay = (Button) root.lookup("#btnPlay");
		btnPause = (Button) root.lookup("#btnPause");
		btnStop = (Button) root.lookup("#btnStop");
		
		labelTime = (Label) root.lookup("#labelTime");
		sliderVolume = (Slider) root.lookup("#sliderVolume");
		progressBar = (ProgressBar) root.lookup("#progressBar");
		progressIndicator = (ProgressIndicator) root.lookup("#progressIndeicator");
	}
	
	public void setMedia(Parent root, String mediaName) {
		Media media = new Media(getClass().getResource(mediaName).toString()); 
		seVontroller(root);
		mediaPlay = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlay);
		mediaPlay.setOnReady(new Runnable() {
			
	public void run() {
		btnPlay.setDisable(false);
		btnPause.setDisable(true);
		btnStop.setDisable(true);
		
		mediaPlay.currentTimeProperty().addListener((obj, oldv, newv)->{
			double progress = mediaPlay.getCurrentTime().toSeconds() / mediaPlay.getTotalDuration().toSeconds();
			progressBar.setProgress(progress);
			progressIndicator.setProgress(progress);
			labelTime.setText(
			(int) mediaPlay.getCurrentTime().toSeconds()+"/"+
			(int) mediaPlay.getTotalDuration().toSeconds()+" sec"
			);
		});
		}
	});
		
		mediaPlay.setOnPlaying(()->{
			btnPlay.setDisable(true);
			btnPause.setDisable(false);
			btnStop.setDisable(false);
		});
		
		mediaPlay.setOnPaused(()->{
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(false);
		});
		mediaPlay.setOnStopped(()->{
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});
		mediaPlay.setOnEndOfMedia(()->{
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});
	}
	public void myStart() {
		if(endOfmedia) {
			mediaPlay.stop();
			mediaPlay.seek(mediaPlay.getStartTime());
		}
		endOfmedia = false;
	}
	public void myPause() {
		mediaPlay.pause();
	}
	public void myStop() {
		mediaPlay.stop();
	}
}
