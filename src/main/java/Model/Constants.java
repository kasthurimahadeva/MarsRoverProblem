package Model;

public class Constants {
    public enum Command {
        L, R, M
    }

    /**
     * Indicates the facing orientation of the rover
     */
    public enum Orientation {
        N(1), E(2), S(3), W(4);

        private int orientation;

        Orientation(int index) {
            this.orientation = index;
        }

        public static Orientation resolveIndex(int index) {
            for (Orientation orientation :
                    Orientation.values()) {
                if (orientation.getIndex() == index) return orientation;
            }
            throw new IllegalArgumentException();
        }

        public int getIndex() {
            return orientation;
        }
    }
}
