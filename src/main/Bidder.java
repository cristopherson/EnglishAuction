package main;

import behaviors.TerminateBidingIteration;
import behaviors.bidder.ListenProposals;
import behaviors.bidder.ReadyForProposals;
import behaviors.bidder.ReceiveInitiation;
import behaviors.bidder.TerminateAuctionParticipation;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class Bidder extends Agent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final long TICK_PERIOD_MS = 1000;
	private EnglishAuctionParticipant participant;
	private ReceiveInitiation receiveInitiation;
	private ReadyForProposals readyForProposals;
	private TerminateAuctionParticipation terminate;
	private ListenProposals listenProposals;

	public Bidder() {
		participant = new EnglishAuctionParticipant();
		receiveInitiation = new ReceiveInitiation(this, TICK_PERIOD_MS);
		readyForProposals = new ReadyForProposals();
		listenProposals = new ListenProposals();
		terminate = new TerminateAuctionParticipation();

	}

	public void setup() {
		System.out.println("I am bidder " + getLocalName());

		participant.registerFirstState(receiveInitiation,
				FSMTransitionBidderUtils.RECEIVE_INITIATION_NAME);
		participant.registerLastState(terminate,
				FSMTransitionBidderUtils.TERMINATE_AUCTION_ITERATION_NAME);
		participant.registerState(readyForProposals,
				FSMTransitionBidderUtils.READY_FOR_PROPOSALS_NAME);
		participant.registerState(listenProposals,
				FSMTransitionBidderUtils.LISTEN_PROPOSALS_NAME);

		participant.registerTransition(
				FSMTransitionBidderUtils.RECEIVE_INITIATION_NAME,
				FSMTransitionBidderUtils.TERMINATE_AUCTION_ITERATION_NAME,
				FSMTransitionBidderUtils.TIMEOUT_RECEIVE_INITIATION_EVENT);
		participant.registerTransition(
				FSMTransitionBidderUtils.RECEIVE_INITIATION_NAME,
				FSMTransitionBidderUtils.READY_FOR_PROPOSALS_NAME,
				FSMTransitionBidderUtils.RECEIVE_INITIATION_EVENT);
		participant.registerTransition(
				FSMTransitionBidderUtils.READY_FOR_PROPOSALS_NAME,
				FSMTransitionBidderUtils.LISTEN_PROPOSALS_NAME,
				FSMTransitionBidderUtils.READY_FOR_PROPSALS_EVENT);
		participant.registerTransition(
				FSMTransitionBidderUtils.LISTEN_PROPOSALS_NAME,
				FSMTransitionBidderUtils.TERMINATE_AUCTION_ITERATION_NAME,
				FSMTransitionBidderUtils.TERMINATE_EVENT);

		addBehaviour(participant);

		addBehaviour(new OneShotBehaviour() {
			private static final long serialVersionUID = 1L;

			public void action() {
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.addReceiver(new AID("initiator", AID.ISLOCALNAME));
				msg.setContent("I am ready for auction");
				send(msg);
			}
		});

	}
}