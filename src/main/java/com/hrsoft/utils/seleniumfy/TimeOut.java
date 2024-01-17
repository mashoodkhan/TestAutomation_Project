package com.hrsoft.utils.seleniumfy;
import static com.hrsoft.reports.ExtentLogger.*;

/**
 * @author Annameni Srinivas
 *  <a href="mailto:sannameni@gmail.com">sannameni@gmail.com</a>
 */
public class TimeOut {

        long _timeout;
        long _retry;

        /**
         * Constructor method
         * 
         * @param millis
         *            Timeout value (in milliseconds)
         * @param retry
         *            Sleep time in between retries (in milliseconds)
         */
        public TimeOut (long millis, long retry) {
            _retry = retry;
            _timeout = System.currentTimeMillis () + millis;
        }

        /**
         * Wait for the next instruction
         */
        public void Wait () {
            try {
                Thread.sleep (_retry);
            } catch (InterruptedException e) {
//                info (e.getMessage ());
            }
        }

        /**
         * Check to see if it has timedout or not
         * 
         * @return True if it has timedout, otherwise false
         */
        public boolean Timedout () {
            return System.currentTimeMillis () > _timeout;
        }
    }
