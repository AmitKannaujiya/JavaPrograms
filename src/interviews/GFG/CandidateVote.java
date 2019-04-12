package interviews.GFG;

/**
 * Created by amit on 1/4/19.
 */
public class CandidateVote {
    int id;
    String status;
    Candidate candidate;
    String timestamp;

    public CandidateVote(String status, Candidate candidate, String timestamp) {
        this.status = status;
        this.candidate = candidate;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
