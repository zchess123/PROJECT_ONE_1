package test.java;

import java.util.HashSet;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 * This class provides a set of unit tests for the {@code Talk} classes
 * using the JUnit testing framework and the Java Reflection API.
 */
public class TalkTest {

  // TODO: will be upated by instructor

  public static void main(String[] args) {
    System.out.println("Running tests...\n");

    JUnitCore junitCore = new JUnitCore();
    junitCore.addListener(new CustomRunListener());
    Result result;

    long startTime = System.currentTimeMillis();
    if (args.length == 0 || args[0].toLowerCase().equals("all")) {
      result = junitCore.run(TalkTest.class);
    } else {
      Request request = Request.method(TalkTest.class, args[0]);
      result = junitCore.run(request);
    }
    long testTime = System.currentTimeMillis() - startTime;
    int passingCount = result.getRunCount() - result.getFailureCount();

    System.out.println(String.format("%d passing (%dms)", passingCount, testTime));
    if (result.wasSuccessful()) {
      System.out.println("\u001B[32mALL TESTS PASSED!\u001B[0m\n");
    } else {
      System.out.println("\u001B[31m" + result.getFailureCount() + " TEST FAILURES\u001B[0m\n");
    }

    System.exit(result.wasSuccessful() ? 0 : 1);
  }

  private static class CustomRunListener extends RunListener {

    HashSet<String> failures = new HashSet<>();

    @Override
    public void testFailure(Failure failure) throws Exception {
      this.failures.add(failure.getDescription().getMethodName());
      System.out.println("\u001B[31mFAILED: " + failure.toString() + "\u001B[0m");
    }

    @Override
    public void testFinished(Description description) throws Exception {
      if (!this.failures.contains(description.getMethodName())) {
        System.out.println("\u2714 \u001B[32mPASSED: " + description.getMethodName() + "\u001B[0m");
      }
      System.out.println();
    }

    @Override
    public void testStarted(Description description) throws Exception {
      System.out.println("#" + description.getMethodName());
    }
  }
}
