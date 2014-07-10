package behaviors.bidder;

import main.FSMTransitionBidderUtils;
import main.FSMTransitionUtils;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class ReadyForProposals extends SimpleBehaviour {

	private boolean isDone = false;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("Waiting for a propasal notification");
		ACLMessage msgRx = myAgent.receive();
		if (msgRx != null) {
			if (msgRx.getPerformative() == ACLMessage.CFP) {
				ACLMessage reply = msgRx.createReply();
				reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
				reply.setContent("Ready for proposals");
				isDone = true;
			}
		} else {
			block();
		}
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return isDone;
	}

	public int onEnd() {
		return FSMTransitionBidderUtils.READY_FOR_PROPSALS_EVENT;
	}

}
