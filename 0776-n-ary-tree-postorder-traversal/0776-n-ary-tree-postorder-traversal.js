/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
    const res = [], stack = [root];
    while (stack.length) {
        const curr = stack.pop();
        if (!curr) continue;
        res.push(curr.val);
        stack.push(...curr.children);
    }
    return res.reverse();
};