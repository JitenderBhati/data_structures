import java.util.*;

class spot {
    int i, j;
    int value;
    spot parent = null;
    int f = 0, g = 0, h = 0;
    ArrayList<spot> neighbour = new ArrayList<>();

    public spot(int value, int i, int j) {
        this.value = value;
        this.i = i;
        this.j = j;

    }
}

public class launcher {
    static int row = 3;
    static int cols = 3;
    static spot[][] grid = new spot[row][cols];
    static ArrayList<spot> path = new ArrayList<>();
    static int heruistic(spot a, spot b) {
        int d = Math.abs(a.i - b.i) - Math.abs(a.j - b.j);
        return d;
    }

    public static void main(String[] args) {
        System.out.println("Enter the data in grid: ");
        Scanner sc = new Scanner(System.in);
        // populate grid with node
        int data = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                // int data = sc.nextInt();
                grid[i][j] = new spot(data, i, j);
                data++;
            }
        }

        // adding neighbour of each node

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (i < row - 1) {
                    grid[i][j].neighbour.add(grid[i + 1][j]);
                }
                if (i > 0) {
                    grid[i][j].neighbour.add(grid[i - 1][j]);
                }
                if (j > 0) {
                    grid[i][j].neighbour.add(grid[i][j - 1]);
                }
                if (j < cols - 1) {
                    grid[i][j].neighbour.add(grid[i][j + 1]);
                }
            }
        }
        final spot start = grid[0][0];
        final spot end = grid[2][2];

        ArrayList<spot> openSet = new ArrayList<>();
        ArrayList<spot> closedSet = new ArrayList<>();
        openSet.add(start);
        while (openSet.size() > 0) {
            int winner = 0;
            boolean flag = false;
            for (int i = 0; i < openSet.size(); i++) {
                if (openSet.get(i).f < openSet.get(winner).f) {
                    winner = i;
                }
                spot current = openSet.get(winner);
                //System.out.println(current.value);
                if (current == end) {
                    System.out.println("Done!");
                    flag = true;
                    spot temp = current;
                    path.add(temp);
                    while (temp.parent!=null) {                      
                        path.add(temp.parent);
                        temp = temp.parent;
                    }
                    Collections.reverse(path);
                    break;
                }

                closedSet.add(current);
                openSet.remove(current);
                for (spot neighbor : current.neighbour) {
                    if (!closedSet.contains(neighbor)) {
                        int tempG = current.g + 1;
                        if (openSet.contains(neighbor)) {
                            if (tempG < neighbor.g) {
                                neighbor.g = tempG;
                            }
                        } else {
                            openSet.add(neighbor);
                            neighbor.g = tempG;
                        }
                        neighbor.h = heruistic(neighbor, end);
                        neighbor.f = neighbor.g + neighbor.h;
                        neighbor.parent = current;
                    }
                    
                }
            }
            if (flag)
                break;

        }
        for (int i = 0; i < path.size(); i++) {
            if (i == path.size() - 1) {
                System.out.println(path.get(i).value);
            } else
                System.out.print(path.get(i).value + "-->");
        }
    }
}