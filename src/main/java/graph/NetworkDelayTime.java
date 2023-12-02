package graph;

import java.util.*;

public class NetworkDelayTime {

    static class Node {

        int destination;
        int time;
        public Node(int goal, int t) {
            destination = goal;
            time = t;
        }
    }
    public static void main(String[] args) {

        int[][] times = {{1,2,1}, {2,3,7}, {1,3,4}, {2,1,2}};
        int k = 1, n = 3;
        System.out.println(networkDelayTime(times, n, k));
    }
    private static int networkDelayTime(int[][] times, int n, int k) {

        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> a.time - b.time);
        pq.add(new Node(k, 0));
        Map<Integer, Set<Node>> map = new HashMap<>();
        for ( int[] time : times ) {

            map.putIfAbsent(time[0], new HashSet<>());
            map.get(time[0]).add(new Node(time[1], time[2]));
        }
        Set<Integer> visited = new HashSet<>();
        int totalTime = 0;
        while ( !pq.isEmpty() ) {

            int size = pq.size();
//            System.out.println(size);
            while ( size-- > 0 ) {

                Node curr = pq.poll();
                if ( visited.contains(curr.destination) )
                    continue;

                visited.add(curr.destination);
                totalTime = Math.max(totalTime, curr.time);
                if ( visited.size() == n )
                    return totalTime;

                if ( map.containsKey( curr.destination ) ) {

                    for ( Node neighbor : map.get(curr.destination) ) {

                        int t = neighbor.time + curr.time;
                        pq.add( new Node(neighbor.destination, t) );
                    }
                }
            }
        }
        return -1;
    }
}
