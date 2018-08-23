package PZ3;

/**
 * Created by gaara on 12.08.16.
 */
public enum placeStatus {
    RESERVED(1),BOUGHT(2),EMPTY(0);

    static public placeStatus getPSById(int id)
    {
        switch (id) {
            case 0:
                return EMPTY;
            case 1:
                return RESERVED;
            case 2:
                return BOUGHT;
            default:
                return null;
        }
    }

    private int id;
    placeStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}