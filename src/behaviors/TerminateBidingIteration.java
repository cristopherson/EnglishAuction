package behaviors;

import main.FSMTransitionUtils;
import jade.core.behaviours.OneShotBehaviour;

public class TerminateBidingIteration extends OneShotBehaviour {

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
		System.out.println("Auction is terminated");
		myAgent.doDelete();
		return FSMTransitionUtils.TERMINATE_EVENT;
	}
}
