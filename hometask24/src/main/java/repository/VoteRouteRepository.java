package repository;

import java.util.List;

public interface VoteRouteRepository {
    boolean addVote(int user_id, int route_id);

    boolean removeVote(int user_id, int route_id);

    boolean hasVoted(int user_id, int route_id);

    int getVotesCount(int route_id);

    List<Integer> getVotedRouteIds(int user_id);
}
