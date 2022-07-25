import java.util.*;


public class Explanation{

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        
        Solution sol = new Solution();
        int[] result = sol.solution(id_list, report, k);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
        
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] totalReport = new int[id_list.length];
        HashMap<String, ArrayList<Integer>> dic = new HashMap<String, ArrayList<Integer>>();
        Set<String> noDup = new HashSet<>();
        for(String s : report){
            noDup.add(s);
        }
        for(String s : noDup){
            String reporter = s.split(" ")[0];
            String reportee = s.split(" ")[1];
            int index = Arrays.asList(id_list).indexOf(reportee);
            totalReport[index]++;
            if (dic.get(reporter) == null) {
                dic.put(reporter, new ArrayList<Integer>());
            }
            dic.get(reporter).add(index);
        }
        ArrayList<Integer> over = new ArrayList<>();
        for(int i=0; i<totalReport.length; i++){
            if(totalReport[i]>=k){
                over.add(i);
            }
        }
        for(String s : dic.keySet()){
            for(int i=0; i<over.size(); i++){
                if(dic.get(s).contains(over.get(i))){
                    answer[Arrays.asList(id_list).indexOf(s)]++;
                }
            }
        }
        return answer;
    }
}