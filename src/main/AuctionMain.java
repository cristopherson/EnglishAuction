package main;

import java.util.LinkedList;

import behaviors.EnglishAuctionInitiator;
import behaviors.PrepareAuction;
import behaviors.PrepareCFP;
import behaviors.ProposeValue;
import behaviors.SendAuction;
import behaviors.SendCFP;
import behaviors.TerminateBidingIteration;
import jade.core.Agent;

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
	private ProposeValue proposeValue;
	private TerminateBidingIteration terminate;
	public static LinkedList<String> biddersList = new LinkedList<String>();
	private int privateValue = 100;
	public static int initialValue = 0;

	public AuctionMain() {
		initiator = new EnglishAuctionInitiator();
		prepareAuction = new PrepareAuction();
		prepareCFP = new PrepareCFP();
		sendAuction = new SendAuction();
		sendCFP = new SendCFP();
		proposeValue = new ProposeValue();

		terminate = new TerminateBidingIteration();
	}

	protected void setup() {
		System.out.println("This is " + getAID().getName()
				+ " agent preparing the english auction.");

		initiator.registerFirstState(prepareAuction,
				FSMTransitionUtils.PREPARE_AUCTION_NAME);
		initiator.registerLastState(terminate,
				FSMTransitionUtils.TERMINATE_BIDING_ITERATION_NAME);

		initiator.registerState(sendAuction,
				FSMTransitionUtils.SEND_AUCTION_NAME);
		initiator
				.registerState(prepareCFP, FSMTransitionUtils.PREPARE_CFP_NAME);
		initiator.registerState(sendCFP, FSMTransitionUtils.SEND_CFP_NAME);
		initiator.registerState(proposeValue,
				FSMTransitionUtils.PROPOSE_VALUE_NAME);

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
				FSMTransitionUtils.PROPOSE_VALUE_NAME,
				FSMTransitionUtils.CFP_SENT_EVENT);

		addBehaviour(initiator);
		/*
		 * addBehaviour(new CyclicBehaviour() {
		 * 
		 * @Override public void action() { ACLMessage msg = new
		 * ACLMessage(ACLMessage.INFORM); msg.addReceiver(new AID("auction-1",
		 * AID.ISLOCALNAME)); msg.setLanguage("English");
		 * msg.setOntology("Weather-forecast-ontology");
		 * msg.setContent("Today it’s raining"); send(msg);
		 * 
		 * 
		 * } });
		 * 
		 * addBehaviour(new CyclicBehaviour() {
		 * 
		 * @Override public void action() { ACLMessage msgRx = receive(); if
		 * (msgRx != null) { System.out.println(msgRx); } else { block(); } }
		 * 
		 * });
		 */
	}
}
