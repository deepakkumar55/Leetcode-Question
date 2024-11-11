function primeSubOperation(nums: number[]): boolean {
    const getMaxElement = (nums: number[]): number => {
        let max = -1;
        for (const num of nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    };

    const fill = (arr: boolean[], value: boolean): void => {
        for (let i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
    };

    const maxElement = getMaxElement(nums);

    const sieve: boolean[] = new Array(maxElement + 1);
    fill(sieve, true);
    sieve[1] = false;
    for (let i = 2; i <= Math.sqrt(maxElement + 1); i++) {
        if (sieve[i]) {
            for (let j = i * i; j <= maxElement; j += i) {
                sieve[j] = false;
            }
        }
    }

    let currValue = 1;
    let i = 0;
    while (i < nums.length) {
        const difference = nums[i] - currValue;

        if (difference < 0) {
            return false;
        }

        if (sieve[difference] === true || difference === 0) {
            i++;
            currValue++;
        } else {
            currValue++;
        }
    }
    return true;
}