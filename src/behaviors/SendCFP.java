package behaviors;

import main.AuctionMain;
import main.FSMTransitionUtils;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class SendCFP extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("Sending CFP");
		for (String bidder : AuctionMain.biddersList) {
			System.out.println("CFPing " + bidder);
			ACLMessage msg = new ACLMessage(ACLMessage.CFP);
			msg.addReceiver(new AID(bidder, AID.ISLOCALNAME));
			msg.setContent("Call for proposals");
			myAgent.send(msg);
		}

	}

	@Override
	public int onEnd() {
		System.out.println("CFP has been sent");
		return FSMTransitionUtils.CFP_SENT_EVENT;
	}
}
