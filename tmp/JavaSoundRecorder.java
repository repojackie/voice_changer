
import javax.sound.sampled.*;
import java.io.*;


/**
 *	TEST FILE FOR CAPTURING SOUND
 *	from --> https://www.codejava.net/coding/capture-and-record-sound-into-wav-file-with-java-sound-api
 *
 */
public class JavaSoundRecorder {
	static final long RECORD_TIME = 60000;		// one minute

	File wavFile = new File("new_file.wav");

	AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;

	TargetDataLine line;

	AudioFormat getAudioFormat() {
		float sampleRate = 16000;
		int sampleSizeInBits = 8;
		int channels = 2;
		boolean signed = true;
		boolean bigEndian = true;
		AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
		return format;
	}

	/**
	 *  Captures the sound and records it into a WAV file
	 */

	void start() {
		try {
			AudioFormat format = getAudioFormat();
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

			// checking if system supports the data line
			if (!AudioSystem.isLineSupported(info)) {
				System.out.println("Line not supported");
				System.exit(0);
			}

			line = (TargetDataLine) AudioSystem.getLine(info);
			line.open(format);
			line.start();			// begin capturing

			System.out.println("Start capturing...");

			AudioInputStream ais = new AudioInputStream(line);

			System.out.println("Start recording...");

			// begin recording
			AudioSystem.write(ais, fileType, wavFile);
		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	void finish()
	{
		line.stop();
		line.close();
		System.out.println("Finished");
	}



	/*
	 * MAIN ENTRY POINT FOR PROGRAM
	 */

	public static void main(String[] args)
	{
		final JavaSoundRecorder recorder = new JavaSoundRecorder();

		// new thread that waits for a specified time before stoppping
		Thread stopper = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(RECORD_TIME);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

				recorder.finish();
			}
		});

		stopper.start();

		recorder.start();
	}
}
