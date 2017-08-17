package wheelOfJeopardy;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



public class TimeKeeper {

        private int NumberOfSeconds;
        private final List<TimeKeeperListener> Listeners = new ArrayList<>(); 
	Timer Timer = new Timer();
        TimerTask Task;

    public TimeKeeper() {
        this.Task = new TimerTask(){
            @Override
            public void run(){
                Listeners.stream().forEach((theListener) -> {
                    theListener.onTimeChange();
                });

                if (NumberOfSeconds == 0){
                    Timer.cancel();
                    Timer.purge();
                }
                else{
                    --NumberOfSeconds;
                }
            }
        };
    }
        
	public void startTimer(int theDuration){
		this.NumberOfSeconds = theDuration;
                this.Timer.scheduleAtFixedRate(this.Task, 0, 1000);
	}
	public void stopTimer(){
            this.Timer.cancel();
            this.Timer.purge();
	}
	public void pauseTimer(){
            this.Timer.cancel();
	}
	public void continueTimer(){
            this.Timer = new Timer();
            this.Timer.scheduleAtFixedRate(this.Task, 0, 1000);
	}
        
        public int getNumberOfSeconds(){
            return this.NumberOfSeconds;
        }
        
        public void addListener(TimeKeeperListener theListener){
            this.Listeners.add(theListener);
        }
}
