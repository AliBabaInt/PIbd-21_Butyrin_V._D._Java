public enum CountOfWeapons {
    one,
    three,
    two;

    public static CountOfWeapons getCount(int digit) {
        switch (digit) {
            case 1:
                return CountOfWeapons.one;
            case 2:
                return CountOfWeapons.two;
            case 3:
                return CountOfWeapons.three;
        }
        return null;
    }
}
