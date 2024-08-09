/**
 * @param {number[][]} grid
 * @return {number}
 */
var numMagicSquaresInside = function(grid) {
    let count = 0;
    const rows = grid.length;
    const cols = grid[0].length;

    for (let i = 0; i <= rows - 3; i++) {
        for (let j = 0; j <= cols - 3; j++) {
            if (isValidMagicSquare(grid, i, j)) {
                count++;
            }
        }
    }

    return count;
};

/**
 * @param {number[][]} grid
 * @param {number} startRow
 * @param {number} startCol
 * @return {boolean}
 */
function isValidMagicSquare(grid, startRow, startCol) {
    // Create a boolean array to track the presence of each number (1-9)
    const numPresence = new Array(10).fill(false);

    // Check each element in the 3x3 subgrid
    for (let i = startRow; i < startRow + 3; i++) {
        for (let j = startCol; j < startCol + 3; j++) {
            const num = grid[i][j];
            if (num < 1 || num > 9 || numPresence[num]) {
                return false;
            }
            numPresence[num] = true;
        }
    }

    // Check if the sums of rows, columns, and diagonals are equal
    const targetSum = grid[startRow][startCol] + grid[startRow][startCol + 1] + grid[startRow][startCol + 2];
    for (let i = 0; i < 3; i++) {
        if (getRowSum(grid, startRow + i, startCol) !== targetSum ||
            getColSum(grid, startRow, startCol + i) !== targetSum) {
            return false;
        }
    }

    const diagonalSum1 = grid[startRow][startCol] + grid[startRow + 1][startCol + 1] + grid[startRow + 2][startCol + 2];
    const diagonalSum2 = grid[startRow + 2][startCol] + grid[startRow + 1][startCol + 1] + grid[startRow][startCol + 2];
    return diagonalSum1 === targetSum && diagonalSum2 === targetSum;
}

/**
 * @param {number[][]} grid
 * @param {number} row
 * @param {number} startCol
 * @return {number}
 */
function getRowSum(grid, row, startCol) {
    return grid[row][startCol] + grid[row][startCol + 1] + grid[row][startCol + 2];
}

/**
 * @param {number[][]} grid
 * @param {number} startRow
 * @param {number} col
 * @return {number}
 */
function getColSum(grid, startRow, col) {
    return grid[startRow][col] + grid[startRow + 1][col] + grid[startRow + 2][col];
}