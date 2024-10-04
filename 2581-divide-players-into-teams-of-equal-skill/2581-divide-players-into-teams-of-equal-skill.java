class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long totalSum = skill[0] + skill[skill.length - 1];
        long total = 0;

        for (int i = 0, j = skill.length - 1; i < skill.length / 2; i++, j--) {
            if (skill[i] + skill[j] != totalSum) {
                return -1;
            }
            total += (long) skill[i] * skill[j];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] skill = {3, 6, 1, 8, 4}; 
        Solution solution = new Solution();
        System.out.println(solution.dividePlayers(skill));
    }
}