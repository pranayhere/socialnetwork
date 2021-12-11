package io.socialnetwork.processors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CliInputProcessor implements InputProcessor {
    @Override
    public void process() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String input = br.readLine();
                System.out.println("ip: " + input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
