package com.villeneuve.justin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputOutput {
    public static Graph readFile(String inputFile) {
        ClassLoader classLoader = Main.class.getClassLoader();
        File file = new File(classLoader.getResource(inputFile).getFile());

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n = Integer.parseInt(scanner.nextLine()); // number of vertices in the graph

        Double[][] adjMatrix = new Double[n][n];
        List<List<Integer>> edges = new ArrayList<>();

        while(scanner.hasNext()) {
            String[] lineArr = scanner.nextLine().split(" ");
            int u = Integer.parseInt(lineArr[0]);
            int v = Integer.parseInt(lineArr[1]);
            double w = Double.parseDouble(lineArr[2]); // weight

            List<Integer> e = new ArrayList<>(2);
            e.add(u);
            e.add(v);
            edges.add(e);

            adjMatrix[u][v] = -Math.log(w);
        }

        return new Graph(n, adjMatrix, edges);
    }

    public static void writeFile(String output, String content) {
        String path = System.getProperty("user.dir") + "/data/" + output;


        FileWriter out = null;
        try {
            out = new FileWriter(path, true);
            out.write(content);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
