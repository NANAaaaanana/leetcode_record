package learning.daliy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.text.Position;

/**
 * 874. Walking Robot Simulation
 * A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot can receive a sequence of these three possible types of commands:
 *
 * -2: Turn left 90 degrees.
 * -1: Turn right 90 degrees.
 * 1 <= k <= 9: Move forward k units, one unit at a time.
 * Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot runs into an obstacle, then it will instead stay in its current location and move on to the next command.
 *
 * Return the maximum Euclidean distance that the robot ever gets from the origin squared (i.e. if the distance is 5, return 25).
 */
public class WalkingRobotSimulation_874_0904 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] position = {0, 0};
        // 0 = north, 1 = east, 2 = south, 3 = west
        int orientation = 0;
        int result = 0;
        for (int i = 0; i < commands.length; i++) {
            System.out.println("orientation: " + orientation + " position: " + position[0] + " " + position[1] + " commands[i]: "+ commands[i]);

            if (commands[i] == -1) {
                orientation = (orientation + 1) % 4;
            } else if (commands[i] == -2) {
                orientation = (orientation + 3) % 4;
            } else {
                if(isObstacle(position, obstacles, orientation, commands[i])) {
                    position = Optional.ofNullable(adjustWhenObstacle(position, obstacles, orientation, commands[i]))
                                       .orElse(new int[] { 40000, 40000 });
                    if(position[0] == 40000 && position[1] == 40000) {
                        System.out.println("WARNING: UNEXPECT CONDITION");
                    }
                    result = Math.max(result, position[0] * position[0] + position[1] * position[1]);
                    continue;
                }
                position = move(position, orientation, commands[i]);
            }
            result = Math.max(result, position[0] * position[0] + position[1] * position[1]);
        }
        return result;
    }

    public boolean isObstacle(int[] position, int[][] obstacles, int orientation, int distance) {
        for (int i = 0; i < obstacles.length; i++) {
            if(orientation == 0 && obstacles[i][0] == position[0] && position[1] < obstacles[i][1] && position[1] + distance >= obstacles[i][1]
               ||orientation == 1 && obstacles[i][1] == position[1] && position[0] < obstacles[i][0] && position[0] + distance >= obstacles[i][0]
               || orientation == 2 && obstacles[i][0] == position[0] && position[1] > obstacles[i][1]  && position[1] - distance <= obstacles[i][1]
               || orientation == 3 && obstacles[i][1] == position[1] && position[0] > obstacles[i][0] && position[0] - distance <= obstacles[i][0] ) {
                return true;
            }
        }
        return false;
    }

    public int[] adjustWhenObstacle(int[] position, int[][] obstacles, int orientation, int distance) {
        List<Position> obstaclesList = Arrays.stream(obstacles).map(o -> new Position(o[0], o[1])).collect(Collectors.toList());

        if(orientation == 0 || orientation == 1) {
            obstaclesList.sort(Comparator.comparingInt(Position::getY).thenComparing(Position::getX));
        } else {
            obstaclesList.sort(Comparator.comparing(Position::getX, Comparator.reverseOrder()).thenComparing(Position::getY, Comparator.reverseOrder()));
        }

        for (Position obstacle: obstaclesList) {
            if(orientation == 0 && obstacle.getX() == position[0] && position[1] + distance >= obstacle.getY() && position[1] < obstacle.getY()) {
                return new int[]{obstacle.getX(), obstacle.getY() - 1};
            }
            if(orientation == 1 && obstacle.getY() == position[1] && position[0] + distance >= obstacle.getX() && position[0] < obstacle.getX()) {
                return new int[]{obstacle.getX() - 1, obstacle.getY()};
            }
            if(orientation == 2 && obstacle.getX() == position[0] && position[1] - distance <= obstacle.getY() && position[1] > obstacle.getY()) {
                return new int[]{obstacle.getX(), obstacle.getY() + 1};
            }
            if(orientation == 3 && obstacle.getY() == position[1] && position[0] - distance <= obstacle.getX() && position[0] > obstacle.getX()) {
                return new int[]{obstacle.getX() + 1, obstacle.getY()};
            }
        }
        return null;
    }


    public class Position {
        private int x;
        private int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        void setX(int x) {
            this.x = x;
        }

        void setY(int y) {
            this.y = y;
        }
    }

    public int[] move(int[] position, int orientation, int distance) {
        if(orientation == 0) {
            return new int[]{position[0], position[1] + distance};
        } else if(orientation == 1) {
            return new int[]{position[0] + distance, position[1]};
        } else if(orientation == 2) {
            return new int[]{position[0], position[1] - distance};
        } else {
            return new int[]{position[0] - distance, position[1]};
        }
    }

    public static void main(String[] args) {
        int[] commands = {7,-2,-2,7,5};
        int[][] obstacles = {{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,3},{2,2}};
        System.out.println(new WalkingRobotSimulation_874_0904().robotSim(commands, obstacles));
    }
}
