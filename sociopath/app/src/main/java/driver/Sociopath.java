package driver;
import java.util.List;

public class Sociopath {
	
    /**
     * findTheSociopath method finds the sociopath
     * from a provided List of likes between individuals
     * The sociopath is the individual liked by all others
     * that doesn't like anyone else
     * @param groupSize the total number of individuals in the group
     * @param likeList a List of int arrays representing who likes whom;
     * 	      each array is [liker, liked]
     * @return the number of the sociopath if found; -1 otherwise
     */
	public static int findTheSociopath (int groupSize, List<int []> likeList) {
		
		//invalid groupSize is an automatic fail
        if (groupSize <= 0) {return -1;}
        
        //lists to track likes received and given
        int[] likeReceived = new int[groupSize + 1];
        boolean[] likeGiven = new boolean[groupSize + 1];
        
        //counts up all like pairings
        for (int[] pair : likeList) {

            int giver = pair[0];
            int receiver = pair[1];
            
            //ensures all individuals are valid
            if (giver > 0 && giver <= groupSize &&
                receiver >= 1 && receiver <= groupSize) {

                likeReceived[receiver]++;
                likeGiven[giver] = true;

            }

        }
        
        //identify the sociopath:
        for (int i = 1; i <= groupSize; i++) {
        	
            //liked by everyone else
            if (likeReceived[i] == groupSize - 1) {
            	
            	//given no likes themselves
                if (!likeGiven[i]) {return i;}

                return -1;

            }

        }

        return -1;

    }
	
}