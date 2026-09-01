public enum Priority {
    HIGH(0),
    MEDIUM(1),
    LOW(2);
    
    private final int value;
    
    //constructor
    Priority(int value) {
        this.value = value;
    }

    //getter
    public int getValue() {
        return value;
    }
}
