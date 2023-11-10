class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        def dfs(node):
            visited.add(node)
            res.append(node)

            for neighbor in d[node]:
                if (neighbor not in visited):
                    dfs(neighbor)

        d = collections.defaultdict(list)

        # Create a hash table with key: node and value: neighbors
        for u,v in adjacentPairs:
            d[u].append(v)
            d[v].append(u)

        # Find the head (whose neighbors = single)
        head = None
        for k, v in d.items():
            if (len(v) == 1):
                head = k

        res = []
        visited = set()
        dfs(head)

        return res
