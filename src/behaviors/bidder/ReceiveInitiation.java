package behaviors.bidder;

import main.FSMTransitionBidderUtils;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class ReceiveInitiation extends SimpleBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int retries = 0;
	private final int MAX_RETRIES = 60;
	private boolean isDone = false;
	private long period = 0;

	public ReceiveInitiation(Agent a, long period) {
		super(a);
		this.period = period;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		retries++;

		if (!(retries < MAX_RETRIES))
			isDone = true;

		ACLMessage msgRx = myAgent.receive();
		if (msgRx != null) {
			System.out.println(msgRx);
			isDone = true;
		} else {
			block(period);
		}
	}

	public int onEnd() {
		if (!(retries < MAX_RETRIES)) {
			System.out.println("Timeout received. Exiting Auction");
			return FSMTransitionBidderUtils.TIMEOUT_RECEIVE_INITIATION_EVENT;
		} else {
			System.out.println("Auction initiation has been received");
			return FSMTransitionBidderUtils.RECEIVE_INITIATION_EVENT;
		}
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return isDone;
	}

}
