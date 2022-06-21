package byow.Core;


public class SaeyiSewonRoom {

    int width;
    int height;
    int ourID;
    SaeyiSewonPoint bottomRight;
    SaeyiSewonPoint topLeft;

    public SaeyiSewonRoom(int width, int height, SaeyiSewonPoint bottomRight,
                          SaeyiSewonPoint topLeft, int ourID) {
        this.width = width;
        this.height = height;
        this.bottomRight = bottomRight;
        this.topLeft = topLeft;
        this.ourID = ourID;

    }


}
