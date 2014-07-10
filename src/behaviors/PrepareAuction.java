package behaviors;

import java.util.LinkedList;

import main.AuctionMain;
import main.FSMTransitionUtils;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class PrepareAuction extends SimpleBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MAX_BIDDERS_ACCEPTED = 5;
	private int bidderNumber = 0;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("Waiting for a bidder");
		ACLMessage msgRx = myAgent.receive();
		if (msgRx != null) {
			System.out.println("Registering bidde: "
					+ msgRx.getSender().getName());
			AuctionMain.biddersList.addLast(msgRx.getSender().getLocalName());
			bidderNumber++;
		} else {
			block();
		}

	}

	@Override
	public int onEnd() {
		System.out.println("Auction has been prepared");
		return FSMTransitionUtils.AUCTION_PREPARED_EVENT;
	}

	public boolean done() {
		return !(bidderNumber < MAX_BIDDERS_ACCEPTED);
	}

}
