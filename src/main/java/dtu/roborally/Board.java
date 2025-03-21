package dtu.roborally;

public class Board {
    //Class Attributes
    private static Tiles[][] board; //Matrix to create 'tile'
    private String[][] easyBoard =
            {       { "A", "A", "A", "A", "A", "A", "A", "A", "A", "A" },
                    { "2", "A", "A", "A", "A", "A", "A", "A", "A", "A" },
                    { "A", "2", "A", "A", "A", "P", "A", "P", "A", "A" },
                    { "A", "A", "A", "A", "A", "A", "A", "A", "A", "B" },
                    { "2", "A", "A", "A", "A", "Q", "A", "Q", "A", "A" },
                    { "A", "2", "A", "A", "A", "A", "A", "A", "A", "A" },
                    { "A", "A", "A", "A", "A", "A", "A", "A", "A", "A" },
                    { "A", "A", "A", "A", "A", "P", "A", "A", "A", "A" },
                    { "A", "A", "A", "A", "A", "A", "A", "A", "A", "A" },
                    { "A", "A", "A", "A", "A", "A", "A", "A", "A", "A" },
            };

    private String[][] mediumBoard =
            {       {"A", "A", "A", "A", "A", "A", "A", "A", "U", "B"},
                    {"A", "A", "A", "A", "A", "A", "S", "A", "A", "A"},
                    {"A", "A", "Z", "A", "A", "A", "A", "A", "A", "R"},
                    {"2", "A", "L", "A", "P", "A", "A", "A", "A", "A"},
                    {"2", "A", "L", "A", "Q", "A", "A", "I", "A", "A"},
                    {"2", "A", "L", "A", "E", "E", "G", "W", "A", "A"},
                    {"2", "A", "L", "A", "A", "A", "A", "A", "Z", "A"},
                    {"A", "A", "X", "A", "A", "S", "A", "A", "L", "A"},
                    {"A", "K", "A", "A", "A", "A", "A", "D", "X", "A"},
                    {"A", "V", "A", "A", "A", "A", "A", "D", "A", "A"},
            };

    private String[][] hardBoard =
            {       {"A", "A", "A", "A", "A", "A", "A", "A", "A", "Z"},
                    {"2", "A", "A", "A", "A", "A", "A", "A", "P", "L"},
                    {"A", "A", "A", "P", "K", "A", "A", "S", "A", "L"},
                    {"A", "2", "W", "P", "A", "A", "A", "A", "C", "X"},
                    {"A", "F", "V", "P", "A", "A", "A", "A", "A", "A"},
                    {"A", "G", "A", "P", "A", "A", "G", "I", "B", "A"},
                    {"A", "2", "K", "P", "Q", "A", "A", "A", "A", "Z"},
                    {"A", "A", "V", "P", "A", "A", "W", "A", "C", "L"},
                    {"2", "A", "A", "A", "A", "A", "A", "S", "A", "L"},
                    {"A", "A", "A", "A", "A", "A", "A", "A", "P", "X"},
            };


    private int rows = 10; //store number of rows
    private int columns = 10; //store number of column

    private int difficulty;
    private int numberOfPlayers;

    //Constructor
    public Board(int numberOfPlayers, int difficulty) {
        this.numberOfPlayers = numberOfPlayers;
        this.difficulty = difficulty;
        this.board = new Tiles[rows][columns];

        System.out.println(difficulty);
        if (difficulty == 1) {
            readBoard(easyBoard);
        }
        if (difficulty == 2) {
            readBoard(mediumBoard);
        }
        if (difficulty == 3) {
            readBoard(hardBoard);
        }
    }

    //returning board
    /* Note : getBoard() allows accessing the game board data without
    directly accessing the attribute. */
    public Tiles[][] getBoard() {
        return board;
    }
    //puts tiles in coordinates
    public Tiles getTile(int x, int y) {
        return board[y][x];
    }



    public Tiles[][] readBoard(String[][] boardEasy) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (boardEasy[i][j].equals("A")) {
                    board[i][j] = new Empty();
                } else if (boardEasy[i][j].equals("B")) {
                    board[i][j] = new CheckPoint();
                } else if (boardEasy[i][j].equals("C")) {
                    board[i][j] = new Bomb();
                } else if (boardEasy[i][j].equals("D")) {
                    board[i][j] = new ConveyorBelt1(0);
                } else if (boardEasy[i][j].equals("E")) {
                    board[i][j] = new ConveyorBelt1(1);
                } else if (boardEasy[i][j].equals("F")) {
                    board[i][j] = new ConveyorBelt1(2);
                } else if (boardEasy[i][j].equals("G")) {
                    board[i][j] = new ConveyorBelt1(3);
                } else if (boardEasy[i][j].equals("H")) {
                    board[i][j] = new ConveyorBelt2(0);
                } else if (boardEasy[i][j].equals("I")) {
                    board[i][j] = new ConveyorBelt2(1);
                } else if (boardEasy[i][j].equals("J")) {
                    board[i][j] = new ConveyorBelt2(2);
                } else if (boardEasy[i][j].equals("K")) {
                    board[i][j] = new ConveyorBelt2(3);
                } else if (boardEasy[i][j].equals("L")) {
                    board[i][j] = new LaserLine(0);
                } else if (boardEasy[i][j].equals("M")) {
                    board[i][j] = new LaserLine(1);
                } else if (boardEasy[i][j].equals("N")) {
                    board[i][j] = new LaserLine(2);
                } else if (boardEasy[i][j].equals("O")) {
                    board[i][j] = new LaserLine(3);
                } else if (boardEasy[i][j].equals("P")) {
                    board[i][j] = new Lava();
                } else if (boardEasy[i][j].equals("Q")) {
                    board[i][j] = new Life();
                } else if (boardEasy[i][j].equals("R")) {
                    board[i][j] = new OilSpill();
                } else if (boardEasy[i][j].equals("S")) {
                    board[i][j] = new Pithole();
                } else if (boardEasy[i][j].equals("T")) {
                    board[i][j] = new Wall(0);
                } else if (boardEasy[i][j].equals("U")) {
                    board[i][j] = new Wall(1);
                } else if (boardEasy[i][j].equals("V")) {
                    board[i][j] = new Wall(2);
                } else if (boardEasy[i][j].equals("W")) {
                    board[i][j] = new Wall(3);
                } else if (boardEasy[i][j].equals("X")) {
                    board[i][j] = new WallLaser(0);
                } else if (boardEasy[i][j].equals("Y")) {
                    board[i][j] = new WallLaser(1);
                } else if (boardEasy[i][j].equals("Z")) {
                    board[i][j] = new WallLaser(2);
                } else if (boardEasy[i][j].equals("1")) {
                    board[i][j] = new WallLaser(3);

                } else if (boardEasy[i][j].equals("2")) {
                    board[i][j] = new StartPoint();
                }
            }
        }
        return board;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean boundaryCheck(int x, int y){
        boolean ValidX = ((x>-1) && (x<columns));
        boolean ValidY = ((y>-1) && (y<rows));
        return (ValidX && ValidY);
    }

    public int getDifficulty() {
        return difficulty;
    }

}