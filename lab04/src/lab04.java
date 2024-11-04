public class lab04 {

    public static void main(String[] args)
    {
        int size_x = Integer.parseInt(args[0]);
        int size_y = Integer.parseInt(args[1]);
        int steps = Integer.parseInt(args[2]);
        int preset = Integer.parseInt(args[3]);

        GameOfLife game = new GameOfLife(size_x, size_y, preset);
        for (int i = 0; i < steps; i++) {
            System.out.println("------ " + (i + 1) + " -------");
            game.display();
            game.update();
        }
    }
}

    class GameOfLife {
        private final int size_x;
        private final int size_y;
        private final int offset_x;
        private final int offset_y;
        private boolean[][] board;

        public GameOfLife(int size_x, int size_y, int preset) {
            this.size_x = size_x;
            this.size_y = size_y;
            this.offset_x = size_x / 2 - 1;
            this.offset_y = size_y / 2 - 1;
            this.board = new boolean[size_x][size_y];

            switch (preset) {
                case 1:
                    preset1();
                    break;
                case 2:
                    preset2();
                    break;
                case 3:
                    preset3();
                    break;
                default:
                    random();
                    break;
            }
        }

        public void update()
        {
            boolean[][] newBoard = new boolean[size_y][size_x];

            for (int y = 0; y < size_y; y++) {
                for (int x = 0; x < size_x; x++) {
                    int liveNeighbors = countLiveNeighbors(board, y, x);
                    if (board[y][x]) {
                        newBoard[y][x] = liveNeighbors == 2 || liveNeighbors == 3;
                    } else {
                        newBoard[y][x] = liveNeighbors == 3;
                    }
                }
            }

            board = newBoard;
        }

        public void display()
        {
            for (boolean[] booleans : board) {
                for (int x = 0; x < board[0].length; x++) {
                    System.out.print(booleans[x] ? "X" : ".");
                }
                System.out.println();
            }
        }

        public void random() {
            for (int y = 0; y < size_y; y++) {
                for (int x = 0; x < size_x; x++) {
                    board[y][x] = Math.random() <= 0.5;
                }
            }
        }

        public void preset1(){
            boolean[][] boat = {
                    {true, true, false},
                    {true, false, true},
                    {false, true, false}
            };

            placePattern(boat);
        }

        private void placePattern(boolean[][] boat) {
            for(int y = 0; y < board.length && y < boat.length; ++y ) {
                for(int x = 0; x < board[y].length && x < boat[0].length; ++x){
                    this.board[this.offset_y + y][this.offset_x + x] = boat[y][x];
                }
            }
        }

        public void preset2() {
            boolean[][] blinker = {
                    {false, false, false},
                    {true, true, true},
                    {false, false, false}
            };

            placePattern(blinker);
        }

        public void preset3() {
            boolean [][] glider = {
                    {true, true, true},
                    {true, false, false},
                    {false, true, false}
            };

            placePattern(glider);
        }

        public int countLiveNeighbors(boolean[][] board, int y, int x) {
            int count = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue; // pomiń samą komórkę
                    int newY = y + i;
                    int newX = x + j;
                    if (newY >= 0 && newY < board.length && newX >= 0 && newX < board[0].length) {
                        if (board[newY][newX]) count++;
                    }
                }
            }
            return count;
        }
    }