let longests = new Uint32Array(100001);
let minLasts = Array(100001).fill(0);
let ps = Array(100001).fill(0);

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaximumLength = function (nums) {
  let n = nums.length;

  for (let i = 0; i < n; ++i) {
    ps[i + 1] = ps[i] + nums[i];
  }

  longests.fill(1, 0, n + 1);
  minLasts.fill(1e12, 0, n + 1);
  minLasts[0] = 0;

  for (let i = 1; i <= n; ++i) {
    if (longests[i - 1] >= longests[i]) {
      longests[i] = longests[i - 1];
      minLasts[i] = Math.min(minLasts[i], minLasts[i - 1] + nums[i - 1]);
    }

    let l = i + 1;
    let r = n;
    let p = -1;

    while (l <= r) {
      let m = (l + r) >> 1;
      if (ps[m] - ps[i] >= minLasts[i]) {
        p = m;
        r = m - 1;
      } else {
        l = m + 1;
      }
    }

    if (p != -1) {
      if (longests[i] + 1 == longests[p]) {
        minLasts[p] = Math.min(minLasts[p], ps[p] - ps[i]);
      } else {
        longests[p] = longests[i] + 1;
        minLasts[p] = ps[p] - ps[i];
      }
    }
  }

  return longests[n];
};