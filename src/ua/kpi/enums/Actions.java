package ua.kpi.enums;

public enum Actions {
    RIGHT{
        @Override
        public int returnTargetCell(int i, int j) {
            return i + 1;
        }
    },
    LEFT {
        @Override
        public int returnTargetCell(int i, int j) {
            return i - 1;
        }
    },
    DOWN {
        @Override
        public int returnTargetCell(int i, int j) {
            return j - 1;
        }
    },
    UP{
        @Override
        public int returnTargetCell(int i, int j) {
            return j + 1;
        }
    },
    NOTHING {
        @Override
        public int returnTargetCell(int i, int j) {
            throw new RuntimeException("Nope");
        }
    };

    public abstract int returnTargetCell(int i, int j);

//    public String getStringWithIndex(int i) {
//        i++;
//        switch (this){
//            case WHITE_LEFT_1:
//                return "<- " + i;
//            case WHITE_LEFT_2:
//                return "<-- " + i;
//            case BLACK_RIGHT_1:
//                return i + " ->";
//            case BLACK_RIGHT_2:
//                return i + " -->";
//            default: throw new RuntimeException("opoops");
//        }
//    }
}
