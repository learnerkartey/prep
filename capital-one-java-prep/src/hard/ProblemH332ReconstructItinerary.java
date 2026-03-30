import java.util.*;

public class ProblemH332ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        LinkedList<String> route = new LinkedList<>();
        dfs("JFK", graph, route);
        return route;
    }

    private void dfs(String node, Map<String, PriorityQueue<String>> graph, LinkedList<String> route) {
        PriorityQueue<String> heap = graph.get(node);
        while (heap != null && !heap.isEmpty()) {
            dfs(heap.poll(), graph, route);
        }
        route.addFirst(node);
    }
}
