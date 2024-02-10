package com.villeneuve.justin;

import java.util.List;


/**
 * If a negative cycle is found, then there is an arbitrage opportunity
 */

public class Main {
    public static void main(String[] args) {
        String in = args[0]; // input file
        String out = args[1]; // output file

        Graph G = InputOutput.readFile(in);

        boolean negCycleFound = G.bellmanFord();

        if (!negCycleFound) {
            InputOutput.writeFile(out, "NO ARBITRAGE\n");
        } else {
            List<Integer> verticesInCycle = G.findNegativeCycle();
            StringBuilder s = new StringBuilder();
            s.append("ARBITRAGE OPPORTUNITY : ");
            s.append(verticesInCycle.get(0));

            for (int i = 1 ; i < verticesInCycle.size(); i++) {
                s.append(" => " + verticesInCycle.get(i));
            }
            s.append("\n");

            InputOutput.writeFile(out, s.toString());
        }

    }
}
