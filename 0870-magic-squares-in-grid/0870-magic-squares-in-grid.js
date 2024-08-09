function numMagicSquaresInside(grid) {
    if (grid.length < 3 || grid[0].length < 3) {
        return 0;
    }

    let count = 0;

    for (let i = 0; i < grid.length - 2; i++) {
        for (let j = 0; j < grid[0].length - 2; j++) {
            if (isMagic(grid, i, j)) {
                count++;
            }
        }
    }

    return count;
}

function isMagic(grid, i, j) {
    const nums = new Set();

    for (let x = 0; x < 3; x++) {
        for (let y = 0; y < 3; y++) {
            const num = grid[i + x][j + y];
            if (num < 1 || num > 9) return false;
            nums.add(num);
        }
    }

    if (nums.size !== 9) return false;

    const a = grid[i][j] + grid[i][j+1] + grid[i][j+2];
    const b = grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2];
    const c = grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
    const d = grid[i][j] + grid[i+1][j] + grid[i+2][j];
    const e = grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1];
    const f = grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2];
    const g = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
    const h = grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j];

    return a === b && b === c && c === d && d === e && e === f && f === g && g === h;
}