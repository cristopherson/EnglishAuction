package behaviors;

import main.AuctionMain;
import main.FSMTransitionUtils;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class SendAuction extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("Sending auction");
		for (String bidder : AuctionMain.biddersList) {
			System.out.println("Notifying to " + bidder);
			ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
			msg.addReceiver(new AID(bidder, AID.ISLOCALNAME));
			msg.setContent("Auction is ready");
			myAgent.send(msg);			
		}		
	}

	@Override
	public int onEnd() {
		System.out.println("Auction has been sent");
		return FSMTransitionUtils.AUCTION_SENT_EVENT;
	}
}
