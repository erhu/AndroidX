package cn.erhu.android.flog;

import android.text.TextUtils;
import android.util.Log;

/**
 * FLog
 *
 * @author hujunjie
 * @version 1.1
 * @since 14-11-11 10:38
 */
public class FLog {

    private static final int THREAD_STR_LENGTH = 15;
    private static final int STACK_STR_LENGTH = 50;

    private static final String LOG_FORMATTER = "❖❖❖  %s  %s ❖❖❖  %s";

    public static boolean isDebuggable() {
        return FConfig.DEBUG;
    }

    public static void logDebug(String tag, String msg) {
        if (isDebuggable()) {
            Log.d(tag, String.format(LOG_FORMATTER, threadName(), stackInfo(new Throwable().getStackTrace()), msg));
        }
    }

    public static void logDebug(String tag, String fmt, Object... obj) {
        if (isDebuggable()) {
            Log.d(tag, String.format(
                    String.format(LOG_FORMATTER, threadName(), stackInfo(new Throwable().getStackTrace()), fmt), obj));
        }
    }

    public static void logInfo(String tag, String msg) {
        if (isDebuggable()) {
            Log.i(tag, String.format(LOG_FORMATTER, threadName(), stackInfo(new Throwable().getStackTrace()), msg));
        }
    }

    public static void logInfo(String tag, String fmt, Object... obj) {
        if (isDebuggable()) {
            Log.i(tag, String.format(
                    String.format(LOG_FORMATTER, threadName(), stackInfo(new Throwable().getStackTrace()), fmt), obj));
        }
    }

    public static void logError(String tag, String msg) {
        if (isDebuggable()) {
            Log.e(tag, String.format(LOG_FORMATTER, threadName(), stackInfo(new Throwable().getStackTrace()), msg));
        }
    }

    public static void logError(String tag, String fmt, Object... obj) {
        if (isDebuggable()) {
            Log.e(tag, String.format(
                    String.format(LOG_FORMATTER, threadName(), stackInfo(new Throwable().getStackTrace()), fmt), obj));
        }
    }

    public static void logWarn(String tag, String msg) {
        if (isDebuggable()) {
            Log.w(tag, String.format(LOG_FORMATTER, threadName(), stackInfo(new Throwable().getStackTrace()), msg));
        }
    }

    public static void logWarn(String tag, String fmt, Object... obj) {
        if (isDebuggable()) {
            Log.w(tag, String.format(
                    String.format(LOG_FORMATTER, threadName(), stackInfo(new Throwable().getStackTrace()), fmt), obj));
        }
    }

    /**
     * stacktrace
     */
    private static String stackInfo(StackTraceElement[] traces) {
        String str = "";
        if (traces.length > 1 && traces[1] != null) {
            String fileName = traces[1].getFileName();
            int lastDotIndex = fileName.lastIndexOf(".");
            fileName = fileName.substring(0, lastDotIndex);
            str = String.format("%s.%s():%d", fileName, traces[1].getMethodName(), traces[1].getLineNumber());
        }
        return fixStringLength(str, STACK_STR_LENGTH);
    }

    public static void printStackTrace() {
        printStackTrace(null);
    }

    public static void printStackTrace(String tag) {
        if (isDebuggable()) {
            if (TextUtils.isEmpty(tag)) {
                return;
            }

            StringBuilder sb = new StringBuilder();
            StackTraceElement[] stackElements = new Throwable().getStackTrace();
            if (stackElements != null) {
                for (int i = 0; i < stackElements.length; i++) {
                    sb.append(stackElements[i]);
                    if (i != stackElements.length - 1) {
                        sb.append("\n\t");
                    }
                }
                if (TextUtils.isEmpty(tag)) {
                    System.out.println(sb);
                } else {
                    logDebug(tag, sb.toString());
                }
            }
        }
    }

    /**
     * Thread Name
     */
    private static String threadName() {
        return fixStringLength(Thread.currentThread().getName(), THREAD_STR_LENGTH);
    }

    /**
     * Output string with fixed length
     */
    private static String fixStringLength(String s, int len) {
        if (s != null) {
            int l = s.length();
            while (l < len) {
                s += " ";
                l++;
            }

            if (l > 15) {
                s = s.substring(0, len);
            }
        }
        return s;
    }
}

