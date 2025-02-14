class ProductOfNumbers {
    private List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            prefix.add(1);
        } else {
            prefix.add(num * prefix.get(prefix.size() - 1));
        }
    }

    public int getProduct(int k) {
        int n = prefix.size();
        if (k >= n) {
            return 0;
        }
        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as follows:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */