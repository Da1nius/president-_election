package president.election.application.models;

public class RegionVotes {

    private String Region;
    private int  votes;

    public RegionVotes(String region, int votes) {
        this.Region = region;
        this.votes = votes;
    }


    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "RegionVotes{" +
                "Region='" + Region + '\'' +
                ", votes=" + votes +
                '}';
    }
}
