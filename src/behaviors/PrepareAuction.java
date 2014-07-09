package behaviors;

import main.FSMTransitionUtils;
import jade.core.behaviours.OneShotBehaviour;

public class PrepareAuction extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("Preparing auction");

	}

	@Override
	public int onEnd() {
		System.out.println("Auction has been prepared");
		return FSMTransitionUtils.AUCTION_PREPARED_EVENT;
	}

}
