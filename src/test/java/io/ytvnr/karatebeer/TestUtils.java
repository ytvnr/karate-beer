package io.ytvnr.karatebeer;

import java.time.Instant;

public class TestUtils {
  public static final void logTime() {
    System.err.println("We are in karate: " + Instant.now());
  }
}
