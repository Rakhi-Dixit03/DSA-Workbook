package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Maximum_Partition {

        private int k;
        private String s;

        Map<Long, Integer> map = new HashMap<>();

        public int maxPartitionsAfterOperations(String s,int k) {

            this.s=s;
            this.k=k;
            return solve(0, 0, true) + 1;

        }

        private int solve(long i, long uniqueChars, boolean canChange) {

            long key = (i << 27) | (uniqueChars << 1) | (canChange ? 1 : 0);

            if (map.containsKey(key)) {

                return map.get(key);

            }

            //Base case

            if (i == s.length()) {
                return 0;
            }

            //When not changing character

            int charIdx = s.charAt((int) i) - 'a';

            long updatedUniqueChars = uniqueChars | (1L << charIdx);

            int uniqueCharCount = Long.bitCount(updatedUniqueChars);

            int result;

            if (uniqueCharCount > k) {

                result = 1 + solve(i + 1, 1L << charIdx, canChange);

            } else {

                result = solve(i + 1, updatedUniqueChars, canChange);

            }

            //Changing character

            if (canChange) {

                for (int newCharIdx = 0; newCharIdx < 26; newCharIdx++) {

                    long newSet = uniqueChars | (1L << newCharIdx);

                    int newUniqueCharCount = Long.bitCount(newSet);

                    if (newUniqueCharCount > k) {

                        result = Math.max(result, 1 + solve(i + 1, 1L << newCharIdx, false));

                    } else {

                        result = Math.max(result, solve(i + 1, newSet, false));

                    }
                }
            }

            map.put(key, result);
            return result;

        }


    public static void main(String[] args) {
            Maximum_Partition mx=new Maximum_Partition();

        System.out.println(mx.maxPartitionsAfterOperations("xxyz",1));
    }

    }

