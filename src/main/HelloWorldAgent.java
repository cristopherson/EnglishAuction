package main;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;

public class HelloWorldAgent extends Agent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setup() {
		System.out.println("Hello. My name is " + getLocalName());
		addBehaviour(new CyclicBehaviour() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void action() {
				ACLMessage msgRx = receive();
				if (msgRx != null) {
					System.out.println(msgRx);
					ACLMessage msgTx = msgRx.createReply();
					msgTx.setProtocol(FIPANames.InteractionProtocol.FIPA_ENGLISH_AUCTION);
					msgTx.setContent("Hello!");
					send(msgTx);
				} else {
					block();
				}
			}
		});
	}
}