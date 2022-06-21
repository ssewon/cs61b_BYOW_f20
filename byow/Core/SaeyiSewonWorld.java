package byow.Core;


/*import byow.TileEngine.TERenderer;*/

import java.io.Serializable;

/*import static byow.Core.Engine.TER;*/

public class SaeyiSewonWorld implements Serializable {

    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    /*public static int avatarX;
    public static int avatarY;
    private static Random RANDOM = null;
    public static TETile[][] ourTile;

    private static HashMap<Integer, SaeyiSewonRoom> roomID;


    *//*public SaeyiSewonWorld(){
        ourTile = SaeyiSewonWorld.ourTile;
        roomID = SaeyiSewonWorld.roomID;
        RANDOM = SaeyiSewonWorld.RANDOM;
    }*//*

    *//*public static SaeyiSewonWorld pls(){
        return new SaeyiSewonWorld();
    }*//*

    public static TETile[][] newWorld(long seed) {
        return ourWorld(seed);
    }




    public static TETile[][] ourWorld(long seed) {

        ourTile = new TETile[WIDTH][HEIGHT];
        roomID = new HashMap<>();
        RANDOM = new Random();
        *//*TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);*//*
        RANDOM.setSeed(seed);
        buildNothing(ourTile);
        int numberRoom = 10;
        for (int i = 0; i < numberRoom; i++) {
            buildRoom(ourTile);
            breakWall(ourTile);
        }
        for (int i = 1; i < numberRoom; i++) {
            buildHallway(ourTile, roomID.get(i), roomID.get(i + 1));
            breakWall(ourTile);
        }
        buildDoor(ourTile);
        buildAvatar(ourTile);
        *//*ter.renderFrame(ourTile);*//*
        return ourTile;
    }
    public static void ourWorld2(long seed) {


        *//*TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);*//*

        RANDOM = new Random();
        RANDOM.setSeed(seed);
        ourTile = new TETile[WIDTH][HEIGHT];
        buildNothing(ourTile);
        roomID = new HashMap<>();
        int numberRoom = 10;
        for (int i = 0; i < numberRoom; i++) {
            buildRoom(ourTile);
            breakWall(ourTile);
        }
        for (int i = 1; i < numberRoom; i++) {
            buildHallway(ourTile, roomID.get(i), roomID.get(i + 1));
            breakWall(ourTile);
        }
        buildDoor(ourTile);
        buildAvatar(ourTile);
        *//*ter.renderFrame(ourTile);*//*
    }

    public static TETile[][] syswTile() {
        return ourTile;
    }


    public static void buildNothing(TETile[][] nothingWorld) {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                nothingWorld[i][j] = Tileset.NOTHING;
            }
        }
    }

    public static void buildRoom(TETile[][] roomWorld) {

        int roomWidth = RANDOM.nextInt(3) + 2;
        int roomHeight = RANDOM.nextInt(3) + 2;

        int randomX = RANDOM.nextInt(WIDTH - 10) + 1;
        int randomY = RANDOM.nextInt(HEIGHT - 1) + 1;

        SaeyiSewonPoint topLeft = new SaeyiSewonPoint(randomX, randomY);
        SaeyiSewonPoint bottomRight = new SaeyiSewonPoint(topLeft.x + roomWidth,
                topLeft.y - roomHeight);

        if (bottomRight.x > WIDTH) {
            bottomRight.x = WIDTH - 1;
        }
        if (bottomRight.y < 0) {
            bottomRight.y = 1;
        }

        for (int x = topLeft.x; x <= bottomRight.x; x++) {
            for (int y = bottomRight.y; y <= topLeft.y; y++) {
                if ((roomWorld[x][y] != Tileset.WALL) && (roomWorld[x][y] != Tileset.FLOOR)) {
                    if (y == bottomRight.y || y == topLeft.y
                            || x == bottomRight.x || x == topLeft.x) {
                        roomWorld[x][y] = Tileset.WALL;
                    } else {
                        roomWorld[x][y] = Tileset.FLOOR;
                    }
                }
            }
        }
        SaeyiSewonRoom ourRoom = new SaeyiSewonRoom(roomWidth, roomHeight,
                bottomRight, topLeft, roomID.size() + 1);
        roomID.put(ourRoom.ourID, ourRoom);
    }

    public static void breakWall(TETile[][] breaking) {

        for (int x = 1; x < WIDTH - 1; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (breaking[x][y] == Tileset.WALL) {
                    if ((breaking[x - 1][y] == Tileset.FLOOR)
                            && (breaking[x + 1][y] == Tileset.FLOOR)) {
                        breaking[x][y] = Tileset.FLOOR;
                    } else if ((breaking[x - 1][y] == Tileset.FLOOR)
                            && (breaking[x + 1][y] == Tileset.WALL)
                            && (breaking[x + 2][y] == Tileset.FLOOR)) {
                        breaking[x][y] = Tileset.FLOOR;
                    }
                }
            }
        }

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 1; y < HEIGHT - 1; y++) {
                if (breaking[x][y] == Tileset.WALL) {
                    if ((breaking[x][y - 1] == Tileset.FLOOR)
                            && (breaking[x][y + 1] == Tileset.FLOOR)) {
                        breaking[x][y] = Tileset.FLOOR;
                    } else if ((y + 2) < 30 && (breaking[x][y - 1] == Tileset.FLOOR)
                            && (breaking[x][y + 1] == Tileset.WALL)
                            && (breaking[x][y + 2] == Tileset.FLOOR)) {
                        breaking[x][y] = Tileset.FLOOR;
                    } else if ((y + 2) >= 30 && (breaking[x][y - 1] == Tileset.FLOOR)
                            && (breaking[x][y + 1] == Tileset.WALL)) {
                        breaking[x][y] = Tileset.FLOOR;
                    }
                }
            }
        }
    }

    public static void buildHallway(TETile[][] hallwayWorld, SaeyiSewonRoom r1, SaeyiSewonRoom r2) {
        SaeyiSewonRoom leftRoom;
        SaeyiSewonRoom rightRoom;
        if (r1.topLeft.x < r2.topLeft.x) {
            leftRoom = r1;
            rightRoom = r2;
        } else {
            leftRoom = r2;
            rightRoom = r1;
        }

        int pointerX = leftRoom.bottomRight.x;
        int pointerY = leftRoom.bottomRight.y;
        int temp = pointerY;
        int tempX = pointerX;

        if (pointerY != 0) {

            if (temp >= rightRoom.bottomRight.y + 1) {
                while (temp > rightRoom.bottomRight.y + 1) {
                    vertHallwayDown(hallwayWorld, pointerX, temp);
                    temp--;
                }
                while (pointerX < rightRoom.bottomRight.x) {
                    horHallway(hallwayWorld, pointerX, temp);
                    pointerX++;
                }
                *//*bottom left*//*
                hallwayWorld[tempX][temp - 1] = Tileset.WALL;
                hallwayWorld[tempX - 1][temp - 1] = Tileset.WALL;
                hallwayWorld[tempX - 2][temp - 1] = Tileset.WALL;
                hallwayWorld[tempX - 2][temp] = Tileset.WALL;
                hallwayWorld[tempX - 2][temp + 1] = Tileset.WALL;
                *//*top right*//*
                hallwayWorld[pointerX][temp + 1] = Tileset.WALL;
                hallwayWorld[pointerX - 1][temp + 1] = Tileset.WALL;
                hallwayWorld[pointerX - 2][temp + 1] = Tileset.WALL;
                hallwayWorld[pointerX][temp] = Tileset.WALL;
                hallwayWorld[pointerX][temp - 1] = Tileset.WALL;

            }
            int temp2 = pointerY;
            if (temp2 <= rightRoom.bottomRight.y + 1) {
                while (temp2 < rightRoom.bottomRight.y - 1) {
                    vertHallwayUp(hallwayWorld, pointerX, temp2);
                    temp2++;
                }
                while (pointerX < rightRoom.bottomRight.x) {
                    horHallway(hallwayWorld, pointerX, temp2);
                    pointerX++;
                }
                *//*bottom right*//*
                hallwayWorld[pointerX][temp2 + 1] = Tileset.WALL;
                hallwayWorld[pointerX][temp2] = Tileset.WALL;
                hallwayWorld[pointerX][temp2 - 1] = Tileset.WALL;
                hallwayWorld[pointerX - 1][temp2 - 1] = Tileset.WALL;
                hallwayWorld[pointerX - 2][temp2 - 1] = Tileset.WALL;
                *//*top left*//*
                hallwayWorld[tempX][temp2 + 1] = Tileset.WALL;
                hallwayWorld[tempX - 1][temp2 + 1] = Tileset.WALL;
                hallwayWorld[tempX - 2][temp2 - 1] = Tileset.WALL;
                hallwayWorld[tempX - 2][temp2] = Tileset.WALL;
                hallwayWorld[tempX - 2][temp2 + 1] = Tileset.WALL;

            }
        }
    }


    private static void vertHallwayDown(TETile[][] temp, int x, int y) {
        temp[x][y - 1] = Tileset.WALL;
        temp[x - 1][y - 1] = Tileset.FLOOR;
        temp[x - 2][y - 1] = Tileset.WALL;
    }

    private static void vertHallwayUp(TETile[][] temp, int x, int y) {
        temp[x][y + 1] = Tileset.WALL;
        temp[x - 1][y + 1] = Tileset.FLOOR;
        temp[x - 2][y + 1] = Tileset.WALL;
    }

    private static void horHallway(TETile[][] temp, int x, int y) {
        temp[x][y + 1] = Tileset.WALL;
        temp[x][y] = Tileset.FLOOR;
        temp[x][y - 1] = Tileset.WALL;
    }

    public static void buildDoor(TETile[][] tile) {


        int xPos = RANDOM.nextInt(WIDTH - 2) + 1;
        int yPos = RANDOM.nextInt(HEIGHT - 2) + 1;

        *//* right = tile[xPos + 1][yPos]
         *  left = tile[xPos - 1][yPos]
         *  up = tile[xPos][yPos + 1]
         *  down = tile[xPos][yPos - 1] *//*

        while (true) {
            if (tile[xPos][yPos].equals(Tileset.WALL)
                    && tile[xPos + 1][yPos].equals(Tileset.NOTHING)
                    && tile[xPos - 1][yPos].equals(Tileset.FLOOR)) {
                tile[xPos][yPos] = Tileset.LOCKED_DOOR;
                break;
            } else if (tile[xPos][yPos].equals(Tileset.WALL)
                    && tile[xPos + 1][yPos].equals(Tileset.FLOOR)
                    && tile[xPos - 1][yPos].equals(Tileset.NOTHING)) {
                tile[xPos][yPos] = Tileset.LOCKED_DOOR;
                break;
            } else if (tile[xPos][yPos].equals(Tileset.WALL)
                    && tile[xPos][yPos + 1].equals(Tileset.NOTHING)
                    && tile[xPos][yPos - 1].equals(Tileset.FLOOR)) {
                tile[xPos][yPos] = Tileset.LOCKED_DOOR;
                break;
            } else if (tile[xPos][yPos].equals(Tileset.WALL)
                    && tile[xPos][yPos + 1].equals(Tileset.FLOOR)
                    && tile[xPos][yPos - 1].equals(Tileset.NOTHING)) {
                tile[xPos][yPos] = Tileset.LOCKED_DOOR;
                break;
            } else {
                xPos++;
                if (xPos >= WIDTH) {
                    xPos = 1;
                }
                yPos++;
                if (yPos >= HEIGHT) {
                    yPos = 1;
                }
            }
        }
    }

    public static void headsUpDisplay(TETile[][] tile) {
        String location = "";
        int x = (int) StdDraw.mouseX();
        int y = (int) StdDraw.mouseY();
        if ((x < WIDTH && y < HEIGHT) && tile[x][y].equals(Tileset.WALL)) {
            *//*ter.renderFrame(tile);*//*
            location = "Wall";
        } else if ((x < WIDTH && y < HEIGHT) && tile[x][y].equals(Tileset.FLOOR)) {
            *//*ter.renderFrame(tile);*//*
            location = "Floor";
        } else if ((x < WIDTH && y < HEIGHT) && tile[x][y].equals(Tileset.LOCKED_DOOR)) {
            *//*ter.renderFrame(tile);*//*
            location = "Locked door";
        }
        Font font = new Font("Arial", Font.PLAIN, 13);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.yellow);
        StdDraw.text(WIDTH - 3, HEIGHT - 2, location);
        StdDraw.show();
    }

    public static void buildAvatar(TETile[][] tile) {
        int tempX = RANDOM.nextInt(WIDTH);
        int tempY = RANDOM.nextInt(HEIGHT);
        Point initPosition = new Point(tempX, tempY);
        while (!tile[initPosition.x][initPosition.y].equals(Tileset.FLOOR)) {
            tempX++;
            if (tempX >= WIDTH) {
                tempX = 1;
            }
            tempY++;
            if (tempY >= HEIGHT) {
                tempY = 1;
            }
            initPosition = new Point(tempX, tempY);
        }
        tile[initPosition.x][initPosition.y] = Tileset.AVATAR;
        avatarX = initPosition.x;
        avatarY = initPosition.y;

    }*/

    /*public static void main(String[] args) {
        Engine.interactWithInputString("n7685817615627686380s");
        while (true) {
            headsUpDisplay(ourTile);
            Engine.move(ourTile, avatarX, avatarY);
        }*/

        /*RANDOM = new Random(7341909481878015308L);
        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];
        buildNothing(randomTiles);
        roomID = new HashMap<>();
        int numberRoom = RANDOM.nextInt(10) + 10;
        for (int i = 0; i < numberRoom; i++) {
            buildRoom(randomTiles);
            breakWall(randomTiles);
        }
        for (int i = 1; i < numberRoom; i++) {
            buildHallway(randomTiles, roomID.get(i), roomID.get(i + 1));
            breakWall(randomTiles);
        }*/
}
/*
MOVED ALL OF THE METHOD TO ENGINE TO PASS THE DESIGN*/
