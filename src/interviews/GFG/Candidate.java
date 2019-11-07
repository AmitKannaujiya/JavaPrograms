package interviews.GFG;

/**
 * Created by amit on 1/4/19.
 */
public class Candidate {
    int id;
    String name;
    long votes;

    public Candidate(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "ID : " + getId() + " NAME : " + getName() + " VOTES: " + getVotes();
    }
}
