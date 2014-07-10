package behaviors.bidder;

import main.FSMTransitionBidderUtils;
import main.FSMTransitionUtils;
import jade.core.behaviours.OneShotBehaviour;

public class TerminateAuctionParticipation extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("Finished");
	}

	@Override
	public int onEnd() {
		System.out.println("Auction participation is terminated");
		myAgent.doDelete();
		return FSMTransitionBidderUtils.TERMINATE_EVENT;
	}
}
