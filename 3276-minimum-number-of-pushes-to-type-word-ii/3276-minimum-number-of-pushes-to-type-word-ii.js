/**
 * @param {string} word
 * @return {number}
 */
var minimumPushes = function(word) {
    const letterFreq = new Array(26).fill(0);
    for (let c of word) {
        letterFreq[c.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }
    
    letterFreq.sort((a, b) => b - a);
    
    let totalPresses = 0;
    for (let i = 0; i < 26; i++) {
        if (letterFreq[i] === 0) break;
        totalPresses += Math.floor(i / 8 + 1) * letterFreq[i];
    }
    
    return totalPresses;
};