package main;

import behaviors.EnglishAuctionInitiator;
import behaviors.PrepareAuction;
import behaviors.PrepareCFP;
import behaviors.SendAuction;
import behaviors.SendCFP;
import behaviors.TerminateBidingIteration;
import jade.core.Agent;
import jade.domain.FIPANames.InteractionProtocol;

public class AuctionMain extends Agent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EnglishAuctionInitiator initiator;
	private PrepareAuction prepareAuction;
	private PrepareCFP prepareCFP;
	private SendAuction sendAuction;
	private SendCFP sendCFP;
	private TerminateBidingIteration terminate;

	public AuctionMain() {
		initiator = new EnglishAuctionInitiator();
		prepareAuction = new PrepareAuction();
		prepareCFP = new PrepareCFP();
		sendAuction = new SendAuction();
		sendCFP = new SendCFP();
		terminate = new TerminateBidingIteration();
	}

	protected void setup() {
		// Printout a welcome message
		System.out.println("Hello! Buyer-agent " + getAID().getName()
				+ " is ready with " + InteractionProtocol.FIPA_ENGLISH_AUCTION);

		initiator.registerFirstState(prepareAuction,
				FSMTransitionUtils.PREPARE_AUCTION_NAME);
		initiator.registerLastState(terminate,
				FSMTransitionUtils.TERMINATE_BIDING_ITERATION_NAME);

		initiator.registerState(sendAuction,
				FSMTransitionUtils.SEND_AUCTION_NAME);
		initiator
				.registerState(prepareCFP, FSMTransitionUtils.PREPARE_CFP_NAME);
		initiator.registerState(sendCFP, FSMTransitionUtils.SEND_CFP_NAME);

		initiator.registerTransition(FSMTransitionUtils.PREPARE_AUCTION_NAME,
				FSMTransitionUtils.SEND_AUCTION_NAME,
				FSMTransitionUtils.AUCTION_PREPARED_EVENT);
		initiator.registerTransition(FSMTransitionUtils.SEND_AUCTION_NAME,
				FSMTransitionUtils.PREPARE_CFP_NAME,
				FSMTransitionUtils.AUCTION_SENT_EVENT);
		initiator.registerTransition(FSMTransitionUtils.PREPARE_CFP_NAME,
				FSMTransitionUtils.SEND_CFP_NAME,
				FSMTransitionUtils.CFP_PREPARED_EVENT);
		initiator.registerTransition(FSMTransitionUtils.SEND_CFP_NAME,
				FSMTransitionUtils.TERMINATE_BIDING_ITERATION_NAME,
				FSMTransitionUtils.CFP_SENT_EVENT);

		addBehaviour(initiator);
	}
}
