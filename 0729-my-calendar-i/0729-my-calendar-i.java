class MyCalendar {
    private TreeMap<Integer, Integer> bookings;
    public MyCalendar() {
        bookings = new TreeMap<>();
    }
    public boolean book(int start, int end) {
        Integer floorKey = bookings.floorKey(start);
        if (floorKey != null && bookings.get(floorKey) > start) return false;
        Integer ceilingKey = bookings.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return false;
        bookings.put(start, end);
        return true;
    }
}