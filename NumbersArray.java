import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,1,5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));

        System.out.println();

        input = new Integer[] {1,2,3,4,1,2,5,3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));
    }

    // Write your methods here

    public static Integer findMax(Integer[] inputs){
        int highest = (int) Double.NEGATIVE_INFINITY;
        for (Integer input: inputs){
            if (input > highest){
                highest = input;
            }
        }
        return highest;
    }

    public static Integer[] findDuplicates(Integer[] input) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (Integer num : input) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        return duplicates.toArray(new Integer[0]);
    }

    public static Integer[] findUnique(Integer[] inputs){
        Integer[] res = new Integer[inputs.length];
        Map<String, Integer> hashmap = new HashMap<>();
        for (Integer input: inputs){
            if (hashmap.containsKey(input)){
                hashmap.put(String.valueOf(input), hashmap.get(input) + 1);
            }else {
                hashmap.put(String.valueOf(input), 1);
            }
        }
        int i = 0;
        for (Map.Entry<String, Integer> entry :hashmap.entrySet()){
            if (entry.getValue() == 1){
                res[i] = Integer.valueOf(entry.getKey());
                i += 1;
            }
        }
        return Arrays.copyOf(res, i);
    }

}