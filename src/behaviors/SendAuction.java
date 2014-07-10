package behaviors;

import main.AuctionMain;
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
		for (String bidder : AuctionMain.biddersList)
			System.out.println(bidder + " is registered");
		System.out.println("Auction is ready");
	}

	@Override
	public int onEnd() {
		System.out.println("Auction has been sent");
		return FSMTransitionUtils.AUCTION_SENT_EVENT;
	}
}
