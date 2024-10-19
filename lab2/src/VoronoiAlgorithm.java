import java.io.FileWriter;
import java.io.IOException;

public class VoronoiAlgorithm {

    private static final double DX = 0.01;

    public static void main(String[] args) {
        double[][] points = {
            {12, 45}, {23, 87}, {62, 56}, {92, 84}, {28, 34}, {7, 75}
        };
        int numPoints = points.length;

        savePointsToFile(points, "points.dat");

        try (FileWriter writer = new FileWriter("results.dat")) {
            for (double xCoord = 0; xCoord < 100.0; xCoord += DX) {
                for (double yCoord = 0; yCoord < 100.0; yCoord += DX) {
                    double[] distances = calculateDistances(points, xCoord, yCoord, numPoints);
                    int[] nearestPoints = findNearestPoints(distances, numPoints);
                    int closestIndex1 = nearestPoints[0];
                    int closestIndex2 = nearestPoints[1];

                    double distanceDifference = distances[closestIndex1] - distances[closestIndex2];

                    if (Math.abs(distanceDifference) < DX) {
                        double deltaX = points[closestIndex1][0] - points[closestIndex2][0];
                        double deltaY = points[closestIndex1][1] - points[closestIndex2][1];

                        double magnitude = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
                        deltaX /= magnitude;
                        deltaY /= magnitude;

                        double magicFactor = 4;
                        double newX = xCoord + magicFactor * distanceDifference * deltaX;
                        double newY = yCoord + magicFactor * distanceDifference * deltaY;

                        writer.write(String.format("%.3f %.3f\n", newX, newY));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double[] calculateDistances(double[][] points, double x, double y, int numPoints) {
        double[] distances = new double[numPoints];
        for (int i = 0; i < numPoints; i++) {
            distances[i] = Math.sqrt(Math.pow(points[i][0] - x, 2) + Math.pow(points[i][1] - y, 2));
        }
        return distances;
    }

    private static int[] findNearestPoints(double[] distances, int numPoints) {
        int closestIndex1 = 0;
        int closestIndex2 = 1;

        for (int i = 1; i < numPoints; i++) {
            if (distances[i] < distances[closestIndex1]) {
                closestIndex2 = closestIndex1;
                closestIndex1 = i;
            } else if (i != closestIndex1 && distances[i] < distances[closestIndex2]) {
                closestIndex2 = i;
            }
        }
        return new int[]{closestIndex1, closestIndex2};
    }

    private static void savePointsToFile(double[][] points, String filename) {
        try (FileWriter pointWriter = new FileWriter(filename)) {
            for (double[] point : points) {
                pointWriter.write(String.format("%.3f %.3f\n", point[0], point[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}