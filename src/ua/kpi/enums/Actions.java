package ua.kpi.enums;

public enum Actions {
    RIGHT{
        @Override
        public int[] returnTargetCellCoordinates(int[]index) {
             index[1] += 1;
            return index;
        }
    },
    LEFT {
        @Override
        public int[] returnTargetCellCoordinates(int[]index) {
             index[1] -= 1;
             return index;
        }
    },
    DOWN {
        @Override
        public int[] returnTargetCellCoordinates(int[]index) {
             index[0] += 1;
             return index;
        }
    },
    UP{
        @Override
        public int[] returnTargetCellCoordinates(int[]index) {
             index[0] -= 1;
             return index;
        }
    },
    NOTHING {
        @Override
        public int[] returnTargetCellCoordinates(int[]index) {
            throw new RuntimeException("Nope");
        }
    };

    public abstract int[] returnTargetCellCoordinates(int[] index);

}
