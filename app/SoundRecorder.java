import javax.sound.sampled.*;
import java.io.*;

/**
 * Make it so that functions can be invoked/stopped with external functions
 *
 */

public class SoundRecorder
{
	// static final long RECORD_TIME = 600000;
	

	// some variables
	File wavFile;
	AudioFileFormat.Type fileType;
	TargetDataLine line;
	
	public SoundRecorder(String filename)
	{
		// what to do with these variables?
		wavFile = new File(filename);
		fileType = AudioFileFormat.Type.WAVE;
	}

	AudioFormat getAudioFormat()
        {
                 float sampleRate = 16000;
                 int sampleSizeInBits = 8;
                 int channels = 2;
                 boolean signed = true;
                  boolean bigEndian = true;
                  AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
                  return format;
        }

	void start()
	{
		try
		{
			AudioFormat format = getAudioFormat();
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
			
			if (!AudioSystem.isLineSupported(info))
			{
				System.out.println("Line not supported");
				System.exit(0);
			}

			line = (TargetDataLine) AudioSystem.getLine(info);
			line.open(format);
			line.start();

			System.out.println("Begin capturing");

			AudioInputStream ais = new AudioInputStream(line);

			System.out.println("Begin recording");

			AudioSystem.write(ais, fileType, wavFile);
		} catch (LineUnavailableException ex)
		{
			ex.printStackTrace();
		} catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	void finish()
	{
		line.stop();
		line.close();
		System.out.println("Record finished");
	}
}
