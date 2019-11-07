package interviews.GFG;

import java.util.Comparator;

/**
 * Created by amit on 1/4/19.
 */
public class CandidateSort implements Comparator<Candidate> {

    @Override
    public int compare(Candidate a, Candidate b) {
        int diff = (int) (b.getVotes() - a.getVotes());
        if (diff == 0) {
            return a.getName().compareTo(b.getName());
        }
        return diff;
    }

//    @Override
//    public Comparator<Candidate> reversed() {
//        Comparator comparator = Comparator.reverseOrder();
//        return null;
//    }
}
