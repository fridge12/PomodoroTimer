import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Timer extends Thread {

    @Override
    public void run() {
    while (true){

        System.out.println("thread running \nremaining " + Pomodoro_timer.time_remaining+"\nelapsed "+Pomodoro_timer.time_elapsed+"\ntotal elapsed "+Pomodoro_timer.total_time_elapsed);
        try {
            sleep(60000);
            Pomodoro_timer.time_remaining--;
            Pomodoro_timer.timerTime.setText(String.valueOf(Pomodoro_timer.time_remaining));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if(Pomodoro_timer.time_remaining==0){
            Pomodoro_timer.play();
        }
        Pomodoro_timer.time_elapsed++;

        System.gc();
    }
    }


}
