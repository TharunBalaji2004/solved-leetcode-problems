class Solution {

    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    class Tuple {
        int first, second, third; 
        Tuple(int first, int second, int third) {
            this.first = first; 
            this.second = second;
            this.third = third; 
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        int m = flights.length; 
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2])); 
        }
     
        Queue<Tuple> q = new LinkedList<>(); 
        
        q.add(new Tuple(0, src, 0));


        int[] dist = new int[n]; 
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9); 
        }
        dist[src] = 0; 

        while(!q.isEmpty()) {
            Tuple it = q.peek(); 
            q.remove(); 
            int stops = it.first; 
            int node = it.second; 
            int cost = it.third; 
            
            // We stop the process as soon as the limit for the stops reaches.
            if(stops > K) continue; 
            for(Pair iter: adj.get(node)) {
                int adjNode = iter.first; 
                int edW = iter.second; 
        
                if (cost + edW < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + edW; 
                    q.add(new Tuple(stops + 1, adjNode, cost + edW)); 
                }
            }
        }
        // If the destination node is unreachable return ‘-1’
        // else return the calculated dist from src to dst.
        if(dist[dst] == (int)(1e9)) return -1; 
        return dist[dst]; 

     
    }
}