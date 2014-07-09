package behaviors;

import main.FSMTransitionUtils;
import jade.core.behaviours.OneShotBehaviour;

public class PrepareCFP extends OneShotBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("Preparin CFP message");

	}

	@Override
	public int onEnd() {
		System.out.println("CFP has been prepared");
		return FSMTransitionUtils.CFP_PREPARED_EVENT;
	}
}
