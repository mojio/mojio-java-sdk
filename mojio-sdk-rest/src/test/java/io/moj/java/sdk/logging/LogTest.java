package io.moj.java.sdk.logging;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Random;
import java.util.logging.Level;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class LogTest {

    @Before
    public void setup() {
        Log.clearLoggers();
    }

    /**
     * Verifies no exceptions are thrown when no loggers are set.
     */
    @Test
    public void testNoLoggers() {
        verifyLogLevel(Level.FINER);
        verifyLogLevel(Level.FINE);
        verifyLogLevel(Level.INFO);
        verifyLogLevel(Level.WARNING);
        verifyLogLevel(Level.SEVERE);
    }

    @Test
    public void testAppend() {
        String tag = "tag";
        String message = "message";

        Log.Logger logger = mock(Log.Logger.class);

        Log.append(logger);
        Log.d(tag, message);
        verify(logger).log(Level.FINE, tag, message, null);

        // add the same logger again and verify it gets executed 2 more times
        Log.append(logger);
        Log.w(tag, message);
        verify(logger, times(2)).log(Level.WARNING, tag, message, null);

        // append a different logger and verify it is invoked once
        Log.Logger otherLogger = mock(Log.Logger.class);
        Log.append(otherLogger);
        Log.e(tag, message);
        verify(otherLogger).log(Level.SEVERE, tag, message, null);
        verify(logger, times(2)).log(Level.SEVERE, tag, message, null);
    }

    @Test
    public void testClearLoggers() {
        // add and remove the logger
        Log.Logger logger = mock(Log.Logger.class);
        Log.append(logger);
        Log.clearLoggers();

        // verify our logger is not invoked
        Log.d("tag", "message");
        verify(logger, never()).log(any(Level.class), anyString(), anyString(), any(Throwable.class));
    }

    @Test
    public void testRemoveLogger() {
        // add and remove the logger
        Log.Logger logger = mock(Log.Logger.class);
        Log.append(logger);
        Log.remove(logger);

        // verify our logger is not invoked
        Log.d("tag", "message");
        verify(logger, never()).log(any(Level.class), anyString(), anyString(), any(Throwable.class));
    }

    @Test
    public void testV() {
        verifyLogLevel(Level.FINER);
    }

    @Test
    public void testD() {
        verifyLogLevel(Level.FINE);
    }

    @Test
    public void testI() {
        verifyLogLevel(Level.INFO);
    }

    @Test
    public void testW() {
        verifyLogLevel(Level.WARNING);
    }

    @Test
    public void testE() {
        verifyLogLevel(Level.SEVERE);
    }

    @SuppressWarnings("ThrowableInstanceNeverThrown")
    private void verifyLogLevel(Level level) {
        Random r = new Random();
        String tag = String.valueOf(r.nextInt());
        String msg = String.valueOf(r.nextInt());
        Throwable t = new Throwable();

        Log.Logger logger = mock(Log.Logger.class);
        Log.append(logger);

        if (level.equals(Level.FINER)) {
            Log.v(tag, msg);
            Log.v(tag, msg, t);
        } else if (level.equals(Level.FINE)) {
            Log.d(tag, msg);
            Log.d(tag, msg, t);
        } else if (level.equals(Level.INFO)) {
            Log.i(tag, msg);
            Log.i(tag, msg, t);
        } else if (level.equals(Level.WARNING)) {
            Log.w(tag, msg);
            Log.w(tag, msg, t);
        } else if (level.equals(Level.SEVERE)) {
            Log.e(tag, msg);
            Log.e(tag, msg, t);
        }

        verify(logger).log(level, tag, msg, null);
        verify(logger).log(level, tag, msg, t);
    }

}

