package test;

import driver.Sociopath;
import java.util.List;
import java.util.Arrays;

//JUnit imports
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SociopathTest {
	
	//sociopath with a groupSize of 2
    @Test
    void simpleSociopath() {
    	
        List<int[]> likes = Arrays.asList(
        		
        		new int[] {1, 2}
        
        );

        assertEquals(2, Sociopath.findTheSociopath(2, likes));
        
    }
    
    //no individual is liked by everyone else
    @Test
    void noAllLiked() {
    	
        List<int[]> likes = Arrays.asList(
        		
        		new int[] {1, 2}
        
        );

        assertEquals(-1, Sociopath.findTheSociopath(3, likes));
        
    }
    
    //sociopath with a groupSize of 3
    @Test
    void groupSociopath() {
    	
        List<int[]> likes = Arrays.asList(
        		
        		new int[] {1, 2},
        		new int[] {1, 3},
        		new int[] {2, 3}
        
        );

        assertEquals(3, Sociopath.findTheSociopath(3, likes));
        
    }
    
    //all individuals like someone else
    @Test
    void allLiked() {
    	
        List<int[]> likes = Arrays.asList(
        		
        		new int[] {1, 3},
        		new int[] {2, 3},
        		new int[] {3, 1}
        
        );

        assertEquals(-1, Sociopath.findTheSociopath(3, likes));
        
    }
    
    //invalid group size of zero
    @Test
    void zeroGroupSize() {
    	
        List<int[]> likes = Arrays.asList(
        		
        		new int[] {1, 2}
        
        );

        assertEquals(-1, Sociopath.findTheSociopath(0, likes));
        
    }
    
    //invalid individual of zero
    @Test
    void zeroPerson() {
    	
        List<int[]> likes = Arrays.asList(
        		
        		new int[] {1, 0}
        
        );

        assertEquals(-1, Sociopath.findTheSociopath(3, likes));
        
    }
    
}
