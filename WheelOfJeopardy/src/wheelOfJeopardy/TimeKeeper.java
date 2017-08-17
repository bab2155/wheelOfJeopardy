package wheelOfJeopardy;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



public class TimeKeeper
{
    // Instance variables
    private int NumberOfSeconds;
    private boolean increasingInTime = false;
    private final List<TimeKeeperListener> Listeners = new ArrayList<TimeKeeperListener>( );
	Timer Timer = new Timer( );

    TimerTask Task = new TimerTask( )
    {
        @Override
        public void run( ){
            for ( TimeKeeperListener theListener : Listeners ){
                theListener.onTimeChange( );
            }

            if (!increasingInTime){
                if ( NumberOfSeconds == 0){
                    Timer.cancel();
                    Timer.purge();
                }
                else
                {
                    --NumberOfSeconds;
                }
            }
            else{
                ++NumberOfSeconds;
            }
        }
    };

    /**
     * start the timer
     *
     * @param theDuration duration of the time allowed
     */
    public void startTimer( int theDuration )
    {
	this.NumberOfSeconds = theDuration;
        this.Timer.scheduleAtFixedRate( this.Task, 0, 1000 );
    }

    public void startStopWatch()
    {
        this.increasingInTime = true;
        this.Timer.scheduleAtFixedRate( this.Task, 0, 1000 );
    }
    
    /**
     * stop the timer
     */
	public void stopTimer( )
    {
        this.Timer.cancel();
        this.Timer.purge();
	}

    /**
     * pause the timer
     */
	public void pauseTimer( )
    {
        this.Timer.cancel( );
	}

    /**
     * continue the timer
     */
	public void continueTimer( )
    {
        this.Timer = new Timer( );
        this.Timer.scheduleAtFixedRate( this.Task, 0, 1000 );
	}

    /**
     * returns number of seconds
     *
     * @return numberOfSeconds
     */
    public int getNumberOfSeconds( )
    {
        return this.NumberOfSeconds;
    }

    /**
     *
     * @param theListener listens for changes from gui
     */
    public void addListener( TimeKeeperListener theListener )
    {
        this.Listeners.add(theListener);
    }
}
