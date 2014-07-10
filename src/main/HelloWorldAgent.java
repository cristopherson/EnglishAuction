package main;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;

public class HelloWorldAgent extends Agent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setup() {
		System.out.println("Hello. My name is " + getLocalName());
		addBehaviour(new OneShotBehaviour() {
			private static final long serialVersionUID = 1L;

			public void action() {
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.addReceiver(new AID("initiator", AID.ISLOCALNAME));
				msg.setLanguage("English");
				msg.setOntology("Weather-forecast-ontology");
				msg.setContent("I am ready for auction");
				send(msg);
			}
		});
	}
}