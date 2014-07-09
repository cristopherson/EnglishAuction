package behaviors;

import main.FSMTransitionUtils;
import jade.core.behaviours.OneShotBehaviour;

public class SendCFP extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("Sending CFP");
	}

	@Override
	public int onEnd() {
		System.out.println("CFP has been sent");
		return FSMTransitionUtils.CFP_SENT_EVENT;
	}
}
