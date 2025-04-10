var numberOfPowerfulInt = function(start, finish, limit, suffix) {
    const countPowerfulUpTo = (num) => {
        const numStr = num.toString();
        const prefixLength = numStr.length - suffix.length;

        if (prefixLength < 0) return 0;

        const dp = Array.from({ length: prefixLength + 1 }, () => Array(2).fill(0));

        dp[prefixLength][0] = 1;
        const suffixFromNum = numStr.substring(prefixLength);
        dp[prefixLength][1] = parseInt(suffixFromNum) >= parseInt(suffix) ? 1 : 0;

        for (let i = prefixLength - 1; i >= 0; i--) {
            const digitFromNum = parseInt(numStr[i]);

            dp[i][0] = (limit + 1) * dp[i + 1][0];

            if (digitFromNum <= limit) {
                dp[i][1] = digitFromNum * dp[i + 1][0] + dp[i + 1][1];
            } else {
                dp[i][1] = (limit + 1) * dp[i + 1][0];
            }
        }

        return dp[0][1];
    };

    return countPowerfulUpTo(finish) - countPowerfulUpTo(start - 1);
};