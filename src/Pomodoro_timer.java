import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;

public class Pomodoro_timer {

    static JFrame frame;
    static int  time_remaining=0;
    static int time_elapsed=0;
    static int total_time_elapsed=0;
    static Timer t;
    static JTextField timerTime;

    public static void main(String args[]){

        //play();
        createFrame();

    }

    public static void createFrame(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(150,150);
        frameContents();
        frame.setVisible(true);
    }


    public static void frameContents(){
        frame.getContentPane().removeAll();
        frame.getContentPane().setLayout(new FlowLayout());
        t= new Timer();
        t.start();

        JLabel timerName = new JLabel();
        timerName.setPreferredSize(new Dimension(100,30));
        timerName.setText("BREAK");
        timerName.setVisible(true);
        timerTime = new JTextField();
        timerTime.setPreferredSize(new Dimension(100,30));
        timerTime.setText(String.valueOf(time_remaining));
        timerTime.setVisible(true);
        JButton breakButton = new JButton("START");
        breakButton.setPreferredSize(new Dimension(100,30));
        breakButton.addActionListener(e ->{
            System.out.println(time_remaining);
            if(total_time_elapsed>=100 && breakButton.getText().equals("BREAK")){
                time_remaining=total_time_elapsed/5;
                time_elapsed=0;
                total_time_elapsed=0;
                timerTime.setText(String.valueOf(time_remaining));
                timerName.setText("BREAK");
                breakButton.setText("START");
            }
            else if(breakButton.getText().equals("BREAK")){
                time_remaining= time_elapsed/5;
                total_time_elapsed+=time_elapsed;
                time_elapsed=0;
                timerTime.setText(String.valueOf(time_remaining));
                timerName.setText("BREAK");
                breakButton.setText("START");
            }
            else{
                time_remaining = 25;
                time_elapsed=0;
                timerTime.setText(String.valueOf(time_remaining));
                timerName.setText("TIMER");
                breakButton.setText("BREAK");
            }
            System.out.println(time_remaining);
        });
        breakButton.setVisible(true);

        frame.getContentPane().add(timerName);
        timerTime.setText(String.valueOf(time_remaining));
        frame.getContentPane().add(timerTime);
        frame.getContentPane().add(breakButton);
    }

    public static void play()
    {
        //stores position of where the sound is playing
        long currentFrame;
        //preloads the clip so it can be played from any where
        Clip clip;

        //plays the wav file
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Completion.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception e ){
            e.printStackTrace();
        }

    }
}
