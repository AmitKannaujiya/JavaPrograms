package interviews.GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by amit on 1/4/19.
 */
public class CastVotesTest {

    //ArrayList<Candidate> candidates = new ArrayList<>();
    HashMap<Integer, Candidate> candidates = new LinkedHashMap<>();


    public static void main(String[] args) throws IOException {
        CastVotesTest castVotesTest = new CastVotesTest();
        castVotesTest.seedCandidate();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = true;

        do {
            System.out.println("Please select your options : \nCast Vote type : 1\nGet Top n Candidates type : 2\nExit type 3");
            int input = Integer.valueOf(br.readLine());
            switch (input) {
                case 1:
                    System.out.println("Please input candidate id: \n");
                    int candidateId = Integer.valueOf(br.readLine());
                    ;
                    System.out.println("Your Vote Catested success fully to  " + castVotesTest.voteCandidate(candidateId));
                    break;
                case 2:
                    System.out.println("Please input value of n: \n");
                    int n = Integer.valueOf(br.readLine());
                    castVotesTest.getTopK(n);
                    break;
                case 3:
                    exit = false;
                    break;
                default:
                    exit = false;
            }

        } while (exit);

    }

    public String voteCandidate(int candidateId) {
        Candidate candidate = null;
        if(candidates.containsKey(candidateId)) {
            candidate = candidates.get(candidateId);
            candidate.setVotes(candidate.getVotes() +1); // this must be in side db transactions
            candidates.put(candidateId, candidate);
            CandidateVote candidateVote = new CandidateVote("Success", candidate, new Date().toString());

        }

        return candidate!=null? candidate.getName() : null;
    }

    public void getTopK(int k) {
         ArrayList<Candidate> candidateArrayList = new ArrayList<>(candidates.values());
         candidateArrayList.sort(new CandidateSort());

         for (int i = 0; i<(candidateArrayList.size() > k ? k : candidateArrayList.size()); i++) {
             System.out.println(candidateArrayList.get(i).toString());
         }
    }

    public void seedCandidate() {
        for (int i = 0; i < 24; i++) {
            Candidate candidate = new Candidate(i+1, "Name => " + (i+1));
            candidates.put(i+1, candidate);
        }
    }
}
