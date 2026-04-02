class FileSystem {
    public final Map<String,Integer> valueByPath = new HashMap();
    public FileSystem() {        
    }    
    public boolean createPath(String path, int value) {
        int lastIndexOfSlash = path.lastIndexOf("/");
        if(lastIndexOfSlash > 0 && !valueByPath.containsKey(path.substring(0,lastIndexOfSlash))) {
            return false;
        }
        if(valueByPath.containsKey(path)) {
            return false;
        }
        valueByPath.put(path, value);
        return true;
    }    
    public int get(String path) {
        return valueByPath.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
