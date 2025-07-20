public class AlienDictionaryTopologicalSort {
 
   String solve(String [] words) {
 
     Map<Character, Set<Character>> graph =  new HashMap<>();
     Map<Character, Integer> indegree =  new HashMap<>();
 
     for(int i=0;i<words.length;i++) {
       for(int j=0;j<words[i].length();j++) {
         graph.putIfAbsent(words[i].charAt(j), new HashSet<>());
         indegree.put(words[i].charAt(j), 0);
       }
     }
 
 
     for(int i=0;i<words.length-1;i++) {
       String s1 = words[i];
       String s2 = words[i+1];
 
       if(s1.length()>s2.length() && s1.startsWith(s2)) return "";
       int minLength = Math.min(s1.length(), s2.length());
 
 
       for(int j=0;j<minLength;j++) {
         char c1 = s1.charAt(j);
         char c2 = s2.charAt(j);
         if(c1!=c2) {
           if(!graph.get(c1).contains(c2)) {
             graph.get(c1).add(c2);
             indegree.put(c2,indegree.get(c2)+1);
           }
         }
       }
     }
 
 
     Queue<Character> q = new LinkedList<>();
     for(char c: indegree.keySet()) {
       if(indegree.get(c)==0) q.offer(c);
     }
     StringBuilder sb = new StringBuilder();
 
     while(!q.isEmpty()) {
 
       char c = q.poll();
       sb.append(c);
       for(char neighbours : graph.get(c)) {
         indegree.put(neighbours, indegree.get(neighbours)-1);
         if(indegree.get(neighbours)==0) q.offer(neighbours);
       }
     }
     return sb.length()==indegree.size() ? sb.toString() : "";
   }
 
 
   public static void main(String[] args) {
 
     String [] words = {"wrt", "wrf", "er", "ett", "rftt"};
 
     String x = new AlienDictionaryTopologicalSort().solve(words);
     System.out.println("x -> "+ x);
   }
 
 }
