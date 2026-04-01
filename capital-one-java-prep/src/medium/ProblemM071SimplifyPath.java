class Solution {
    public String simplifyPath(String path) {
      // Use Deque for efficient operations
        Deque<String> deque = new ArrayDeque<>();
        
        // Split the input path by "/" to process each part
        String[] components = path.split("/");
        
        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                // Skip empty parts or current directory
                continue;
            } else if (component.equals("..")) {
                // Go to the parent directory, if possible
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                // Add valid directory name to the deque
                deque.offerLast(component);
            }
        }
        
        // Build the simplified path from the deque
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : deque) {
            simplifiedPath.append("/").append(dir);
        }
        
        // Return root "/" if the deque is empty
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
}
