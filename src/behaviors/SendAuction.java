package behaviors;

import main.FSMTransitionUtils;
import jade.core.behaviours.OneShotBehaviour;

public class SendAuction extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("Auction is ready");

	}

	@Override
	public int onEnd() {
		System.out.println("Auction has been sent");
		return FSMTransitionUtils.AUCTION_SENT_EVENT;
	}
}
