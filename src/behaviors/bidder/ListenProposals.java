package behaviors.bidder;

import main.FSMTransitionBidderUtils;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class ListenProposals extends SimpleBehaviour {

	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage msgRx = myAgent.receive();
		if (msgRx != null) {
			System.out.println(msgRx);
		} else {
			block();
		}
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

	public int onEnd() {
		return FSMTransitionBidderUtils.TERMINATE_EVENT;
	}

}
