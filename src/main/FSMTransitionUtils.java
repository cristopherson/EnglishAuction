package main;

public interface FSMTransitionUtils {
	public static final String PREPARE_AUCTION_NAME = "PrepareAuction";
	public static final String PREPARE_CFP_NAME = "PrepareCFP";
	public static final String SEND_AUCTION_NAME = "SendAuction";
	public static final String SEND_CFP_NAME = "SendCFP";
	public static final String PROPOSE_VALUE_NAME = "ProposeValue";
	public static final String TERMINATE_BIDING_ITERATION_NAME = "TerminateBidingIteration";

	public static final int AUCTION_PREPARED_EVENT = 0;
	public static final int AUCTION_SENT_EVENT = 1;
	public static final int CFP_PREPARED_EVENT = 2;
	public static final int CFP_SENT_EVENT = 3;
	public static final int PROPOSE_VALUE_EVENT = 4;
	public static final int TERMINATE_EVENT = 99;
}
