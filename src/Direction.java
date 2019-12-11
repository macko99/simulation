public enum Direction {
    DEG0,
    DEG45,
    DEG90,
    DEG135,
    DEG180,
    DEG225,
    DEG270,
    DEG315;

    Position toUnitVector() {
        switch (this) {
            case DEG0:
                return new Position(0,1);
            case DEG45:
                return new Position(1,1);
            case DEG90:
                return new Position(1,0);
            case DEG135:
                return new Position(1,-1);
            case DEG180:
                return new Position(0,-1);
            case DEG225:
                return new Position(-1,-1);
            case DEG270:
                return new Position(-1,0);
            case DEG315:
                return new Position(-1,1);
        }
        return new Position(0,0);
    }

}
