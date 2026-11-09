
package com.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testApplicationOutput() {

        // Capture console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(output));

        try {
            // Run the application
            App.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String result = output.toString();

        // Verify expected output
        assertTrue(result.contains("Welcome to Java CI/CD App"));
        assertTrue(result.contains("Application: Java Maven App"));
        assertTrue(result.contains("Build Tool: Maven"));
        assertTrue(result.contains("CI/CD Tool: Jenkins"));
        assertTrue(result.contains("Deployment: Docker on AWS EC2"));
        assertTrue(result.contains("Application deployed successfully!"));
    }
}
