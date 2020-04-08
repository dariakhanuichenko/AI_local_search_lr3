package ua.kpi.enums;

public enum Actions {
    RIGHT{
        @Override
        public int[] returnTargetCell(int[]index) {
             index[1] += 1;
            return index;
        }
    },
    LEFT {
        @Override
        public int[] returnTargetCell(int[]index) {
             index[1] -= 1;
             return index;
        }
    },
    DOWN {
        @Override
        public int[] returnTargetCell(int[]index) {
             index[0] += 1;
             return index;
        }
    },
    UP{
        @Override
        public int[] returnTargetCell(int[]index) {
             index[0] -= 1;
             return index;
        }
    },
    NOTHING {
        @Override
        public int[] returnTargetCell(int[]index) {
            throw new RuntimeException("Nope");
        }
    };

    public abstract int[] returnTargetCell(int[] index);

}
