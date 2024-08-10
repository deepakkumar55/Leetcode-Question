/**
 * @param {string[]} grid
 * @return {number}
 */
var regionsBySlashes = function(grid) 
{
    const n = grid.length;

    const UnionFind = function(numGroups)
    {
        let groups = Array(numGroups);
        for(let i=0; i<numGroups; i++)
            groups[i] = i;
        let isFlat = true;

        const find = function(loc)
        {
            id = groups[loc]
            if(id == loc)
                return id;   // This is the parent.
            groups[loc] = find(id);
            return groups[loc];
        };
        
        const merge = function(eater, eaten)
        {
            groups[eaten] = eater
            isFlat = false;
        };

        const union = function(eater, eaten)
        {
            let p1 = find(eater);
            let p2 = find(eaten);
            if(p1 === p2)
                return false;
            merge(p1, p2);
            return true;
        }

        const getParents = function()
        {
            if(!isFlat)
            {
                isFlat = true;
                for(let i=0; i<numGroups; i++)
                    find(i);
            }
            let parents = new Set();
            for(let i=0; i<numGroups; i++)
            {
                if(groups[i] === i)
                    parents.add(i);
            }

            return [...parents];
        };

        const showGroups = function()
        {
            console.log(groups);
        }

        return {union, find, getParents, showGroups};
    };

    // group format: each cell is group r*n+c*2 and r*n+c*2+1
    // first group is "left": nw for / or sw for \
    let uf = UnionFind(n*n*2);

    // Merge upper and lower regions for blank cells.
    for(let i=0; i<n; i++)
    {
        for(let j=0; j<n; j++)
        {
            if(grid[i][j] === ' ')
                uf.union(i*n*2+j*2, i*n*2+j*2+1);
        }
    }

    // Merge along each row.
    for(let i=0; i<n; i++)
    {
        for(let j=1; j<n; j++)
        {
            // Merge left region of cell with right region of previous cell.
            uf.union(i*n*2+j*2-1, i*n*2+j*2);
        }
    }

    // Merge between rows.
    const upper = {' ':1,'/':1,'\\':0};
    const lower = {' ':0,'/':0,'\\':1};
    for(let i=1; i<n; i++)
    {
        for(let j=0; j<n; j++)
        {
            let off1 = upper[grid[i-1][j]], off2 = lower[grid[i][j]];
            uf.union((i-1)*n*2+j*2+off1, i*n*2+j*2+off2);
        }
    }

    return uf.getParents().length;
};