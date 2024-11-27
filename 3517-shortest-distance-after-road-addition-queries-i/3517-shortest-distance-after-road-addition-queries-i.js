var shortestDistanceAfterQueries = function(n, queries) {
    const adj = Array.from({length: n}, (_, i) => [i + 1]);
    
    const shortestPath = () => {
        const q = [[0, 0]]; // node, length
        const visit = new Set();
        visit.add(0);
        
        while (q.length > 0) {
            const [cur, length] = q.shift();
            if (cur === n - 1) {
                return length;
            }
            
            for (const nei of adj[cur]) {
                if (!visit.has(nei)) {
                    q.push([nei, length + 1]);
                    visit.add(nei);
                }
            }
        }
    };
    
    const res = [];
    for (const [src, dst] of queries) {
        adj[src].push(dst);
        res.push(shortestPath());
    }
    
    return res;
};