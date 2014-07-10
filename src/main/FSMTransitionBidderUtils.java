package main;

public interface FSMTransitionBidderUtils {
	public static final String RECEIVE_INITIATION_NAME = "ReceiveInitiation";
	public static final String TIMEOUT_RECEIVE_INITIATION_NAME = "TimeoutReceiveInitiation";
	public static final String READY_FOR_PROPOSALS_NAME = "ReadyForProposals";
	public static final String TERMINATE_AUCTION_ITERATION_NAME = "TerminateAuctionParticipation";
	public static final String LISTEN_PROPOSALS_NAME = "ListenProposals";
	
	public static final int RECEIVE_INITIATION_EVENT = 0;
	public static final int TIMEOUT_RECEIVE_INITIATION_EVENT = 1;
	public static final int READY_FOR_PROPSALS_EVENT = 2;
	public static final int TERMINATE_EVENT = 4;
}
